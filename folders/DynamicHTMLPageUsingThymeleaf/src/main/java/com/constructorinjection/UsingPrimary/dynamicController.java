package com.constructorinjection.UsingPrimary;

import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class dynamicController {
	int a=0;
//	Scanner sc = new Scanner(System.in);
//	String name = sc.next();   taking the input in console and show in website
	@GetMapping("/show")
String getPage(Model m) {
	String content = "hello user "+  ++a+ ", welcome to my first Dynamic page.";
	m.addAttribute("message",content);
	return "Dynamicpage";
}
}
