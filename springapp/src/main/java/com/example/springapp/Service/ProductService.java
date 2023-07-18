package com.example.springapp.Service;

import java.util.List;

import com.example.springapp.Model.Product;




public interface ProductService {

	public List<Product> getProducts();

	public void editProduct(Product product);

	void saveProduct(Product product);

	public int getTotalQuantity();

	public List<Product> getProductsByQuantityLessThanSix();

	public void deleteProduct(int id);
	
}