package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Code;
import com.example.demo.entity.CodeId;
import com.example.demo.repository.CodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService{
	final CodeRepository repository;
	@Override
	public List<Code> selectList() {
		// select * from Code
		return repository.findAll();
	}
	public List<Code> selectPCList(){
		return repository.findPC();
	}

	@Override
	public Code selectOne(CodeId id) {
		// select * from Code where id = id ;
		Optional<Code> entity = repository.findById(id);
		if(entity.isPresent()) {			
			return entity.get();
		}else return null;
	}

	@Override
	public void save(Code entity) {
		// update , insert
		repository.save(entity);
		
	}

	@Override
	public void delete(CodeId id) {
		// delete * from code where id = id;
		repository.deleteById(id);
	}

}
