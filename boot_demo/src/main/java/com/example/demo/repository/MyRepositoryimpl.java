package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
//** EntityManager 사용하기
//=> 영속 컨텍스트에 접근하여 엔티티에 대한 DB 작업을 제공

import com.example.demo.entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional//트랜잭션 내에서 실행되는 작업은 성공하면 커밋되고, 오류가 발생하면 롤백
@Repository//스프링의 리포지토리 빈으로 등록하는 애노테이션
@RequiredArgsConstructor
public class MyRepositoryimpl implements MyRepository {
	
	private final EntityManager em;
	//생성자 주입이 필요한데 , 주입을 아래 생성자의 인자를 이용하여 초기화 하도록 한다 , 또는 @RequiredArgsConstructor
	
	//public MyRepositoryimpl(EntityManager em) {
	//	this.em = em;
	//}//초기화 생성자를  통해 em을 초기화 하도록 세팅.

	@Override
	public List<Member> emMemberList() {
		return em.createQuery("SELECT m FROM Member m ORDER BY m.jno asc", Member.class)
				.getResultList();
	}

	@Override
	public Member emMemberDetail(String id) {
		return em.createQuery("SELECT m FROM Member m WHERE m.id = :id", Member.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	// *** JPA CriteriaBuilder (객체지향 쿼리 빌더)
	@Override
	public List<Member> cbMemberList() {  


	    //1) CriteriaBuilder 객체 생성
	    // => EntityManager 혹은 EntityManagerFactory 에서 제공받음.
	    
		CriteriaBuilder builder = em.getCriteriaBuilder();
	     
	    //2) CriteriaQuery 객체 생성 
	    //=> CriteriaBuilder 에서 제공받음.
	    //=> 반환타입을 알수 없다면 제네릭타입을 Object 로 준다.

	    CriteriaQuery<Member> query = builder.createQuery(Member.class);

	        
	    //3) 조회의 시작점을 뜻하는 Root객체 생성 
	    //=> 이때 m 은 JPQL에서 별칭이라고 생각하면 된다.
	    //=> 반환타입을 알수 없다면 제네릭타입을 Object로 준다.

	    Root<Member> m = query.from(Member.class);
	      
	     //4) 검색조건 정의
	      
	    Predicate jnoEqual = builder.equal(m.get("jno"), 7);

	     //5) 정렬조건 정의
	       
	    Order ageDesc = builder.desc(m.get("age"));

	    // 6) 쿼리문 완성 
	    
	    query.select(m)
	    	.distinct(true)
	    	.where(jnoEqual)
	    	.orderBy(ageDesc);
	     
	    //위에서 반환타입이 명확하지 않다면 Query 객체로 쿼리를 만들고 결과를 받는다.
	    TypedQuery<Member> typeQuery = em.createQuery(query);
	     
	    List<Member> members = typeQuery.getResultList();
	    return members;

	} //cbMemberList
	
	
	

}//class
