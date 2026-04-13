package com.Caloculator.app.service;


import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    
	public static  double add(double a, double b) {
		return a + b;
	}

	public static double sub(double a, double b) {
		return a - b;
	}

	public static double mul(double a, double b) {
		return a * b;
	}

	public static double div(double a, double b) {
		if(b==0) {
		throw new ArithmeticException("Denominator cant be zero");
		}
		else {
			
			return a / b;
		}
	}

}
