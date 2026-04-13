package com.constructorinjection.UsingPrimary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class SecondController {
	@GetMapping("/greet")
	@ResponseBody
	public String greet() {
		return "hello World raghav sab duniya jhaat se";
	}
}
