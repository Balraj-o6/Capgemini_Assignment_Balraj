package com.cg.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeDao implements IEmployeeDao {
	
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("my-pu");
	}

	@Override
	public String saveEmployee(Employee emp) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		return "Employee Added..";
	}

	@Override
	public Employee findEmployee(String empid) {
		EntityManager em = emf.createEntityManager();
		Employee e = em.find(Employee.class, empid);
		 if (e != null)
			 return e;
		 else {
			 System.out.println("Employee not found");
			 return null;
		 }
	}

	@Override
	public List<Employee> getAll() {
		EntityManager em = emf.createEntityManager();
		List<Employee> li = new ArrayList<Employee>();
		li = em.createQuery("from Employee").getResultList();
		return li;
	}

	@Override
	public String updateEmployeeName(String empid, String newName) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, empid);
		if(emp != null) {
			emp.setName(newName);
			em.getTransaction().commit();
			return "Updated successfully..";
		}else
			return "Update Failed.. empid not found";
	}

	@Override
	public String deleteEmployee(String empid) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Employee emp = em.find(Employee.class, empid);
		if(emp != null) {
			em.remove(emp);
			em.getTransaction().commit();
			return "Deleted Successfully..";
		}else
			return "Empid not found..";
	}
	

}