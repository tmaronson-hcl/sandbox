package com.hcl.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * In our BookManager class, we annotate the create method with the @Transactional annotation. 
 * This annotation instructs Spring to atomically execute our create method. 
 * Without a proxy, Spring wouldn't be able to control access to our BookRepository bean and ensure its transactional consistency.
 * Spring creates a proxy that wraps our BookRepository bean and instructs our bean to execute the create method atomically.
 * When we call the BookManager#create method, we can see the output that looks something like this after using curl, Postman
 * or typing url in a browser. curl -X POST http://localhost:9000/book?author=James%20Craig curl output: {"author":"James Craig"}
 * output in server console is something like: com.hcl.proxy.BookRepository$$EnhancerBySpringCGLIB$$8aff59cc 
 * We would expect to see a standard BookRepository object ID; instead, we see an EnhancerBySpringCGLIB object ID.
 * Behind the scenes, Spring has wrapped the BookRepository object as an EnhancerBySpringCGLIB object. 
 * Spring controls access to our BookRepository object (ensuring transactional consistency) and does not use the real SUBJECT 
 * as defined by the Proxy pattern. The transactional consistency is important to all the typical ACID properties of a transaction.



 */

@Service

public class BookManager {
    
    @Autowired
    private BookRepository repository;

    //@Transactional
    public Book create(String author) {
        System.out.println(repository.getClass().getName());
        return repository.create(author);
    }
}
