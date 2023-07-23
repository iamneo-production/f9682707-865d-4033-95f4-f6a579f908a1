package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.Sales;

public interface SalesService {
	public List<Sales> getAllSales();

    public Sales getSalesById(Long id);

	public List<Sales> getSalesByProductId(Long id);

	public void setSales(Sales s);

	public void editSales(Sales s);

	public void deleteSales(Long id);
}

