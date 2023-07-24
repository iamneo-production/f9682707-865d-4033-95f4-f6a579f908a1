
package com.example.springapp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    
List<PurchaseOrder> findByProductId(Long id);
}