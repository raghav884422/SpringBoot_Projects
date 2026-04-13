package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/greeting")
public class Greeting {
@GetMapping("/greet")
@ResponseBody
public String greet() {
	return "hello shivi i love you❤️❤️❤️❤️❤️❤️ shadi kar lo mere se please jaldi";
}

}
