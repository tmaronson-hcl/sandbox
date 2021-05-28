package com.hcl.proxy;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public Book create(String author) {
        return new Book(author);
    }
}
