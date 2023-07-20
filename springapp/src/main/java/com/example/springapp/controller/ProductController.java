package com.example.springapp.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Product;
import com.example.springapp.repository.ProductRepository;
import com.example.springapp.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService product;

	@Autowired
	ProductRepository dao;

	@PostMapping("/product")
	public ResponseEntity<Product> product(@RequestBody Product p) {
		product.createProduct(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}

	
	@GetMapping("/product")
	public List<Product> getpro() {
		return product.getAllProduct();
	}

	@GetMapping("/product/{id}")
	public Product getid(@PathVariable Long id){
     return product.getProductById(id);
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

	@PutMapping("/product")
	public void putpro(@RequestBody Product p) {
		product.editProduct(p);
	}

	@DeleteMapping("/product")
	public void detpro(Long id) {
		product.deleteProduct(id);
	}

   
	@GetMapping("/pg")
	public int pg(String barcode) {
		return dao.findIdByBarcode(barcode);
	}

}
