package com.example.demo01.service;

import java.util.List;

import com.example.demo01.domain.JoDTO;
import com.example.demo01.model.JoDAO;



public class JoService {
	
	JoDAO joDao = new JoDAO();
	
	public List<JoDTO> selectJoListService() {
		return joDao.selectJOList();
	}
	public JoDTO selectJoListOneService(int jno) {
		return joDao.selectJoListOne(jno);
	}
	
	public int insertJoService(JoDTO joDto) {
		return joDao.insertJo(joDto); 
	}
	
	public int updateJoService(JoDTO joDto) {
		return joDao.updateJo(joDto); 
	}
	
	public int deleteJoService(JoDTO joDto) {
		return joDao.deleteJo(joDto);
	}
	
	public List<JoDTO> joinTestService(){
		return joDao.joinTest();
	}
}
