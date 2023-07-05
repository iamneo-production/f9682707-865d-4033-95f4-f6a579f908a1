package com.example.springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapp.Model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
