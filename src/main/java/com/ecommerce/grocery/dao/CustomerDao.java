package com.ecommerce.grocery.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.grocery.dto.Customer;
import com.ecommerce.grocery.dto.Login;
import com.ecommerce.grocery.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
		
	}
	
	
	public List<Customer> getAll() {
		return customerRepository.findAll();
		
	}
	
	
	public Customer loginCustomer(Login login) {
		return customerRepository.loginCustomer(login.getEmail(), login.getPassword());
		
	}
	
	
	public Customer getById(int id) {
		Optional<Customer> optional= customerRepository.findById(id);
		if(optional.isPresent()) {
		return optional.get();
	}
		return null;
	}
}
