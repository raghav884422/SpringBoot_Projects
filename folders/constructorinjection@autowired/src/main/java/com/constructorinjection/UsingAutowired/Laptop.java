package com.constructorinjection.UsingAutowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
	private Os os;
@Autowired
	public Laptop(Os os) {
		super();
		this.os = os;
	}

	public void build() {
		System.out.println("building the first app");
		os.operating();
	}
}
