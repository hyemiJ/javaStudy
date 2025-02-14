package mapperInterface;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo03.domain.BoardDTO;

import pageTest.Criteria;


public interface BoardMapper {
	
	// * idbList : restController에서 axios List 출력 하기.
	// - myBatis 특징
	//			=> sql 구문 작성 xml 대신 @ 을 적용할 수 있다.
	//			=> @Param : @GetMapping(value="/getjo", params = "jno" ) => jno 의 구현 강제.
	//			=>			Mapper @Param 과 다르니 주의해야한다고 했는데 . 현재의 사용법을 보자.
	//			=>			MyBatis 에서는 매개변수 type관ㄴ 무관하지만 갯수는 1개만 허용됨.
	//			=>			복수의 인자 사용시에 @Param을 적용하면 가능함.
	//			=>			단, mapper interface에서만 사용 가능 . xml 구문에서 매칭가능.
	
	//@Select("select * from board where id = #{id} and jno=#{jno}") => 실행시 오류 발생 case
	//public List<BoardDTO> idbList( String id, int jno); => 실행 시 오류 발생 case
	
	//@Select("select * from board where id = #{ii} and jno=#{jno}") => 보통은 두가지 이상 조건을 부여할시에 dto를 전송하여 편하게 하지만 ,
	//public List<BoardDTO> idbList(@Param("ii") String id, @Param("jno") int jno);=> 두가지 이상의 인자로 따로 받을시에는 param을 의무적으로 써줘야한다.
	
	
	@Select("select * from board where id = #{ii}")
	public List<BoardDTO> idbList(@Param("ii") String id);
	
	//@Select("select * from board where id = #{id}")
	//public List<BoardDTO> idbList(String id);
	
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
