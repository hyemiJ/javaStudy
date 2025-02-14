package com.example.demo03.service;

import java.util.List;

import com.example.demo03.domain.JoDTO;
import com.example.demo03.domain.MemberDTO;

public interface JoService {

	// ** selectList
	List<JoDTO> selectJoListService();

	// ** selectOne
	JoDTO selectJoListOneService(int jno);
	
	// ** insert
	int insertJoService(JoDTO joDto);

	// ** update
	int updateJoService(JoDTO joDto);
	
	// ** delete
	int deleteJoService(JoDTO joDto);

	List<JoDTO> joinTestService();
	
	//** selectMember
	List<MemberDTO> jnosearch(int jno);

}