package com.example.demo01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo01.domain.MemberDTO;
import com.example.demo01.model.MemberDAO;

@Service
public class MemberService {
// ** 전역변수 정의
	
	@Autowired(required = false)
	MemberDAO dao ;

// ** selectList
	public List<MemberDTO> selectList() {
		return dao.selectList();
	}

// ** selectOne
	public MemberDTO selectOne(String id) {
		return dao.selectOne(id);
	}

// ** insert
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}

// ** update
	public int update(MemberDTO dto) {
		return dao.update(dto);
	}

// ** delete
	public int delete(MemberDTO dto) {
		return dao.delete(dto);
	}
	


}// class