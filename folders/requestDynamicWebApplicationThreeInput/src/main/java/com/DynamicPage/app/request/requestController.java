package com.DynamicPage.app.request;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DynamicPage.app.service.RequestService;
@Controller
@RequestMapping("/api")
public class requestController {
	RequestService ref;

	public requestController(RequestService ref) {
		super();
		this.ref = ref;
	}
	@GetMapping("/show1/{fname}/{mname}/{lname}")
	@ResponseBody
	String method1(@PathVariable("fname") String firstname,@PathVariable("mname")String middlename,@PathVariable("lname")String lastname) {
		
		String content = ref.genrateMessage(firstname, middlename, lastname);
		
		return content;
	}
	@GetMapping("/show2")
	@ResponseBody
	String method2(@RequestParam("firstname") String fname,@RequestParam("middlename")String mname,@RequestParam("lastname")String lname) {
		
		String content = ref.genrateMessage(fname, mname, lname);
		
		return content;
	}
	
	@GetMapping("/show3")
	@ResponseBody
	String method3(@RequestBody Map<String, String>req) {
		String fname =req.get("firstname");
		String mname =req.get("middlename");
		String lname =req.get("lastname");
		
		
		String content = ref.genrateMessage(fname, mname, lname);
		
		return content;
	}
	

}
