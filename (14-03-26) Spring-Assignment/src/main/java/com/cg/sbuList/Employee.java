package com.cg.sbuList;

public class Employee {
	private int empId;
	private String empName;
	private double salary;

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
