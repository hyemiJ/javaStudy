package com.example.demo02.service;

import java.util.List;

import com.example.demo02.domain.BoardDTO;

import pageTest.Criteria;

public interface BoardService {

	// *checkBoxSearch : Board checkBoxSearch PageList
	public List<BoardDTO> bCheckList(Criteria cri);
	// *checkBoxSearch : checkBoxSearch total
	public int checkRowsCount(Criteria cri);
	
	// * bPageList
	public List<BoardDTO> bPageList(Criteria cri);
	// * totalCount
	public int totalRowsCount(Criteria cri);
	
	// * selectList
	public List<BoardDTO> selectList();
	
	// * selectOne
	public BoardDTO selectOne(int seq);
	
	// * insert
	public int insert(BoardDTO dto);
	
	// * update
	public int update(BoardDTO dto);
	
	// * delete
	public int delete(BoardDTO dto);
	
	//replyInsert
	public int rinsert(BoardDTO dto);
	
}//interface Service
