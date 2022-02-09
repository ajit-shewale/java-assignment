package com.example.demo.controller;

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

import com.example.demo.entity.BookDao;
import com.example.demo.service.LibraryServiceImpl;

@RestController
@CrossOrigin("*")
public class HomeController {
	@Autowired
	private LibraryServiceImpl libraryServiceImpl;
	
	@PostMapping(value = "saveBook")
	public BookDao saveBook(@RequestBody BookDao book) {
		libraryServiceImpl.saveBook(book);
		return book;
	}
	
	@GetMapping(value = "getAllBooks")
	public List<BookDao> findAllBook(){
		return libraryServiceImpl.findAllBooks();
	}
	
	@PutMapping(value = "updateBook")
	public BookDao updateBook(@RequestBody BookDao book) {
		return libraryServiceImpl.updateBook(book);
	}
	
	@DeleteMapping("deleteBook")
	public String deleteBook(@RequestParam int id) {
		//libraryServiceImpl.deleteBook(id);
		return "Book deleted!!";
	}
}
	