package com.nadim.springbootconcepts3;

import com.nadim.springbootconcepts3.model.Book;
import com.nadim.springbootconcepts3.model.BookCategory;
import com.nadim.springbootconcepts3.repository.BookCategoryRepository;
import com.nadim.springbootconcepts3.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


// We are using CommandLineRunner interface so as to ease our development process
// If we use CommandLineRunner the we need not use Postman for testing each api
// rather we can use run function to call other functions on application start up.

// run function executes whenever our application starts so we can use it to remove
// some temporary files which we don't require after server starts up.
@SpringBootApplication
public class Springbootconcepts3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Springbootconcepts3Application.class, args);
	}


	// doubt --> BookRepository is an interface then how are we creating an instance of it??
	@Autowired
	BookRepository bookRepository;

	@Autowired
	BookCategoryRepository bookCategoryRepository;


	@Override
	public void run(String... args) throws Exception {

		Set<Book> books = new HashSet<>();

		// inserting books in database
		Book book1 = new Book("springboot","nadim",1000);
		Book book2 = new Book("css","lee",1200);
//		bookRepository.save(book1);
//		bookRepository.save(book2);

		books.add(book1);
		books.add(book2);


		// creating new  bookCategory
		bookCategoryRepository.save(new BookCategory("non programming"));
		// creating new bookCategory along with books that belong to the category
		bookCategoryRepository.save(new BookCategory("programming",books));


		// printing all books in database
//		System.out.println(bookRepository.findAll());
//		System.out.println(bookRepository.findByAuthorName("nadim"));
//		System.out.println(bookRepository.findByAuthor("akhtar")); // This will give error if no implementation.
//		System.out.println(bookRepository.findByAuthor("akhtar"));
//		System.out.println(bookRepository.findByAuthors("nadim")); // giving error due to some syntax error
//		System.out.println(bookRepository.findByCost(1000));
//		System.out.println(bookRepository.findById(2));
	}
}
