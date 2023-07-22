package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Product;
import com.example.springapp.model.Sales;
import com.example.springapp.repository.ProductRepository;
import com.example.springapp.repository.SalesRepository;

@Service
public class SalesServiceImpl implements SalesService {
	@Autowired
	SalesRepository sale;

	@Autowired
	ProductRepository pro;

	@Override
	public List<Sales> getAllSales() {
		return sale.findAll();
	}

	@Override
	public List<Sales> getSalesByProductId(Long id) {
		return sale.findByProductId(id);
	}

	@Override
	public Sales getSalesById(Long id) {
		return sale.findById(id).orElse(null);
	}

	@Override
	public void setSales(Sales s) {
	List <Sales> v=sale.findByProductId(s.getProductId());
	
   

		if(v==null || v.isEmpty()){
			

			sale.save(s);
	 }
		
		else
		{
			Sales u=v.get(0);
			u.setPrice(u.getPrice()+s.getPrice());
			u.setQuantity(u.getQuantity()+s.getQuantity());
			sale.save(u);
		}

	}

	@Override
	public void editSales(Sales s) {
		sale.save(s);

	}

	@Override
	public void deleteSales(Long id) {
		sale.deleteById(id);

	}
}
