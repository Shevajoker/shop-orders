package com.liga.orders.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liga.orders.dao.OrderDAO;
import com.liga.orders.entity.Order;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	@Transactional
	public void saveOrder(Order order) {
	
		orderDAO.saveOrder(order);
		
	}
	
	
}
