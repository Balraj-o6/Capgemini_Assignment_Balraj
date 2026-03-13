package com.cg.collection;

public class EmployeeService {
	private EmployeeDAO dao;

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	public Employee getEmployee(int id) {
		return dao.getEmployee(id);
	}
}
