package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{
	
	@EntityGraph(attributePaths = {"options"})
	List<Products> findByCategoryId(String id);
	
	// findAll에 @EntityGraph 추가
	@EntityGraph(attributePaths = {"options"})
	List<Products> findAll();
	
	@EntityGraph(attributePaths = {"options"})
	Optional<Products> findById(Long id);
	
}
