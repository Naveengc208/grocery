package com.ecommerce.grocery.dao;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.grocery.dto.Employee;
import com.ecommerce.grocery.dto.Login;
import com.ecommerce.grocery.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
}
	
	
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	
	public Employee loginEmp(Login login) {
		return employeeRepository.LoginEmp(login.getEmail(), login.getPassword());
		
	}
}