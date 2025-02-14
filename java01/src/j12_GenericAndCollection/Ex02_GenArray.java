package j12_GenericAndCollection;

import j05_classMethod.Car;

//** 과제
//=> 배열을 출력해주는 제네릭 클래스 만들기
//	 배열정의, setter/getter, arrayPrint()
//=> 실행시에 원하는 타입을 결정 & 출력
//=> 배열 타입 Generic

class GenArray<T> {
	// private 배열정의
	private T[] arr;
	
	// public getter/setter
	public void setArr(T[] arr) { this.arr=arr; }  
	public T[] getArr() { return arr; }
	
	public void arrayPrint() {
		// 배열 출력구문 완성 -> eachFor
		for (T a :arr) {
			System.out.print(" "+a);
		}
		System.out.println();
	}//arrayPrint
} //GenArray

public class Ex02_GenArray {

	public static void main(String[] args) {
		// 1) String
		String[] ss = {"가","나","다","라","마"};
		GenArray<String> ga1 = new GenArray<String>();
		ga1.setArr(ss);
		// ga1.setArr({"가","나","다","라","마"}); ->컴파일오류
		//ga1.setArr(ii); // 컴파일오류
		ga1.arrayPrint();
		
		// 2) Integer
		Integer[] ii = {1, 2, 3, 4, 5};
		GenArray<Integer> ga2= new GenArray<Integer>();
		ga2.setArr(ii);
		ga2.arrayPrint();
		
		// 3) Character (char)
		Character[] cc = {'A', 'B', 'C', '디', '이' };
		GenArray<Character> ga3= new GenArray<Character>();
		ga3.setArr(cc);
		ga3.arrayPrint();
		
		// 4) Car 
		// new Car(10, 20, "현대", 'A', "Silver")
		Car[] cars = {  new Car(10, 20, "현대", 'A', "Silver"),
						new Car(10, 20, "기아", 'A', "Gold"),
						new Car(10, 20, "쌍용", 'A', "White")	};
		GenArray<Car> ga4= new GenArray<Car>();
		ga4.setArr(cars);
		ga4.arrayPrint();
		
	} //main

} //class
