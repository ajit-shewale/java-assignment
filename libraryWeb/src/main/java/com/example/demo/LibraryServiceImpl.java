package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class LibraryServiceImpl implements LibraryInterface   {

	@Autowired
	private LibraryRepository libraryRepo;
	
	@Override
	public Book saveBook(Book book) {
		return libraryRepo.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return libraryRepo.save(book);

	}

	@Override
	public void deleteBook(int id) {
		libraryRepo.deleteById(id);
		
	}

	@Override
	public List<Book> findAllBooks() {
		return List<Book>libraryRepo.findAll();
	}

	
}
