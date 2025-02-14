package j07_classExtends;

import j05_classMethod.Car;

//** 상속 : extends
//=> 기능을 확장해서 업그레이드 버젼 만듦.
//=> 기존(조상) 클래스의 맴버들(필드와 메소드)을 재사용 & 일부변경도 가능 
//
//** 생성순서
//=> JVM은 extends 키워드가 있으면 조상생성후 후손생성
// 이때 기본은 조상의 default 생성자를 실행하고,
// 특별히 후손 생성자에서 조상생성자_super(...)를 호출해 놓으면 그생성자를 실행함.
//=> 상속을 허용하는 클래스는 default 생성자를 반드시 작성하는것이 바람직함.
//
//** 조상 : Super (Parent, Base) class  
//=> super.  : 조상의 인스턴스를 의미 (조상의 맴버에 접근 가능)
//=> super(...)
// 조상의 생성자를 의미 (조상의 생성자에 접근 가능).
// this() 처럼 생성자 메서드 내에서 첫줄에 위치해야함.
//
//=> 생성자메서드_super(), this() 호출은 생성자 내에서만 가능 
//
//** 후손 : Sub ( Child, Derived [diráivd] ) class
//=> super class 를 포함



class SportCar extends Car{
	int turbo ;
	String option ;
	
	
	

	SportCar(){
		System.out.println("====SportCar 기본 생성자");
	}
	
//	public SportCar() {
//		super(); // 조상의 생성자 호출 
//					// 생략하면 컴파일러가 자동으로 조상의 기본 생성자를 넣어줌.
//		// TODO Auto-generated constructor stub
//	}

	SportCar(int turbo , String option){
		this.turbo = turbo;
		this.option = option;
		//super(); 
		// 생략하면 컴파일러가 자동으로 조상의 기본 생성자를 넣어줌.
		System.out.println("====SportCar 현재 값 초기화 생성자");
	}
	SportCar(int turbo , String option , double price , int speed , String brand , char grade ,String color){
		super(price,speed,brand,grade,color); // 부모의 생성자를 호출 . 인자의 순서와  갯수와 타입이 일치해야함.
		this.turbo = turbo;
		this.option = option;
		//super(); 
		// 생략하면 컴파일러가 자동으로 조상의 기본 생성자를 넣어줌.
		System.out.println("====SportCar 조상 값 + 현재 값 초기화 생성자");
	}
	@Override // 오버라이드의 재정의 : 좡메서드 + 기능추가.
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()  //super 는 조상을 의미. 추가로 현재값을 넣어주기.
				+"\n [ turbo = "+turbo+" , option : "+ option + " ]";
		
	}
//	@Override
//	public void hpowerUp() {
//		
//		super.hpowerUp();
//	}
	
	@Override
	public void hpowerUp() {
		
		speed+=100;
	}
	
	
	
} //상속 후 확장.

public class Ex02_extendsTest {

	public static void main(String[] args) {
		// 디폴트 생성자
		SportCar sc1 = new SportCar();
		System.out.println("main ) sc1 :"+sc1);
		System.out.println();
		sc1.brand = "apple"; //super 멤버변수 값.
		sc1.grade='b'; // super 멤버변수 값.
		sc1.option="navi"; // sub 멤버 변수 값.
		System.out.println("main ) sc1 (초기화 3개 ):"+sc1);
		sc1.hpowerUp();
		System.out.println("main )sc1.hpowerUp(); :"+sc1);
		System.out.println();
		
		//초기화 생성자
		SportCar sc2 = new SportCar(200 , "자동주행");
		System.out.println("main ) sc2 :"+sc2);
		System.out.println();
		//모든 값 초기화 생성자(int turbo, String option , double price , int speed , String brand , char grade ,String color)
		SportCar sc3 = new SportCar(100 , "옵션" , 400.0 ,100, "브랜드" , 'A' , "컬러" );
		System.out.println("main ) sc3 :"+sc3);
		System.out.println();
	}

}
