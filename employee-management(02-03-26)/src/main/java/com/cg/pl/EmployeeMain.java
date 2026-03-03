package com.cg.pl;

import com.cg.bean.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;

public class EmployeeMain {

	public static void main(String[] args) {
		IEmployeeService es = new EmployeeService();
		// String result = es.createEmployee(new Employee("Rama", "ram@gmail.com",
		// "1981-06-26"));
		// System.out.println(result);
		System.out.println(es.findById("Ram17"));
		System.out.println(es.getAllEmployee());
		// System.out.println(es.updateEmployeeName("Ram17", "Bal"));
		// System.out.println(es.removeEmployee("Ram17"));

	}

}