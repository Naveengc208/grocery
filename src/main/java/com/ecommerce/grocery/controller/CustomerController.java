package com.ecommerce.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.grocery.dto.Customer;
import com.ecommerce.grocery.dto.Login;
import com.ecommerce.grocery.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;


@CrossOrigin
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	
	@GetMapping("/customers")
	public List<Customer> getAll(){
		return customerService.getCustomers();
		
	}
	
	@PostMapping("/customers/login")
	public Customer loginCustomer(@RequestBody Login login, HttpServletRequest request) {
		return customerService.loginCustomer(login, request);
	}
	
	
	@GetMapping("/customer/{id}")
	public Customer getById(@PathVariable("id") int id) {
		return customerService.getById(id);
		
	}
}
