package com.constructorinjection.UsingPrimary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class EngineController {
	@GetMapping("/page")
String getPage() {
	return "page2";
}
}
