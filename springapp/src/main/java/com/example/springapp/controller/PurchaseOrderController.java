
package com.example.springapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.springapp.model.PurchaseOrder;
import com.example.springapp.repository.PurchaseOrderRepository;
import com.example.springapp.service.PurchaseOrderService;

@RestController
@CrossOrigin

public class PurchaseOrderController {

	@Autowired
	PurchaseOrderService pos;

	@Autowired
	PurchaseOrderRepository doas;

	@PostMapping("/purchase-order")
	public void setPurchaseOrder(@RequestBody PurchaseOrder p) {
		pos.createPurchaseOrder(p);
	}

	@GetMapping("/purchase-order")
	public List<PurchaseOrder> getPurchaseOrder() {
		return pos.getAllPurchaseOrder();
	}

	@GetMapping("/purchase-order/{id}")
	public List<PurchaseOrder> getbyid(@PathVariable Long id) {
		return pos.getPurchaseOrderByProductId(id);
	}

	@PutMapping("/purchase-order")
	public void editPurchaseOrder(@RequestBody PurchaseOrder p) {
		pos.editPurchaseOrder(p);
	}

	@DeleteMapping("/purchase-order")
	public void delPurchaseOrder(Long id) {
		pos.deletePurchaseOrder(id);
	}

	@PostMapping("/purchase-orderss")
	public void setPurchaseOrders(@RequestBody PurchaseOrder p) {
		doas.save(p);
	}

}