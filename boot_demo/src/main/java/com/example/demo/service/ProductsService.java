package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.ProductsDTO;
import com.example.demo.entity.Products;

public interface ProductsService {

	List<Products> findAll();
	
	List<Products> findByCategoryId(String id);
	
	List<ProductsDTO> findListDSL();
	
	Products findById(Long id);
	
	ProductsDTO findByJoinOne(Long id);
	
	void save(Products item);
	
	void deleteById(Long id);
}
