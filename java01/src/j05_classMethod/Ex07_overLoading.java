package j05_classMethod;
//** Method OverLoading (메서드 오버로딩)
//=> 하나의 클래스내에서 메서드 이름의 중복 허용
//=> 단, 매개변수의 갯수 또는 타입이 반드시 달라야 함.
//=> 장점: 동일한 기능에 대한 메서드명을 통일 시킬 수 있음. 

//** 과제
//=> 두수를 입력받아 add 연산 결과를 return 하는 메서드를 만든다.
// 단, 모든 기본자료형의 인자를 사용할 수 있도록 한다. 
// add1(int, int)  add2(int, double)  add3(double, int)  add4(double,double)
// 메소드명이 중복을 허용하지 않으면, 위처럼 불편.
//=> 매개변수명이 다른것은 오버로딩에 해당되지 않음.


public class Ex07_overLoading {
	
	public static int add (int a , int b) {
		return a+b;
	}
	public static double add (int a , double b) {
		double result = (double)a + b ;
		return result;
	}
	public static double add (double a , int b) {
		double result = a + (double)b ;
		return result;
	}
	public static double add (double a , double b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		System.out.println("int+int : "+Ex07_overLoading.add(3, 6));
		System.out.println("double+int : "+Ex07_overLoading.add(3.2, 6));
		System.out.println("int+double : "+Ex07_overLoading.add(3, 6.7));
		System.out.println("double+double : "+Ex07_overLoading.add(3.12, 6.41));
	}

}
