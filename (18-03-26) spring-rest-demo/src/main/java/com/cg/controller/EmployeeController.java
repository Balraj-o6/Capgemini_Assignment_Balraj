package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Employee;
import com.cg.service.IEmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	private IEmployeeService service;
	
	
	public EmployeeController(IEmployeeService service) {
		super();
		this.service = service;
	}

	@GetMapping
	public List<Employee> getXyz() { 
		return service.getAllEmployee();
	}
	
	@GetMapping("/{eid}")
	public Employee getEmp(@PathVariable int eid) {
		return service.getEmployee(eid);
	}
	
	@GetMapping("/name/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name){
		return service.getEmpByName(name);
	}
	
	@PostMapping
	public Employee createNewEmployee(@RequestBody Employee emp) {
		return service.createEmployee(emp);
	}
	
	@DeleteMapping("/{empid}")
	public String deleteEmployee(@PathVariable int empid) {
		return service.removeEmployee(empid);
	}
	
	@PutMapping
	public Employee updateEmployee(Employee emp) {
		return service.updateEmployee(emp);
	}
}
