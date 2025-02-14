package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Board;

//** JPA 쿼리의 특징
// => 테이블이 아닌 엔티티 객체를 대상으로 처리함.

public interface BoardRepository extends JpaRepository<Board, Integer>  { 
	
	//@Query("SELECT b.seq, b.title, b.id, b.regdate, b.cnt, b.root, b.step, b.indent FROM Board b order by b.root desc, b.step asc")
	// => 오류구문
	@Query("SELECT b FROM Board b order by b.root desc, b.step asc")
	List<Board> findAllOrder();
	
}
