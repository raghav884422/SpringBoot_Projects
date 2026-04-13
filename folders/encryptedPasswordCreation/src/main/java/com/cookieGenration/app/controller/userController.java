 package com.cookieGenration.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cookieGenration.app.entiity.Kodnestuser;
import com.cookieGenration.app.entiity.Role;
import com.cookieGenration.app.service.UserServices;
import com.cookieGenration.app.service.userServiceIpmle;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class userController {
	UserServices services;

	public userController(UserServices services) {
		super();
		this.services = services;
	}
	@PostMapping("/signup")
	public Map<String , String> userSignUp(@RequestBody Map<String, String> request){
		Map<String, String> responce = new HashMap<>();
		String username = request.get("username");
		String password = request.get("password");
		int age = Integer.parseInt(request.get("age"));
		int marks = Integer.parseInt(request.get("marks"));
		Role role = Role.valueOf(request.get("role"));
		Kodnestuser ku = new Kodnestuser(username, password, age, marks, role);
		Kodnestuser registerUser = services.register(ku);
	if(registerUser!=null) {
		responce.put("Message", "Register sucessfully");
	}else {
		responce.put("Message", "Register failed");
	}
		
		return responce;
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> Login(@RequestParam String username, @RequestParam String password){
	boolean result =services.login(username, password);
	if(result) {
	return ResponseEntity.ok(Map.of("Message", "Login Successful"));
	
	}
	else {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("Message", "invailid credetials"));
	}
}
}