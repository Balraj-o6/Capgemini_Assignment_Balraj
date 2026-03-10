package com.cg.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
//import java.sql.SQLException;

public class MyDBConnection {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Balraj@666");
			System.out.println("Connected");
			// Statement stat = con.createStatement();
			/*
			 * ResultSet rs = stat.executeQuery("Select * from emp"); while (rs.next()) {
			 * System.out.println(rs.getString("ENAME") + "\t" + rs.getString("JOB") + "\t"
			 * + rs.getDouble("SAL")); }
			 */
			// Scanner sc = new Scanner(System.in);
			// System.out.println("Enter Employee ID: ");
			// int id = sc.nextInt();
			// PreparedStatement ps = con.prepareStatement("select * from emp where EMPNO=?
			// and SAL=?");
			// ps.setInt(1, 7521);
			// ps.setInt(2, 1250);
			// ResultSet rs = ps.executeQuery();
			// if(rs.next())
			// System.out.println(rs.getString("ENAME"));
			// else
			// System.out.println("EMP not found");
			PreparedStatement ps = con.prepareStatement("delete from emp where EMPNO=?");
			ps.setInt(1, 1);
			//ps.setString(2, "Ayush");
			//ps.setString(3, "ANALYST");
			//ps.setInt(4, 7526);
			//ps.setString(5, "2026-02-25");
			//ps.setInt(6, 8000);
			//ps.setInt(7, 300);
			//ps.setInt(8, 20);
			int rows = ps.executeUpdate();
			System.out.println(rows + " row deleted");
			//if (rows > 0)
				//System.out.println("emp deleted");
			
			PreparedStatement ps1 = con.prepareStatement("update emp SET HIREDATE =? where EMPNO=?");
			ps1.setString(1, "1981-02-25");
			ps1.setInt(2, 7521);
			int row = ps1.executeUpdate();
			System.out.println(row+" row updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
