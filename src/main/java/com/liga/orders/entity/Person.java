package com.liga.orders.entity;


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

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surName;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pet_id")
	private Pet pet;
	
	
	public Person() {
	
	}


	public Person(int id, String name, String surName) {
		this.id = id;
		this.name = name;
		this.surName = surName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurName() {
		return surName;
	}


	public void setSurName(String surName) {
		this.surName = surName;
	}


	public Pet getPet() {
		return pet;
	}


	public void setPet(Pet pet) {
		this.pet = pet;
	}


	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surName=" + surName + ", pet=" + pet + "]";
	}


	
	
	
}
