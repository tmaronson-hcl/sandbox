package com.hcl.demos;

import java.sql.*;

public class JDBCExamplePrepStmt {
	// Get Type 4 Java Driver
	// static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	// Check database, connection port and get URL.
	static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";

	// Obviously password would not be clear text but what the heck for demo.
	static final String USER = "root";
	static final String PASS = "passwd";

	public static void main(String[] args) {

		JDBCExamplePrepStmt jdbc = new JDBCExamplePrepStmt();
		jdbc.getConnection();
	}

	private void getConnection() {

		// Don't need classloader with above driver.
		// Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database...");
		// Will use datasource later.
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
			getData(conn);

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getData(Connection conn) {

		System.out.println("Creating PreparedStatement...");
		String sql = "SELECT * FROM actor"; // get actor table in db sakila.
		try (PreparedStatement stmt = conn.prepareStatement(sql); 
			 ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) { // iterate through ResultSet and print data
				int id = rs.getInt("actor_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String date = rs.getString("last_update");

				System.out.printf("ID: %d", id);
				System.out.printf(", Name: %s %s", firstName, lastName);
				System.out.printf(", date: %s \n", date);
			}
			sql = "INSERT INTO actor(first_name, last_name) VALUES(?, ?) ";
			try (PreparedStatement stmt2 = conn.prepareStatement(sql);) {
				stmt2.setString(1, "Bob");
				stmt2.setString(2, "Kinsey");
				stmt2.executeUpdate();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
