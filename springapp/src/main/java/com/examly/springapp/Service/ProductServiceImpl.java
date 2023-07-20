package com.examly.springapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.Model.Product;
import com.examly.springapp.Repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product saveProduct(Product product) {

		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Long id) {
		return productRepo.findById(id).get();	}

	@Override
	public String deleteProduct(Long id) {
		Product product = productRepo.findById(id).get();

		if (product != null) {
			productRepo.delete(product);
			return "Product Delete Sucessfully";
		}

		return "Something wrong on server";
	}

	@Override
	public Product editProduct(Product p, Long id) {

		Product oldProduct = productRepo.findById(id).get();

		oldProduct.setName(p.getName());
		oldProduct.setDescription(p.getDescription());
		oldProduct.setPrice(p.getPrice());
		oldProduct.setBarcode(p.getBarcode());
		oldProduct.setQuantity(p.getQuantity());
		oldProduct.setLocation(p.getLocation());

		return productRepo.save(oldProduct);
	}

}