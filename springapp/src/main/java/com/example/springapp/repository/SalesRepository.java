package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.springapp.model.Product;
import com.example.springapp.model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {

List <Sales> findByProductId(Long productId);
    
//  @Query("select * from Sales s where s.productId=?1 ")
//  Sales findByProductIds(Long productId);

    

}
