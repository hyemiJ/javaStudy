package j08_abstractInterFace;



//** 추상 클래스 
//=> 추상메서드가 하나라도 정의되면 그 클래스는 반드시 추상클래스로 정의 해야 함 
//=> 직접 인스턴스를 생성하지 못함. ( new 사용불가 )
// 그러나 참조형 변수(인스턴스)의 타입으로 선언은 가능하다.
// 그리고 후손으로 인스턴스를 생성할 수 있음. 
// 그러므로 후손은 반드시 추상메서드 오버라이딩의 의무를 가짐
//
//** 추상 메서드
//=> Body 부분이 없고 Header 만 선언
//=> 앞쪽에 abstract, 매개변수 뒤에 ; 붙여야됨.
//=> Body 부분은 Child 클래스에서 반드시 재정의(오버라이딩) 해야 함.
//( 실행문이 없어도 공백으로 작성해야함 -> { } )
//=> 추상 메서드 목적 : 후손에게 오버라이딩 의 강제성을 부여 (메서드명의 통일성)

//하나라도 추상 메서드가 포함된다면 클래스 또한  추상 클래스로 ,abstract 명시,
abstract class Animal{ 
	
	String kind;
	
	//일반 메서드가 와도 됨.
	void breath() {
		System.out.println(kind + "는(은) 숨을 쉽니다. , class ) Animal");
	}
	
	//추상 메서드 : 헤더명시 + 세미클론 표기 + abstract 명시
	abstract void sound();
	
	Animal(){
		System.out.println("Animal의 기본 생성자 , class ) Animal ");
	}
}

class Cat extends Animal{
	
	Cat(){
		kind = "고양이";
		//super.kind="고양이"; //위와 동일
	}
	
	@Override
	void sound() {
		System.out.println("야옹 야옹 , class ) Cat -Animal(Animal 의 추상메서드) ");
		
	}
	
	void eyeColor() {
		System.out.println("고양이 눈은 반짝 반짝 ! , class ) Cat -Animal");
	}
	
}

class Dog extends Animal{

	Dog(){
		kind = "강아지";
		//super.kind="강아지"; //위와 동일
	}
	
	@Override
	void sound() {
		System.out.println("몽몽 몽몽  , class ) Dog -Animal (Animal 의 추상메서드)");
	}
	
	void speed() {
		System.out.println("우리집 강아지는 초수피드 !  , class ) Dog -Animal");
	}
}

class Eagle{
	
	void breath() {
		System.out.println( "독수리는 숨을 쉽니다. , class ) Eagle");
	}
	void sound() {
		System.out.println("수리 수리  , class ) Eagle");
	}
	void flying() {
		System.out.println("독수리는 훨훨 날아요  , class ) Eagle");
	}
}


public class Ex01_AbstractAnimal {
	public static void main(String[] args) {
		//추상 클래스는 타입으로 이용할 수 있지만 , 직접 생성은 불가하다.
		//Animal animal = new Animal(); //  컴파일 오류  : Cannot instantiate the type Animal
		
		Animal cat1 = new Cat();
		cat1.sound();
		cat1.breath();
		System.out.println();
		Animal dog1 = new Dog();
		dog1.sound();
		dog1.breath();
		System.out.println();
		//dog1 = new Cat();
		
		System.out.println("순수 cat 인스턴스");
		Cat cat2 = new Cat();
		cat2.sound();
		cat2.breath();
		cat2.eyeColor();
		
		//독수리를 animal 에 ? 컴파일 오류
		//Animal eagle = new Eagle(); //Type mismatch: cannot convert from Eagle to Animal
		
//         ** 결론
//         => Animal Type, Cat Type 모두 생성가능하지만,
//            접근 가능한 맴버의 범위는 Type 에 정의된 범위로 제한됨
//            즉, Cat 에만 정의된 메서드는 Animal Type 에서는 접근할 수 없음
//         => 그러나 실행은 Cat 의 메서드가 실행됨.
//           ( Animal 에는 header 부분만 있기 때문에 실행이 불가능함 )
//        
//         => 장점
//            -> Animal Type 으로 선언하게되면 우측을 Cat, Dog 만 변경하면
//             클래스교체를 쉽게 할 수 있음
//            -> 같은 조상을 상속하는 후손들은 조상의 타입으로 정의하면 클래스교체가 편리하다
		
		System.out.println();
		Eagle eagle1 = new Eagle();
		eagle1.flying();
		eagle1.breath();
		eagle1.sound();
			
		System.out.println();
		//다형성 확인 : 매개변수로 확인
		System.out.println("다형성의 확인");
		animalUse(cat1);
		animalUse(cat2); //후손도 인자의 animal 타입에 적용 가능. // Animal animal = new Cat();
		animalUse(dog1);
		animalUse(new Dog());
		
		System.out.println();
		System.out.println("배열로 다형성의 확인");
		Animal []animals = {cat1, cat2 , dog1 , new Dog()};
		animalUse(animals);
		
		System.out.println();
		System.out.println("매개변수로 object 타입으로 선언 및 사용");
		
		animalUse((Object)dog1);
		animalUse(eagle1); // 모든 클래스는 object 의 후손이기 때문에 eagle 클래스도 사용가능.
		
		//연산자 instanceof
		//인스턴스 확인 연산자
		if (cat1 instanceof Animal) {
			System.out.println("cat1 은 Animal 의 인스턴스 이다.");
		}
//		else if (eagle1 instanceof Animal) {
//			System.out.println(" eagle1 은 Animal의 인스턴스 이다. "); // 컴파일 오류 :Incompatible conditional operand types Eagle and Animal
//		}
        // 4) 연산자 instanceof
        // => 인스턴스 확인 연산자 
//         => Animal 처럼 추상클래스 또는 클래스 Type 을 확인하는 경우에는
//            컴파일 오류 발생 instanceof 연산자의 필요성이 없지만,
//            interface 의 경우에는 런타임시에 오류 발생 하므로 instanceof 연산자를 이용한 확인이 필요함 
		else {
			System.out.println("cat 1은 Animal 의 인스턴스가 아닙니다.");
		}
		
	}
	
	public static void animalUse(Animal animal) {
		animal.breath();
		animal.sound();
	}
	public static void animalUse(Object obj) {
		System.out.println("animalUse(Object obj) : "+obj);
		System.out.println("obj.hashCode() : "+obj.hashCode());
	}
	public static void animalUse(Animal[] animals) {
		for (Animal animal : animals) {
			animal.breath();
			animal.sound();
		}
	}
}
