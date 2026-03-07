package com.cg.practice;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmployeeMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		Department d = new Department("Accounts");
//		List<Employee> li = new ArrayList<>();
//		li.add(new Employee("Rama",30000,d));
//		li.add(new Employee("Romi",10000,d));
//		li.add(new Employee("goldie",50000,d));
//		d.setEmployee(li);
//		em.persist(d);
//		em.getTransaction().commit();
//		System.out.println("Created....");
		
//		Department d = em.find(Department.class, 2);
//		d.getEmployee().forEach(a->System.out.println(a.getName()));
		
		Employee e = em.find(Employee.class, 52);
		System.out.println(e.getDepartment().getDeptName());
		
	}
}
