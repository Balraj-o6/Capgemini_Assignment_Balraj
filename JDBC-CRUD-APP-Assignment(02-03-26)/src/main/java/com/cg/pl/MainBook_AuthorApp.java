package com.cg.pl;

import com.cg.bean.Author;
import com.cg.bean.Book;
import com.cg.service.BookService;
import com.cg.service.IBookService;

public class MainBook_AuthorApp {
	public static void main(String[] args) {
		IBookService bs = new BookService();
		// System.out.println(bs.insertAuthor(new
		// Author("Ayush","kumar","chaudhary","123456")));
		// System.out.println(bs.insertBook(new Book("Java",3500,2)));
		// System.out.println(bs.getBooksByAuthor("Ba"));
		System.out.println(bs.updateBookPrice("Ba", 3000));
	}
}
