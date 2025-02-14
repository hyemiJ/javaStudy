package j12_GenericAndCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// ** Set 을 이용한 로또번호 생성기
// => 중복을 허용하지않는 특성을 활용
// => Set 객체에 Ramdom 또는 Math.random() 로 1~45 범위내의 정수를 6개 담기 
// => 오름차순 출력

//** Set 구현 클래스
//=> HashSet
//	 HashSet은 해쉬 테이블에 원소를 저장하기 때문에 성능면에서 가장 우수하다.
//	 하지만 원소들의 순서가 일정하지 않은 단점이 있다.
//=> TreeSet
//	 레드-블랙 트리(red-black tree)에 원소를 저장한다. 
//	 따라서 값에 의해 순서가 결정되지만 HashSet보다는 느리다.
//=> LinkedHashSet
//	 해쉬 테이블과 링크드 리스트를 결합한 것으로
//	 원소들의 순서는 삽입되었던 순서와 같다. 

public class Ex08_SetLotto {

	public static void main(String[] args) {
		// 1.Set 정의
		Set<Integer> lottoSet = new HashSet<>();
		Random rn = new Random();
		
		// 2. 번호추출
		// => 반복문 선택, 6개를 채움
		while(lottoSet.size()<6) {
			// => size=0 부터 시작하기 때문
			lottoSet.add(rn.nextInt(45)+1);
		}
		
		// 3. 출력
		System.out.println("** 정렬전 Lotto => "+lottoSet);
		
		// 4. 정렬
//		 => Collections : Collection 들의 Wrapper Class
//			  Collection 과 관련된 편리한 메서드를 제공
//		    단, interface Collection 과 구별
//		    또, interface Collector 의 구현클래스 Collectors 와도 구별
//		 => Collections.sort(List<T> list)
//		    인자로 List 타입이 필요함
		
		//4.1) Set -> List
		//=> LinkedList, ArrayList 의 생성자 중에 Set을 인자로 받아 list 를 생성해주는 생성자가 있음.
		
		//LinkedList<Integer> list = new LinkedList<>(lottoSet);
		ArrayList<Integer> list = new ArrayList<>(lottoSet);
		
		Collections.sort(list);
		System.out.println("** 정렬후 Lotto, list => "+list);
		
		//4.2) Set -> 배열
		//=> 배열정의
		Object[] oArr = lottoSet.toArray();
		Arrays.sort(oArr);
		System.out.println("** 정렬후 Lotto, oArr => "+Arrays.toString(oArr));
		System.out.println("** 정렬후 Lotto 원본 => "+lottoSet);
		
		//5. TreeSet
		//=> 중복을 허용하지않으면서 6개를 채우고, 오름차순 정렬 가능 
		Set<Integer> tSet = new TreeSet<>(); 
		while(tSet.size()<6) {
			tSet.add(rn.nextInt(45)+1);
		}
		System.out.println("** TreeSet Lotto => "+tSet);

		//6. LinkedHashSet
		//=> 입력 순서 유지
		Set<String> lkSet = new LinkedHashSet<>(); 
		lkSet.add("칼국수");
		lkSet.add("장조림백반");
		lkSet.add("짜장면");
		lkSet.add("냉면");
		System.out.println("** LinkedHashSet => "+lkSet);
		
	} //main

} //class
