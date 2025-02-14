package j06_packageTest;

//import j05_classMethod.Car;
import j05_classMethod.Ex02_MyClassTest2;



//** Access Modifier (접근 한정자_제어자)
//=> private : 해당 클래스내부 에서만
//=> default : 같은 Package 내
//=> protected : package + 자손
//=> public : 프로젝트내의 모든 Class 접근 가능
//  (단, 다른 package 에서는 import 해야함)

public class Ex01_accessTest {

	public static void main(String[] args) {
		//1 ) public 클래스에 접근
		//Car.java 이용
		
		//Car car = new Car();
		//car.brand = "테스트";
		//car.color = "blue"; 디폴트 멤버 변수는 접근 불가.
		//클래스 수준에서는 허용하더라도 멤버 수준에서 허용되지 않으면 접근 불가하다.
        // 2) default 클래스 접근
        // => 같은 Package 내에서만 접근 가능
        // => Ex04_Factorial 을 default 로 변경 후 Test
        // 2.1) default 클래스, default 맴버
        //Ex04_Factorial ex04 = new Ex04_Factorial();  
		//인스턴스 생성이 불가능 함으로 , 접근 불가.
        
		// 2.2) default 클래스, public 맴버 
		// -> 인스턴스 생성이 불가능 함으로 , 접근 불가.
         
		//2.3 )default 클래스, static 맴버 
		//Ex04_Factorial.factorial02(2);
		// -> 클래스 접근이 불가함으로 , 접근이 불가
       
		//3 ) 참조형 변수 접근해보기
		//Ex02_MyClassTest2.myCar; 
		//생성만 되고 , 인스턴스가 없는 변수.
		//Ex02_MyClassTest2.myCar = new Car(); 
		System.out.println(Ex02_MyClassTest2.myCar);
		System.out.println(Ex02_MyClassTest2.newCar); 
		Ex02_MyClassTest2.newCar.hpowerUp();
		System.out.println(Ex02_MyClassTest2.newCar); 
		
		
		//상수 : 고정값. -> static final 로 정의한다.
		//static final double PI = 3.141592;
	}

}
