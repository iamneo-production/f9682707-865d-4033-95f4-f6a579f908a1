package com.example.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
