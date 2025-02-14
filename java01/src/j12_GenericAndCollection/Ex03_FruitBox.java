package j12_GenericAndCollection;

import j05_classMethod.Car;

//** Generic Class Test 
//** FruitBox 만들기
//=> Apple, Banana 등 모든 과일을 담을수 있는 Generic FruitBox class 를 만들어 보세요.
//	 단 과일들만 담을 수 있어야 함.
//=> Apple, Banana 등 모든 과일은 클래스 입니다.

//** 실습
//=> 과일들을 묶어줈 있는 조상이 필요 : interface
//=> 과일 클래스 4개정도
//=> 과일들만 담을 수 있는 FruitBox


interface Fruiti {
	public void toEat();
}

class Apple implements Fruiti{
	@Override
	public void toEat() {
		System.out.println("나는 사과");
	}
}
class Banana implements Fruiti{
	@Override
	public void toEat() {
		System.out.println("나는 바나나");
	}
}
class Grape implements Fruiti{
	@Override
	public void toEat() {
		System.out.println("나는 포도");
	}
}
class Orange implements Fruiti{
	@Override
	public void toEat() {
		System.out.println("나는 오렌지");
	}
}
class Tomato {
	public void toEat() {
		System.out.println("나는 토마토");
	}
}


class FruitBox <T extends Fruiti>{
	private T[] Box;

	public T[] getBox() {
		return Box;
	}

	public void setBox(T[] box) {
		Box = box;
	}
	
	public void boxPrint() {
		for (T t : Box) {
			System.out.println(t+" ");
		}
	}
}
















//
//interface Fruiti {  }
//class Fruit { public String toString() { return "I am Fruit"; } } //class
//
//class Apple extends Fruit implements Fruiti {
//	@Override
//	public String toString() { return "I am Apple"; }
//}
//class Banana extends Fruit implements Fruiti {
//	@Override
//	public String toString() { return "I am Banana"; }
//}
//class Orange extends Fruit implements Fruiti {
//	@Override
//	public String toString() { return "I am Orange"; }
//}
//
//class Tomato { 
//	@Override
//	public String toString() {return "I am Tomato"; }
//}
//
//// ** FruitBox 만들기
//// 1) FruitBoxA : 모든 Type 적용가능
//class FruitBoxA<T> {
//	private T[] arr;
//	public void setArr(T[] arr) { this.arr=arr; }
//	public void fruitPrint() {
//		for (T a : arr) {
//			System.out.println(a);
//		} //for
//	} //fruitPrint
//} //FruitBoxA
//
//// 2) Type 을 제한하는 FruitBox
//// => Fruit class 후손들만 허용
//class FruitBox<T extends Fruit> {
//	private T[] arr;
//	public void setArr(T[] arr) { this.arr=arr; }
//	public void fruitPrint() {
//		for (T a : arr) {
//			System.out.println(a);
//		} //for
//	} //fruitPrint
//} //FruitBox
//
//// 3) interface Test
//// => extends 를 이용해서 적용가능
//class FruitBoxi<T extends Fruiti> {
//	private T[] arr;
//	public void setArr(T[] arr) { this.arr=arr; }
//	public void fruitPrint() {
//		for (T a : arr) {
//			System.out.println(a);
//		} //for
//	} //fruitPrint
//} //FruitBoxi

public class Ex03_FruitBox {

	public static void main(String[] args) {
//		// 1) FruitBoxA : 종합선물세트
//		// => 모든객체 적용가능
//		Object[] oarr = { new Apple(), new Banana(), new Car(), new Tomato() };
//		FruitBoxA<Object> fb1 = new FruitBoxA<Object>();
//		fb1.setArr(oarr);
//		fb1.fruitPrint();
//		
//		// => TomatoBox 또는 AppleBox 모두가능
//		Tomato[] tarr = { new Tomato(), new Tomato(), new Tomato() };
//		FruitBoxA<Tomato> fb2 = new FruitBoxA<Tomato>();
//		fb2.setArr(tarr);
//		fb2.fruitPrint();
//		
//		// 2) Fruit 선물세트
//		// => Type 을 제한하는 FruitBox 필요함
//		// => 클래스 Fruit Type 배열 정의 : Fruit 의 후손들만 가능 -> new Tomato() 컴파일오류
//		Fruit[] farr = {new Apple(), new Banana(), new Orange()};
//		FruitBox<Fruit> fb3 = new FruitBox<Fruit>();
//		fb3.setArr(farr);
//		fb3.fruitPrint();
//		
//		// => Apple, Banana, Orange Box 는 가능하지만 Tomato Box는 불가능
//		Banana[] barr = {new Banana(), new Banana(), new Banana()};
//		FruitBox<Banana> fb4 = new FruitBox<Banana>();
//		fb4.setArr(barr);
//		fb4.fruitPrint();
//		
//		// 3) interface Test
//		// => Fruiti 구현 클래스만 적용가능 (Tomato, Fruit -> 컴파일오류) 
//		Fruiti[] iarr = {new Apple(), new Banana(), new Orange()};
//		FruitBoxi<Fruiti> fb5 = new FruitBoxi<Fruiti>();
//		fb5.setArr(iarr);
//		//fb5.setArr(farr);  //컴파일오류 -> Fruiti 와 Fruit 은 무관함
//		fb5.fruitPrint();
//		
//		// => Apple, Banana, Orange Box 는 가능하지만 Tomato, Fruit Box는 불가능
//		Apple[] apples = {new Apple(), new Apple(), new Apple()};
//		FruitBoxi<Apple> fb6 = new FruitBoxi<Apple>();
//		fb6.setArr(apples);
//		fb6.fruitPrint();
		
		Apple[] applebox = {new Apple(),new Apple(),new Apple()};
		Banana[] bananabox = {new Banana(),new Banana(),new Banana()};
		Fruiti[] mixbox = {new Apple(),new Banana(),new Grape()};
		FruitBox<Fruiti> box = new FruitBox<>(); 
		box.setBox(applebox);
		box.setBox(bananabox);
		box.setBox(mixbox);
		box.boxPrint();
		
	} //main
} //class
