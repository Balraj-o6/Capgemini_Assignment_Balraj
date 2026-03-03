package com.cg.service;

import java.util.List;

import com.cg.bean.Author;
import com.cg.bean.Book;

public interface IBookService {
	public List<String> getBooksByAuthor(String firstName);

	public String insertBook(Book book);

	public String insertAuthor(Author author);

	public String updateBookPrice(String authorName, double newPrice);
}
