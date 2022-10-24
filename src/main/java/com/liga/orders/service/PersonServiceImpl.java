package com.liga.orders.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liga.orders.dao.PersonDAO;
import com.liga.orders.entity.Person;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDAO personDAO;

	@Override
	@Transactional
	public void savePerson(Person person) {
		
		personDAO.savePerson(person);
	}
	
	
	
	
}
