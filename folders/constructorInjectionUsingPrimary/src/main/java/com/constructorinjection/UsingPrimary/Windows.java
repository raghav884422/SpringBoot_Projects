package com.constructorinjection.UsingPrimary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Windows implements Os {
@Override
public void operate() {
	// TODO Auto-generated method stub
	System.out.println("Windows is operating.......");
	
}
}
