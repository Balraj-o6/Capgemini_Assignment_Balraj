package com.cg.employee;

public class Employee {
	private int empid;
	private String name;
	private double sal;
	private String sbu;
	private int age;

	public Employee() {
	}

	public Employee(int empid, String name, double sal, String sbu, int age) {
		super();
		this.empid = empid;
		this.name = name;
		this.sal = sal;
		this.sbu = sbu;
		this.age = age;
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

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public String getSbu() {
		return sbu;
	}

	public void setSbu(String sbu) {
		this.sbu = sbu;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void firstQuestion() {
		System.out.println("Answer for first question..");
		System.out.println("Employee Details......");
		System.out.println("Emp Id: " + empid);
		System.out.println("Emp Name: " + name);
		System.out.println("Emp sal: " + sal);
		System.out.println("Employee BU: " + sbu);
		System.out.println("=====================================");

	}

}
