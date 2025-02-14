package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.JoDTO;
import com.example.demo.entity.Member;

//* QueryDSL 적용
public interface MemberDSLRepository {

	//1. Entity 리턴
	List<Member> findMemberJnoDSL(int jno);
	
	//2.Join , DTO 리턴
	List<JoDTO> findMemberJoinDSL();
	
	List<JoDTO> findMemberJoinDSL2();
}
