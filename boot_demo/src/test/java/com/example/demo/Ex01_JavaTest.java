package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
/* * 테스트 레벨 4단계
//=> 단위테스트 -> 통합테스트 -> 시스템테스트 -> 인수테스트

//** 테스트 주도 개발 (Test-Driven Development , TDD)
//=> JUnit 활용
//  Java 개발시 가장 많이 이용되는 단위테스트 프레임
//  오픈 소스 형태로 개발되며 계속 업그레이드 되고 있음.
//  JUnit4 부터 에너테이션 적용 ( Java 가 5 부터 언어적 개선이 이루어짐에 따른 변화임 )

//** @ 종류
//=> @Before - @Test - @After
//  -> 하나의 클래스에서 @ 들을 반복사용하면 오류는 안나지만, 앞쪽 @이 실행됨
//=> @ 적용 테스트 메서드 : non static, void 로 정의 해야 함.

//** org.junit.Assert 가 지원하는 다양한 Test용 Method 
//1) assertEquals(a,b) : a와 b의 값(Value) 이 같은지 확인
//2) assertSame(a,b) : 객체 a와b가 같은 객체임(같은 주소) 을 확인
//3) assertTrue(a) : a가 참인지 확인
//4) assertNotNull(a) : a객체가 Null 이 아님을 확인
//5) assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인

//=> 자동 import 가 안되는경우
//  -> 프로젝트 우클릭 -> Build Path -> Configure Build Path.. 
//          -> Libraries -> Add Library  -> JUnit4
//  -> @Test: import org.junit.Test 확인

//** JUnit4 / JUnit5 비교
//=> JUnit4 
//  -> 단일 모듈
//  -> 패키지명: org.junit.Test 

//=> JUnit5 
//  -> Junit Jupiter, JUnit plateform,  JUnit Vintage모듈로 구성됨.
//  -> 패키지명: org.junit.jupiter.api.Test
//  -> Spring boot 2.2부터는 기본으로 Junit5 모듈 사용
*/
class Book {
    String author;
    String title;
    int price;
    
    Book(String author, String title, int price) {
        this.author=author;
        this.title=title;
        this.price=price;
    }
    
    public boolean isBook(boolean b) { return b; }
} //Book


public class Ex01_JavaTest {
	
	//** org.junit.Assert 가 지원하는 다양한 Test용 Method 
	
	//1) assertEquals(a,b) : a와 b의 값(Value) 이 같은지 확인
	//@Test
	public void equalsTest() {
		Book b1 = new Book("홍길동","홍길동전",9900);
		assertEquals(b1.author,"톨스토이");
	}
	
	
	//2) assertSame(a,b) : 객체 a와b가 같은 객체임(같은 주소) 을 확인
	//@Test
	public void sameTest() {
		Book b1 = new Book("홍길동","홍길동전",9900);
		Book b2 = new Book("홍길동","홍길동전",9900);
		assertSame(b1,b1);
	}
	//3) assertTrue(a) : a가 참인지 확인
	//@Test
	public void trueTest() {
		Book b1 = new Book("홍길동","홍길동전",9900);
		Book b2 = new Book("홍길동","홍길동전",9900);
		assertTrue(b1.isBook(true));
	}
	//4) assertNotNull(a) : a객체가 Null 이 아님을 확인
	//@Test
	public void nullTest() {
		Book b1 = new Book("홍길동","홍길동전",9900);
		Book b2 = new Book("홍길동","홍길동전",9900);
		b2 = null;
		assertNotNull(b1);
	}
	//5) assertArrayEquals(a,b) : 배열 a와b가 일치함을 확인
	@Test
	public void arrayTest() {
		String[] a1 = {"가","나","다"};
		String[] a2 = {"가","나","다"};//동일 순서 동일 내용
		String[] a3 = {"가","다","나"};//다른 순서 동일 내용
		String[] a4 = {"가","나","라"};//다른 순서 다른 내용
		
		//동일 순서 동일 내용
		//서로 다른 주소값을 지녔더라도 , 값의 비교를 통해 boolean 값 반환
		//assertArrayEquals(a1, a2);
		//다른 순서 동일 내용
		//assertArrayEquals(a1, a3);
		//다른 순서 다른 내용
		//assertArrayEquals(a1, a4);
	}


}
