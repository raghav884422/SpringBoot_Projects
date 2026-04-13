package com.constructorinjection.UsingPrimary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstwebApplication {

	public static void main(String[] args) {
		ApplicationContext ac =SpringApplication.run(FirstwebApplication.class, args);
	SimpleController sc = ac.getBean(SimpleController.class);
	sc.greet();
	
	}

}
