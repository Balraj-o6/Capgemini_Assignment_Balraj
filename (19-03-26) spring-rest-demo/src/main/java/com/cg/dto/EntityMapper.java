package com.cg.dto;

import com.cg.entity.Employee;

public class EntityMapper {
	public static Employee convertObjectToEntity(EmployeeDTO edto) {
		return new Employee(edto.getEmployeeId(),edto.getFullName(),edto.getDob(),edto.getSalary());
	}
	
	public static EmployeeDTO convertEntityToObject(Employee emp) {
		return new EmployeeDTO(emp.getEmpid(),emp.getName(),emp.getDob(),emp.getSal());
	}
}
