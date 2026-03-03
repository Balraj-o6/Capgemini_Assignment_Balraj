package com.cg.bean;

public class Book {
	private int isbn;
	private String title;
	private double price;
	private int authorId;

	public Book() {
	}

	public Book(String title, double price, int authorId) {
		this.title = title;
		this.price = price;
		this.authorId = authorId;
	}

	// getters and setters
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public int getAuthorId() {
		return authorId;
	}

	public String toString() {
		return "Title: " + getTitle() + " Price: " + getPrice() + " Author Id: " + getAuthorId();
	}

}
