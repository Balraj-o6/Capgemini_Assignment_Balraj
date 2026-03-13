package com.cg.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmployeeDAO {
	private Map<Integer, Employee> empMap = new LinkedHashMap<>();

	public void setEmpMap(Map<Integer, Employee> empMap) {
		this.empMap = empMap;
	}

	public Employee getEmployee(int empId) {
		return empMap.get(empId);
	}
}
