package com.nadim.springbootconcepts3.model;


import javax.persistence.*;

/*
@Entity is not picked up by springboot on start up because it does not
contain @Component annotation. But it is picked up by Hibernate
 */

@Entity
/*
This annotation is used to change/give custom name to table in database.
But it is not recommended to change table/column name in between.
 */
@Table(name = "my_book")

public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "book_name") // This annotation is used to change/give custom name to column name in table
    private String name;
    private String authorName;
    @Column(name = "price")  // This annotation is used to change/give custom name to column name in table
    private Integer cost;


    /*
        @ManyToOne has two component
        Many - represents the current class
        One - represents the class which it is related to ( here BookCategory)
     */

    @ManyToOne
    /*
    @JoinColumn will join the (primary key) of related table ( here BookCategory)
    to current table as a foreign key.

    | id(pk)  | name  | author_name  | cost  | book_category_id(fk) |
     */
    @JoinColumn // It similar to getting a foreign key
    private BookCategory bookCategory;


    /*
   we create default constructor because springboot or hibernate uses default constructor to
   create bean or objects
   */

    public Book() {
    }

    public Book(String name, String authorName, Integer cost) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
    }


    /*
        This is the new constructor required after ManyToOne relation
         */
    public Book(String name, String authorName, Integer cost, Integer bookCategory) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
        this.bookCategory = new BookCategory();
        this.bookCategory.setId(bookCategory);
    }

    public Book(Integer id, String name, String authorName, Integer cost) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", cost=" + cost +
                '}';
    }
}
