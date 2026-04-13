package com.DynamicPage.app.server;

import org.springframework.stereotype.Service;

@Service
public class serviceRequest {
  public String genrateMessage(String name) {
	   return "welcome "+name+" welcome to my new project";
   }
}
