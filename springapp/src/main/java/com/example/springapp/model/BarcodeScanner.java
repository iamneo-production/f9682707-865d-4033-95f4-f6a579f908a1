package com.example.springapp.model;

import javax.persistence.*;

@Entity
public class BarcodeScanner {

	@Id
	@GeneratedValue(generator = "bar", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "bar", sequenceName = "bars", initialValue = 1, allocationSize = 1)
	private int id;
	
	private String name;
	private String location;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
