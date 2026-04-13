package com.authenticationOtp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.authenticationOtp.app.entity.Users;
import com.authenticationOtp.app.service.userService;

@Controller
@RequestMapping("/user/api")
public class userController {
	userService us;

	public userController(userService us) {
		super();
		this.us = us;
	}

	@GetMapping("/")

	public String getSignUp() {
		return "signup";
	}

	@PostMapping("/signup")

	public String signupinpl(@RequestParam("username") String uname, @RequestParam("password") String upassword,
			@RequestParam("email") String uemail, @RequestParam("role") String urole) {
		Users newUser = new Users(uname, upassword, uemail, urole);
		boolean succes = us.userSignUp(newUser);
		if (succes) {
			return "login";
		} else {
			return "invailidsingup";
		}
	}
	@GetMapping("/login")
	public String loginuser(String username,String password) {
		boolean result=us.userSignIn(username, password);
		if(result) {
			return "otplogin";
		}
		else {
			return "loginFaild";
		}
	}
		@GetMapping("/otplogin")
		public String verifyOtp(@RequestParam("otpvalue") int otp, Model m) {
			
			Users ref = us.verifyOtp(otp);
			if(ref!=null) {
				m.addAttribute("username", ref.getUsername());
				return "home";
			}
			else {
				return "login";
			}
		
	}
}