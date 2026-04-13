package com.DynamicPage.app.server;

import org.springframework.stereotype.Service;

@Service
public class RequestService {
	public String genrateMessage(int x) {
          return "hello user " + x +" welcome to first server layer dynamic page";
	}
}
