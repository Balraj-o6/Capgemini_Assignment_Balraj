package com.cg.lib_man_sys;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AuthorService {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
	EntityManager em = emf.createEntityManager();
	Scanner sc = new Scanner(System.in);

	public void insertdata(Author a, List<Book> book) {
		em.getTransaction().begin();
		a.setBooks(book);
		em.persist(a);
		em.getTransaction().commit();
	}

	public void readAll() {
		List<Author> author = em.createQuery("from Author", Author.class).getResultList();
//		for (Author aut : author) {
//			System.out.println("Author Id: " + aut.getAuthorId());
//			System.out.println("Author name: " + aut.getAuthorName());
//			System.out.println("========Books=======");
//			for (Book book : aut.getBooks()) {
//				System.out.println(book.getTitle() + " - " + book.getPrice());
//			}
//		}
		author.forEach(a -> {
			System.out.println("Author Id: " + a.getAuthorId());
			System.out.println("Author name: " + a.getAuthorName());
			System.out.println("========Books=======");
			a.getBooks().forEach(e -> System.out.println(e.getTitle() + " - " + e.getPrice()));
		});
	}

	public void updateprice(int id, double price) {
		em.getTransaction().begin();

		Book book = em.find(Book.class, id);

		book.setPrice(price);
		em.getTransaction().commit();

	}

	public void deletebook(int id) {
		em.getTransaction().begin();

		Book book2 = em.find(Book.class, id);
		em.remove(book2);
		em.getTransaction().commit();

	}

	public void deleteAuthor(int aid) {
		em.getTransaction().begin();

		Author au = em.find(Author.class, aid);
		em.remove(au);
		em.getTransaction().commit();

	}
}
