package j08_abstractInterFace;


//** interface 1.
//=> 상수, 추상메서드
//=> static, default 메서드 (구현부가 있는 메서드, Java8 부터 추가됨)
interface Animali{
	
	//상수 : public static final 생략가능.
	final static int LEGS = 4;
	//int LEGS = 4;와 같다.
	
	//추상 메서드 : public abstract 생략가능.
	void breath ();
	void sound ();
	default void crying() {
		System.out.println("default 메서드는 default를 명시 . interface ) Animali");
	}
//	void Animali{
//		System.out.println("생성자 ?");
//	} //클래스가 아니기 때문에 생성자를 사용 할 수 없다.
} // 상수와 추상 메서드만 올 수 있기 때문에 생략가능하다.

class Cati implements Animali{

	@Override
	public void breath() {
		System.out.println("고양이는 숨을 쉽니다 ! , class ) Cati -Animali(Animali 의 추상메서드) ");
		
	}

	@Override
	public void sound() {
		System.out.println("야옹 야옹 , class ) Cati -Animali(Animali 의 추상메서드) ");
		
	}
	Cati() {
		System.out.println("고양이 생성자");
	}
	
	void here() {
		System.out.println("여기는 클래스 임으로 , 일반 메서드 사용 가능. class ) Cati");
	}
}

class Dogi implements Animali{
	@Override
	public void breath() {
		System.out.println("강아지는 숨을 쉽니다 ! , class ) Dogi -Animali(Animali 의 추상메서드) ");
		
	}
	@Override
	public void sound() {
		System.out.println("몽몽 몽몽 , class ) Dogi -Animali(Animali 의 추상메서드) ");
		
	}
	public Dogi() {
		System.out.println("강아지 생성자");
	}
	
	void speed(){
		System.out.println("여기는 클래스 임으로 , 일반 메서드 사용 가능. class ) Dogi");
	}
}


public class Ex02_interAnimal {
	public static void main(String[] args) {
        // 1) 생성
        // => 직접생성은 불가능
        // => 인스턴스의 Type 으로는 정의가능, 구현클래스를 통해 생성됨
        // => 그러나 사용범위는 interface 에 정의된 만큼만
		Animali ani = new Cati();
		
		ani.breath();
		ani.sound();
		System.out.println(Animali.LEGS);
		System.out.println();
		Cati cati = new Cati();
		cati.crying(); //default 메서드로 정의되어 있기 때문에, Cati 클래스에서 자동으로 상속.
		cati.breath();
		cati.here();
		System.out.println();
		
		Animali dogi1 = new Dogi();
		dogi1.breath();
		dogi1.crying();
		dogi1.sound();
		//dogi1.speed(); Dog 클래스의 개별적 메서드 접근 불가.
		System.out.println();
		Dogi dogi2 = new Dogi();
		dogi2.breath();
		dogi2.crying();
		dogi2.sound();
		dogi2.speed();
		
		//dogi1 = ani;
		//dogi2=cati; // Dogi = Cati서로 다른 타입임으로 대입 불가.
		//dogi2 = dogi1;  //Dogi = Animali 서로 다른 타입임으로 대입불가
		//dogi1 = dogi2; //Animali = Dogi
		//형변환이 가능한경우 -> 조상 type = 후손 type(변환 허용)
		//dogi2 = (Dogi)dogi1; //Dogi = Animali타입의 dogi 인스턴스 
		//형변환이 가능한 경우에 제한적으로 변환 허용 (형변환 가능 여부를 알려주는 연산자가 instanceof)
		//cati = (Cati)dogi1;
		//cati = (Cati)ani; //Cati = Animali(Cati인스턴스)
		//cati =(Cati)dogi1;//Cati = Animali(Dogi인스턴스) -> 런타임 오류 발생
		
		System.out.println();
		Eagle eagle = new Eagle();
		eagle.breath();
		eagle.flying();
		eagle.sound();
		System.out.println();
		//instance of 테스트
		if(ani instanceof Animali) {
			System.out.println("ani는 Animali 의 인스턴스인가 ? yes");
		} 
		//ani : Animali type /Cati instance
		
		if(dogi2 instanceof Animali) {
			System.out.println("dogi2 는 Animali의 인스턴스 인가 ? yes ");
		}else {
			System.out.println("dogi2 는 Animali의 인스턴스 인가 ? no ");
		}
		//dogi2 : Dogi type /Dogi instance
		
		if(eagle instanceof Animali) {
			System.out.println("eagle 는 Animali의 인스턴스 인가 ? yes ");
		}else {
			System.out.println("eagle 는 Animali의 인스턴스 인가 ? no ");
		}
		//eagle : Eagle type /Eagle instance
	}
}
