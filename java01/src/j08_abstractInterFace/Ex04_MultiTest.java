package j08_abstractInterFace;
//** interface 3.
//1) 인터페이스와 인터페이스 관계
//=> 인터페이스 간의 상속(extends) 가능.
//=> 다중상속(부모 여러개 허용), 계층적 상속 모두 가능 
//
//2) 클래스 와 인터페이스 관계
//=> 다중 구현(implements) 가능
//=> 클래스가 클래스를 상속(extends) 받으면서 동시에
// 인터페이스를 구현(implements, 다중구현도 포함) 하는것 가능 
//
//** 그러므로 자바는 다중상속이 안되는점을 극복 가능함 

interface Inter1 {//==============================================================================interface Inter1 
	float PI = 3.141592f; // 상수
	int getA(); //추상 메서드
}

interface Inter2{//===============================================================================interface Inter2
	int getB();
}

interface Inter3 extends Inter1, Inter2{//=============================interface Inter3 extends Inter1, Inter2
	float getC();
}

class MulteInter implements Inter1,Inter2,Inter3{ //=========class MulteInter implements Inter1,Inter2,Inter3
	int a = 123 , b = 100;
	public MulteInter() {
		
	}
	
	@Override
	public int getA() {
		return a;
	}
	@Override
		public int getB() {
			return b;
		}
	@Override
		public float getC() {
			return (a+b)*PI;
		}
}//================================================================ class MulteInter implements Inter1,Inter2,Inter3

//클래스 상속 + interface 구현 모두 하는 클래스.

class Add {
	int addNum(int a , int b) {
		return a+b;
	}
}

class MultiExIm extends Add implements Inter1, Inter2, Inter3{// class MultiExIm extends Add implements Inter1, Inter2, Inter3
	int a= 456 , b = 100;
	@Override
	public int getA() {
		return a;
	}
	@Override
	public int getB() {
		return b;
	}
	@Override
	public float getC() {
		return addNum(a,b)*PI ;
	}
	
}// ======================================================================class MultiExIm extends Add implements Inter1, Inter2, Inter3






public class Ex04_MultiTest {//================================================== class Ex04_MultiTest
	public static void main(String[] args) {
		
		System.out.println("MulteInter m1 = new MulteInter();");
		MulteInter m1 = new MulteInter();
		System.out.printf("m1 : getA = %d , getB = %d , getC = %f %n", m1.getA(), m1.getB() , m1.getC());
		System.out.println();
		
		System.out.println("MultiExIm m2 = new MultiExIm();");
		MultiExIm m2 = new MultiExIm();
		System.out.printf("m2 : getA = %d , getB = %d , getC = %f %n", m2.getA(), m2.getB() , m2.getC());
		System.out.println();
		
		Inter1 in1 = new MulteInter();
		Inter2 in2 = new MultiExIm();
		System.out.println("Inter1 , Inter2 타입의 메서드 사용");
		System.out.println("in1.getA = "+in1.getA());
		System.out.println("in2.getB = "+in2.getB());
		// inter1 , inter2 에 해당하는 만큼만 접근 가능
		System.out.println();
		Inter3 in3MulteInter = new MulteInter();
		Inter3 in3MultiExIm = new MultiExIm();
		System.out.printf("in3MulteInter(타입 : Inter3 , 인스턴스 : MulteInter) : getA = %d , getB = %d , getC = %f %n", in3MulteInter.getA(), in3MulteInter.getB() , in3MulteInter.getC());
		System.out.printf("in3MultiExIm (타입 : Inter3 , 인스턴스 : MultiExIm): getA = %d , getB = %d , getC = %f %n", in3MultiExIm.getA(), in3MultiExIm.getB() , in3MultiExIm.getC());
		
		//in3MulteInter = in3MultiExIm;
		//in3MulteInter = m1; 
		// (타입 : Inter3 , 인스턴스 : MulteInter) =  (타입 : MulteInter , 인스턴스 : MulteInter)
		//타입 미스 m2 = in3MultiExIm ;
		
		//m2 = (MultiExIm)in3MultiExIm;  
		// (타입 : MultiExIm , 인스턴스 : MultiExIm) =  (타입 : Inter3 , 인스턴스 : MultiExIm)
		System.out.println();
		System.out.println("instanceof 테스트");
		if(m1 instanceof Inter1) {
			System.out.println("m1 instanceof Inter1  :  yes");
		}else {
			System.out.println("m1 instanceof Inter1  :  noo");
		}
		
		if(m2 instanceof Inter1) {
			System.out.println("m2 instanceof Inter1  :  yes");
		}else {
			System.out.println("m2 instanceof Inter1  :  noo");
		}
		
		if(in1 instanceof Inter3) {
			System.out.println("in1 instanceof Inter3  :  yes");
		}else {
			System.out.println("in1 instanceof Inter3  :  noo");
		}
		
		if(in3MultiExIm instanceof Inter1) {
			System.out.println("in3MultiExIm instanceof Inter1  :  yes");
		}else {
			System.out.println("in3MultiExIm instanceof Inter1  :  noo");
		}
		
		
		//Add 클래스 테스트 
		Add add = new Add();
		
		if(add instanceof Inter3) {
			System.out.println("add instanceof Inter3  :  yes");
		}else {
			System.out.println("add instanceof Inter3  :  noo");
		}
		
	}
}//================================================================================= class Ex04_MultiTest
