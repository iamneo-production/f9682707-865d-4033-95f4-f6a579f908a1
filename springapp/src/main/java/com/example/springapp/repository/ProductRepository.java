package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springapp.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select * from Product p where p.quantity < 6", nativeQuery = true)
	List<Product> findProductsByQuantityLessThanSix();

	@Query("SELECT SUM(p.quantity) FROM Product p")
	int getTotalQuantity();

	@Query("SELECT COUNT(p.quantity) FROM Product p where p.quantity < 6")
	int getAlertQuantity();

	@Query("SELECT p.id FROM Product p WHERE p.barcode = :barcode")
	int findIdByBarcode(@Param("barcode") String barcode);
}
