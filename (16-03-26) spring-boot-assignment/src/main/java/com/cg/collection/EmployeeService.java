package com.cg.collection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {
	@Autowired
	private List<Employee3> l = new ArrayList<Employee3>();

	public EmployeeService() {

	}

	public EmployeeService(List<Employee3> l) {
		super();
		this.l = l;
	}

	public List<Employee3> getL() {
		return l;
	}

	public void setL(List<Employee3> l) {
		this.l = l;
	}
	
	public void fourthQuestion(int id) {
		System.out.println("Fourth Answer....");
		for(Employee3 e: l) {
			if(e.getEmpId() == id) {
				System.out.println("Employee Detail...");
				System.out.println("Employee Id: "+e.getEmpId());
				System.out.println("Employee Name: "+e.getEmpName());
				System.out.println("Employee Salary: "+e.getSalary());
			}
		}
	}

}
