package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Productoptions;
import com.example.demo.entity.ProductoptionsId;


public interface ProductoptionsService {
	List<Productoptions> findAll();
	
	List<Productoptions> findByProductId(Long id);
	
	
	
	Productoptions findById(ProductoptionsId id);
	
	
	void save(Productoptions options);
	
	void deleteById(ProductoptionsId id);
	
}
