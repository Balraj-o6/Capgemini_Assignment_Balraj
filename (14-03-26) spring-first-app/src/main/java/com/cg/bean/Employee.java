package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("e")
public class Employee {
	@Value("${empid}")
	private int empid;
	@Value("${empname}")
	private String name;
	@Autowired
	private Address address;

	public Employee() {
	}

	public Employee(int empid, String name, Address address) {
		this.empid = empid;
		this.name = name;
		this.address = address;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void printEmployeeDetails() {
		System.out.println("EmpId: " + empid);
		System.out.println("Name: " + name);
		System.out.println("==========Address===========");
		System.out.println("City: " + address.getCity());
		System.out.println("Country: " + address.getCountry());
		System.out.println("Zip: " + address.getZip());
	}
}
