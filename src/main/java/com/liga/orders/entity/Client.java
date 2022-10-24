package com.liga.orders.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int clientId;
	
	@Column(name = "name")
	private String clientName;
	
	@Column(name = "surname")
	private String clientSurName;
	
	@Column(name = "phone")
	private int clientPhone;
	
	@Column(name = "email")
	private String clientEmail;
	
	@Column(name = "age")
	private int clientAge;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}, 
			mappedBy = "client")
	List<Order> orders;
	
	public Client() {
	
	}

	public Client(int clientId, String clientName, String clientSurName, int clientPhone, String clientEmail, int clientAge) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientSurName = clientSurName;
		this.clientPhone = clientPhone;
		this.clientEmail = clientEmail;
		this.clientAge = clientAge;
	}
	
	
	public void addClientToOrder (Order order) {
		
		if (orders == null) {
			orders = new ArrayList<>();
		}
		
		orders.add(order);
		order.setClient(this);
		
	}
	

	public int getId() {
		return clientId;
	}

	public void setId(int id) {
		this.clientId = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientSurName() {
		return clientSurName;
	}

	public void setClientSurName(String clientSurName) {
		this.clientSurName = clientSurName;
	}

	public int getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(int clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public int getClientAge() {
		return clientAge;
	}

	public void setClientAge(int clientAge) {
		this.clientAge = clientAge;
	}

	
	



	public List<Order> getOrders() {
//		if(orders == null) {
//			orders = new ArrayList<>();
//		}
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Client [id=" + clientId + ", clientName=" + clientName + ", clientSurName=" + clientSurName + ", clientPhone="
				+ clientPhone + ", clientEmail=" + clientEmail + ", clientAge=" + clientAge + "]";
	}
	
	

}
