package com.cg.sbuList;

import java.util.List;

public class SBU {
	private int sbuCode;
	private String sbuName;
	private String sbuHead;

	private List<Employee> empList;

	public void setSbuCode(int sbuCode) {
		this.sbuCode = sbuCode;
	}

	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}

	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public void displaySBUDetails() {

		System.out.println("SBU Details");
		System.out.println("Code: " + sbuCode);
		System.out.println("Name: " + sbuName);
		System.out.println("Head: " + sbuHead);

		System.out.println("\nEmployee List:");

		for (Employee e : empList) {
			System.out.println(e);
		}
	}
}
