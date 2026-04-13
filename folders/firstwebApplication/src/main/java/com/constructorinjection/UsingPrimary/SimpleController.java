package com.constructorinjection.UsingPrimary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController {
@RequestMapping("/")
@ResponseBody
public String greet() {
	return "Hello World";
}
}
