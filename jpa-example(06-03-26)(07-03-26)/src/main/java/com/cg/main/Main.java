package com.cg.main;

import java.time.LocalDate;
import java.util.List;

import com.cg.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		// Product p = new Product(104, "HP-ENVY", 190000, 4, LocalDate.of(2025, 8,
		// 20));
		// Product p1 = new Product(105, "MSI-modern-15", 50000, 60, LocalDate.of(2024,
		// 10, 10));
		// Product p2 = new Product(106, "Samsung SSD-1TB", 5000, 50, LocalDate.of(2023,
		// 4, 20));
		// Product p3 = new Product(107, "Shoes", 1500, 100, LocalDate.of(2025, 7, 20));
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
		EntityManager em = emf.createEntityManager();
		// Product p = em.find(Product.class, 105);
		// if (p != null)
		// System.out.println(p);
		// else
		// System.out.println("Product not found");
		// EntityTransaction tx = em.getTransaction();
		// tx.begin();
		// em.persist(p);
		// em.persist(p1);
		// em.persist(p2);
		// em.persist(p3);
		// tx.commit();
		// System.out.println("Product Created...");

		List<Product> li = em.createQuery("from Product").getResultList();
		li.forEach(p -> System.out.println(p));
	}
}
