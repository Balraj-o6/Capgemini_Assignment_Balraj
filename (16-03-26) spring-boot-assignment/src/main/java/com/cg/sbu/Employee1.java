package com.cg.sbu;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee1 {
	private int empId;
	private String empName;
	private double salary;
	private int age;
	@Autowired
	private SBU sbu;

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSbu(SBU sbu) {
		this.sbu = sbu;
	}

	public void secondQuestion() {
		System.out.println("Second Answer....");
		System.out.println("Employee Details");
		System.out.println("ID: " + empId);
		System.out.println("Name: " + empName);
		System.out.println("Salary: " + salary);
		System.out.println("Age: " + age);

		System.out.println(sbu.getSbuDetails());
		System.out.println("============================================");
	}
}
