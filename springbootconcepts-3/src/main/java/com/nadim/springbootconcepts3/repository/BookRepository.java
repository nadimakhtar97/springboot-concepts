package com.nadim.springbootconcepts3.repository;

import com.nadim.springbootconcepts3.model.Book;
import com.nadim.springbootconcepts3.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


//JpaRepository is an interface which contains all the standard functions
// like save,delete,update,find etc.
// NOTE: we need not implement the functions present in JpaRepository or its superclass
// all the functions are implemented by SimpleJpaRepository.class
// But if we make our own function in BookRepository then we are required to give its implementation.

public interface BookRepository extends JpaRepository<Book, Integer> {

    /*
     This is a custom function whose implementation is given
     */

//    @Query(value = "SELECT * FROM book WHERE book.name=:name", nativeQuery = true)
//    public List<Book> findByName(String name);

    /*
     This method will not give any error even if it has no implementation
     because authorName is a property of Book entity and author is not a
     property of Book entity.
     */

    public List<Book> findByAuthorName(String name);

    /*
    This method will give error because author is not a property in
    Book entity.
     */

//    public List<Book> findByAuthor(String name);  // will give error.

    /*
    custom function with implementation
    In this we are using SQL as query language
     */

    @Query(value = "select * from book b where b.author_name=:my_name", nativeQuery = true)
    public List<Book> findByAuthor(String my_name);  // no error.


    /*
     custom function with implementation
     In this we are using JPQL java persistence query lang as query language and we do not need nativeQuery=true
     */

//    @Query(value = "select b from Book b where b.authorName=:authors_name")
//    public List<Book> findByAuthors(String author_name); // some syntax error so giving error

    List<Book> findByName(String name); // no error

    List<Book> findByCost(Integer cost); // no error

    /*
    This function is defined to avoid lazy loading error when we want to list all books in a bookCategory.
     */
    List<Book> findByBookCategory(BookCategory bookCategory);
}
