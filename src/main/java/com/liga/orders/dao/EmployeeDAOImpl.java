package com.liga.orders.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.liga.orders.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee employee) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(employee);
		
	}
	
	
	@Override
	public List<Employee> getAllEmployees() {
	
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery("from Employee").list();
	}
	
	@Override
	public Employee getEmployeeById(int id) {
	
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Employee.class, id);
	}
	
}
