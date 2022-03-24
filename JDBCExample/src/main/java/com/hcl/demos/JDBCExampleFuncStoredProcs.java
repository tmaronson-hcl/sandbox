package com.hcl.demos;

import java.sql.*;

import static java.sql.Types.VARCHAR;

public class JDBCExampleFuncStoredProcs {
	// Get Type 4 Java Driver
	// static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	// Check database, connection port and get URL.
	static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";

	// Obviously password would not be clear text but what the heck for demo.
	static final String USER = "root";
	static final String PASS = "passwd";
	

	public static void main(String[] args) {

		JDBCExampleFuncStoredProcs jdbc = new JDBCExampleFuncStoredProcs();
		jdbc.getConnection();
	}

	private void getConnection() {

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {
			// Don't need classloader with above driver.
			// Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			// Will use datasource later.
			getData(conn);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void getData(Connection conn) throws SQLException {

		System.out.println("Creating CallableStatement...");
		// Refactored with try-with-resources twice to avoid closing cs, cs2, rs
		try (CallableStatement cs = conn.prepareCall("{? = call show_film_choices(?, ?)}");) {
			cs.registerOutParameter(1, VARCHAR);
			cs.setDouble(2, 11.25);
			cs.setString(3, "AFRICAN EGG");
			cs.execute();
			System.out.printf("Result of rental is: %s\n", cs.getString(1));

			// stored procedure
			try (CallableStatement cs2 = conn.prepareCall("call afford_film_choices(?)");) {
				cs2.setDouble(1, 2.25);
				try (ResultSet rs = cs2.executeQuery();) {

					while (rs.next()) {
						System.out.printf("%d  ", rs.getInt("film_id"));
						System.out.printf("%s ", rs.getString("title"));
						System.out.printf("%10.2f  ", rs.getDouble("rental_rate"));
						System.out.printf("%s  \n", rs.getString("description"));
					}

				} catch (SQLException se) {
					se.printStackTrace();
				}
			} // end try with resources inner
		} // end try with resources outer
	}
}
