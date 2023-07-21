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

import com.example.springapp.model.Shipment;

import com.example.springapp.service.ShipmentService;

@RestController
@CrossOrigin

public class ShipmentController {

	@Autowired
	ShipmentService shipmentService;

	@PostMapping("/shipment")
	public void setShipments(@RequestBody Shipment sh) {
		shipmentService.setShipment(sh);
	}
    
	@GetMapping("/shipment/{id}")
	public Shipment getid(@PathVariable Long id){
       return shipmentService.getShipmentById(id);
	}

	@GetMapping("/shipment")
	public List<Shipment> getShipments() {
		return shipmentService.getAllShipment();
	}

	@PutMapping("/shipment")
	public void editShioments(@RequestBody Shipment sh) {
		shipmentService.editShipment(sh);
	}

	@DeleteMapping("/shipment")
	public void deleteShipments(Long id) {
		shipmentService.deleteShipment(id);
	}
}