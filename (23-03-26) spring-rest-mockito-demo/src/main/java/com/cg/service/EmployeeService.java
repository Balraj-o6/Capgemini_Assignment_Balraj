package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IEmployeeRepo;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.exception.EmployeeNotFoundException;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepo repo;
	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<Employee> emps = repo.findAll();
		List<EmployeeDTO> empd = new ArrayList<>();
		emps.forEach(e->empd.add(EntityMapper.convertEntityToObject(e)));
		return empd;
	}

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO emp) {
		Employee e = repo.saveAndFlush(EntityMapper.convertObjectToEntity(emp));
		return EntityMapper.convertEntityToObject(e);
	}

	@Override
	public EmployeeDTO getEmployee(int empid) throws EmployeeNotFoundException {
		Optional<Employee> op = repo.findById(empid);
		if(op.isPresent()) {
			return EntityMapper.convertEntityToObject(op.get());
		}
		else
			throw new EmployeeNotFoundException("Employee Not Found !!!!!");
	}

	@Override
	public String removeEmployee(int empid) {
		if(getEmployee(empid)!=null) {
		repo.deleteById(empid);
		return "Employee Deleted....";
		}else {
			return "Employee not found";
		}
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO emp) {
		if(getEmployee(emp.getEmployeeId())!=null) {
			Employee e = repo.saveAndFlush(EntityMapper.convertObjectToEntity(emp));
			return EntityMapper.convertEntityToObject(e);
		}else {
			return null;
		}
	}

	@Override
	public List<EmployeeDTO> getEmpByName(String name) {
		List<Employee> emps = repo.findByName(name);
		List<EmployeeDTO> empd = new ArrayList<>();
		emps.forEach(e->empd.add(EntityMapper.convertEntityToObject(e)));
		return empd;
	}

}
