package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Inventory;

public interface InventoryService {
	public List<Inventory> getAllInventory();

	Inventory getInventoryById(Long id);

	public void createInventory(Inventory i);

	public void editInInventory(Inventory i);

	public void deleteInInventory(Long id);
}
