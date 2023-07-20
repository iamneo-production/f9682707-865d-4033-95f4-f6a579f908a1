package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Product;




public interface ProductService {

	public List<Product> getProducts();

	public void editProduct(Product product);

	void saveProduct(Product product);

	public int getTotalQuantity();

	public List<Product> getProductsByQuantityLessThanSix();

	public void deleteProduct(int id);
	
}