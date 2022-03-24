package com.hcl.demos;

import java.sql.*;

public class JDBCExample {
	// Get Type 4 Java Driver
	// static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	// Check database, connection port and get URL.
	static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";

	// Obviously password would not be clear text but what the heck for demo.
	static final String USER = "root";
	static final String PASS = "passwd";

	public static void main(String[] args) {
		
		getData();
	}

	private static void getData() {

		// Don't need classloader with above driver.
		// 1. Load driver class if necessary.
				// Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Connecting to database...");
				// Will use datasource later. Use try-with-resources
				// 2. Create SQL.
				String sql = "SELECT * from actor"; // get any table in db sakila.
				// 3. Get connection
				try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
						// 4. Create statement or prepared statement.
						Statement stmt = conn.createStatement();
						// 5. For SELECT query, get ResultSet and process it.
						ResultSet rs = stmt.executeQuery(sql);) {

					while (rs.next()) { // iterate through ResultSet and print data
						int id = rs.getInt("actor_id");
						String firstName = rs.getString("first_name");
						String lastName = rs.getString("last_name");
						String date = rs.getString("last_update");

						System.out.printf("ID: %d", id);
						System.out.printf(", Name: %s %s", firstName, lastName);
						System.out.printf(", date: %s \n", date);
					}

				} catch (SQLException se) { // try - catch for Statement, Connection
					se.printStackTrace();
				}
	}
}
