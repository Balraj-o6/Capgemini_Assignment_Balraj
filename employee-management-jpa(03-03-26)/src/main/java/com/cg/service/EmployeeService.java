package com.cg.service;

import java.util.List;
import java.util.Random;

import com.cg.bean.Employee;
import com.cg.dao.EmployeeDao;
import com.cg.dao.IEmployeeDao;

public class EmployeeService implements IEmployeeService {
	IEmployeeDao dao = new EmployeeDao();

	@Override
	public String createEmployee(Employee emp) {
		if (emp.getName() == null || emp.getName().length() < 4 || emp.getEmail() == null) {
			return "Invalid Employee Data";
		} else {
			Random r = new Random();
			String empid = emp.getName().substring(0, 3) + r.nextInt(1000);
			emp.setEmpid(empid);
			return dao.saveEmployee(emp);
		}
	}

	@Override
	public Employee findById(String eid) {
		if (eid == null || eid.isEmpty() || eid.length() <= 4) {
			System.out.println("Wrong Empid enter new");
			return null;
		} else
			return dao.findEmployee(eid);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return dao.getAll();
	}

	@Override
	public String updateEmployeeName(String eid, String name) {
		if (eid == null || eid.length() <= 4 || name == null || name.isEmpty())
			return "Invalid empid or name";
		else
			return dao.updateEmployeeName(eid, name);
	}

	@Override
	public String removeEmployee(String empid) {
		if (empid != null)
			return dao.deleteEmployee(empid);
		else
			return "Invalid data";
	}

}