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

import com.example.springapp.model.Sales;

import com.example.springapp.service.SalesService;

@RestController
@CrossOrigin

public class SalesController {

	@Autowired
	SalesService sale;

	@PostMapping("/sales")
	public void setSales(@RequestBody Sales s) {

		sale.setSales(s);

	}

	
	@GetMapping("/sales")
	public List<Sales> getSales() {
		return sale.getAllSales();
	}

	@GetMapping("/sales/{id}")
	public List<Sales> getSalesBYProductId(@PathVariable Long id) {
		return sale.getSalesByProductId(id);
	}

	@PutMapping("/sales")
	public void putSales(@RequestBody Sales s) {
		sale.editSales(s);
	}

	@DeleteMapping("/sales")
	public void delSales(Long id) {
		sale.deleteSales(id);
	}
}
