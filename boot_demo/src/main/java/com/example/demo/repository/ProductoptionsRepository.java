package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Productoptions;
import com.example.demo.entity.ProductoptionsId;

public interface ProductoptionsRepository extends JpaRepository<Productoptions, ProductoptionsId>{

	List<Productoptions> findByProductId(Long product_id);
}
