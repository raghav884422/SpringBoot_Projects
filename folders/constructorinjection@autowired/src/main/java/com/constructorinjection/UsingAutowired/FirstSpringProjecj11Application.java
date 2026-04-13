package com.constructorinjection.UsingAutowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringProjecj11Application {

	public static void main(String[] args) {
//	ApplicationContext ac	=SpringApplication.run(FirstSpringProjecj11Application.class, args);
//	Laptop lap = ac.getBean(Laptop.class);
//	lap.build();
		ApplicationContext ac = SpringApplication.run(FirstSpringProjecj11Application.class, args);
		Laptop laptop = (Laptop)ac.getBean("laptop");
		laptop.build();
	
	
	}

}
