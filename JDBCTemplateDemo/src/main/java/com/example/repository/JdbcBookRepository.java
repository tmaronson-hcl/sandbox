package com.example.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Book;

@Repository
public class JdbcBookRepository implements BookRepository {

	// code demo found here:
	// https://mkyong.com/spring-boot/spring-boot-jdbc-examples/
	// also some ideas for experimenting:
	// https://mkyong.com/spring/spring-jdbctemplate-querying-examples/

	// Spring Boot will create and configure DataSource and JdbcTemplate
	// To use it, just @Autowired

	// Spring Boot motto/philosophy: "convention over configuration"

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from books", Integer.class);
	}

	@Override
	public int save(Book book) {
		return jdbcTemplate.update("insert into books (name, price) values(?,?)", // :name
				book.getName(), book.getPrice());
	}

	@Override
	public int update(Book book) {
		return jdbcTemplate.update("update books set price = ? where id = ?", book.getPrice(), book.getId());
	}

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update("delete from books where id = ?", id);
	}

	@Override
	public List<Book> findAll() {
		return jdbcTemplate.query("select * from books",
				(rs, rowNum) -> new Book(rs.getLong("id"), rs.getString("name"), rs.getBigDecimal("price")));
	}

	// jdbcTemplate.queryForObject, populates a single object
	

	//@Override
//	public Optional<Book> findById(Long id) {
//		return jdbcTemplate.queryForObject("select * from books where id = ?", new Object[] { id }, (rs,
//				rowNum) -> Optional.of(new Book(rs.getLong("id"), rs.getString("name"), rs.getBigDecimal("price"))));
//	}

	@Override
    public Book findById(Long id) {
    	
    	int[] types = new int[] { java.sql.Types.NUMERIC};
        return jdbcTemplate.queryForObject(
                "select * from books where id = ?",
                new Object[]{id}, 
                types,
                (rs, row) -> 
                        (new Book(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getBigDecimal("price")
                        ))
                
        );
    }

	@Override
	public List<Book> findByNameAndPrice(String name, BigDecimal price) {
		return jdbcTemplate.query("select * from books where name like ? and price <= ?",
				
				(rs, rowNum) -> new Book(rs.getLong("id"), rs.getString("name"), 
						rs.getBigDecimal("price")), 
				new Object[] { "%" + name + "%", price });
	}

	@Override
	public String getNameById(Long id) {
		return jdbcTemplate.queryForObject("select name from books where id = ?", new Object[]{id}, 
				new int[] { java.sql.Types.NUMERIC},
				String.class);
	}

}
