package mapperInterface;

import java.util.List;

import com.example.demo02.domain.BoardDTO;

import pageTest.Criteria;


public interface BoardMapper {
	
	// *checkBoxSearch : Board checkBoxSearch PageList
	public List<BoardDTO> bCheckList(Criteria cri);
	// *checkBoxSearch : checkBoxSearch total
	public int checkRowsCount(Criteria cri);
	
	
	// *Search : Board Search PageList
	public List<BoardDTO> bSearchList(Criteria cri);
	// *Search : Search total
	public int searchRowsCount(Criteria cri);
	
	// *pageNation : bPageList
	public List<BoardDTO> bPageList(Criteria cri);
	// *pageNation : total
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
	
	// * replyInsert
	public int rinsert(BoardDTO dto);
	
	// * stepUpdate
	public int stepUpdate(BoardDTO dto);
	
}//interface Mapper
