package j12_GenericAndCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ex05_LinkedList {

	public static void main(String[] args) {
		// 1) 정의
		// => 다형성 적용 가능
		List<String> l1 = new LinkedList<String>();
		List<String> l2 = new ArrayList<String>();
				
		LinkedList<String> list = new LinkedList<String>();
		
		// 2) 초기화
		list.add("Java");
		//list.add(12345); -> 컴파일오류
		list.add("JavaScript");
		list.add("Servlet");
		list.add("JSP");
		list.add("MySql");
		
		// 3) 활용
		// => set(index, value), get(index), remove(index)
		// => size
		String ss = list.get(2)+list.get(3);
		list.set(4, ss); // 수정
		list.add(1, "Spring"); // 인덱스 1로 추가
		list.add("Mybatis"); // 뒤쪽에 추가
		
		list.remove(2);
		
		// 4) 출력
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 5) 배열과의 관계
		// => 배열 -> List -> Iterator(순차처리를 지원하는 클래스) 로 변환가능
		// => Arrays.asList(menu) -> List Type 을 return
		String[] menu = {"마라탕", "마카롱", "탕후르", "로제떡볶기", "왕만두"}; 
		
		l1=Arrays.asList(menu); // List 로 정의한 l1 은 형변환 필요없음
		//list =(LinkedList)Arrays.asList(menu); 
		// => LinkedList 로 정의한 list는 형변환 필요함 
		// => 런타임오류: java.lang.ClassCastException
		
		// => 변환된 리스트에 set, get -> 허용
		//    remove, add -> 런타임오류 발생 : java.lang.UnsupportedOperationException
		// => 배열의  Data를 복사해 새로운 List 를 만드는것이 아니기때문
		
		l1.set(4, "요아정"); //요거트 아이스크림의 정석
		//l1.add(4, "짜장면");
		//l1.remove(0);
		
		for (int i=0; i<l1.size(); i++) {
			System.out.println(l1.get(i));
		}
		System.out.println(Arrays.toString(menu)); // Data 변경되었음 확인
		System.out.println("** 주소확인 menu => "+menu.hashCode());
		System.out.println("** 주소확인 l1 => "+l1.hashCode());
		
		// => List -> Iterator
		// => Iterator : 순차처리를 편리하게 지원하는 클래스, hasNext(), next() 메서드제공 
		Iterator iMenu = l1.iterator();
		while(iMenu.hasNext()) {
			System.out.println(iMenu.next());
		}

	} //main

} //class
