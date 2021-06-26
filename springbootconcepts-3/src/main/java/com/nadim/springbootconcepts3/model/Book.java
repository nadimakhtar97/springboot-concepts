package com.nadim.springbootconcepts3.model;


import javax.persistence.*;

/*
@Entity is not picked up by springboot on start up because it does not
contain @Component annotation. But it is picked up by Hibernate
 */

@Entity
/*
This annotation is used to change/give custom name to table in database.
But it is not recommended to change table/coulmn name in between.
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

    public Book() {
    }

    public Book(String name, String authorName, Integer cost) {
        this.name = name;
        this.authorName = authorName;
        this.cost = cost;
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
