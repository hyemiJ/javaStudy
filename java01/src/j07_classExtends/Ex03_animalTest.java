package j07_classExtends;

//** Java 의 상속의 특징
//=> 계층적으로는 다중 상속이 가능하고 제한이 없음.
//=> 그러나 다중 상속은 안된다 ( 부모는 무조건 1개의 클래스만 허용 )
//   class WildAnimal extends Mammal , Reptile {  -> ERROR

//** 메서드 오버라이딩 , 상속관계에서만 일어나는 현상.
//=> 조상의 메서드와 매개변수, 리턴값, 이름 모두 동일한 메서드
//  ( 매개변수가 다르다면 메서드 오버로딩에 해당됨.) 
//   현재 클래스에 구현된 메서드가 호출됨
//   이름은 동일하지만 후손클래스 별로 다양한 기능을 구현할 수 있음. 

//** static , final
//=> 맴버변수, 맴버메서드 , 클래스(final)
//=> final
//      - class : 종단클래스 (상속불가)
//      - method : 재정의(Override) 금지
//      - 필드(변수) : 상수
//=> static 메서드
//      - 상속(오버라이딩) 안됨
//      - 클래스(종속) 메서드로써 필요시 각자 정의해서 사용하는것은 가능함.
//        ( 단, 동일한 이름의 메서드를 후손이 non_static 으로 정의하는것은 불가능 )    
//      - super , this 는 non_static (인스턴스 메서드) 에서만 사용가능
//        ( super , this 인 인스턴스를 의미하기 때문 )
//      - static 변수는 클래스명으로 접근 

//** Animal
//=> Mammal ( String cry, crying )  , 
//   Reptile ( swimming ) 
//=> WildAnimal ( allPrint ) , PetAnimal ( infoPrint() )

class Animal {
	String name;
	static int numberOfLegs = 1;
	boolean breathExercise;
	String birth;
	
	public Animal(){
		System.out.println("Animal,동물의 기본 생성자");
	}
	
	void crying() { // 같은 이름의 인스턴스 메서드
		System.out.printf("다형성을 테스트하기 위한 같은 이름의 인스턴스 메서드 (위치 : Animal)%s 은(는) 소리를 냅니다 %n.",name );
	}
	
	public Animal(String name , int numberOfLegs, boolean breathExercise,String birth){
		this.name=name;
		this.numberOfLegs=numberOfLegs;
		this.breathExercise=breathExercise;
		this.birth=birth;
		System.out.println("Animal의 모든 값 초기화 생성자");
	}
	
	public void hurtOnesLeg() {
		System.out.printf("%s 은(는) 한쪽 다리를 다쳤다 %n", name);
		numberOfLegs--;
	}
	public void breath() {
		System.out.printf("%s 은(는) 호흡을 하고 , 다리는 %d 개 입니다 %n", name , numberOfLegs);
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", numberOfLegs=" + numberOfLegs + ", breathExercise=" + breathExercise
				+ ", birth=" + birth + "]";
	}
	
	
}

class Mammal extends Animal {
	int numberOfLegs = 2;
	String cry ;
	String kindOf;
	String house;
	
	void parentlegs() { //Mammal 에서 Animal 에 static 변수 접근 해보기.
		System.out.printf(" 전역 = %d , parent(Animal)_super.numberOfLegs = %d , parent(Animal)_Animal.numberOfLegs  = %d %n",
				 this.numberOfLegs , super.numberOfLegs , Animal.numberOfLegs); //상속의 경우라고 하더라도 static 이라면 static으로 접근하기. static 은 클래스 종속이다.
	}
	public Mammal() {
		System.out.println("Mammal,포유류의 기본 생성자");
	}
	public Mammal(String kindOf,String cry) {
		this.kindOf = kindOf;
		this.cry = cry;
		System.out.println("Mammal,포유류의 현재값 초기화 생성자");
	}
	public Mammal(String kindOf,String cry,String name , int numberOfLegs, boolean breathExercise,String birth) {
		super( name , numberOfLegs, breathExercise, birth);
		this.kindOf = kindOf;
		this.cry = cry;
		System.out.println("Mammal,포유류의 모든값 초기화 생성자");
	}
	@Override // 오버라이드 되면 명시해 줄것.
	void crying() { // 같은 이름의 메서드 (오버라이드)
		System.out.printf(" mammal crying %s 은(는) %s 소리를 냅니다 %n.",name , cry);
	}
	void whereHouse() {
		System.out.printf("%s 은(는) 집이 %s 입니다. %n", name , house);
	}
	
	@Override
	public String toString() {
		return "Mammal   [name="+ name + ", numberOfLegs=" + numberOfLegs +", cry ="+cry+ ", breathExercise=" + breathExercise
				+ ", birth=" + birth+"kindOf=" + kindOf + ", house=" + house + "]";
	}
	//static 메서드의 오버라이딩
	static void staticTest() {
		System.out.println("Mammal의 static 테스트 메서드.");
	}
//	void staticTest() {
//		System.out.println("Mammal의 static 테스트 메서드.");
//	} // static이 아니더라도 이름이 같으면 허용하지 않음.
	
}


class Wild extends Mammal{
	
	
	
	public Wild() {
		super.house = "동물원";
		System.out.println("Wild, 기본 생성자");
	}

	public Wild(String kindOf, String cry,String name, int numberOfLegs, boolean breathExercise, String birth) {
		super(kindOf,cry, name, numberOfLegs, breathExercise, birth);
		super.house = "동물원";
		// TODO Auto-generated constructor stub
		System.out.println("Wild,야생 모든 값 생성자");
	}



	@Override
	public String toString() {
		return "Wild [cry=" + cry + ", kindOf=" + kindOf + ", house=" + house + ", name=" + name + ", numberOfLegs="
				+ numberOfLegs + ", breathExercise=" + breathExercise + ", birth=" + birth + "]";
	}
}

class Pet extends Mammal{
	
	int numberOfLegs =3;
	
	public Pet() {
		super.house = "집";
		System.out.println("Pet, 기본 생성자");
	}
	void checking() {
		System.out.printf("%s 은(는) 예방접종을 했습니다 .%n", name);
	}
	void legsPrint (int numberOfLegs) {
		System.out.printf("Local(지역) = %d  , 전역 = %d , parent(포유류) = %d , animal(할아버지) = %d %n",
				numberOfLegs , this.numberOfLegs , super.numberOfLegs , Animal.numberOfLegs);
	}
	@Override
	void crying() {
		super.crying();
		System.out.printf("펫 crying 펫인 %s 는 노래도 부릅니다 %n",name);
	}
	
	void printInfo() {
		breath(); //animal
		crying(); // pet //mammal에 있는것을 호출하려면 super.crying();
		whereHouse(); //mammal
	}
	
	
	public Pet(String kindOf, String cry, String name, int numberOfLegs, boolean breathExercise, String birth) {
		super(kindOf, cry, name, numberOfLegs, breathExercise, birth);
		super.house = "집";
		System.out.println("Pet,펫 모든 값 생성자");
	}

	public Pet(String kindOf, String cry) {
		super(kindOf, cry);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pet [cry=" + cry + ", kindOf=" + kindOf + ", house=" + house + ", name=" + name + ", numberOfLegs="
				+ numberOfLegs + ", breathExercise=" + breathExercise + ", birth=" + birth + "]";
	}
	
	static void staticTest() {
		System.out.println("pet의 staticTest 메서드");
		Mammal.staticTest();
	}
//    ** static 메서드 오버라이드 Test ------------------------------
//    => static 맴버들은 클래스 종속 이므로 상속의 개념보다 우선적용됨
//       그러므로 Override 적용안되고 각 클래스의 맴버 이다.
//       즉, 조상의 staticTest() 와는 무관한 PetAnimal.staticTest() 임
//       -> 이러한 특성을 "static 메서드 오버라이딩 불가" 라함.
//       => 그러므로 상속과는 무관하게 어디서든 클래스명으로 접근가능
//       ( 단, 그렇기 때문에 ststic 메서드에서는 this, super 사용금지 )   
	
//	 void staticTest() {
//			System.out.println("pet의 staticTest 메서드");
//		} //mammal에 같은 이름이 있기 때문에 허용되지 않음.
	
	
}


class Reptile extends Animal{
	String howToRun;
	
	public Reptile() {
		System.out.println("Reptile,파충류 기본 생성자");
	}
	
	public Reptile(String howToRun) {
		this.howToRun=howToRun;
	}
	
	public Reptile(String howToRun,String name , int numberOfLegs, boolean breathExercise,String birth) {
		super( name , numberOfLegs, breathExercise, birth);
		this.howToRun=howToRun;
		System.out.println("Reptile,파충류 모든 값 초기화 생성자");
	}
	
	void running () {
		System.out.printf("%s 의 움직이는 방법은 %s 입니다", name , howToRun);
	}
	
	@Override
	void crying() {
		// TODO Auto-generated method stub
		super.crying();
	}

	@Override
	public String toString() {
		return "Reptile [howToRun=" + howToRun + ", name=" + name + ", numberOfLegs=" + numberOfLegs
				+ ", breathExercise=" + breathExercise + ", birth=" + birth + "]";
	}
}

public class Ex03_animalTest {

	public static void main(String[] args) {
		Animal animal1 = new Animal();
		Animal animal2 = new Animal("김밥", 4 ,true , "오이");//모든 값 초기화//String name , int numberOfLegs, boolean breathExercise,String birth
		animal2.breath();
		System.out.println("animal1(기본)"+animal1);
		System.out.println("animal2(모든 값 초기화)"+animal2);
		animal2.hurtOnesLeg();
		System.out.println("animal2(모든 값 초기화)"+animal2);
		
		Mammal mammal1 = new Mammal();
		Mammal mammal2 = new Mammal("티라노","크앙","공룡",6,false,"알");
		//모든 값 초기화 : String kindOf,String cry,String name , int numberOfLegs, boolean breathExercise,String birth
		mammal2.crying();
		mammal2.breath();
		mammal2.hurtOnesLeg();
		System.out.println("mammal2(모든 값 초기화)"+mammal2);
		
		Pet pet1 = new Pet();
		System.out.println("pet1(모든 값 초기화)"+pet1);
		Pet pet2 = new Pet("고양이과", "야옹", "냥냥이", 7 , true , "새끼");
		pet2.checking();
		pet2.printInfo();
		System.out.println("pet2(모든 값 초기화)"+pet2);

		System.out.println("animal.numberOfLegs : "+Animal.numberOfLegs);
		System.out.println("pet2.numberOfLegs :" +pet2.numberOfLegs );
		//System.out.println("animal1.name :" +animal1.name );
		//System.out.println("pet2.name :" +pet2.name );
		
		//모든 값 초기화 : String kindOf, String cry, String name, int numberOfLegs, boolean breathExercise, String birth
		
		//super 의 테스트.
		pet2.legsPrint(10); // 결과 : Local(지역) = 10  , 전역 = 3 , parent(포유류) = 2 , animal(할아버지) = 7 
		//static 변수는 클래스의 종속이기 때문에 instance 의 입장으로 보면 큰일 남. 
		
		//static 메서드의 오버라이딩
		Mammal.staticTest();
		//pet2.staticTest();
		Pet.staticTest();
//	     ** static 메서드 오버라이드 Test ------------------------------
//	     => static 맴버들은 클래스 종속 이므로 상속의 개념보다 우선적용됨
//	        그러므로 Override 적용안되고 각 클래스의 맴버 이다.
//	        즉, 조상의 staticTest() 와는 무관한 PetAnimal.staticTest() 임
//	        -> 이러한 특성을 "static 메서드 오버라이딩 불가" 라함.
//	        => 그러므로 상속과는 무관하게 어디서든 클래스명으로 접근가능
//	        ( 단, 그렇기 때문에 ststic 메서드에서는 this, super 사용금지 )   
		
		
		
		
		//상속의 관계는 같은 타입이 될 수 있다 : 다형성
		//타입 변수 = 생성+ 기본생성자 ; 
		Animal a0 = new Animal();
		Animal a1 = new Pet();
		Animal a2 = new Mammal();
		Mammal m1 = new Pet();
		System.out.println();
		//a0.crying(); 
		//다형성을 테스트하기 위한 같은 이름의 인스턴스 메서드 (위치 : Animal)null 은(는) 소리를 냅니다 
		//a1.crying();
		// mammal crying null 은(는) null 소리를 냅니다 
		//.펫 crying 펫인 null 는 노래도 부릅니다 
		//a2.crying();
		//mammal crying null 은(는) null 소리를 냅니다 
		//m1.crying();
		// mammal crying null 은(는) null 소리를 냅니다 
		//.펫 crying 펫인 null 는 노래도 부릅니다 
		
		//클래스의 타입캐스팅 (강제 형변환)
		Mammal ma1 = new Mammal(); //순수 Mammal 타입
		//Mammal ma2 = new Animal();
		//=> a1과는 접근 범위가 다르다.
		ma1 = (Mammal)a2;
		//타입 캐스팅
		Pet pe1 = new Pet(); //순수 pet 타입
		System.out.println();
		System.out.println("형변환 테스트");
		Mammal lion = new Mammal("포유류","어흥","사자",4,true,"새끼");
		//모든 값 초기화 : String kindOf,String cry,String name , int numberOfLegs, boolean breathExercise,String birth
		lion.crying();
		System.out.println("Mammal lion"+lion.toString());
		Animal rabbit = new Mammal("포유류","깡총","토끼",2,true,"새끼");
		System.out.println("Animal rabbit : "+rabbit.toString());
		
		lion = (Mammal)rabbit;
		System.out.println("lion = (Mammal)rabbit : "+lion.toString());
		
		Animal petTypeAnimal = new Pet();
		lion = (Mammal)petTypeAnimal;
		System.out.println("lion = (Mammal)petTypeAnimal : "+lion.toString());
		
		Wild typeWild = new Wild();
		Pet typepet = new Pet();
		//typeWild =(Wild)typepet;
		//오류 : Cannot cast from Pet to Wild
		

		
	}

}
