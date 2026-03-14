package com.cg.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

		Employee emp = (Employee) context.getBean("e1");
		emp.displayEmployeeDetails();
		((ClassPathXmlApplicationContext) context).close();
	}
}
