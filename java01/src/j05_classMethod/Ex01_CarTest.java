package j05_classMethod;

public class Ex01_CarTest {

	public static void main(String[] args) {
		System.out.println("Ex01_CarTest.java 의 테스트 ");
		
		//객체 생성 (객체 생명주기: 생성 -> 사용 -> 소멸)
		//생성(new) : 객체화한다 = 인스턴스화한다 = 인스턴스를 생성 한다 
		Car myCar = new Car();
		System.out.println("Car의 toString 01 (멤버 변수의 초기값 확인)");
		System.out.println("-> "+myCar.toString());
		//객체 사용(myCar.toString())
		myCar.brand="현대";
		myCar.color="gold";
		myCar.speed =600;
		myCar.price=5.5;
		myCar.grade='A';
		System.out.println("Car의 출력");
		System.out.println("-> "+myCar);
		System.out.println("Car의 toString 02(멤버 변수의 초기화 후 확인)");
		System.out.println("-> "+myCar.toString());
		
		//객체의 소멸
//         ** 소멸: 메모리청소
//         => 더이상 사용되지않는 값들은 자동제거해줌
//         => Garbage Collector (쓰레기 수집기)
//         => 정해진 알고리즘에 의해 작동됨 ( 일정시간동안 또는 더이상 참조되지않는등등... )   
//         => 참조형 변수에 null 값을 주면 소멸 (더이상 참조되지않음)
		
		myCar = null;
		System.out.println("소멸의 Car의 출력");
		System.out.println("-> "+myCar);
		//System.out.println("-> "+myCar.toString()); 
		// 런타임 오류 : Exception in thread "main" java.lang.NullPointerException at j05_classMethod.Ex01_CarTest.main(Ex01_CarTest.java:34)
		//myCar.brand="ht";
		// 런타임 오류 : Exception in thread "main" java.lang.NullPointerException at j05_classMethod.Ex01_CarTest.main(Ex01_CarTest.java:36)
		
		//인스턴스 들의 생성
		Car fCar = new Car();
		fCar.brand="벤츠";
		fCar.color="black";
		fCar.speed =600;
		fCar.price=5.5;
		fCar.grade='A';
		Car mCar = new Car();
		mCar.brand="아우디";
		mCar.color="white";
		mCar.speed =400;
		mCar.price=4.5;
		mCar.grade='B';
		
		myCar = fCar; // fCar 의 주소값이 전달됨.
		System.out.println("fCar의 출력");
		System.out.println("-> "+fCar);
		System.out.println("mCar의 출력");
		System.out.println("-> "+mCar);
		System.out.println("myCar의 출력");
		System.out.println("-> "+myCar);
		
		//speed 값을 변경하는 메서드 사용
		fCar.hpowerDown();
		System.out.println("fCar.hpowerDown(); 후 fCar의 출력");
		System.out.println("-> "+fCar);
		System.out.println("fCar.hpowerDown(); 후 myCar의 출력");
		System.out.println("-> "+myCar);
		
		myCar.hpowerDown();
		System.out.println("myCar.hpowerDown(); 후 fCar의 출력");
		System.out.println("-> "+fCar);
		System.out.println("myCar.hpowerDown(); 후 myCar의 출력");
		System.out.println("-> "+myCar);
		System.out.println();
		
		//생성과 동시에 , 주소값 참조
		Car mCar5 = fCar;
		mCar5.hpowerDown();
		
		System.out.println("mCar.hpowerDown(); 후 fCar의 출력");
		System.out.println("-> "+fCar);
		System.out.println("mCar.hpowerDown(); 후 mCar의 출력");
		System.out.println("-> "+mCar5);
		System.out.println();
		
		//초기화에 속성값 대입.
		mCar5.speed = mCar.speed;
		System.out.println("mCar5.speed = mCar.speed; 후 mCar의 출력");
		System.out.println("-> "+mCar);
		System.out.println("mCar5.speed = mCar.speed; 후 mCar5의 출력");
		System.out.println("-> "+mCar5);
		
	}
}
