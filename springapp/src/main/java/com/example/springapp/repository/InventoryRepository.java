package com.example.springapp.repository;


import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Modifying
    @Transactional
    @Query("delete from Inventory i where i.location=?1")
    void deletebyLocation(String location);

    @Transactional
    @Modifying
    void deleteByDateBefore(Date date);

    Inventory findByProductId(Long productId);

}
