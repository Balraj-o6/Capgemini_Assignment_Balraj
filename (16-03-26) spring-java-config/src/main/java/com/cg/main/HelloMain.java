package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.bean.Employee;
import com.cg.bean.HelloWorld;
import com.cg.cfg.MyConfig;

public class HelloMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig.class);
		Employee h = ctx.getBean(Employee.class);
		h.printEmployeeDetails();
		
	}
} 
