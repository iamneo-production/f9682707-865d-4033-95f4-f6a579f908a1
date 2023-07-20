package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Location;

public interface Locationdao extends JpaRepository<Location, Integer> {

}
