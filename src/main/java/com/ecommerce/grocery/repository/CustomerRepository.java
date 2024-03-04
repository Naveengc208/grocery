package com.ecommerce.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.grocery.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	@Query("select a from Customer a where email=:email and password=:password")
	public Customer loginCustomer(@RequestParam String email, @RequestParam String password);
}
