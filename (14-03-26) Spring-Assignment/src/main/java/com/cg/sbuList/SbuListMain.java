package com.cg.sbuList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SbuListMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

		SBU sbu = (SBU) context.getBean("sbuList");
		sbu.displaySBUDetails();
		((ClassPathXmlApplicationContext) context).close();

	}

}
