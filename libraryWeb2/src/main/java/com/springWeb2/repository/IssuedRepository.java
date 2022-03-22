package com.springWeb2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;

@Repository
public interface IssuedRepository extends JpaRepository<IssuedBookDao, Integer>{


    @Query(value = "select * from issued_books_table  where issuedBy like %:userId%", nativeQuery = true)
    List<IssuedBookDao> findBooksByUserId(@Param("userId") int userId);
}
