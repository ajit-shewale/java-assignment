package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BookDao;

@Repository
public interface LibraryRepository extends CrudRepository<BookDao, Integer> {

}
