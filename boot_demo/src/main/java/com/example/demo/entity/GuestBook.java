package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // JPA에서 엔티티 클래스로 선언함을 의미 : @Entity를 선언하면 JPA는 이 클래스를 보고 해당 테이블과 매핑되는 엔티티로 간주
@Table(name="guestbook")//데이터베이스에서 이 클래스가 매핑될 테이블의 이름을 지정 :entity 클래스 명과 테이블 명이 같으면 에노테이션 생략가능.
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder //빌더 패턴을 통해 객체를 생성 :여러 개의 생성자를 일일이 작성하지 않고도 가독성 있게 객체를 생성
public class GuestBook extends BaseEntity{
	
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment
	private Long gno; // auto-increment (P.K)
	
	@Column(length = 100,nullable = false) // 크기와 notnull 지정
	private String title;
	@Column(length = 1000,nullable = false)
	private String content;
	@Column(length = 30,nullable = false)
	private String writer;
	public void changeTitle(String title) {
		this.title = title;
	}//일종의 setter.
	public void changeContent(String content) {
		this.title = content;
	}//일종의 setter.
}
