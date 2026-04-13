package com.Password.app.service;

import org.springframework.stereotype.Service;

import com.Password.app.entity.user;
import com.Password.app.repo.userRepo;
import com.Password.app.userDTO.userDto;
@Service
public class userService {
	userRepo uRepo;
	
	public userService(userRepo uRepo) {
		super();
		this.uRepo = uRepo;
	}

	public String userResponce(String name) {
	
      return "hello "+name+"Welcome, you are an user";
	}

	public String adminResponse(String name) {
	      return "hello "+name+"Welcome, you are an admin";
	}
	public String getuserrole(String username,String password) {
	user ref=	uRepo.findByUsername(username);
	if(ref!=null) {
		if(ref.getPassword().equals(password)) {
			
			return ref.getRole();
		}else {
			return "invailid";
		}
	}else {
		return "incorect";
		
	}
	}
}
