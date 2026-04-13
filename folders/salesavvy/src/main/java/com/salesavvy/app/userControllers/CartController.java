package com.salesavvy.app.userControllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesavvy.app.entiry.User;
import com.salesavvy.app.service.CartServiceContract;
import com.salesavvy.app.serviceImplementation.CartService;
import com.salesavvy.app.userrepositries.UserReopsitory;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "http://localhost:5174", allowCredentials = "true")
@RequestMapping("/api/cart")
public class CartController {
	UserReopsitory	userRepository;
	 CartServiceContract  cartService;
	 
	 public CartController(UserReopsitory userRepository, CartServiceContract cartService) {
		super();
		this.userRepository = userRepository;
		this.cartService = cartService;
	}

	 @PostMapping("/add")
	 @CrossOrigin(origins = "http://localhost:5174", allowCredentials = "true")
	public ResponseEntity<Void> addToCart(@RequestBody Map<String, Object> request) {
	    String username = (String) request.get("username");
	    int productId = (int) request.get("productId");

	    // Handle quantity: Default to 1 if not provided
	    int quantity = request.containsKey("quantity") ? (int) request.get("quantity") : 1;

	    // Fetch the user using username
	    User user = userRepository.findByUsername(username)
	            .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));

	    // Add the product to the cart
	    cartService.addToCart(user.getUser_id(), productId, quantity);
	    return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	 @GetMapping("/items")
	    public ResponseEntity<Map<String, Object>> getCartItems(HttpServletRequest request) {
	        // Fetch user by username to get the userId
	        User user = (User) request.getAttribute("authenticatedUser");

	        // Call the service to get cart items for the user
	        Map<String, Object> cartItems = cartService.getCartItems(user.getUser_id());
	        return ResponseEntity.ok(cartItems);
	    }
	 
	 @PutMapping("/update")
	 public ResponseEntity<Void> updateCartItemQuantity(@RequestBody Map<String, Object> request) {
	     String username = (String) request.get("username");
	     int productId = (int) request.get("productId");
	     int quantity = (int) request.get("quantity");

	     // Fetch the user using username
	     User user = userRepository.findByUsername(username)
	             .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));

	     // Update the cart item quantity
	     cartService.updateCartItemQuantity(user.getUser_id(), productId, quantity);
	     return ResponseEntity.status(HttpStatus.OK).build();
	 }
	 
	 
	 @DeleteMapping("/delete")
	 public ResponseEntity<Void> deleteCartItem(@RequestBody Map<String, Object> request) {
	     String username = (String) request.get("username");
	     int productId = (int) request.get("productId");

	     // Fetch the user using username
	     User user = userRepository.findByUsername(username)
	             .orElseThrow(() -> new IllegalArgumentException("User not found with username: " + username));

	     // Delete the cart item
	     cartService.deleteCartItem(user.getUser_id(), productId);
	     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 }
	 @GetMapping("/items/count")
	 public ResponseEntity<Integer> getCartItemCount(
	         HttpServletRequest request
	 ) {
	     // Authenticated user set by AuthenticationFilter
	     User user = (User) request.getAttribute("authenticatedUser");

	     int cartCount = cartService.getCartItemCount(user.getUser_id());

	     return ResponseEntity.ok(cartCount);
	 }
	 
	 
}
