package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Member;

import jakarta.transaction.Transactional;

public interface MemberRepository extends JpaRepository<Member, String>{
	
	//JpaRepository Method 규약 
	//findBy + 검색칼럼 (첫문자는 반드시 대문자로)
	//쿼리문을 직접 쓰지않아도 , 검색컬럼에 맞춰 자동으로 쿼리를 인식하게 된다.
	
	//List<Member> findBySearchId(String keyword);	
	//-> List 형식 return 의 경우에도 findby~~~	
	//가능하면 @Query("...") 보다는 Method 규약을 이용하는것이 작업량을 줄일수 있으므로 권장됨.
	@EntityGraph(attributePaths = {"roleList"})
	List<Member> findByJno(int jno);
	
	//단위테스트용 
	
	

	// ** 해당 아이디에 비밀 번호 변경 : JPQL 버전
	@Modifying
	@Transactional
	@Query("UPDATE Member m SET password=:password WHERE id = :id")
	void updatePassword(@Param("id") String id,@Param("password") String password);
	
    /* ** @EntityGraph 
    => 1:N 또는  N:1 등 서로 연관된 엔티티들을 SQL한번으로 조회하는 방법
        즉, JPA가 제공하는 Fetch Join의 간편한 @ 버전으로
        N+1 문제를 해결하고, 성능 최적화에 도움을 줄수있음.     */

	@EntityGraph(attributePaths = {"roleList"})
	// => "roleList": Member 엔티티의 
	//     @ElementCollection(fetch = FetchType.LAZY) 로 정의한 속성
	@Query("SELECT m FROM Member m where m.id=:id")
	Member getWithRoles(@Param("id") String id);
	
}
