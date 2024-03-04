package com.ecommerce.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.grocery.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
	@Query("select a from Employee a where email=:email and password=:password")
	public Employee LoginEmp(@RequestParam String email, @RequestParam String password);
}
