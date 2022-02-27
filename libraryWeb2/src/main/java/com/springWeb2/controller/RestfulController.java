package com.springWeb2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.service.IssuedServiceImpl;
import com.springWeb2.service.LibraryServiceImpl;

@RestController
@CrossOrigin("*")
public class RestfulController {

    @Autowired
    private LibraryServiceImpl libraryServiceImpl;
    
    @Autowired
    private IssuedServiceImpl issuedServiceImpl;

    @PostMapping(value = "save/book")
    public BookDao saveBook(@RequestBody BookDao book) {
        libraryServiceImpl.saveBook(book);
        return book;
    }

    @GetMapping(value = "get/books")
    public List<BookDao> findAllBook() {
        return libraryServiceImpl.findAllBooks();
    }
    
    @GetMapping("/get/book/{id}")
    public BookDao getBook(@PathVariable(value = "id") int id) {
        return libraryServiceImpl.getBookById(id);
    }

    @PutMapping("update/book")
    public String updateBook(@RequestBody BookDao book) {
        libraryServiceImpl.updateBook(book);
        return "Book Updated!!";
    }

    @DeleteMapping("delete/book/{id}")
    public String deleteBook(@RequestParam int id) {
         libraryServiceImpl.deleteBook(id);
        return "Book deleted!!";
    }
    
    @GetMapping(value = "get/issuedBooks")
    public List<IssuedBookDao> findAllIssuedBooks() {
        return issuedServiceImpl.findAllIssuedBooks();
    }
}

    

