package com.hcl.demos;

import java.sql.*;

public class JDBCExampleSQLite {
	// Get Type 4 Java Driver
	// static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	// Check database, connection port and get URL.
	static String PATH = "C:\\Users\\thomas.aronson\\Database"
			+ "\\oreilly_getting_started_with_sql-master\\oreilly_getting_started_with_sql-master\\rexon_metals.db";;
	static final String DB_URL = 
			"jdbc:sqlite:///" + PATH;

	// Obviously password would not be clear text but what the heck for demo.
	static final String USER = "";
	static final String PASS = "";

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
				String sql = "SELECT customer_id, name, region from customer"; // get any table in db sakila.
				// 3. Get connection
				try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
						// 4. Create statement or prepared statement.
						Statement stmt = conn.createStatement();
						// 5. For SELECT query, get ResultSet and process it.
						ResultSet rs = stmt.executeQuery(sql);) {

					while (rs.next()) { // iterate through ResultSet and print data
						int id = rs.getInt("Customer_id");
						String name = rs.getString("name");
						String region = rs.getString("region");
						System.out.printf("ID: %d, Name: %s, Region:  %s\n", id, name, region);
						
					}

				} catch (SQLException se) { // try - catch for Statement, Connection
					se.printStackTrace();
				}
	}
}
