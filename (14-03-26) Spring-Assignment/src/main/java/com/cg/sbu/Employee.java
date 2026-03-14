package com.cg.sbu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("e2")
public class Employee {
	@Value("${empid}")
	private int empId;
	@Value("${empname}")
	private String empName;
	@Value("${sal}")
	private double salary;
	@Value("${age}")
	private int age;
	@Autowired
	@Qualifier("sbu")
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

	public void getEmployeeDetails() {

		System.out.println("Employee Details");
		System.out.println("ID: " + empId);
		System.out.println("Name: " + empName);
		System.out.println("Salary: " + salary);
		System.out.println("Age: " + age);

		System.out.println(sbu.getSbuDetails());
	}
}
