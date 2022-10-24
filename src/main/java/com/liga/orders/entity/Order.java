package com.liga.orders.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "orders2")
public class Order {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@Column(name = "orderNumber")
	private long orderNumber;

	@Column(name = "saleAmount")
	private double saleAmount;

	@Column(name = "paymentAmount")
	private double paymentAmount;

	@Column(name = "deliveryDate")
	@DateTimeFormat(iso=ISO.DATE)
	private Date deliveryDate;

	@Column(name = "discount")
	private int discount;

	@Column(name = "deliveryAddress")
	private String deliveryAddress;

	@Column(name = "comment")
	private String comment;

	@Column(name = "creationDate")
	@DateTimeFormat(iso=ISO.DATE)
	private Date creationDate;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH,
			CascadeType.MERGE })
	@JoinColumn(name = "employeeId")
	private Employee employee;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH,
			CascadeType.MERGE })
	@JoinColumn(name = "clientId")
	private Client client;

	public Order() {

	}

	public Order(int orderId
			, long orderNumber
			, double saleAmount
			, double paymentAmount
			, Date deliveryDate
			, int discount
			, String deliveryAddress
			, String comment
			, Date creationDate
			) {
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.saleAmount = saleAmount;
		this.paymentAmount = paymentAmount;
		this.deliveryDate = deliveryDate;
		this.discount = discount;
		this.deliveryAddress = deliveryAddress;
		this.comment = comment;
		this.creationDate = creationDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(double saleAmount) {
		this.saleAmount = saleAmount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderNumber=" + orderNumber + ", saleAmount=" + saleAmount
				+ ", paymentAmount=" + paymentAmount + ", deliveryDate=" + deliveryDate + ", discount=" + discount
				+ ", deliveryAddress=" + deliveryAddress + ", comment=" + comment + ", creationDate=" + creationDate
				+ "]";
	}


	

}
