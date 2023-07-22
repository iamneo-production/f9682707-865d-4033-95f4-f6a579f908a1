
package com.example.springapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Inventory;
import com.example.springapp.model.Product;
import com.example.springapp.model.PurchaseOrder;
import com.example.springapp.repository.InventoryRepository;
import com.example.springapp.repository.ProductRepository;
import com.example.springapp.repository.PurchaseOrderRepository;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	@Autowired
	PurchaseOrderRepository purchase;
	@Autowired
	ProductRepository product;

	@Autowired
	InventoryRepository inven;

	@Override
	public List<PurchaseOrder> getAllPurchaseOrder() {

		return purchase.findAll();
	}

	@Override
	public List<PurchaseOrder> getPurchaseOrderByProductId(Long id) {

		return purchase.findByProductId(id);
	}

	@Override
	public void createPurchaseOrder(PurchaseOrder p) {
		Product p2 = product.findById(p.getProductId()).orElse(null);
        Inventory in=inven.findByProductId(p.getProductId());
		p2.setQuantity(p2.getQuantity() + p.getQuantity());
		in.setQuantity(in.getQuantity() + p.getQuantity());
		purchase.save(p);
        inven.save(in);
		product.save(p2);

	}

	@Override
	public void editPurchaseOrder(PurchaseOrder p) {
		Product p2 = product.findById(p.getProductId()).orElse(null);
		PurchaseOrder original = purchase.findById(p.getId()).orElse(null);
		p2.setQuantity(p2.getQuantity() - original.getQuantity() + p.getQuantity());
		purchase.save(p);
		product.save(p2);

	}

	@Override
	public void deletePurchaseOrder(Long id) {
		purchase.deleteById(id);

	}

}