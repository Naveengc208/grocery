package com.ecommerce.grocery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.grocery.dao.AdminDao;
import com.ecommerce.grocery.dto.Admin;
import com.ecommerce.grocery.dto.Login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;
	
	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}
	
	public Admin loginAdmin(Login login, HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		Admin admin= adminDao.loginAdmin(login);
		if(admin!=null) {
			httpSession.setAttribute("admin", admin);
		}
		return admin;
	}
}
