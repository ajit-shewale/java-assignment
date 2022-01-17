package com.example.demo;

import java.util.List;

public interface LibraryInterface {

	public Book saveBook(Book book);
	public Book updateBook(Book book);
	public void deleteBook(int id);
	public List<Book> findAllBooks();
}
