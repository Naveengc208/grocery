package com.ecommerce.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.grocery.dao.EmployeeDao;
import com.ecommerce.grocery.dto.Employee;
import com.ecommerce.grocery.dto.Login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	
	public Employee saveEmp(Employee employee) {
		return employeeDao.saveEmployee(employee);
		
	}
	
	public List<Employee> getAll(){
		return employeeDao.getAll();
	}
	
	
	public Employee loginEmp(Login login, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Employee employee=employeeDao.loginEmp(login);
		if(employee!=null)
		{
			session.setAttribute("employee", employee);
		}		
		return employee;
	}

}
