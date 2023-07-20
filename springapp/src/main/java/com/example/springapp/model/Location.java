package com.example.springapp.model;

import javax.persistence.*;

@Entity
public class Location {
	@Id
	@GeneratedValue(generator = "loc", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "loc", sequenceName = "locat", initialValue = 1, allocationSize = 1)
	private int id;
	private String name;
	private String address;
	private String contact;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
