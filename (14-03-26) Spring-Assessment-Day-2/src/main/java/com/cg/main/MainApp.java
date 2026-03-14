package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.Librarian;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("=================With Setter Injection====================");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		Librarian l = (Librarian) ctx.getBean("lib");
		l.issueBook();
		
		System.out.println("=================With Constructor Injection====================");
		ApplicationContext ctx1 = new ClassPathXmlApplicationContext("conbean.xml");
		Librarian l1 = (Librarian) ctx1.getBean("lib");
		l1.issueBook();
		((ClassPathXmlApplicationContext) ctx).close();
		((ClassPathXmlApplicationContext) ctx1).close();
	}
}
