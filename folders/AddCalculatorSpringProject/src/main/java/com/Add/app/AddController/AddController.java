package com.Add.app.AddController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Add.app.AddServices.AddServices;

@Controller
@RequestMapping("/api")
public class AddController {
	AddServices service;

	public AddController(AddServices service) {
		super();
		this.service = service;
	}

	@GetMapping("/")
	String index() {
		return "index";
	}
	
	@GetMapping("/calculate")
	String add(@RequestParam int a,@RequestParam int b,Model m) {
		int c = AddServices.add(a,b);
		m.addAttribute("sum",c);
		return "result";
	}
}
