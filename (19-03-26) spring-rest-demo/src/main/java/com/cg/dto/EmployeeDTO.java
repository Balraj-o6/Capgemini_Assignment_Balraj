package com.cg.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmployeeDTO {
	private int employeeId;
	private String fullName;
	@JsonFormat(pattern = "dd-MMM-yyyy")
	private LocalDate dob;
	private double salary;

	public EmployeeDTO() {

	}

	public EmployeeDTO(int employeeId, String fullName, LocalDate dob, double salary) {
		super();
		this.employeeId = employeeId;
		this.fullName = fullName;
		this.dob = dob;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
