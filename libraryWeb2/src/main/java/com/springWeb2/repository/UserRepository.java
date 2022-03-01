package com.springWeb2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springWeb2.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u from User u where u.username = :username")
    public User getUserByUsername(@Param("username") String username);
    
}
