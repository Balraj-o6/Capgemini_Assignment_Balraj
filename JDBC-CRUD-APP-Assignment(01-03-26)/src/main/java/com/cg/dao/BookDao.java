package com.cg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Author;
import com.cg.bean.Book;

public class BookDao implements IBookDao {

	private static Connection con;
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Balraj@666");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getBooksByAuthor(String firstName) {
		List<String> li = new ArrayList<String>();
		try {
			PreparedStatement ps = con.prepareStatement(
					"select b.title from book b join author a on b.authorID = a.authorID where a.firstName = ?");
			ps.setString(1, firstName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				li.add(rs.getString(1));
			}
			return li;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("No book found.");
		return null;
	}

	@Override
	public String insertBook(Book book) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO Book(title,price,authorId) VALUES (?,?,?)");
			ps.setString(1, book.getTitle());
			ps.setDouble(2, book.getPrice());
			ps.setInt(3, book.getAuthorId());
			int row = ps.executeUpdate();
			if (row > 0)
				return "Book added success.";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Book insert failed.";
	}

	@Override
	public String insertAuthor(Author author) {
		try {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO Author(firstName,middleName,lastName,phoneNo) VALUES (?,?,?,?)");
			ps.setString(1, author.getFirstName());
			ps.setString(2, author.getMiddleName());
			ps.setString(3, author.getLastName());
			ps.setString(4, author.getPhoneNo());
			int row = ps.executeUpdate();
			if (row > 0)
				return "Author added successfully. ";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Author insert failed";
	}

	@Override
	public String updateBookPrice(String authorName, double newPrice) {
		try {
			PreparedStatement ps = con.prepareStatement(
					"update book set price = ? where authorID in(select authorID from author where firstName = ?)");
			ps.setDouble(1, newPrice);
			ps.setString(2, authorName);
			int row = ps.executeUpdate();
			if (row > 0)
				return "Book price updated.";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Author not found.";
	}

}
