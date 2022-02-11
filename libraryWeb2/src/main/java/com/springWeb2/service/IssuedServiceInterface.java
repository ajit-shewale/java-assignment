package com.springWeb2.service;

import java.util.List;


import com.springWeb2.entity.IssuedBookDao;


public interface IssuedServiceInterface {


    List<IssuedBookDao> findAllBooks();

    void saveBook(IssuedBookDao book);

    void deleteBook(int id);

}
