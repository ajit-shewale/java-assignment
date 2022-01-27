package com.example.demo.controllerPack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmployeeServicePack.EmployeeService;
import com.example.demo.entity.EmployeeDao;

@RestController
public class MyController {
	@Autowired
	EmployeeService ES;
	
	@GetMapping("/home")
	public  String home() {
		return "This is home!!";
	}
	
	@GetMapping("/getStaff")
	public  List<EmployeeDao> getStaff(){
		return ES.getStaff();
	}
	
	@PostMapping("/addStaff")
	public EmployeeDao addEmployee(@RequestBody EmployeeDao E)
	{
		return ES.addEmployee(E);
	}
	
	@PutMapping("/updateStaff")
	public EmployeeDao updateEmployee(@RequestBody EmployeeDao E)
	{
		return ES.updateEmployee(E);
	}
	
	@DeleteMapping("/deleteStaff/{id}")
	public String deleteEmployee(@PathVariable("id") int id) 
	{
		return "Staff deleted";
	}
}
