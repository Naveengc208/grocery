package com.ecommerce.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.grocery.dto.Employee;
import com.ecommerce.grocery.dto.Login;
import com.ecommerce.grocery.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employees")
	public Employee saveEmp(@RequestBody Employee employee) {
		return employeeService.saveEmp(employee);
		
	}
	
	@GetMapping("/employees")
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	
	@PostMapping("/employees/login")
	public Employee loginEmp(@RequestBody Login login, HttpServletRequest request) {
		
		return employeeService.loginEmp(login, request);
	}
}
