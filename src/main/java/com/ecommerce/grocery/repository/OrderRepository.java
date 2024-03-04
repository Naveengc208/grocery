package com.ecommerce.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.grocery.dto.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
