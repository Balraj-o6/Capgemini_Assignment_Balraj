package com.cg.lib_man_sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AuthorService ls = new AuthorService();
		while (true) {
			System.out.println("Choose your operation to perfoorm...");
			System.out.println("1.Insert new author and books.");
			System.out.println("2.Display all authors and there books.");
			System.out.println("3.Update book price.");
			System.out.println("4.Delete a specific book.");
			System.out.println("5.Delete a author and all their books.");
			System.out.println("6. Exit.");

			System.out.println("Enter your choice: ");
			int ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 1:
				System.out.println("Enter author name: ");
				String aname = sc.nextLine();
				System.out.println("Enter author email: ");
				String email = sc.nextLine();
				Author a = new Author(aname, email);
				List<Book> li = new ArrayList<>();
				System.out.println("Enter the no. of books: ");
				int n = sc.nextInt();
				sc.nextLine();
				for (int i = 0; i < n; i++) {
					System.out.println("Enter book title: ");
					String title = sc.nextLine();
					System.out.println("Enter book price: ");
					double price = sc.nextDouble();
					sc.nextLine();
					li.add(new Book(title, price, a));
				}
				ls.insertdata(a, li);
				System.out.println("Created...");
				break;
			case 2:
				ls.readAll();
				break;
			case 3:
				System.out.println("Enter bookId: ");
				int bid = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter new price: ");
				double price = sc.nextDouble();
				sc.nextLine();
				ls.updateprice(bid, price);
				System.out.println("Updated....");
				break;
			case 4:
				System.out.println("Enter bookId: ");
				int bid2 = sc.nextInt();
				sc.nextLine();

				ls.deletebook(bid2);
				System.out.println("Book Deleted....");
				break;
			case 5:
				System.out.println("Enter AuthorId: ");
				int aid = sc.nextInt();
				sc.nextLine();
				ls.deleteAuthor(aid);
				System.out.println("Author and their book deleted...");
				break;
			case 6:
				System.out.println("Exiting system...");
				System.exit(100);
			default:
				System.out.println("Enter a valid choice...");
				break;
			}
			// sc.close();
		}

	}
}
