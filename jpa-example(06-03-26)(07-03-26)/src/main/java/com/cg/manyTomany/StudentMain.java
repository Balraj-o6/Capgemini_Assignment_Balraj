package com.cg.manyTomany;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class StudentMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Student s = new Student("Golden");
		Course c = em.find(Course.class, 2);
//		Course c1 = new Course("Spring");
//		em.persist(c);
//		em.persist(c1);
		Set<Course> li = new HashSet<>();
		li.add(c);
//		li.add(c1);
		s.setCourses(li);
		
		em.persist(s);
		em.getTransaction().commit();
		System.out.println("Created....");
		
	}
}
