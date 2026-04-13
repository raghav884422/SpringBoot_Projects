package com.Caloculator.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Caloculator.app.service.CalculatorService;

@Controller
@RequestMapping("/api")
public class CalculatorController {
	@Autowired
private CalculatorService cs;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	@PostMapping("/calculate")
	public String calculate(@RequestParam("num1") double n1,@RequestParam("num2") double n2,@RequestParam("operation") String op,Model m) {
		double result = 0;
		switch(op) {
		case "add":
			result = cs.add(n1,n2);
			break;
		case "sub":
			result = cs.sub(n1,n2);
			break;
		case "mul":
			result = cs.mul(n1,n2);
			break;
		case "div":
			if(n2!=0) {
				
				result = cs.div(n1,n2);
			}else {
				m.addAttribute("num1", n1);
				m.addAttribute("num2", n2);
				return "result";
			}
			break;
			default: 
				m.addAttribute("error", "invaild oeration");
				return "result";
		}
		m.addAttribute("num1", n1);
		m.addAttribute("num2", n2);
		m.addAttribute("operation", op);
		m.addAttribute("result", result);
		return "result";
	}
	
}
