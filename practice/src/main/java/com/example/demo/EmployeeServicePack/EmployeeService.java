package com.example.demo.EmployeeServicePack;
import com.example.demo.entity.*;
import java.util.List;


public interface EmployeeService {

	public List<EmployeeDao> getStaff();
	public EmployeeDao addEmployee(EmployeeDao E);
	public EmployeeDao updateEmployee(EmployeeDao E);
	public EmployeeDao deleteEmployee(int id);
}
