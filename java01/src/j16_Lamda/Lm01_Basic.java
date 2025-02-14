package j16_Lamda;
//** Lamda 식 표현 (자바8 부터 추가)
//=> 인터페이스가 하나의 추상메서드만 가지고 있는 경우
// 이를 함수형 인터페이스(Functional Interface) 라 하며
// 이러한 함수형 인터페이스를 구현하는 경우
// 짧은 코드로 완성할수 있도록 지원하는것이 람다식.

//** @FunctionalInterface (예제 Lm02_~~, Lm03_~~ 참고 )
//=> 함수형 인터페이스임을 확인하는 애너테이션
//=> 그러므로 위의 애너테이션이 붙은 인터페이스에 둘이상의 추상메서드가 존재하면 컴파일오류
//=> 그러나 구현부가 있는 static, default 선언이 붙은 메서드는 무관함.
//=> 미리 정의된 표준 함수형 인터페이스 (java.util.function 패키지)
// Predicate<T>, Supplier<T>, Consumer<T>, Function<T,R>
// 이들은 다양하게 활용할수있도록 각각 추상메서드를 정의해놓고 있으므로
// 필요에 따라 이용.

interface Printable{
	void myTest(String s);
}//interface

class Printer implements Printable{
	@Override
	public void myTest(String s) {
		System.out.println("🐇. 일반적인 interface 구현 사용 / 매개변수 s = "+s);
	}
}//class


public class Lm01_Basic {

	public static void main(String[] args) {
		Printable p1 = new Printer();
		p1.myTest("🐻 hello Lamda 🐻");
		
		Printable p2 = new Printable() {
			@Override
			public void myTest(String s) {
				System.out.println("🐷. 익명 클래스 사용 / 매개변수 s = "+s);
			}
		};
		p2.myTest("🐼 Annonymous 🐼");
		
		/*
		 * Printable p3 = (String s)->{
		 * System.out.println("🐵. 람다식 표현 사용 / 매개변수 s = "+s); };
		 * p3.myTest("🐶 신기한 람다 마법 🐶");
		 */
		
		Printable p3 = s->{
			System.out.println("🐵. 람다식 표현 사용 / 매개변수 s = "+s);
		};
		p3.myTest("🐶 신기한 람다 마법 🐶");
		
		Printable p4 = System.out::println;
		p4.myTest("🐶메서드 참조 람다식 🐶");

	}//main
}//class
