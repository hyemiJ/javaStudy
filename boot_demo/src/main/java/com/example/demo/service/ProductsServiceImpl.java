package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.ProductsDTO;
import com.example.demo.entity.Products;
import com.example.demo.repository.ProductsDSLRepository;
import com.example.demo.repository.ProductsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

	private final ProductsRepository repository;
	private final ProductsDSLRepository dsrepository;
	@Override
	public List<Products> findAll() {
		return repository.findAll();
	}
	@Override
	public List<ProductsDTO> findListDSL() {
		
		return dsrepository.findByJoinList();
	}
	
	@Override
	public List<Products> findByCategoryId(String id){
		return repository.findByCategoryId(id);
	}

	@Override
	public Products findById(Long id) {
		return repository.findById(id).get();
	}
	public ProductsDTO findByJoinOne(Long id) {
		return dsrepository.findByJoinOne(id);
	}

	@Override
	public void save(Products item) {
		 repository.save(item);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

}
