package com.examly.springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.Model.Product;

public interface ProductRepo extends JpaRepository<Product,Long> {

}
