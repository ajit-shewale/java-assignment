package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.BookDao;

public interface LibraryServiceInterface {

	public BookDao saveBook(BookDao book);
	public BookDao updateBook(BookDao book);
	public void deleteBook(int id);
	public List<BookDao> findAllBooks();
}
