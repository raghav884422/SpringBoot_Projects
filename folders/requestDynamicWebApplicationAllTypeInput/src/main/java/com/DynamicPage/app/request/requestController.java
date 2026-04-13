package com.DynamicPage.app.request;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DynamicPage.app.server.serviceRequest;


@Controller
@RequestMapping("/api")
public class requestController {
	serviceRequest ref;

	public requestController(serviceRequest ref) {
		super();
		this.ref = ref;
	}
	
	
//	PATH VERIABLE
    @GetMapping("/show1/{name}")
    @ResponseBody
	String method1(@PathVariable String name) {
    	String content = ref.genrateMessage(name);
         return content;
	}
    
//    REQUEST PARAMETER
    @GetMapping("/show2")
    @ResponseBody
    String method2(@RequestParam String name) {
    	String content = ref.genrateMessage(name);
    	return content;
    }
    
//    REQUEST BODY
    @GetMapping("/show3")
    @ResponseBody
    String method3(@RequestBody Map<String,String>req) {
    	String name=req.get("username");
    	String content = ref.genrateMessage(name);
    	return content;
    }
    
}
