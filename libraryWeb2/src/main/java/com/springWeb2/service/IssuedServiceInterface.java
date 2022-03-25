package com.springWeb2.service;

import java.util.List;


import com.springWeb2.entity.IssuedBookDao;


public interface IssuedServiceInterface {


    List<IssuedBookDao> findAllIssuedBooks();
    
    List<IssuedBookDao> findAllIssuedBooksIssuedBy(String userName);

    void saveBook(IssuedBookDao book);

    void deleteBook(int id);

}
