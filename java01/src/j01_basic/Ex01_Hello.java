package j01_basic;
//** 이클립스 단축키 
//자동 import : Ctrl+Shift+O
//Line삭제 : Ctrl + d

//들여쓰기 : Ctrl+A , Ctrl+I 
//=> 한번에 Ctrl+Shift+F

//클래스 Ctrl+클릭 => 클래스 소스보기 
//클래스 Ctrl+T => 클래스 계층도 

//** 클래스 
//=> 클래스명은 화일명과 동일함.
//=> 맴버   
//  변수: value, 
//  메서드 (함수 function , 프로시져 procedure) : 동작

//** 문장(Statement)
//=> 사용자가 컴퓨터에게 작업을 지시하는 단위
//=> 문장의 끝은 항상 세미콜론 (;)
//=> 선언문 과 실행문(메소드 안에 작성) 

//** Java Coding
//=> 대.소 문자구별함

/* 주석(comment)의 종류
=> 한줄 주석
  => 여러줄 주석
*/
public class Ex01_Hello {//메인클래스 -> 파일명과 동일해야함.
	
	
	 static int num = 100;// 변수 선언이 가능함.(멤버)
	 
	//System.out.println("안녕하세요 !!"); 실행문은 메서드 안에서만.
	 
	public static void main(String[] args) { // 메서드(멤버)
		
		String name = "홍길동"; //지역변수
		
		System.out.println("안녕하세요 !!");
		System.out.println("num = "+ num);
		System.out.println("name = "+ name);
	}

}
