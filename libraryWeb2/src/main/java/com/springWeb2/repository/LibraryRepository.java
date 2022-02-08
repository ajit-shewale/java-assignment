package com.springWeb2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springWeb2.entity.BookDao;

@Repository
public interface LibraryRepository extends JpaRepository<BookDao, Integer> {

}
