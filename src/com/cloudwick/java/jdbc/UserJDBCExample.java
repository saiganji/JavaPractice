package com.cloudwick.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 *  Use con.setautocommmit=false; while creating connection
 *  
 *   
 */

public class UserJDBCExample {
	private Connection con;

	private void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/test";
			con = DriverManager.getConnection(url, "root", "ganji");
			con.setAutoCommit(false);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertUser() throws SQLException {
		String sql = "Insert into User(username, password) values(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "abc");
		ps.setString(2, "def");
		int count = ps.executeUpdate();
		System.out.println("Count " + count);

	}

	private void updateUser() throws SQLException {
		Statement st = con.createStatement();
		int count = st
				.executeUpdate("Update User set username='FG' where userid=1");
	}

	private void selectUser() throws SQLException {
		PreparedStatement ps = con
				.prepareStatement("select * from User where userid=?");
		ps.setInt(1, 1);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("test");
			int id = rs.getInt(1);
			String uname = rs.getString(2);
			String pass = rs.getString(3);
			System.out.println("Id: " + id + " Username: " + uname
					+ " Password " + pass);
		}

	}

	public static void main(String[] args) throws SQLException {
		UserJDBCExample obj = new UserJDBCExample();

		obj.createConnection();
		obj.insertUser();
		obj.updateUser();
		obj.selectUser();

	}

}
