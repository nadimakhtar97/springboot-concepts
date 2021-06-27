package com.nadim.springbootconcepts3.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "bookCategory" , cascade = CascadeType.ALL)
    private Set<Book> books;


    // In case of GenerationType.AUTO Hibernate will take care of assigning id
    // insert the first entry in table 1 --> 1
    // insert the first entry in table 2 --> 2
    // insert the second entry in table 1 --> 3


    // In case of GenerationType.Identity MySql sever will take care of assigning id
    // insert the first entry in table 1 --> 1
    // insert the first entry in table 2 --> 1
    // insert the second entry in table 1 --> 2
    // insert the second entry in table 2 --> 2


    /*
    we create default constructor because springboot or hibernate uses default constructor to
    create bean or objects
    */
    public BookCategory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public BookCategory(String name) {
        this.name = name;
    }

    public BookCategory(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
        this.books.forEach(x->x.setBookCategory(this));
    }
}
