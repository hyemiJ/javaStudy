package j07_classExtends;

import j05_classMethod.Car;
import j06_packageTest.Ex03_studentTest;

// 클래스와 클래스 간의 관계
//1 ) 포함 (집합 , has-a)
//2 ) 사용 (use)
//3 ) 상속 (is-a)
public class Ex01_ClassToClass {
	
	static Car car = new Car();
	static void myCar(Car car) {
		car.hpowerUp();
		System.out.println("use관계 테스트(car.speed) : " + car.speed);
	}
	public static void main(String[] args) {
		//출력확인.
		System.out.println("메인 메서드 테스트 car : "+car);
		//메서드 확인.
		myCar(car);
		//참조형 Ex03_studentTest 의 car를 참조받기.
		Ex03_studentTest.car.hpowerUp();
		System.out.println("참조형의 car"+ Ex03_studentTest.car);
		
		//상속 확인
		
	}

}
