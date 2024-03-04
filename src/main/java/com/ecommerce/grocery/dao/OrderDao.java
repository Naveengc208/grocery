package com.ecommerce.grocery.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.grocery.dto.Orders;
import com.ecommerce.grocery.repository.OrderRepository;

@Repository
public class OrderDao {

	
	@Autowired
	OrderRepository orderRepository;
	
	public Orders saveOrder(Orders orders) {
		return orderRepository.save(orders);
		
	}
	
	
}
