package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.TestKey;
import com.example.demo.entity.TestKeyId;

import jakarta.transaction.Transactional;

//** JPA 복합키실습 (@IdClass 방법) 과 count 값 수정하기  
//=> DML 사용시 @Modifying, @Transactional 적용 필수.
//1) JPQL : OK
//2) Native_SQL : OK
//3) default 메서드로 구현
// => 복잡한 계산식에 활용
// => 계산식을 메서드로 구현하고, 쿼리메서드를 호출하여 적용
//     -> 서비스는 default 메서드를 호출

public interface TestKeyRepository extends JpaRepository<TestKey, TestKeyId> {
	//updateCount
	@Transactional
	@Modifying
	//@Query("UPDATE TestKey t SET t.count=t.count+:count WHERE t.id=:id and t.no=:no")//JPQL을 적용 -> entity를 기준으로 entity명을 사용
	@Query(nativeQuery = true, 
					value = "UPDATE testkey SET count=count+:count WHERE id=:id and no=:no")//Native_SQL을 적용 -> 테이블명을 mySQL 기준으로 작성
	void updateCount(@Param("id") String id ,@Param("no") int no ,@Param("count") int count);
	
	//tdupupdate : 없으면 입력 , 있으면 컬럼 값의 증가
	//INSERT INTO my_entity (id, name, count)
	//VALUES (:id, :name, 1)
	//ON DUPLICATE KEY UPDATE count = count + 1;
	@Transactional
	@Modifying
	@Query(nativeQuery = true, 
				value = "INSERT INTO testkey(id,no,name,count)"//Native_SQL을 적용 -> 테이블명을 mySQL 기준으로 작성
						+ "	 VALUES(:id,:no,:name,:count) ON DUPLICATE KEY UPDATE count = count + :count")//insert같은 경우JPQL 불가 
	void dupUpdateCount(@Param("id") String id ,@Param("no") int no ,@Param("name") String name,@Param("count") int count);

	//계산 로직 구현하여 테이블로 저장할 값을 계산.
	default int calcCount(String id, int no, int count) {
		int result = count * no + 100;
		System.out.println("TestKeyRepository_calcCount_result "+ result);
		updateCount(id, no, result);
		return result;
	}
	@Transactional
	@Modifying
	@Query("UPDATE TestKey t SET t.count=:result WHERE t.id=:id and t.no=:no")//JPQL을 적용 -> entity를 기준으로 entity명을 사용
	void updateSql (@Param("id") String id,@Param("no") int no,@Param("result") int result);
}
