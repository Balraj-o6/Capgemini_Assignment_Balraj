package com.cg.employee;

public class Employee {
	private int empId;
	private String empName;
	private double salary;
	private String businessUnit;
	private int age;

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void displayEmployeeDetails() {
		System.out.println("Employee Details");
		System.out.println("Employee ID: " + empId);
		System.out.println("Employee Name: " + empName);
		System.out.println("Salary: " + salary);
		System.out.println("Business Unit: " + businessUnit);
		System.out.println("Age: " + age);
	}
}
