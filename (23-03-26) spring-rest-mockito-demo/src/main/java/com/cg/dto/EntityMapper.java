package com.cg.dto;

import com.cg.entity.Employee;

public class EntityMapper {
	public static Employee convertObjectToEntity(EmployeeDTO edto) {
		return new Employee(edto.getFullName(),edto.getDob(),edto.getSalary());
	}
	
	public static EmployeeDTO convertEntityToObject(Employee emp) {
		EmployeeDTO edto = new EmployeeDTO(emp.getName(),emp.getDob(),emp.getSal());
		edto.setEmployeeId(emp.getEmpid());
		return edto;
	}
}
