package com.labs;

public class EmployeeMain {
	public static void main(String[] args) {
		EmployeeService es = new EmployeeService();
		System.out.println(es.sumOfSalary());
		System.out.println();
		System.out.println(es.getCountNoOfEEmployeeByDept());
		System.out.println();
		System.out.println(es.getSeniorMostEmployee());
		System.out.println();
		System.out.println(es.getEmployeeWithoutDept());
		System.out.println();
		es.getEmployeeDuration().forEach(e->System.out.println(e));
		System.out.println();
		System.out.println(es.getDeptWithoutEmployee());
		System.out.println();
		System.out.println(es.getDeptWithHighestCountEmployee());
	}
}
