package com.example.springapp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Product;
import com.example.springapp.model.Shipment;
import com.example.springapp.repository.ProductRepository;
import com.example.springapp.repository.ShipmentRepository;

@Service

public class ShipmentServiceImpl implements ShipmentService {
	@Autowired
	ShipmentRepository shipment;

	@Autowired
	ProductRepository product;

	@Override
	public List<Shipment> getAllShipment() {
		return shipment.findAll();
	}

	@Override
	public void setShipment(Shipment sh) {
		Product p2 = product.findById(sh.getProductId()).orElse(null);
		if(p2==null){
            shipment.save(sh);
		}
		else{
		p2.setQuantity(p2.getQuantity() - sh.getQuantity());
		shipment.save(sh);
		product.save(p2);}

	}

	@Override
	public void createShipment(Shipment sh) {
		shipment.save(sh);

	}
	
    @Override
	public Shipment getShipmentById(Long id) {
		
     return shipment.findById(id).orElse(null);
	}


	@Override
	public void editShipment(Shipment sh) {
		Shipment originalShipment = shipment.findById(sh.getId()).orElse(null);
		Product p2 = product.findById(sh.getProductId()).orElse(null);
		p2.setQuantity(p2.getQuantity() + originalShipment.getQuantity() - sh.getQuantity());
		shipment.save(sh);
		product.save(p2);

	}

	@Override
	public void deleteShipment(Long id) {
		shipment.deleteById(id);

	}
}