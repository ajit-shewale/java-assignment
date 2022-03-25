package com.springWeb2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springWeb2.entity.IssuedBookDao;

@Repository
public interface IssuedRepository extends JpaRepository<IssuedBookDao, Integer> {

    @Query(value = "select * from library_schema.issued_books_table  where issuedfor = :userName", nativeQuery = true)
    List<IssuedBookDao> findByissuedFor(@Param("userName") String userName);

}
