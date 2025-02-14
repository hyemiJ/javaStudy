package mapperInterface;

import java.util.List;

import com.example.demo02.domain.JoDTO;
import com.example.demo02.domain.MemberDTO;

public interface JoMapper {
	public List<JoDTO> selectJOList();
	public JoDTO selectJoListOne(int jno);
	public int insertJo(JoDTO joDto);
	public int updateJo(JoDTO joDto);
	public int deleteJo(JoDTO joDto);
	public List<JoDTO> joinTest();
	public List<MemberDTO> jnosearch(int jno);
}
