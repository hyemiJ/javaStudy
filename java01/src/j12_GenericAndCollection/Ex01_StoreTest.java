package j12_GenericAndCollection;

import j05_classMethod.Car;

//------------------------------------------------------------
//** Generic
//=> 컬렉션(Collection:자료구조) 을 보강해준 기능
//=> 컴파일 단계에서 객체의 자료형을 선언(정의) 해주면
//	 다른 타입의 자료가 저장될수 없도록 해주는 기능

//** Generic 클래스 정의
//=> 클래스 이름 옆에 <> 사이에 알파벳 1글자를 사용하여 
//	 Generic Type 명을 선언해줌 
//	 ex : <T> 처럼 "<" 와 ">" 사이에 선언 
//=> 대문자로 T, E 등을 많이 사용 
//	 Type 의미로 "T" 를 주로 사용
//=> Generic 타입으로 클래스를 사용한다는 의미 
//=> 제네릭으로 기본 자료형(int, float, double....)은 사용할 수 없지만
//	 기본자료형의 wrapper 클래스를 이용할 수있다. 

//** Generic 타입제한 (사용시, Wildcards_와일드카드타입 이용으로)
//=> <?>
//	 Unbounded Wildcards (제한없음_모든 클래스나 인터페이스 타입 가능)
//=> <? extends 클래스명>
//	 Upper Bounded Wildcards (상위클래스 제한_같거나 하위 타입 가능)
//=> <? super 클래스명>
//	 Lower Bounded Wildcards (하위클래스 제한_ 같거나 상위타입 가능)

//=> 정의할때: <T> , <T extends 클래스명> , <T super 클래스명>
//------------------------------------------------------------

//1. Object 이용한 기존방식
//=> 모든 클래스는 Object 의 후손이므로
//	 아래처럼 Object Type 으로 우측에 정의될 수 있음.
//	 즉, 모든 클래스는 setData 의 매개변수가 될 수 있다. 
//	 Object data = new String("Generic_Test");
//=> 이러한 Object 의 특성을 이용해서 다목적용 클래스를 만들수 있지만,
//	 클래스타입으로 인하여 발생가능한 런타임오류를 컴파일타임에서는 알수없는 단점이 있음. 
class Store {
	private Object data;
	public Object getData() { return data; }
	public void setData(Object data) { this.data=data; }
} //Store

//2. Generic 방식
//=> 다양한 클래스에 적용할 수 있는 다목적용 기능을 만들기 위해 
//	 클래스 맴버변수의 타입을 T(임의의 알파벳) 로 표현 해놓고
//	 실행코드에서 결정해서 사용 프로그래밍 기법 
//=> 결정된 타입 이외에는 사용불가 ( Exception 발생 )
class StoreG<T> {
	private T data;
	public T getData() { return data; }
	public void setData(T data) { this.data=data; }
} //StoreG

public class Ex01_StoreTest {

	public static void main(String[] args) {
		//1. Object 이용한 기존방식
		// => 다양한 클래스에 적용할 수 있는 다목적용 기능을 만들기 위해
		//    모든 클래스의 조상인 Object Type 으로하면 가능은 하지만,
		//    형변환이 불가능한 경우 사용시에도 컴파일 오류가 없음
		//   (런타임 오류_java.lang.ClassCastException 발생)
		//    이러한 상황을 방지하기위한 프로그래밍 기법이 Generic 프로그래밍 
		Store s1 = new Store();
		s1.setData("짜장면");
		s1.setData(123); //자동형변환 int 123 -> Integer 123
		System.out.println("**1. Object1_1 => "+((Integer)s1.getData()+200));
		
		s1.setData(123.456); //자동형변환 double -> Double
		s1.setData(new Car(10, 20, "현대", 'A', "Silver"));
		System.out.println("**1. Object2 => "+s1.getData());
		
		//System.out.println("**1. Object1_2 => "+((Integer)s1.getData()+200));
		// => 원하지 않는 객체가 들어가더라도 컴파일오류 없음	
		//    런타임 오류 발생 java.lang.ClassCastException
		
		//2. Generic 방식
		//2.1) Generic Type 생략
		// => 생성은 되지만 Generic 이 적용안됨 (위 1. Object 처럼 동작)
		StoreG g1 = new StoreG();
		g1.setData("Generic Test");
		g1.setData(12345);
		g1.setData(new Car());
		
		//2.2) Integer 로 사용
		// => 생성시 Type 결정
		StoreG<Integer> g2 = new StoreG<Integer>();
		g2.setData(12345); // OK
		//g2.setData(123.456); // 컴파일오류
		//g2.setData(new Car()); // 컴파일오류 
		System.out.println("**2. Generic => "+(g2.getData()+200));
		
		//2.3) Car Type 
		StoreG<Car> g3 = new StoreG<Car>();
		g3.setData(new Car());	
		//g3.setData("짬뽕"); //컴파일오류
		
		// 3) 기본자료형은 사용불가 (Wrapper Class 로 가능)
		//StoreG<int> g4 = new StoreG<int>(); XXXXX
		
	} //main

} //class
