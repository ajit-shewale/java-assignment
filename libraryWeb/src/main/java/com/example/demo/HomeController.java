package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class HomeController {
	@Autowired
	private LibraryServiceImpl libraryServiceImpl;

	@PostMapping(value = "saveBook")
	public Book saveBook(@RequestBody Book book) {
		libraryServiceImpl.saveBook(book);
		return book;
	}
	
	@GetMapping(value = "getAllBooks")
	public List<Book> findAllBook(){
		return libraryServiceImpl.findAllBooks();
	}
	
	@PutMapping("updateBook")
	public Book updateBook(@RequestBody Book book) {
		return libraryServiceImpl.updateBook(book);
	}
	
	@DeleteMapping("deleteBook")
	public String deleteBook(@RequestBody int id) {
		libraryServiceImpl.deleteBook(id);
		return "Book deleted!!";
	}
}
	
