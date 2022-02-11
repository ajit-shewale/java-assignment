package com.springWeb2.service;
import java.util.List;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;

public interface LibraryServiceInterface {

	public List<BookDao> findAllBooks();
	public void saveBook(BookDao book);
	public BookDao updateBook(BookDao book);
	public void deleteBook(int id);
	public BookDao getBookById(int id);
	public List<BookDao> getByKeyword(String keyword);
	
}
