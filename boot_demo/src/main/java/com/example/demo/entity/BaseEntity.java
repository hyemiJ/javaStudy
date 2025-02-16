package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
//** BaseEntity
//=> 자료 등록시간, 수정시간 등 자동으로 추가되고 변경되는 값들을 자동으로 처리하기위한 BaseEntity 클래스 
//=> 추상클래스로 작성      
//=> @MappedSuperclass: 테이블로 생성되지않음
//=> @EntityListeners : 엔티티객체의 변화를 감지하는 리스너설정 (AuditingEntityListener.class 가 담당)
//   AuditingEntityListener 를 활성화 시키기 위해서는 
//   DemoJpaApplication.java 에 @EnableJpaAuditing 설정추가해야함.

@EntityListeners(value = { AuditingEntityListener.class }) // 자동 감지 리스너
@Getter
@MappedSuperclass
abstract class BaseEntity {
	@CreatedDate
	@Column(name = "regdate", updatable = false)//수정되면 안되는 값(디폴트는 true)
	private LocalDateTime regdate;
	
	@LastModifiedDate
	@Column(name = "moddate") //항상 수정이 가능한 값.
	private LocalDateTime moddate; 
}//날짜 데이터를 처리하는 class
