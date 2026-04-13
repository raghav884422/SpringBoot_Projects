package com.Password.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Password.app.service.userService;
import com.Password.app.userDTO.userDto;

@RestController
@RequestMapping("/user/api")
public class userController {
	userService userSer;

	public userController(userService userSer) {
		super();
		this.userSer = userSer;
	}
@GetMapping("/login")
	public Map<String, String> userlogin(@RequestBody userDto userdto) {
		String username = userdto.getUsername();
		String password = userdto.getPassword();
		String role = userSer.getuserrole(username, password);
		String message =null;
		if(!(role.equals("invailid")||role.equals("incorect"))) {
			if(role.equals("user")) {
				message =userSer.userResponce(username);
			}
			else {
				message = userSer.adminResponse(username);
			}
		}else {
			if(role.equals("invailid")) {
				message= "invaild username or password";
			}
			else {
				message = "user with "+username+" dose not exist";
			}
		}
		Map<String ,String> response = new HashMap<>();
		response.put("message", message);
		return response;
		

	}
}
