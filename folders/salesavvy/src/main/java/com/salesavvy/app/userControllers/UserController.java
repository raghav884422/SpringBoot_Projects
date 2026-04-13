package com.salesavvy.app.userControllers;

import java.util.Map;

import com.salesavvy.app.entiry.User;
import com.salesavvy.app.service.userServiceContract;
import com.salesavvy.app.serviceImplementation.AuthServiceIplementation;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(
        origins = "http://localhost:5174",
        allowCredentials = "true"
)
public class UserController {

    private final userServiceContract userService;
    private final AuthServiceIplementation authService;

    public UserController(userServiceContract userService,
                          AuthServiceIplementation authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok(
                    Map.of(
                            "message", "User registered successfully",
                            "user", registeredUser
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", e.getMessage())
            );
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest,
                                   HttpServletResponse response) {

        User user = userService.login(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );

        String token = authService.generateToken(user);

        Cookie cookie = new Cookie("authToken", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // true in production
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        return ResponseEntity.ok(
                Map.of("message", "Login successful")
        );
    }
}
