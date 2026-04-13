package com.constructorinjection.UsingPrimary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Laptop {
	@Autowired
private Os os;

void build() {
	System.out.println("building the first app");
	os.operate();
}
}
