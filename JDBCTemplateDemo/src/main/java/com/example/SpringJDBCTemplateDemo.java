package com.example;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.model.Book;
import com.example.repository.BookRepository;

import lombok.extern.log4j.Log4j2;

// note: in order to get @Log4j2 to work in boot, need to add these dependencies/exclusions: 

/* <dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
<exclusions>
	<exclusion>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-logging</artifactId>
	</exclusion>
</exclusions>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-log4j2</artifactId>
<version>2.4.5</version>
</dependency>
*/

@Log4j2 
// https://howtodoinjava.com/spring-boot2/logging/logging-with-lombok/
// https://projectlombok.org/api/lombok/extern/log4j/Log4j2.html
@SpringBootApplication
public class SpringJDBCTemplateDemo implements CommandLineRunner {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("jdbcBookRepository")
	private BookRepository bookRepository;
		
	public static void main(String[] args) {
		SpringApplication.run(SpringJDBCTemplateDemo.class, args);
	}

	// https://mkyong.com/spring-boot/spring-boot-jdbc-examples/
	// https://mkyong.com/spring-boot/spring-boot-jdbc-mysql-hikaricp-example/
	// https://mkyong.com/spring/spring-jdbctemplate-querying-examples/
	@Override
	public void run(String... args) throws Exception {
		log.info("starting up this application!");
		log.trace("in the trace now");
		runJDBC();
		
	}

	private void runJDBC() {
		log.info("testing out things");
		
		List<Book> books = Arrays.asList(
                new Book("Thinking in Java", new BigDecimal("46.32")),
                new Book("Book 01", new BigDecimal("1.99")),
                new Book("Java in a Nutshell", new BigDecimal("17.30")),
                new Book("Head First Design Patterns", new BigDecimal("41.19"))
        );

        log.info("[SAVE]");
        books.forEach(book -> {
            log.info("Saving...{}", book.getName());
            bookRepository.save(book);
        });
        
     // count
        log.info("[COUNT] Total books: {}", bookRepository.count());
        
     // find all
        log.info("[FIND_ALL] {}", bookRepository.findAll());
        
     // find by id
        log.info("[FIND_BY_ID] :2L");
        Book book = bookRepository.findById(2L);//.orElseThrow(IllegalArgumentException::new);
        log.info("{}", book);
        
     // find by name (like) and price
        log.info("[FIND_BY_NAME_AND_PRICE] : like '%Java%' and price <= 10");
        log.info("{}", bookRepository.findByNameAndPrice("Java", new BigDecimal(10)));

        // get name (string) by id
        log.info("[GET_NAME_BY_ID] :1L = {}", bookRepository.getNameById(1L));

        // update
        log.info("[UPDATE] :2L :99.99");
        book.setPrice(new BigDecimal("99.99"));
        log.info("rows affected: {}", bookRepository.update(book));

        // delete
        log.info("[DELETE] :3L");
        log.info("rows affected: {}", bookRepository.deleteById(3L));
		
	}

}
