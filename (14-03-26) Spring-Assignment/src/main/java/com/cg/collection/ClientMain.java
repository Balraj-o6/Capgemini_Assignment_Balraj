package com.cg.collection;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientMain {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

		EmployeeService service = (EmployeeService) context.getBean("empService");

		Scanner sc = new Scanner(System.in);

		System.out.print("Employee ID: ");
		int id = sc.nextInt();

		Employee e = service.getEmployee(id);

		System.out.println("Employee Info");
		System.out.println("Employee ID: " + e.getEmpId());
		System.out.println("Employee Name: " + e.getEmpName());
		System.out.println("Employee Salary: " + e.getSalary());
		
		((ClassPathXmlApplicationContext)context).close();
		sc.close();
	}
}
