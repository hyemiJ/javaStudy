package com.ncs.spring02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.spring02.domain.JoDTO;
import com.ncs.spring02.model.JoDAO;

import mapperInterface.JoMapper;

@Service
public class JoServiceImpl implements JoService {
	@Autowired
	//JoDAO dao;
	// => Mybatis 적용
	JoMapper mapper;
	
	// ** selectList
	@Override
	public List<JoDTO> selectList() {
		return mapper.selectList();
	}
	// ** selectOne
	@Override
	public JoDTO selectOne(JoDTO dto) {
		return mapper.selectOne(dto);
	}
	// ** Insert
	@Override
	public int insert(JoDTO dto) {
		return mapper.insert(dto);
	}
	// ** Update
	@Override
	public int update(JoDTO dto) {
		return mapper.update(dto);
	}
	// ** Delete
	@Override
	public int delete(JoDTO dto) {
		return mapper.delete(dto);
	}

}//class
