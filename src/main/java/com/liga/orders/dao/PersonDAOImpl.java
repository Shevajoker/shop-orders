package com.liga.orders.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.liga.orders.entity.Person;

@Repository
public class PersonDAOImpl implements PersonDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void savePerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(person);
		
	}

}
