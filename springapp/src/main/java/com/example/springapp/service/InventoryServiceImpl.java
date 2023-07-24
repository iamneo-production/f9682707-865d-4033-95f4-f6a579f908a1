package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Inventory;
import com.example.springapp.model.Product;
import com.example.springapp.repository.InventoryRepository;
import com.example.springapp.repository.ProductRepository;

@Service
public class InventoryServiceImpl implements InventoryService {
	@Autowired
	InventoryRepository inventorydao;
	@Autowired
	ProductRepository product;

	@Override
	public List<Inventory> getAllInventory() {

		List<Inventory> optional = inventorydao.findAll();
		return optional;
	}

	@Override
	public void createInventory(Inventory i) {
		Product p2 = product.findById(i.getProduct().getId()).orElse(null);
		i.setProduct(p2);
		inventorydao.save(i);

	}

@Override
	public Inventory getInventoryById(Long id) {

		
		return inventorydao.findById(id).orElse(null);
	}


	@Override
	public void editInInventory(Inventory i) {
		Product p2 = product.findById(i.getProduct().getId()).orElse(null);
		i.setProduct(p2);
		inventorydao.save(i);

	}

	@Override
	public void deleteInInventory(Long id) {
		inventorydao.deleteById(id);
	}

}
