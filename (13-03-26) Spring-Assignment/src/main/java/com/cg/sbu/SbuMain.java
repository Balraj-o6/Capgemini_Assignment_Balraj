package com.cg.sbu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SbuMain {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

		Employee emp = (Employee) context.getBean("employeeSbu");
		emp.getEmployeeDetails();
		((ClassPathXmlApplicationContext) context).close();
	}
}
