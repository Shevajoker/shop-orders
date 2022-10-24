package com.liga.orders.dao;

import java.util.List;

import com.liga.orders.entity.Employee;

public interface EmployeeDAO {

	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	
}
