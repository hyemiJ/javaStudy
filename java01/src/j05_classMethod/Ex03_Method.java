package j05_classMethod;

//** 맴버메서드(Method)
//=> 함수(Function), 프로시져(Procedure)
//
//1) 정의 , 실행
//
//2) return 값
//=> return 이 있으면 Type 을 지정, 없으면 무조건 void  
//=> 메서드 실행결과 return Type에 해당하는 결과값을 제공
//=> return 명령어를 void 메서드 에서 사용하면 메서드 종료
//
//3) 매개변수
//=> 매개변수(Argument, 인자), Parameter
//=> 메서드의 지역변수이며, 모든타입 정의 가능
//=> 매개변수의 값 전달방법
//CallByValue (기본자료형, String -> 매개변수의 값 전달)
//CallByReference (참조자료형: 배열, 인스턴스 -> 주소전달)   
//
//** 기본자료형 : Primitive Data Type (int, double, boolean....)
//** 참조자료형 : Reference Data Type (String, 배열 등 클래스타입) 


//     1. 메서드 종류별 4종 정의 & 호출
//     2. return Test 
//        => return 값 활용 (main 에서 Test)
//        => void 메서드 에서 사용 : 메서드 종료 
//     3. 매개변수 전달방법
//          => CallByValue (기본자료형, String -> 매개변수의 값 전달됨) 
//           => CallByReference (참조자료형, 주소값을 전달 -> 배열, 인스턴스)
public class Ex03_Method {
	
	int price = 5000; //맴버 변수, 클래스의 전역(Global)변수
//	메서드 명 : 식별자의 규칙을 준수. - 사용자 정의 네이밍
//	소문자 시작 , 예약어 제외 
//	동일한 이름의 메서드명 허용(단 , 동일한 이름의 메서드들이 매개변수나 타입이 달라야 함.) 
	
	//1) 매개변수 X void O return X
	public void juiceCafe1() { // 메서드의 header
		System.out.println("무슨 주스를 원하시나요 ?"); // 메서드의 body
		System.out.println("메서드 구성 : 매개변수 X void O"); // 메서드의 body
		System.out.println();
	}
	public void juiceCafe1(String s) { 
		System.out.println("매개변수 테스트"); 
		s = "망고수박"; //값은 전달해준 kind 에는 영향을 주지 않는다. kind 의 리터럴만 전달했기 때문(CallByValue)
		System.out.printf("무슨 주스를 원하시나요 ? %s %n", s);
		System.out.println();
	}
	
	//2) 매개변수 O void O return O
	public void juiceCafe2(String s , int n) { // nonstatic 임으로 인스턴스메서드라고 보면 된다.-> 인스턴스가 있어야지만 접근 할 수 있음. 
		if (n<5) {
			System.out.println("다섯잔 이상 주문 해주세요"); return;
		}
		System.out.printf("주문 내역 안내 : %s 쥬스 %d 잔%n", s , n);
		System.out.println("메서드 구성 : 매개변수 O void O"); 
		System.out.println();
	}
	//3) 매개변수 X void X
	public String juiceCafe3() {
		return"주스 한잔의 가격은 "+price+"원 입니다.";
	}
	//4) 매개변수 O void X
	public int juiceCafe4(String s, int n) {
		System.out.println();
		System.out.printf("%s 쥬스 %d 잔, 총액은 ? %n",s , n);
		System.out.println("메서드 구성 : 매개변수 O void X"); // 1)출력하고 나서 
		return n * price;
	}
	public int juiceCafe4( int n) {
		System.out.println("메서드 명 중복 테스트"); // 1)출력하고 나서 
		return n * price;
	}
	
	public int carTast(Car car, int speed) {
		System.out.println("carTest 메서드**************");
		System.out.println("car->"+ car);
		car.brand ="BMW";
		car.grade='D';
		System.out.println("car (brand / grade 변경 후 )->"+ car);
		System.out.println("carTest 메서드**************");
		return car.speed + price ;
	}
	
	public static void main(int i) {
		System.out.println("오버로딩 테스트");
	}
	
	public static void main(String[] args) { //static 임으로 ,
		//메서드 호출
		Ex03_Method ex03 = new Ex03_Method();
		// 위의 메서드들이 nonstatic 임으로 인스턴스메서드라고 보면 된다.-> 인스턴스가 있어야지만 접근 할 수 있음. -> 인스턴스 생성.
		//같은 클래스 내라고 하더라도 , static 메서드에서 nonstatic 메서드를 사용하기 위해서는 인스턴스 생성이 필요함.
		ex03.juiceCafe1();
		ex03.juiceCafe2("수박", 15);
		ex03.juiceCafe2("오렌지", 2);
		//ex03.juiceCafe2(2 ,"오렌지"); // 컴파일 오류 The method juiceCafe2(String, int) in the type Ex03_Method is not applicable for the arguments (int, String)
		System.out.println(ex03.juiceCafe3());
		System.out.println("메서드 구성 : 매개변수 X void X");
		System.out.println("총액 : "+ex03.juiceCafe4("오렌지", 15)); // 2) 실행
		
		System.out.println();
		System.out.println("메서드 중복 테스트 중 : 메서드 오버 로딩");
		ex03.juiceCafe1();
		ex03.juiceCafe1("오렌지");
		System.out.println(ex03.juiceCafe4(4));
		ex03.juiceCafe4("오렌지", 6);
		System.out.println();
		//매개변수의 전달 확인
		//1.기본자료형, String
		String kind = "바나나";
		ex03.juiceCafe1(kind); 
		System.out.println(kind);
		//2.참조자료형
		System.out.println();
		Car myCar = new Car(); 
		myCar.brand ="기아";
		myCar.grade='K';
		System.out.println("main에서 수정한 mycar 1"+myCar);
		System.out.println("ex03.carTast(myCar, 10 호출");
		System.out.println(ex03.carTast(myCar, 10)); // 메서드 호출
		System.out.println("ex03.carTast(myCar, 10); 호출후  mycar 2"+myCar);
		System.out.println(ex03.carTast(new Car(), 10)); 
	}
}
