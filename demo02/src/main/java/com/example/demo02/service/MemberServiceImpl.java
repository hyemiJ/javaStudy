package com.example.demo02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo02.domain.MemberDTO;

import mapperInterface.JoMapper;
import mapperInterface.MemberMapper;
import pageTest.Criteria;

//** Service
//=> 요청클래스 와 mapper클래스 사이의 연결(완충지대) 역할
//=> 요청클래스(컨트롤러) 와 mapper클래스 사이에서 변경사항이 생기더라도 서로 영향    받지않도록해주는 역할
//결합도는 낮추고, 응집도는 높인다

//** interface 자동완성 
//=> Alt + Shift + T  
//=> 또는 마우스우클릭 PopUp Menu 의  Refactor - Extract Interface...



@Service
public class MemberServiceImpl implements MemberService {
// ** 전역변수 정의
	
	//@Autowired(required = false)
	//MemberDAO dao ;
    // ** Mybatis 적용
    // => mapper 구현객체는 스프링이 실행시 자동으로 만들어 주입해줌.
    // => 그러므로 개발자는 interface 와 xml 만 구현하고 Service 와 연결해주면 됨.
    //    즉, 위 인터페이스의 구현체(클래스)는 개발자가 작성할 필요가 없음
	@Autowired(required = false)
	MemberMapper mapper;
	JoMapper jomapper;
	// * List<MemberDTO> mCheckList(Criteria cri);
	public List<MemberDTO> mCheckList(Criteria cri){
		return mapper.mCheckList(cri);
	}
	public int mCheckCount(Criteria cri) {
		return mapper.mCheckCount(cri);
	}

	// ** List<MemberDTO> mPageList();
	public List<MemberDTO> mPageList(Criteria cri){
		//return mapper.mPageList(cri);
		return mapper.mSearchList(cri);
	}
	public int totalRowsCount(Criteria cri) {
		//return mapper.totalRowsCount(cri);
		return mapper.mSearchCount(cri);
	}
// ** selectList
	@Override
	public List<MemberDTO> selectList() {
		return mapper.selectList();
	}

// ** selectOne
	@Override
	public MemberDTO selectOne(String id) {
		return mapper.selectOne(id);
	}

// ** insert
	@Override
	public int insert(MemberDTO dto) {
		return mapper.insert(dto);
	}

// ** update
	@Override
	public int update(MemberDTO dto) {
		return mapper.update(dto);
	}

// ** delete
	@Override
	public int delete(MemberDTO dto) {
		return mapper.delete(dto);
	}
	
//	public List<JoDTO> selectJoListService() {
//		return jomapper.selectJOList();
//	}


}// class