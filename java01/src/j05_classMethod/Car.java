package j05_classMethod;
//** 클래스에 포함 가능한것 (맴버)
//=> 속성(변수, 필드_Field, Column), 기능.동작(메서드)
//=> 맴버변수(전역변수), 맴버메서드 
//=> 맴버메서드 종류 (역할이 정해져있는 메서드들)
// - main, 생성자(Constructor), toString, setter, getter
//
//** 클래스명                                                                                                        
//=> 대문자로 시작, 예약어 사용불가 , API 라이브러리의 클래스명 비추
//=> 클래스는 객체의 설계도
//
//** 객체의 주기 (LifeCycle)
//=> 생성 -> 사용 -> 소멸  (in Memory, RAM)
//=> 클래스(in HDD) -> 생성(in Memory) -> 객체화 (인스턴스 생성)
//                -> 사용 -> 소멸(Memory 반납)
//
//** 클래스, 객체, 인스턴스(instance : 사례, 경우) 
//  클래스와 인스턴스는 설계도와 제품이라고 할수있다.
//  그럼 객체는 클래스일까 인스턴스일까? 
//  Java 프로그래밍에서는 설계도인 클래스가
//  메모리상의 구체적인 실체인 인스턴스가 되었을때 객체라고 부른다. 
//
//  그러므로 클래스와 인스턴스는 구별되고, 클래스와 객체도 구별되지만, 
//  객체와 인스턴스는 구분없이 포괄적으로 객체라는 말을 쓰기도 한다.
public class Car {
//pubic 사용범위를 일컫음.
	public int speed ;
	public double price ; 
	public char grade ;
	public String brand; 
	//전역변수는 초기화 하지 않지만 , 필요시에 초기화 할 수 있다.
	//초기화 하지 않을 경우 디폴트 값을 가짐. int = 0 ; String = null ;
	String color = "blue"; 
	//클래스에 있는 모든 메서드 들에서 사용 할 수있고 , 외부(타 클래스)에 노출 할 수 있는 변수.
	
	//리턴이 있는 메서드인지 없는 메서드인지 반드시 표기해줘야함.
	//void => 리턴이 없는 메서드
	public void hpowerUp() {
		speed+=10;
	}
	public void hpowerDown() {
		speed-=10;
	}
	//변수를 출력하기 위한 메서드
	public String toString() {
		return "[speed ="+speed+", price ="+price+", brand = "+brand
					+", color = "+color+", grade: "+grade+" ]";
	} 
	//리턴값이 없으면 컴파일 오류 발생
	
	
	
	//생성자 정의
	public Car(){
		System.out.println("====Car의 기본 생성자");
	}
	
	public Car(double price , int speed , String brand , char grade ,String color) {
		this.price = price;
		this.speed = speed;
		this.brand = brand;
		this.grade = grade;
		this.color = color;
		System.out.println("====Car의 모든 값 초기화 생성자");
	}
}



