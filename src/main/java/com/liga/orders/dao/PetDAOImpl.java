package com.liga.orders.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.liga.orders.entity.Pet;

@Repository
public class PetDAOImpl implements PetDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void savePet(Pet pet) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(pet);
		
	}

}
