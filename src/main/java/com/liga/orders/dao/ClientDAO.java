package com.liga.orders.dao;

import java.util.List;

import com.liga.orders.entity.Client;

public interface ClientDAO {

	public void saveClient(Client client);
	public List<Client> getAllClients();
	public Client getClientById(int id);
	
}
