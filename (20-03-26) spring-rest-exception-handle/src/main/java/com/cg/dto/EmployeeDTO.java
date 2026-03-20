package com.cg.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeDTO {
	private int employeeId;
	@NotNull(message = "Name is required")
	@NotBlank(message = "Enter valid Name")
	private String fullName;
	@JsonFormat(pattern = "dd-MMM-yyyy")
	private LocalDate dob;
	@NotNull(message = "Salary is required")
	@Min(value = 10000)
	private Double salary;

	public EmployeeDTO() {

	}

	public EmployeeDTO(String fullName, LocalDate dob, Double salary) {
		super();
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
