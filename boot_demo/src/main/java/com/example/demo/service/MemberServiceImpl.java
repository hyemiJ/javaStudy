package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.JoDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberDSLRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MyRepository;

import lombok.RequiredArgsConstructor;


//** Service
//=> 요청클래스 와 mapper클래스 사이의 연결(완충지대) 역할
//=> 요청클래스(컨트롤러) 와 mapper클래스 사이에서 변경사항이 생기더라도 서로 영향    받지않도록해주는 역할
//결합도는 낮추고, 응집도는 높인다

//** interface 자동완성 
//=> Alt + Shift + T  
//=> 또는 마우스우클릭 PopUp Menu 의  Refactor - Extract Interface...



@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository repository;
	private final MyRepository emrepository;
	private final MemberDSLRepository dsrepository;
	
	//joinDSL
	public List<JoDTO> joinDSL(){
		return dsrepository.findMemberJoinDSL2();
	}
	
	
	
	// ** findByJno 조별 출력
	@Override
	public List<Member> findByJno(int jno){
		//return repository.findByJno(jno);
		return dsrepository.findMemberJnoDSL(jno);
	}
	
// ** selectList
	@Override
	public List<Member> selectList() {
		//return repository.findAll(); //v01
		//return emrepository.emMemberList();//v02
		return emrepository.cbMemberList(); // v03(JPA Criteria Query -> MyRepository)
	}

// ** selectOne
	@Override
	public Member selectOne(String id) {
		//Optional<Member> result =repository.findById(id);
		//if(result.isPresent()) {
		//	return result.get();
		//}else return null; //v01
		return emrepository.emMemberDetail(id);
	}

// ** insert & update
	@Override
	public Member save(Member entity) {
		return repository.save(entity);
	}

	// ** 해당 아이디에 비밀 번호 변경
	public void updatePassword(String id, String password) {
		 repository.updatePassword(id,password);
	}
	
	
// ** delete
	@Override
	public void delete(String id) {
		repository.deleteById(id);
	}

}// class