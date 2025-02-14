package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.JoDTO;
import com.example.demo.entity.Jo;
import com.example.demo.repository.JoRepository;

//import mapperInterface.JoMapper;


@Service
public class JoServiceImpl implements JoService {
	@Autowired(required = false)
	JoRepository repository;
	
	// ** selectList
	@Override
	public List<Jo> selectList() {
		return repository.findAll();
	}
	//** select Join
	@Override
	public List<JoDTO> findAllJoin() {
		return repository.findAllJoin();
	}
	
	// ** selectOne
	@Override
	public Jo selectOne(int jno) {
		Optional<Jo> result = repository.findById(jno);
		if(result.isPresent()) {
			return result.get();
		}else return null;
	}
	
	// ** insert & update
	@Override
	public Jo save(Jo entity) {
		return repository.save(entity);
	}
	
	// ** delete
	@Override
	public void deletebyId(int jno) {
		repository.deleteById(jno);
	}

}
