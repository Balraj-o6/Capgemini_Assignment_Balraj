package com.cg.dao;

import java.util.List;

import com.cg.bean.Author;
import com.cg.bean.Book;

public interface IBookDao {
	public List<String> getBooksByAuthor(String firstName);

	public String insertBook(Book book);

	public String insertAuthor(Author author);

	public String updateBookPrice(String authorName, double newPrice);
}
