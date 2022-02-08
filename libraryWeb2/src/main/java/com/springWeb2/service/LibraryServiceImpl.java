package com.springWeb2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springWeb2.service.LibraryServiceInterface;
import com.springWeb2.entity.BookDao;
import com.springWeb2.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryServiceInterface {

	@Autowired
	private LibraryRepository libraryRepo;

	@Override
	public void saveBook(BookDao book) {
		this.libraryRepo.save(book);
	}
	
	public BookDao getBookById(int id) {
		Optional<BookDao> optional = libraryRepo.findById(id);
		BookDao book = null;
		if(optional.isPresent()) {
			book = optional.get();
		}else {
			throw new RuntimeException("Book not found for id : " + id );
		}
		return book;
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