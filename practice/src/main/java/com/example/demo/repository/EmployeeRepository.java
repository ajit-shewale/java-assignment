package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.EmployeeDao;


public interface EmployeeRepository extends JpaRepository<EmployeeDao, Integer> {

}
