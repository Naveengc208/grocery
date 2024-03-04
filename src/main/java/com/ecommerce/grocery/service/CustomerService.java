package com.ecommerce.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.grocery.dao.CustomerDao;
import com.ecommerce.grocery.dto.Customer;
import com.ecommerce.grocery.dto.Login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}

	
	public List<Customer> getCustomers(){
		return customerDao.getAll();
		
	}
	
	public Customer loginCustomer(Login login, HttpServletRequest request) {
	
		HttpSession session=request.getSession();
		Customer customer=customerDao.loginCustomer(login);
		if(customer!=null) {
			session.setAttribute("customer", customer);
		}
		return customer;
	}
	
	public Customer getById(int id) {
		return customerDao.getById(id);
		
	}
}
