package com.example.springapp.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long productId;
	private Long quantity;
	private String supplier;
    
	@Temporal(TemporalType.DATE)
	private Date timestamp;

	public PurchaseOrder() {
	}

	public PurchaseOrder(Long id, Long productId, Long quantity, String supplier, Date timestamp) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.supplier = supplier;
		this.timestamp = timestamp;
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

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}