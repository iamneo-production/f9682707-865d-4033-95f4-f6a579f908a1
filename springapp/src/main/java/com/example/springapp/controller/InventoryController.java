package com.example.springapp.controller;
import java.util.Calendar;
import java.util.Date;
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

import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Inventory;
import com.example.springapp.repository.InventoryRepository;
import com.example.springapp.service.InventoryService;

@RestController
@CrossOrigin

public class InventoryController {
	@Autowired
	InventoryService inventoryService;

	@Autowired
	InventoryRepository in;

	@PostMapping("/inventory")
	public ResponseEntity<Inventory> postInventory(@RequestBody Inventory i) {
		inventoryService.createInventory(i);
		return ResponseEntity.status(HttpStatus.CREATED).body(i);
	}

	@GetMapping("/inventory")
	public List<Inventory> getInventory() {
		return inventoryService.getAllInventory();
	}

	
	@GetMapping("/inventory/{id}")
	public Inventory getInventory(@PathVariable Long id) {
		return inventoryService.getInventoryById(id);
	}



	@PutMapping("/inventory")
	public void putinv(@RequestBody Inventory i) {
		inventoryService.editInInventory(i);
	}

	@DeleteMapping("/inventory")
	public void delinv(Long id) {
		inventoryService.deleteInInventory(id);
	}

	@DeleteMapping("/del")
	public void deleteOldDates() {
	 Calendar calendar = Calendar.getInstance();
	 Date myDate = new Date(); 
        calendar.setTime(myDate);
        calendar.add(Calendar.DAY_OF_MONTH, -90);
       
		in.deleteByDateBefore(calendar.getTime());
	}

}
