package com.ecommerce.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.grocery.dto.Admin;
import com.ecommerce.grocery.dto.Login;
import com.ecommerce.grocery.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	AdminService adminService;
	
	
	@PostMapping("/admin")
	public Admin saveAdmin(Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	
	@PostMapping("/admin/login")
	public Admin loginAdmin(@RequestBody Login login, HttpServletRequest httpServletRequest) {
		return adminService.loginAdmin(login, httpServletRequest);
		
	}
}
