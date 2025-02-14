package j09_InnerClass;

import j05_classMethod.Car;

//클래스 맴버
//맴버 변수 : 선언문 , 초기화 블럭
//맴버 메서드 : 생성자 메서드 , 메인 메서드 , setter/getter ,  toString , 일반 정의 메서드
//초기화 블럭 : {} , static{}
//내부 클래스 : 클래스 내부에 클래스를 정의 

class OuterClass {
	int age = 100;
	private String name = "홍길동";
	Car car ; //멤버 변수로 클래스를 정의 (has의 관계 : 포함관계 - OuterClass - Car => 재사용성이 많은 경우)
	// inner class 와 car 와의 비교. => 재사용성이 없고 , 현재 클래스(OuterClass)에서만 사용하는 경우 해당.
	
	public OuterClass() {
		System.out.println("기본 생성자 class ) OuterClass ");
	}
	
	class Inner{
		String country = "korea";
		public Inner() {
			System.out.println("기본 생성자 class ) Inner ");
		}
		public void printData(int price) {
			System.out.printf("%s 은(는) %s 에 살고 나이는 %d 입니다. 지역변수(매개변수) price = %d class ) Inner %n",name ,country, age , price);
		}
	}
	
}



public class Ex01_InnerBasic {
	public static void main(String[] args) {
		//1. OuterClass 만 생성.
		// -> Outer 맴버에만 접근이 가능하다.
		
		OuterClass out1 = new OuterClass();
		System.out.printf("out1.age :  %d  %n", out1.age);
		out1.car = new Car();
		out1.car.brand ="현대";
		out1.car.grade ='A';
		out1.car.speed = 200;
		out1.car.price = 12.456;
		System.out.println(out1.car.toString());
		System.out.println();
		//2.inner 생성.
		//Inner in1 = new Inner(); //=> 불가
		//Inner in1 = new OuterClass(); //=> 불가
		System.out.println("inner 생성해보기 ");
		OuterClass.Inner in1 = out1.new Inner();
		in1.country="대한민국";
		in1.printData(10);
		
	}
}
