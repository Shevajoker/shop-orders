package com.liga.orders.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liga.orders.dao.PetDAO;
import com.liga.orders.entity.Pet;

@Service
public class PetServiceImpl implements PetService{
	
	@Autowired
	private PetDAO petDAO;

	@Override
	@Transactional
	public void savePet(Pet pet) {
		petDAO.savePet(pet);
	}

	
	
	
	
}
