package com.springWeb2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.IssuedBookDao;

@Repository
public interface LibraryRepository extends JpaRepository<BookDao, Integer> {

    @Query(value = "select * from library_table  where Book_Id like %:keyword% or Title like %:keyword% or Author like %:keyword%", nativeQuery = true)
    List<BookDao> findByKeyword(@Param("keyword") String keyword);

    @Query(value = "INSERT INTO issued_books_table (Book_Id, Title, Author, Cost)\r\n"
            + "SELECT Book_Id, Title, Author, Cost\r\n"
            + "FROM library_table where Book_Id like %:id% ;" , nativeQuery = true)
    void insertIssuedBook(@Param("id") Integer id);

}



