package com.salesavvy.app.userControllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesavvy.app.entiry.OrderItem;
import com.salesavvy.app.entiry.User;
import com.salesavvy.app.serviceImplementation.PaymentService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:5174", allowCredentials = "true")
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // ================= CREATE PAYMENT =================
    @PostMapping("/create")
    public ResponseEntity<?> createPaymentOrder(
            @RequestBody Map<String, Object> requestBody,
            HttpServletRequest request) {

        try {
            // 🔐 Authenticated user
            User user = (User) request.getAttribute("authenticatedUser");
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("User not authenticated");
            }

            // 💰 Total amount
            BigDecimal totalAmount =
                    new BigDecimal(requestBody.get("totalAmount").toString());

            // 🛒 Cart items
            List<Map<String, Object>> cartItemsRaw =
                    (List<Map<String, Object>>) requestBody.get("cartItems");

            List<OrderItem> cartItems = cartItemsRaw.stream().map(item -> {
                OrderItem orderItem = new OrderItem();
                orderItem.setProductId((Integer) item.get("productId"));
                orderItem.setQuantity((Integer) item.get("quantity"));

                BigDecimal price =
                        new BigDecimal(item.get("price").toString());

                orderItem.setPricePerUnit(price);
                orderItem.setTotalPrice(
                        price.multiply(BigDecimal.valueOf(orderItem.getQuantity()))
                );
                return orderItem;
            }).collect(Collectors.toList());

            // 🚀 Create Razorpay order
            Map<String, Object> razorpayData =
                    paymentService.createOrder(
                            user.getUser_id(),
                            totalAmount,
                            cartItems
                    );

            return ResponseEntity.ok(razorpayData);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Payment creation failed: " + e.getMessage());
        }
    }

    // ================= VERIFY PAYMENT =================
    @PostMapping("/verify")
    public ResponseEntity<?> verifyPayment(
            @RequestBody Map<String, Object> requestBody,
            HttpServletRequest request) {

        try {
            User user = (User) request.getAttribute("authenticatedUser");
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("User not authenticated");
            }

            // ✅ EXACT Razorpay keys (VERY IMPORTANT)
            String razorpayOrderId =
                    (String) requestBody.get("razorpay_order_id");
            String razorpayPaymentId =
                    (String) requestBody.get("razorpay_payment_id");
            String razorpaySignature =
                    (String) requestBody.get("razorpay_signature");

            // 🔍 DEBUG (DO NOT SKIP)
            System.out.println("ORDER ID: " + razorpayOrderId);
            System.out.println("PAYMENT ID: " + razorpayPaymentId);
            System.out.println("SIGNATURE: " + razorpaySignature);

            boolean verified = paymentService.verifyPayment(
                    razorpayOrderId,
                    razorpayPaymentId,
                    razorpaySignature,
                    user.getUser_id()
            );

            if (verified) {
                return ResponseEntity.ok("Payment verified successfully");
            } else {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Payment verification failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Verification error: " + e.getMessage());
        }
    }

}
