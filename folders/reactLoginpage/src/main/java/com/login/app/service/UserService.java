package com.login.app.service;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.login.app.entity.Userlogin;
import com.login.app.repo.UserLoginRepo;

@Service
public class UserService {
	UserLoginRepo userRepo;

	public UserService(UserLoginRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}
	public Userlogin authenticate(String username,String password) {
		Userlogin ul = userRepo.findByUsername(username);
		if(ul!=null && ul.getPassword().equals(password)) {
			return ul;
		}
		else {
			throw new RuntimeException("invalid credencials");
		}
	}
	public Userlogin saveUser(Userlogin ul) {
		return userRepo.save(ul);
	
	}
}
