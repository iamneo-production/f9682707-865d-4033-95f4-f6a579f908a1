package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment,Long>{

}