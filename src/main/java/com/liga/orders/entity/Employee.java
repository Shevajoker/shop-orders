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
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int employeeId;
	
	@Column(name = "name")
	private String employeeName;
	
	@Column(name = "surname")
	private String emlpoyeeSurName;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}, 
			mappedBy = "employee")
	List<Order> orders;
	
	public Employee() {
	
	}


	public Employee(int employeeId, String employeeName, String emlpoyeeSurName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.emlpoyeeSurName = emlpoyeeSurName;
	}
	
	
	
	public void addEmployeeToOrder(Order order) {
		
		if (orders == null) {
			orders = new ArrayList<>();
		}
		
		orders.add(order);
		order.setEmployee(this);
		
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
	

	public int getId() {
		return employeeId;
	}

	public void setId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmlpoyeeSurName() {
		return emlpoyeeSurName;
	}

	public void setEmlpoyeeSurName(String emlpoyeeSurName) {
		this.emlpoyeeSurName = emlpoyeeSurName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + employeeId + ", employeeName=" + employeeName + ", emlpoyeeSurName=" + emlpoyeeSurName + "]";
	}
	
	

}
