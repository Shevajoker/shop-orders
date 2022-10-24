package com.liga.orders.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liga.orders.dao.EmployeeDAO;
import com.liga.orders.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
	
		employeeDAO.saveEmployee(employee);
	}
	
	@Override
	@Transactional
	public List<Employee> getAllEmployees() {

		return employeeDAO.getAllEmployees();
	}
	
	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
	
		return employeeDAO.getEmployeeById(id);
	}
	
}
