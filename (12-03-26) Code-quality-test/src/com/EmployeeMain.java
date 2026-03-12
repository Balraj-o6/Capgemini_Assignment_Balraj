package com;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Balraj
 */
public class EmployeeMain {
	/**
	 * 
	 * 
	 */
	private static final Logger LOGGER = Logger.getLogger("EmployeeMain");
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final Employee employee = new Employee();
		employee.setEmpid(101);
		employee.setName("Balraj");
		employee.setEmail("balraj@gmail.com");
		if(LOGGER.isLoggable(Level.INFO)) {
			LOGGER.info("Name: "+employee.getName());
		}
	}
}
