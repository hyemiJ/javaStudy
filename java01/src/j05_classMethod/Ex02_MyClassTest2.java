package j05_classMethod;
//** MyClass
//=> 맴버변수 3개, 메서드 2개 정의 
//=> MyClass 를 정의하고
// Ex02_MyClassTest 에서 인스턴스 2개 만들어 출력하기


//** 전역변수 와 지역변수 Test

//** API 라이브러리의 클래스명 비추
//class System {
////System.out~~~ 이 오류 뜨는것을 확인해본다.
//} 

class Boyfriend {
//** 맴버 변수
//=> 전역(Global) 변수
//  클래스내에 있는 모든 메서드에서 사용가능
//  다른 클래스에서도 접근 가능
public double height;
  public int money;
  public String face;

  public void moneyUp(int mymoney) { 
	  if (mymoney>10000) {
		  //String name= "홍길동"; // if 문 안에서만 접근 가능한 지역변수
		  System.out.println("범위 초과 오류, 입력 값 : "+mymoney); return;
	  }
  money+=mymoney;
  //System.out.println(name);//if 문 안에있는 지역변수라 인식 불가 컴파일 오류
  System.out.println("** moneyUp money ="+money);  // 전역변수 money를 의미 
  //int price ; 
  //System.out.println(price); // 초기화가 이루어 지지 않아 컴파일 오류
  
  int money = 4000;
  System.out.println("** 지역변수 money ="+money);  //지역변수 money 를 의미
  }
//   ** 지역(Local) 변수
//  => 메서드 내부에 정의된 변수, 인자(매개변수) 
//    {  } 내부에서만 적용가능
//     클래스 외부에서도 접근 불가능
//     전역변수와 동일한 이름의 지역변수를 정의하면 **지역변수** 우선 적용
//    ( 단, 지역변수의 선언위치에 따라 지역변수 선언 이후부터 지역변수 우선함 )
  public void moneyDown(int mymoney) {
  money-= mymoney; 
  System.out.println("** moneyDown money ="+money); 
  }

  public String toString() {
     return "[face= "+face+"  money= "+money+"  hieght= "+height+"]";
  }
} //class 

public class Ex02_MyClassTest2 {
	public static Car myCar; // 인스턴스 이름만 정의, 객체화(메모리할당)은 되지 않았음.
	public static Car newCar = new Car(); // Ex02_MyClassTest2 클래스의 전역 변수
	public static void main(String[] args) {
		System.out.println("** Boyfriend class Test **");
		Boyfriend myBoyfriend = new Boyfriend();
		myBoyfriend.face = "이도현";
		myBoyfriend.height = 183.6;
		myBoyfriend.money = 500000000;
		myBoyfriend.moneyUp(500000000);
		System.out.println("** myBoyfriend =>" + myBoyfriend);

		Boyfriend exBoyfriend = new Boyfriend();
		exBoyfriend.face = "손석구(이원우)";
		exBoyfriend.height = 185.5;
		exBoyfriend.money = 700000000;
		exBoyfriend.moneyDown(5000000);
		System.out.println("** exBoyfriend =>" + exBoyfriend);
		
	}

}
