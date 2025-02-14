package mapperInterface;

import java.util.List;

import com.example.demo03.domain.MemberDTO;

import pageTest.Criteria;

public interface MemberMapper {
	
	public List<MemberDTO> mSearchList(Criteria cri);
	public int mSearchCount(Criteria cri);
	public List<MemberDTO> mCheckList(Criteria cri);
	public int mCheckCount(Criteria cri);
	public List<MemberDTO> mPageList(Criteria cri);
	public int totalRowsCount(Criteria cri);
	public List<MemberDTO> selectList();
	public MemberDTO selectOne(String id);
	public int insert(MemberDTO dto);
	public int update(MemberDTO dto);
	public int delete(MemberDTO dto);
	//public List<JoDTO> selectJoListService();
}
