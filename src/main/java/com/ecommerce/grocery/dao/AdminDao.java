package com.ecommerce.grocery.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.grocery.dto.Admin;
import com.ecommerce.grocery.dto.Login;
import com.ecommerce.grocery.repository.AdminRepository;

@Repository
public class AdminDao {

	@Autowired
	AdminRepository adminRepository;
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public Admin loginAdmin(Login login) {
		return adminRepository.loginAdmin(login.getEmail(), login.getPassword());
	}
}
