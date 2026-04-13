package com.constructorinjection.UsingPrimary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ConstructorInjectionUsingPrimaryApplication {

	public static void main(String[] args) {
		ApplicationContext ac =SpringApplication.run(ConstructorInjectionUsingPrimaryApplication.class, args);
	Laptop laptop = ac.getBean(Laptop.class);
	laptop.build();
	
	}
	

}
