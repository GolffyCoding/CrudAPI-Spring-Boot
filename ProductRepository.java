package com.golffycoding.crudapi.repository;

import com.golffycoding.crudapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}