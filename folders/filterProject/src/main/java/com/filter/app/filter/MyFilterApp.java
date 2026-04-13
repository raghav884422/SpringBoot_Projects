package com.filter.app.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class MyFilterApp implements Filter{
	public MyFilterApp() {
		// TODO Auto-generated constructor stub
		System.out.println("object of filter got created...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
//		1= first we douncast the servalate request to HTTPservelate request to get url end point
//		(URI)
		HttpServletRequest req = (HttpServletRequest)request;
	String uri	=req.getRequestURI();
	if(uri.equals("/api/res1")) {
//		Forwarding the request to the endpoint
		System.out.println("Forwarding request without validation..");
		chain.doFilter(request, response);
		
	}
	else {
		req.setAttribute("message", "Validation success");
		System.out.println("forwarding request after validation ");
		chain.doFilter(request, response);
	}
	}

}
