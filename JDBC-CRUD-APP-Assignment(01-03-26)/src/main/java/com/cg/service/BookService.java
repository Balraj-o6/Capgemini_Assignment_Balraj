package com.cg.service;

import java.util.List;

import com.cg.bean.Author;
import com.cg.bean.Book;
import com.cg.dao.BookDao;
import com.cg.dao.IBookDao;

public class BookService implements IBookService {

	IBookDao bo = new BookDao();

	@Override
	public List<String> getBooksByAuthor(String firstName) {
		if (firstName == null || firstName.isEmpty()) {
			System.out.println("Enter a valid Author Name.");
			return null;
		} else
			return bo.getBooksByAuthor(firstName);
	}

	@Override
	public String insertBook(Book book) {
		if (book.getAuthorId() <= 0 || book.getPrice() <= 0 || book.getTitle() == null) {
			return "Enter valid data.";
		} else
			return bo.insertBook(book);
	}

	@Override
	public String insertAuthor(Author author) {
		if (author.getFirstName() == null || author.getPhoneNo() == null) {
			return "Enter valid data";
		} else
			return bo.insertAuthor(author);
	}

	@Override
	public String updateBookPrice(String authorName, double newPrice) {
		if (authorName == null || newPrice <= 0) {
			return "Enter valid data.";
		} else
			return bo.updateBookPrice(authorName, newPrice);
	}

}
