package j08_abstractInterFace;
//** interface 4.
//=> 상수, 추상메서드
//=> static, default 메서드 (구현부가 있는 메서드, Java8 부터 추가됨)

//** static, default
//=> 반드시 바디를 구현 해야함
//=> 구현클래스의 오버라이딩 의무 없음


interface NewInter{//===========================================================interface NewInter
	
	//추상 메서드 : 반드시 헤더만 있고 , 세미콜론이 명시.
	void test();
	
	//static 메서드 : 반드시 헤더와 바디를 구현 해야함 . 
	static void staticTest() {
		System.out.println("interface NewInter 의 static void staticTest 메서드 ");
	}
	
	//default 메서드 : 인터페이스에만 있는 명시적인 메서드.(추상메서드와 구분하기 위해 필히 명시.)
	//오버라이딩의 의무가 없음. 필요시에 사용 오버라이딩.
	default void defaultTest() {
		System.out.println("interface NewInter 의 default void defaultTest 메서드 ");
	}
}

class NewClass implements NewInter{//======================= class NewClass implements NewInter

	@Override // NewInter 추상 메서드로 의무 메서드
	public void test() {
		System.out.println("class NewClass implements NewInter의 test 메서드 ");
	}
	//static 메서드는 클래스 종속임으로 , 오버라이딩과는 무관.
	//동명의 static 메서드는 허용
	
	static void staticTest() {
		System.out.println("class NewClass implements NewInter 의 static void staticTest 메서드 ");
	}
	//조상이 클래스인 경우 , 동명의 static 메서드와 동명인 경우 오류발생.
	//하지만 여기서는 조상이 interface임으로 상관이 없다. 허용됨.
	
	
	//defaultTest 메서드는 오버라이딩의무는 없으나 필요시에 허용됨.
	//단 , default 의 키워드 사용 불가.
	//접근범위는 조상보다 최소한 같거나 넓어야함.
	//참고로 조상(interface)의 경우에는 접근범위가 명시되어있지 않다면 , public 이다.
	//주의할 점은 접근제어자 default 는 접근 제어자를 정의하지 않았을때의 기본값을 의미하는 것 뿐이다.
	@Override
		public void defaultTest() {
			//NewInter.super.defaultTest();
		System.out.println("class NewClass implements NewInter 의 default void defaultTest 메서드(@Override) ");
		}
	void defaultTest(int i) {
	System.out.println("public void defaultTest 와void defaultTest(int i) 의 오버로딩 ");
	System.out.println("int i * i = "+( i * i));
	}
	
}



public class Ex05_staticDefaultMethod {
	public static void main(String[] args) {
		//클래스 생성
		System.out.println("nc1 ) 타입 : NewClass , 인스턴스 : NewClass");
		NewClass nc1 = new NewClass();
		nc1.defaultTest();
		nc1.defaultTest(10);
		nc1.test();
		NewClass.staticTest();
		
		System.out.println();//==========================================
		
		System.out.println("nc2 ) 타입 : NewInter , 인스턴스 : NewClass");
		NewInter nc2 = new NewClass();
		nc2.defaultTest();
		nc2.test();
		NewInter.staticTest();
		//nc2 = nc1; // 자동 형변환
		//nc1 =(NewClass)nc2; //인스턴스가 같음으로 강제 형변환 가능.
		
	}
}
