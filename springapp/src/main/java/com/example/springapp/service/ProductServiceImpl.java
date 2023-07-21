package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.BarcodeScanner;
import com.example.springapp.model.Inventory;
 import com.example.springapp.model.Product;
  import com.example.springapp.model.PurchaseOrder;
import com.example.springapp.repository.BarcodescannerRepository;
import com.example.springapp.repository.InventoryRepository;
import com.example.springapp.repository.ProductRepository;
 import com.example.springapp.repository.PurchaseOrderRepository;

@Service
public class ProductServiceImpl implements ProductService {


	@Autowired
	ProductRepository prodao;

	@Autowired
    InventoryRepository inv;	

	@Override
	public List<Product> getAllProduct() {
		
		return prodao.findAll();
	}
	@Override
	public Product getProductById(Long id) {
		
		return prodao.findById(id).orElse(null);
	}

	@Override
	public void createProduct(Product product) {
		prodao.save(product);
	}

	@Override
	public void editProduct(Product product) {
		    
		    Inventory one=inv.findByProductId(product.getId());
			Product two=prodao.findById(product.getId()).orElse(null);
			 if(one.getQuantity()==two.getQuantity()){
				one.setQuantity(product.getQuantity());
				inv.save(one);
			 }
			 
			prodao.save(product);	
	}

	@Override
	public void deleteProduct(Long id) {
		prodao.deleteById(id);

	}
     
	@Override
	public int getTotalQuantity() {
		return prodao.getTotalQuantity();
	}

	@Override
	public List<Product> getProductsByQuantityLessThanSix() {
		
		return prodao.findProductsByQuantityLessThanSix();
	}

}
