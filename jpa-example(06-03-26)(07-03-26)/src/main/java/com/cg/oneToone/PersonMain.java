package com.cg.oneToone;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		/*
		 * em.getTransaction().begin(); 
		 * Person p = new Person("Goldie",LocalDate.of(2002, 2, 15)); 
		 * Dl obj = new Dl(LocalDate.of(2040, 10, 12),LocalDate.of(2019, 10, 12),"LMV,HMV");
		 * p.setDl(obj); 
		 * //em.persist(obj); 
		 * em.persist(p); 
		 * em.getTransaction().commit();
		 */
		
		/*
		 * Person p = em.find(Person.class, 1); 
		 * if (p != null) { 
		 * System.out.println(p);
		 * }
		 */
		
		em.getTransaction().begin();
		Person p = em.find(Person.class, 1);
		p.getDl().setExpDate(LocalDate.of(2043, 5, 11));
		em.getTransaction().commit();
		
		// System.out.println("Person Created.....");
	}
}
