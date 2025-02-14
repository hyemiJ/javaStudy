package j12_GenericAndCollection;


import java.util.ArrayList;

import j05_classMethod.Car;

//** ArrayList<E> 의 저장용량  
//=> 데이터가 증가하면 메서드 호출하지 않아도 저장용량은 자동증가 함
//	( 매우 비효율적 : 큰공간을 할당하고 기존의 값들을 이동함 )
//=> 필요시엔 미리 설정가능, 생성시에 필요한 충분한 용량을 할당하는것이 바람직함.
//	1) 생성자 
//=> 초기값 지정 가능 :  new ArrayList<>(100) ;
//	2) 메서드 이용
//=> public void ensureCapacity(int minCapacity) : ArrayList 에 정의

//** 계층도
//=> Collection<E>(i) AbstractCollection<E> 
//	-> List<E> (i), AbstractList<E> -> LinkedList , ArrayList

public class Ex04_ArrayList {

	public static void main(String[] args) {
		// 1) 정의
		// => Generic Type 을 지정하지않으면 Object Type
		ArrayList list = new ArrayList();
		
		// => 초기화
		list.add("홍길동");
		list.add(12345);
		list.add('F');
		list.add(123.456);
		
		// 2) 사용
		// => set(index, value), get(index), remove(index)
		// => 용량변경, size
		list.set(0, "setTest"); // 수정
		list.add(1, "끼워넣기"); // 끼워넣기
		list.add("add_추가");  // 마지막에 추가
		
		System.out.println("** get Test => "+((int)list.get(2)+100) );
		
		list.remove(4);
		
		// => size 와 용량 비교
		//    size : 리스트의 현재 요소의 수
		//    용량 : 재할당없이 수용가능한 요소의 수
		System.out.println("** list_size1 => "+list.size());
		list.ensureCapacity(20); //용량재할당
		System.out.println("** list_size2 => "+list.size());
		
		// => 출력
		for (Object o:list) {
			System.out.println(o);
		}
		
		// 3) Car 적용
		// new Car(10, 20, "현대", 'A', "Silver")
		ArrayList<Car> carList = new ArrayList<Car>(); 
		carList.add(new Car());
		carList.add(new Car(10, 20, "현대", 'A', "Silver"));
		carList.add(new Car(10, 20, "기아", 'A', "Red"));
		
		System.out.println("* Car get => "+carList.get(1).brand);
		for (Car car:carList) {
			System.out.println(car);
		}

	} //main

} //class