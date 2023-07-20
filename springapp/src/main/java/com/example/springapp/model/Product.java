package com.example.springapp.model;

import java.util.List;

import org.springframework.context.annotation.Description;



import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private int price;
	private Long quantity;
	private String location;
	@Column(unique = true)
	private String barcode;
	// @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
	// private List<Inventory> inventory;


	public Product(){

	}

	public Product(Long id, String name, String description, int price, Long quantity, String location, String barcode) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.location = location;
		this.barcode = barcode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getdescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

}
