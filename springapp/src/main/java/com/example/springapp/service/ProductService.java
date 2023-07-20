package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Product;

public interface ProductService {

	public List<Product> getAllProduct();

	Product getProductById(Long id);

	public void editProduct(Product product);

	void createProduct(Product product);

	public int getTotalQuantity();

	public List<Product> getProductsByQuantityLessThanSix();

	public void deleteProduct(Long id);
}
