package com.ecommerce.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.grocery.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	@Query("select a from  Admin a where email=:email and password=:password")
	public Admin loginAdmin(@RequestParam String email, @RequestParam String password);

}
