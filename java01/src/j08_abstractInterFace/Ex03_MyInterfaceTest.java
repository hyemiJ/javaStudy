package j08_abstractInterFace;

class Mychild01 implements Ex03_MyInterface, Animali{
	
	//기본 생성자.
	public Mychild01() {
		System.out.println(" 기본 생성자 class ) Mychild01  / interface ) MyInterface,Animali");
	}
	
	@Override //Ex03_MyInterface
	public int getNum() {
		return NUM;
	}
	
	@Override  //Ex03_MyInterface
	public String getName() {	
		return NAME;
	}
	
	@Override //Animali
	public void breath() {
		System.out.println(NAME +" 은(는) 숨을 쉽니다 ! , class ) Mychild01  / interface ) MyInterface,Animali ");
	}
	
	@Override //Animali
	public void sound() {
		System.out.println(NAME +" 은(는) 노래를  잘 부릅니다 , class ) Mychild01 / interface ) MyInterface,Animali ");
	}
}

class Mychild02 implements Ex03_MyInterface{
	
	String name = "홍길동";
	int num = 100;
	
	//기본 생성자
	public Mychild02() {
		System.out.println(" 기본 생성자 class ) Mychild02  / interface ) MyInterface");
	}
	
	@Override //Ex03_MyInterface
	public String getName() {
		return name;
	} // 클래스 내의 변수 리턴
	
	@Override //Ex03_MyInterface
	public int getNum() {
		return NUM * num;
	}// 클래스 내의 변수 * 인터페이스의 static 변수
}


public class Ex03_MyInterfaceTest {
	public static void main(String[] args) {
		System.out.println("Ex03_MyInterface ch1 = new Mychild01();");
		Ex03_MyInterface ch1 = new Mychild01();
		System.out.println("ch1.getNum() : "+ch1.getNum());
		System.out.println("ch1.getName() : "+ch1.getName());
		System.out.println();
		
		System.out.println("Animali cha =new Mychild01();");
		Animali cha =new Mychild01();
		cha.breath();
		cha.crying();
		cha.sound();
		System.out.println();
		System.out.println("Ex03_MyInterface ch2 = new Mychild02();");
		Ex03_MyInterface ch2 = new Mychild02();
		System.out.println("ch2.getNum() : "+ch2.getNum());
		System.out.println("ch2.getName() : "+ch2.getName());
		System.out.println();
		ch2 = ch1;
		System.out.println("ch2 = ch1;");
		System.out.println("ch2.getNum() : "+ch2.getNum());
		System.out.println("ch2.getName() : "+ch2.getName());
		
		Mychild01 mch1 = new Mychild01();
		Mychild02 mch2 = new Mychild02();
		//mch1 = mch2; //완전히 다른 타입임으로 컴파일 오류
		//cha = mch1; //Animali (Mychild01) = Mychild01(Mychild01);
		//mch1 =cha; // 타입 미스매치
		//mch1 = (Mychild01)cha; // 클래스 캐스팅이 가능
		
		
		
	}

}
