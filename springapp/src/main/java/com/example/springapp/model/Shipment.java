package com.example.springapp.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long productId;
	private Long quantity;
	private String location;
	@Temporal(TemporalType.DATE)
	private Date timestamp;

	
	public Shipment(Long id, Long productId, Long quantity, String location, Date timestamp) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.location = location;
		this.timestamp = timestamp;
	}
	public Shipment() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
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
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	
}