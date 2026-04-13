package com.login.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.app.entity.Userlogin;
import com.login.app.service.UserService;

@RestController
@RequestMapping("api/auth")
@CrossOrigin
public class UserController {
	UserService us;

	public UserController(UserService us) {
		super();
		this.us = us;
	}

	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Map<String, String> request) {
		Map<String, String> responce = null;
		try {
			String username = request.get("username");
			String passworld = request.get("password");
			Userlogin ul = us.authenticate(username, passworld);
			responce = new HashMap<>();
			responce.put("username", ul.getUsername());
			responce.put("Succsessful", "Login Sucessful");
			return responce;
		} catch (Exception e) {
			// TODO: handle exception
			responce.put("username", null);
			responce.put("Failed", e.getMessage());
			return responce;
		}
	}
	@PostMapping("/register")
	public Userlogin create(@RequestBody Userlogin ul) {
		return us.saveUser(ul);
	}
}
