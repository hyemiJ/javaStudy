package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Productoptions;
import com.example.demo.entity.ProductoptionsId;
import com.example.demo.service.ProductoptionsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoptionsServiceImpl implements ProductoptionsService {
	private final ProductoptionsRepository repository;
	
	@Override
	public List<Productoptions> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Productoptions> findByProductId(Long id) {
		
		return repository.findByProductId(id);
	}

	@Override
	public Productoptions findById(ProductoptionsId id) {
		
		return repository.findById(id).get();
	}

	@Override
	public void save(Productoptions options) {
		repository.save(options);

	}

	@Override
	public void deleteById(ProductoptionsId id) {
		repository.deleteById(id);

	}

}
