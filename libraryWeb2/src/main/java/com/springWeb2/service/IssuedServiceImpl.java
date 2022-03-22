package com.springWeb2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springWeb2.entity.IssuedBookDao;
import com.springWeb2.repository.IssuedRepository;

@Service
public class IssuedServiceImpl implements IssuedServiceInterface {

    @Autowired
    IssuedRepository IssuedRepo;

    @Override
    public List<IssuedBookDao> findAllIssuedBooks() {
        return IssuedRepo.findAll();
    }

    @Override
    public void saveBook(IssuedBookDao book) {
        IssuedRepo.save(book);
    }

    @Override
    public void deleteBook(int id) {
        IssuedRepo.deleteById(id);        
    }

    @Override
    public List<IssuedBookDao> findAllIssuedBooksIssuedBy(int userId) {
        return IssuedRepo.findBooksByUserId(userId);
    }
    
}
