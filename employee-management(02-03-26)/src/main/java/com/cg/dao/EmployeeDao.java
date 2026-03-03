package com.cg.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Employee;

public class EmployeeDao implements IEmployeeDao {
	private static Connection con;
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Balraj@666");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public String saveEmployee(Employee emp) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?)");
			ps.setString(1, emp.getEmpid());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getDob());
			int rows = ps.executeUpdate();
			if (rows > 0)
				return "Employee Created";
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "Employee Not Created";
	}

	@Override
	public Employee findEmployee(String empid) {

		Employee em = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from emp where empid=?");
			ps.setString(1, empid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				em = new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			return em;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println("Employee not found");
		return null;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> li = new ArrayList<Employee>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				li.add(new Employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			return li;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return li;
	}

	@Override
	public String updateEmployeeName(String empid, String newName) {
		try {
			PreparedStatement ps = con.prepareStatement("update emp SET name=? where empid=?");
			ps.setString(1, newName);
			ps.setString(2, empid);
			int rows = ps.executeUpdate();
			if (rows > 0)
				return "Updated successfully";
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "Empid not found";
	}

	@Override
	public String deleteEmployee(String empid) {
		try {
			// PreparedStatement ps = con.prepareStatement("delete from emp where empid=?");
			// ps.setString(1, empid);
			// int row = ps.executeUpdate();
			// if(row>0)
			// return "Employee deleted";
			CallableStatement cs = con.prepareCall("{call del_employee(?)}");
			cs.setString(1, empid);
			int row = cs.executeUpdate();
			if (row > 0)
				return "Deleted";
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return "Employee not deleted";
	}

}