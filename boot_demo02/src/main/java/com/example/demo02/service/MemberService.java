package com.example.demo02.service;

import java.util.List;


import com.example.demo02.domain.MemberDTO;

import pageTest.Criteria;

public interface MemberService {

	List<MemberDTO> mCheckList(Criteria cri);
	int mCheckCount(Criteria cri);
	
	List<MemberDTO> mPageList(Criteria cri);
	int totalRowsCount(Criteria cri);
	// ** selectList
	List<MemberDTO> selectList();

	// ** selectOne
	MemberDTO selectOne(String id);

	// ** insert
	int insert(MemberDTO dto);

	// ** update
	int update(MemberDTO dto);

	// ** delete
	int delete(MemberDTO dto);
	
//	List<JoDTO> selectJoListService();

}