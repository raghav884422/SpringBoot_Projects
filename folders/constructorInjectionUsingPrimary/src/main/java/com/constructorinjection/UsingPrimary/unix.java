package com.constructorinjection.UsingPrimary;

import org.springframework.stereotype.Component;

@Component
public class unix implements Os {
@Override
public void operate() {
	// TODO Auto-generated method stub
	System.out.println("unix is operating........");
	
}
}
