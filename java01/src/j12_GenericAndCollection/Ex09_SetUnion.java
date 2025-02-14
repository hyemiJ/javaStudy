package j12_GenericAndCollection;

import java.util.HashSet;
import java.util.Set;

// ** 대량연산 메서드

public class Ex09_SetUnion {

	public static void main(String[] args) {
		// 1. Set 을 2개 정의
		Set<String> menuSet = new HashSet<>(); 
		menuSet.add("칼국수");
		menuSet.add("장조림백반");
		menuSet.add("짜장면");
		menuSet.add("냉면");
		System.out.println("** menuSet => "+menuSet);
		
		Set<String> colorSet = new HashSet<>(); 
		colorSet.add("Red");
		colorSet.add("Orange");
		colorSet.add("Yellow");
		colorSet.add("Green");
		colorSet.add("Blue");
		System.out.println("**colorSet => "+colorSet);
		
		// 2. 대량연산 메서드
		// => 합집합_union, 교집합_intersection, 부분집합, 차집합_difference of sets
		menuSet.addAll(colorSet);
		System.out.println("** menuSet addAll => "+menuSet);
		// => 교집합_intersection
		menuSet.retainAll(colorSet);
		System.out.println("** menuSet retainAll => "+menuSet);
		// => 부분집합 확인 : colorSet 가 menuSet 의 부분집합이면 true 
		System.out.println("** menuSet retainAll => "+menuSet.containsAll(colorSet));
		// => 차집합_difference of sets
		//    현재 동일한 자료만 있으므로 color 2개 추가후 Test
		colorSet.add("Black");
		colorSet.add("White");
		colorSet.removeAll(menuSet);
		System.out.println("** colorSet 차집합 => "+colorSet);

	} //main

} //class
