package com.liga.orders.service;

import java.util.List;

import com.liga.orders.entity.Client;


public interface ClientService {

public void saveClient(Client client);	
public List<Client> getAllClients();
public Client getClientById(int id);
	
}
