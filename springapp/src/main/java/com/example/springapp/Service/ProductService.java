package com.example.springapp.Service;

import java.util.List;

import com.example.springapp.Model.Product;




public interface ProductService {

	public Product saveProduct(Product product);

	public List<Product> getAllProduct();

	public Product getProductById(Long id);

	public String deleteProduct(Long id);

	public Product editProduct(Product product,Long id);
	
}