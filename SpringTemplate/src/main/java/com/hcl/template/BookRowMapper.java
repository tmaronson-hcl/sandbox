package com.hcl.template;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/*
 * Rather than working with the typical boilerplate code of establishing connection, querying and getting ResultSet
 * and parsing through same, closing connection, template pattern with JdbcTemplate (not entire process shown here) and
 * RowMapper helps. So this is the basis of Spring JDBC.
 */

public class BookRowMapper implements RowMapper<Book> {

	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();

		book.setId(rs.getLong("id"));
		book.setTitle(rs.getString("title"));
		book.setAuthor(rs.getString("author"));
		return book;
	}

}
