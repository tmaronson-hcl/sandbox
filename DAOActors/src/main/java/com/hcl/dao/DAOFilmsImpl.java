package com.hcl.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DAOFilmsImpl implements DAOFilms {

	private Connection getConnection() {

		Connection con = null;

		Properties props = new Properties();
		try {
			props.load(DAOFilmsImpl.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		MysqlDataSource ds = new MysqlDataSource();
		ds.setURL(props.getProperty("mysql.url"));
		ds.setUser(props.getProperty("mysql.user"));
		ds.setPassword(props.getProperty("mysql.password"));
//	     	Context ctx = new InitialContext();
//			// JNDI Java Naming Directory Interface
//			// Here is where you can call/use your DAO Use JDBC
//			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
//			con = ds.getConnection();
//			ctx.close();
//		} catch (NamingException | SQLException e) {
//			e.printStackTrace();
//		}
		try {

			con = ds.getConnection();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return con;
	}

	@Override
	public List<String[]> getActors() {

		List<String[]> actors = new ArrayList<>();
		Connection con = getConnection();
		try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM actor");
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				String[] arr = { rs.getString("actor_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("last_update") };
				actors.add(arr);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return actors;
	}

}
