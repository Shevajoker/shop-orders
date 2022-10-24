package com.liga.orders.service;

import java.util.List;

import com.liga.orders.entity.Employee;

public interface EmployeeService {
	
	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);

}
