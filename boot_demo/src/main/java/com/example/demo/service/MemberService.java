package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.JoDTO;
import com.example.demo.entity.Member;



public interface MemberService {

	// ** QueryDSL 
	List<JoDTO> joinDSL();
	
	// ** findByJno 조별 출력
	List<Member> findByJno(int jno);
	
	// ** selectList
	List<Member> selectList();

	// ** selectOne
	Member selectOne(String id);

	// ** insert , update
	Member save(Member entity);
	
	// ** 해당 아이디에 비밀 번호 변경
	void updatePassword(String id, String password);

	// ** delete
	void delete(String id);
}