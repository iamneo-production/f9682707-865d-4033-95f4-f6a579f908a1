package com.examly.springapp.Service;

import java.util.List;

import com.examly.springapp.Model.Product;




public interface ProductService {

	public Product saveProduct(Product product);

	public List<Product> getAllProduct();

	public Product getProductById(Long id);

	public String deleteProduct(Long id);

	public Product editProduct(Product product,Long id);
	
}