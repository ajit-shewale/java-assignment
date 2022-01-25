package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.BookDao;
import com.example.demo.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryServiceInterface {

	@Autowired
	private LibraryRepository libraryRepo;

	@Override
	public BookDao saveBook(BookDao book) {
		return libraryRepo.save(book);
	}

	@Override
	public BookDao updateBook(BookDao book) {
		return libraryRepo.save(book);

	}

	@Override
	public void deleteBook(int id) {
		libraryRepo.deleteById(id);

	}

	@Override
	public List<BookDao> findAllBooks() {
		return (List<BookDao>) libraryRepo.findAll();
	}

}
