package com.example.demo.repository;

import static com.example.demo.entity.QJo.jo;
import static com.example.demo.entity.QMember.member;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.JoDTO;
import com.example.demo.entity.Member;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor; 

@Repository
@RequiredArgsConstructor
public class MemberDSLRepositoryImpl implements MemberDSLRepository {

	private final JPAQueryFactory jpaQueryFactory;
    // 생성을 위한 Bean 설정을 DemoConfig에 추가해야함.
	
	// 1) Entity return
    // => Q클래스로 SQL 구문 작성하고 Entity return
    // => Parameter로 전달된 조원들만 출력하기 
    @Override
    public List<Member> findMemberJnoDSL(int jno) {
        
    	return jpaQueryFactory.selectFrom(member)
    					.where(member.jno.eq(jno).and(member.point.goe(10)))
    					.orderBy(member.age.desc())
    					.fetch();//fetch는 끝을 명시. List type으로 반환.
    					
    }
    
    // 2) Join & DTO return
    // => QueryDSL 에서 DTO 적용하기

    // => 메모장 QueryDSL사용법.txt 참고
    //    4종류 방법중 1) Setter 접근 , 2) 필드 직접접근 적용, 3) 생성자 사용, 4) @QueryProjection
  
    
    
    // 2.1) Setter 접근 
    // => JoDto의 setter 를 호출해서 ,  DTO 의 멤버변수에 injection 해주는 방식.
    // => Projections.bean(~~~)  로 접근
    @Override
    public List<JoDTO> findMemberJoinDSL() {
    	// JPAQueryFactory를 사용하여 쿼리를 시작합니다.
    	// select() 메서드를 통해 JoDTO 클래스로 결과를 매핑하도록 설정합니다.
    	// Projections.bean()은 조회된 결과를 JoDTO로 변환합니다
    	return jpaQueryFactory.select(Projections.bean(JoDTO.class, 
    	        member.id,        // member 엔터티의 id 필드를 JoDTO의 대응 필드에 매핑
    	        member.name,      // member 엔터티의 name 필드를 JoDTO의 대응 필드에 매핑
    	        member.jno,       // member 엔터티의 jno 필드를 JoDTO의 대응 필드에 매핑
    	        jo.jname,         // jo 엔터티의 jname 필드를 JoDTO의 대응 필드에 매핑
    	        jo.project        // jo 엔터티의 project 필드를 JoDTO의 대응 필드에 매핑
    	    ))
    	    
    	    // from() 메서드는 기본적으로 조회할 엔터티를 지정합니다.
    	    // 여기서는 member 엔터티를 기준으로 데이터를 가져옵니다.
    	    .from(member)
    	    
    	    // leftJoin() 메서드는 LEFT JOIN을 설정합니다.
    	    // member와 jo 엔터티 간의 조인을 설정하고, 모든 member 데이터를 유지하며 
    	    // jo 엔터티의 대응되는 데이터를 가져옵니다. 대응되지 않으면 null로 표시됩니다.
    	    .leftJoin(jo)
    	    
    	    // on() 메서드는 LEFT JOIN의 조건을 지정합니다.
    	    // member 엔터티의 jno 값과 jo 엔터티의 jno 값이 같은 경우 조인이 이루어집니다.
    	    .on(member.jno.eq(jo.jno))
    	    
    	    // fetchJoin() 메서드는 조인된 엔터티를 즉시 로딩하도록 강제합니다.
    	    // 기본적으로 조인된 엔터티는 Lazy Loading을 사용하여 필요할 때 로딩되지만,
    	    // fetchJoin()을 사용하면 한 번의 쿼리로 모든 데이터를 가져옵니다.
    	    .fetchJoin()
    	    
    	    // fetch() 메서드는 쿼리를 실행하고 결과를 리스트(List) 형태로 반환합니다.
    	    // 즉, 데이터베이스에서 쿼리를 실행하고, 조회된 데이터를 JoDTO 리스트로 반환합니다.
    	    .fetch();
    	
    	// Projections.bean( 조회 결과를 매핑할 대상 클래스,엔터티의 필드(컬럼)를 가져와서 DTO에 매핑) : SQL 쿼리의 결과를 JoDTO 객체로 매핑하는 역할
    	// from(entity) : 조회할 기본 테이블 또는 엔터티를 지정
    	//leftJoin(entity) : 엔터티의 leftJoin
    	//on(조건) : 은 SQL의 ON 조건과 동일
    	//fetchJoin() : 성능 최적화를 위해 사용, fetchJoin()을 사용하면 조인된 엔터티를 한 번에 가져옴
    	 // => fetchJoin()
        //    - 조인하는 대상 데이터를 즉시 로딩해서 가져온다
        //    - JPA의 지연로딩을 피하고 N+1문제를 해결할 수 있음.
    }

    
    // 2.2) 필드 직접 접근 
    // => 필드에 직접 접근해서 값을 injection 하는 방식.
    // =>Projections.fields(~~~) 로 접근
    //     그러므로 DTO 에 setter/getter 없어도 가능하며
    //     JoDto의 멤버변수에 값이 injection 된다.
    
    // => fetchJoin()
    //    - 조인하는 대상 데이터를 즉시 로딩해서 가져온다
    //    - JPA의 지연로딩을 피하고 N+1문제를 해결할 수 있음.
    //    ( MemberRepository 참고, https://jie0025.tistory.com/518 )

    @Override
    public List<JoDTO> findMemberJoinDSL2() {
    	// jpaQueryFactory를 사용하여 쿼리를 작성하고, Projections.fields()로 결과를 JoDTO에 매핑
    	return jpaQueryFactory.select(Projections.fields(JoDTO.class, member.id,member.name,member.jno,jo.jname,jo.project))
    					.from(member)
    					.leftJoin(jo)
    					.on(member.jno.eq(jo.jno))
    					.fetchJoin()
    					.fetch();
    }
    
}
