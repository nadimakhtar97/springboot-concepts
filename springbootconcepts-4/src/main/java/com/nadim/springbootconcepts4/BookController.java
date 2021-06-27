package com.nadim.springbootconcepts4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;
    
    @GetMapping("/getBooks")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @PostMapping("/createBook")
    public void createBook(@RequestBody CreateRequest request)
    {
        Book book = new Book(request.getName(), request.getAuthorName(), request.getCost());
        bookRepository.save(book);
    }

    @GetMapping("/getBookByAuthorName")
    public List<Book> getBookByAuthorName(@RequestParam("name") String name){
        return bookRepository.findByAuthorName(name);
    }
    
}
