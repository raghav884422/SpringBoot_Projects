package com.salesavvy.app.service;

import java.math.BigDecimal;
import java.util.List;

import com.razorpay.RazorpayException;
import com.salesavvy.app.entiry.OrderItem;

public interface PaymentServiceContract {
	public String createOrder(int userId, BigDecimal totalAmount, List<OrderItem> cartItems) throws RazorpayException;
	 public boolean verifyPayment(String razorpayOrderId, String razorpayPaymentId, String razorpaySignature, int userId);
}
