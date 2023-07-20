package com.example.springapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Product;
import com.example.springapp.service.ProductService;

import com.example.springapp.repository.ProductRepository;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ProductController {

	@Autowired
	ProductService product;

	@Autowired
	ProductRepository dao;

	@PostMapping("/products")
	public void product(@RequestBody Product p) {
		product.saveProduct(p);
	}

	
	@GetMapping("/products")
	public List<Product> getpro() {
		return product.getProducts();
	}

	@GetMapping("/total")
	public int total() {
		return product.getTotalQuantity();
	}

	@GetMapping("/totalert")
	public int totalert() {
		return dao.getAlertQuantity();
	}

	@GetMapping("/productsless")
	public List<Product> getProductsByQuantityLessThanSix() {
		return product.getProductsByQuantityLessThanSix();
	}

	@PutMapping("/products")
	public void putpro(@RequestBody Product p) {
		product.editProduct(p);
	}

	@DeleteMapping("/products")
	public void detpro(int id) {
		product.deleteProduct(id);
	}

	@GetMapping("/pg")
	public int pg(String barcode) {
		return dao.findIdByBarcode(barcode);
	}
	

}