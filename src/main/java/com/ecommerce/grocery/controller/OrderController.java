package com.ecommerce.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.grocery.dto.Orders;
import com.ecommerce.grocery.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
	@PostMapping("/orders")
	public Orders saveOrder(Orders orders) {
		return orderService.saveOrder(orders);
	}
}
