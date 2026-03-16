package com.cg.sbuList;

public class Employee2 {
	private int empId;
	private String empName;
	private double salary;

	public Employee2() {
	}

	public Employee2(int empId, String empName, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return empId + " " + empName + " " + salary;
	}
}
