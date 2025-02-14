package j09_InnerClass;
//** 익명클래스 (Anonymous 클래스)
//=> 이름이 없는 클래스이며, 한번만 사용하고 버려지는 객체를
//    사용 할 때 유용하게 쓰이는 내부클래스로서,
//   다른 클래스를 상속받는 경우 또는 인터페이스를 구현하는 경우 이용됨  


// => 인터페이스의 구현 클래스를 필요한 위치에서 직접 작성
// => 인터페이스는 직접 생성(new) 될수 없고 implements 하는 클래스를 통해 생성후 사용되어짐.
// => 단, 익명 클래스는 새로운 클래스명으로 작성하는것이 아니고, 인터페이스명(또는 조상클래스명) 으로 생성함. 
//      인터페이스의 구현 클래스를 new 다음에 직접 작성함
// => 그러므로 익명 클래스는 클래스를 상속받거나, 인터페이스를 구현하는 형태만 가능하며,
//    강제성을 부여한 일회성 코드에 주로 이용됨 (예, 이벤트 핸들러 또는 이벤트 리스너 구현)  
// => Anonymous 클래스에서는 인터페이스이름으로 new 하고 { ... }; 블럭에서 구현
//    마지막에는 반드시 ;
// => 내부적으로 Flyer 를 구현한 익명의 클래스가 생성되며 이를 Anonymous 클래스 라함.    
//
//Flyer f2 = class { ~~~ }; 
//Flyer f2 = new class { ~~~ }; -> 이러한 개념을 문법적으로는 아래처럼 정의 
//Flyer f2 = new Flyer(); -> 인터페이스로는 생성불가능, 문법적으로 오류, 인터페이스의 생성자는 허용안됨
//Flyer f2 = new Flyer() { ~~~ }; -> 익명 클래스 정의 (허용됨)

interface Flyer{//===============================================================================================Flyer interface
	void fly();
}
//1. 일반적인 인터페이스 구현 클래스를 작성해 놓고 필요시 생성하여 사용

class FlyerImpl implements Flyer{//=============================================================================FlyerImpl class ( implements: Flyer)
	@Override
	public void fly() { System.out.println("인터페이스 구현 클래스의 일반적인 방법");}
}






public class Ex03_AnnonymousFly {//============================================================================main method
	public static void main(String[] args) {
		System.out.println("인터페이스 일반구현 메인");
		Flyer f1 = new FlyerImpl();
		f1.fly();
		System.out.println();
		System.out.println("익명 클래스 구현 메인");
		Flyer f2 = new Flyer() {
			@Override
			public void fly() { System.out.println("인터페이스를 통한 익명 클래스 구현 방법");}
			void test() { System.out.println("멤머 추가 오류는 없어요");}
		};
		f2.fly();
		
		System.out.println();
		System.out.println("object 를 상속받는 익명 클래스 생성 테스트");
		Object obj = new Object() {
			@Override
			public String toString() {
				return "object 를 상속받는 익명 클래스의 @Override ,  toString";
			}
		};
		System.out.println(obj);
	}
}
