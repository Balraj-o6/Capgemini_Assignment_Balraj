package com.cg.sbuList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class SBUList {
	private String sbuCode;
	private String sbuName;
	private String sbuHead;
	@Autowired
	private List<Employee2> empList;

	public void setSbuCode(String sbuCode) {
		this.sbuCode = sbuCode;
	}

	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}

	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}

	public void setEmpList(List<Employee2> empList) {
		this.empList = empList;
	}

	public void thirdQuestion() {
		System.out.println("Third Answer.....");
		System.out.println("SBU Details");
		System.out.println("Code: " + sbuCode);
		System.out.println("Name: " + sbuName);
		System.out.println("Head: " + sbuHead);

		System.out.println("\nEmployee List:");

		for (Employee2 e : empList) {
			System.out.println(e);
		}
		System.out.println("===================================");
	}
}
