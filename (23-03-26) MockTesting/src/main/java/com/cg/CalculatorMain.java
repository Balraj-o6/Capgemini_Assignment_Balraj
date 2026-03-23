package com.cg;

public class CalculatorMain {
	public static void main(String[] args) {
		ICalculator c=(i,j)->i+j;
		CalculatorService cs = new CalculatorService(c);
		
		System.out.println(cs.addService(10, 5));
	}
}
