package com.liga.orders.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liga.orders.dao.ClientDAO;
import com.liga.orders.entity.Client;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientDAO clientDAO;
	
	
	@Override
	@Transactional
	public void saveClient(Client client) {
	
		clientDAO.saveClient(client);
		
	}
	
	@Override
	@Transactional
	public List<Client> getAllClients() {
	                
		return clientDAO.getAllClients();
	}
	
	@Override
	@Transactional
	public Client getClientById(int id) {
		
		return clientDAO.getClientById(id);
	}
	
}
