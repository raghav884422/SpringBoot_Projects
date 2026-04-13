package com.DynamicPage.app.service;

import org.springframework.stereotype.Service;

@Service
public class RequestService {
public String genrateMessage(String fname,String mname,String lname) {
	return "Welcome "+fname+" "+mname+" "+lname+" to my multiple input taking web page";
}
}
