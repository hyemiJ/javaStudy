package com.example.demo02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo02.domain.JoDTO;
import com.example.demo02.domain.MemberDTO;
import com.example.demo02.model.JoDAO;

import mapperInterface.JoMapper;


@Service
public class JoServiceImpl implements JoService {
	@Autowired(required = false)
	JoMapper jomapper;
	
	@Override
	public List<JoDTO> selectJoListService() {
		return jomapper.selectJOList();
	}
	@Override
	public JoDTO selectJoListOneService(int jno) {
		return jomapper.selectJoListOne(jno);
	}
	
	@Override
	public int insertJoService(JoDTO joDto) {
		return jomapper.insertJo(joDto); 
	}
	
	@Override
	public int updateJoService(JoDTO joDto) {
		return jomapper.updateJo(joDto); 
	}
	
	@Override
	public int deleteJoService(JoDTO joDto) {
		return jomapper.deleteJo(joDto);
	}
	
	@Override
	public List<JoDTO> joinTestService(){
		return jomapper.joinTest();
	}
	@Override
	public List<MemberDTO> jnosearch(int jno) {
		
		return jomapper.jnosearch(jno);
	}
	
	
}
