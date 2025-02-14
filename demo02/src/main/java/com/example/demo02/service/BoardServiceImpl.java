package com.example.demo02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo02.domain.BoardDTO;

import mapperInterface.BoardMapper;
import pageTest.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired(required = false)
	BoardMapper mapper;
	
	// *checkBoxSearch : Board checkBoxSearch PageList
	@Override
	public List<BoardDTO> bCheckList(Criteria cri){
		return mapper.bCheckList(cri);
	}
	// *checkBoxSearch : checkBoxSearch total
	@Override
	public int checkRowsCount(Criteria cri) {
		return mapper.checkRowsCount(cri);
	}
	
	
	
// ** bPageList
	// 버전 1 -> 2 : mapper.java 호출명만 변경
	@Override
	public List<BoardDTO> bPageList(Criteria cri) {
		//버전 1 :return mapper.bPageList(cri);
		return mapper.bSearchList(cri);
	}
	// * totalCount
	@Override
	public int totalRowsCount(Criteria cri) {
		//버전 1 :return mapper.totalRowsCount(cri);
		return mapper.searchRowsCount(cri);
	}

	
// ** selectList
	@Override
	public List<BoardDTO> selectList() {
		return mapper.selectList();
	}

// ** selectOne
	@Override
	public BoardDTO selectOne(int seq) {
		return mapper.selectOne(seq);
	}

// ** insert
	@Override
	public int insert(BoardDTO dto) {
		return mapper.insert(dto);
	}

// ** update
	@Override
	public int update(BoardDTO dto) {
		return mapper.update(dto);
	}

// ** delete
	@Override
	public int delete(BoardDTO dto) {
		return mapper.delete(dto);
	}

	// ** reply_insert
	@Override
	public int rinsert(BoardDTO dto) {
		if(mapper.rinsert(dto)>0) {
			//stepUpate.
			System.out.println("stepUpate 카운트"+mapper.stepUpdate(dto));
			return 1;
		}else {
			return 0;
		}
	}


}
