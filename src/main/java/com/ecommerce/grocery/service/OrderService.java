package com.ecommerce.grocery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.grocery.dao.OrderDao;
import com.ecommerce.grocery.dto.Orders;

@Service
public class OrderService {

	@Autowired
	OrderDao orderDao;
	
	public Orders saveOrder(Orders orders) {
		return orderDao.saveOrder(orders);
	}
}
