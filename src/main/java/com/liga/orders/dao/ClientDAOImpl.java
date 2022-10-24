package com.liga.orders.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.liga.orders.entity.Client;

@Repository
public class ClientDAOImpl implements ClientDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveClient(Client client) {
	
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(client);
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Client> getAllClients() {
	
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery("from Client").list();
	}
	
	@Override
	public Client getClientById(int id) {
	
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Client.class, id);
	}
	
	
}
