package j08_abstractInterFace;


//interface 
//멤버 변수로는 상수만 허용. -> 리터럴(값)이 필수.
//멤버 메서드는 추상 메서드로 디폴트 되어 있음. public abstract 생략가능.
//멤버 메서드는 default 메서드 , static 메서드 사용 가능. 
//default는 추상메서드와 혼동이 올 수 있음으로 default를 명시.
//생성자는 불허한다.

public interface Ex03_MyInterface {

		int NUM = 123;
		String NAME = "Green"; // == public static final String NAME = "Green";
		
		int getNum(); // == public abstract int getNum();
		String getName(); // == public abstract int getName();
}
