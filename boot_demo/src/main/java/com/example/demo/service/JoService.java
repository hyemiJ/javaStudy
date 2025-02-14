package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.JoDTO;
import com.example.demo.entity.Jo;

public interface JoService {

	// ** selectList
	List<Jo> selectList();

	// ** select Join
	List<JoDTO> findAllJoin();
	
	// ** selectOne
	Jo selectOne(int jno);
	
	// ** insert & update
	Jo save(Jo entity);
	
	// ** delete
	void deletebyId(int jno);

}