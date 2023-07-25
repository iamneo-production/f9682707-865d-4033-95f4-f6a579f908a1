package com.example.springapp.model;
//#endregion

//Bala
import java.util.Date;

import javax.persistence.*;

@Entity
public class Sales {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	private Long productId;
	private Long quantity;
	private double price;
	@Temporal(TemporalType.DATE)
	private Date date;

	
	public Sales() {
	}
	public Sales(Long id, Long productId, Long quantity, double price, Date date) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
