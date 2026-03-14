package com.cg.bean;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		Car c = (Car)ctx.getBean("car");
//		System.out.println("Enter Engine Type (Petrol or CNG)");
//		String etype = sc.next();
//		System.out.println("Enter Tyre Type (MRF or JK)");
//		String tyre = sc.next();
//		
//		IEngine e = (IEngine)ctx.getBean(etype.toLowerCase());
//		ITyre t = (ITyre)ctx.getBean(tyre.toLowerCase());
//		c.setEngine(e);
//		c.setTyre(t);
//		c.setName("Alto");
		c.printCar();
		sc.close();
		((ClassPathXmlApplicationContext)ctx).close();
	} 

}
