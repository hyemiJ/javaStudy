package j09_InnerClass;
//** 상수 사용 비교
//=> interface(일반적 상수) , enum
//** 열거형(enum) 상수 사용
//=> 정의 : 열거형은 서로 연관된 상수들의 집합
//=> interface 와 비교
//
//** 열거형의 특징
//=> 상수의 사용을 편리하게 지원.
//=> 의미가 있는 단어를 상수로 사용하기 편리함.
//=> 값과 타입을 동시에 확인하기때문에 안전하고 효율적인 코딩 가능
//=> 열거형 내부에 생성자, 필드, 메소드를 가질 수 있어서 단순히 상수가 아니라 더 많은 역할이 가능함. 


interface ScaleI{
	int DO = 0;
	int RE = 1;
	int MI = 2;
	int FA = 3;
	int SOL = 4;
	int RA = 5;
	int SI = 6;
}

enum ScaleE{
	DO , RE , MI , FA , SOL , RA , SI
}
enum Direction {
	EAST , WEST , SOUTH , NORTH
}

public class Ex04_enumTest {
	public static void main(String[] args) {
		//interface 상수 사용 : switch case 구문에 적용
		int ikey = ScaleI.MI;
		switch (ikey) {
		case 0: System.out.println("도"); break;
		case 1: System.out.println("레"); break;
		case 2: System.out.println("미"); break;
		case 3: System.out.println("파"); break;
		case 4: System.out.println("솔"); break;
		case 5: System.out.println("라"); break;
		case 6: System.out.println("시"); break;
		}
		
		//enum 사용 : 의미있는 단어를 사용함으로 값과 타입을 동시에 확인하기 때문에 안전하고 효율적인 코딩 가능
		ScaleE ekey = ScaleE.RA;
		System.out.println(ekey);
		
		switch (ekey) {
		case DO : System.out.println("도"); break;
		case RE : System.out.println("레"); break;
		case MI : System.out.println("미"); break;
		case FA : System.out.println("파"); break;
		case SOL : System.out.println("솔"); break;
		case RA : System.out.println("라"); break;
		case SI : System.out.println("시"); break;
		}
	}
}
