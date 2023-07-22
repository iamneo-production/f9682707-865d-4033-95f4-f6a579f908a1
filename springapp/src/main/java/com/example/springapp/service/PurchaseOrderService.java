
package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.PurchaseOrder;

public interface PurchaseOrderService {
	public List<PurchaseOrder> getAllPurchaseOrder();

	public List<PurchaseOrder> getPurchaseOrderByProductId(Long id);

	public void createPurchaseOrder(PurchaseOrder p);

	public void editPurchaseOrder(PurchaseOrder p);

	public void deletePurchaseOrder(Long id);
}