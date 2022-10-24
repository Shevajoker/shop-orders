package com.liga.orders.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liga.orders.dao.PeopleDAO;
import com.liga.orders.entity.People;

@Service
public class PeopleServiceImpl implements PeopleService{

	@Autowired
	private PeopleDAO peopleDAO;
	
	
	@Override
	@Transactional
	public void savePeople(People people) {
		peopleDAO.savePeople(people);
		
	}

}
