package com.liga.orders.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.liga.orders.entity.People;

@Repository
public class PeopleDAOImpl implements PeopleDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void savePeople(People people) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(people);
		
	}

}
