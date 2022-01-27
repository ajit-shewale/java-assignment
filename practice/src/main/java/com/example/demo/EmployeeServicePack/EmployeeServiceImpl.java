package com.example.demo.EmployeeServicePack;
import com.example.demo.entity.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@Override
	public List<EmployeeDao> getStaff() {
		return (List<EmployeeDao>) employeeRepo.findAll();
	}

	@Override
	public EmployeeDao addEmployee(EmployeeDao E) {
		employeeRepo.save(E);
		return E;
	}

	@Override
	public EmployeeDao updateEmployee(EmployeeDao E) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDao deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
