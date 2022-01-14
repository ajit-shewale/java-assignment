package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Library {

	@Autowired
	LibraryRepository repo;
	
	@GetMapping("/book")
	public List<Book> getBooks()
	{
		List<Book> books = (List<Book>)repo.findAll();
		
		return books;
	}
}
