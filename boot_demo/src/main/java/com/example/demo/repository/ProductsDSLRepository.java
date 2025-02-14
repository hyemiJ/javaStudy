package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.ProductsDTO;

public interface ProductsDSLRepository {
	
	List<ProductsDTO> findByJoinList();
	
	ProductsDTO findByJoinOne(Long id);
}
