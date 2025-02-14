package j12_GenericAndCollection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//** HashMap 의 순차처리 ( Iterator , Entry ) 
//=> HashMap 의 주요 메서드 ( Set Type 으로 return ) 활용
//	- entrySet() : key+value 를 Entry Type 으로 묶어 Set 으로
//	- keySet() : key 값들만 Set 으로
//	- values() : value 들만 Set 으로
//1) 키와 값 같이 읽어 순차처리
//2) 키와 값을 따로 읽어 순차처리

public class Ex12_MapIterator {

	public static void main(String[] args) {
		// 1. HashMap 정의
		// => <상품, 가격>
		Map<String, Integer> hm = new HashMap<>();
		hm.put("아메리카노", 1500);
		hm.put("카푸치노", 2500);
		hm.put("아이스크림", 3000);
		hm.put("카페라떼", 3300);
		hm.put("마끼아또", 4000);
		System.out.println("** hm => "+hm);
		
		// 2. 순차처리
		// 2.1) entrySet()
		// -> key+value 를 Entry Type 으로 묶어 Set 으로
		// -> Set , iterator() 적용가능
		Set<?> set = hm.entrySet();
		System.out.println("** set => "+set);
		Iterator<?> iSet = set.iterator(); 
		
		while(iSet.hasNext()) {
			//=> iSet.next() 확인
			//	- "마끼아또=4000" : key, value 로 구분없음 
			//	- key, value 로 구분하려면 : Entry 객체활용
			//	- Entry 는 Map 의 inner class 임.
			//    그러므로 Map.Entry~~~~ 로 접근
			//System.out.println("* while: "+iSet.next());
			
			Map.Entry<?,?> e = (Map.Entry<?,?>)iSet.next();
			// => 인스턴스  e 를 통해 key, value 접근가능
			System.out.printf("* Entry: key=%s, value=%d \n", e.getKey(), e.getValue());
		} //while
		
		// 2.2) keySet() : key 값들만 Set 으로
		// 2.2.1) set.iterator() 적용
		set = hm.keySet();
		System.out.println("** keySet => "+set);
		iSet = set.iterator(); 
		while(iSet.hasNext()) {
			String hmKey = (String)iSet.next();
			System.out.printf("* while: key=%s, value=%d \n", hmKey, hm.get(hmKey));
		}
		 // 2.2.2) Set 은 eachFor 적용가능
		for (String s:hm.keySet()) {
			System.out.printf("* for: key=%s, value=%d \n", s, hm.get(s));
		}
		
		// 2.3) values() : value 들만 Set 으로
		// => 총합계, 평균 출력하기
		Collection<Integer> cv = hm.values();
		iSet = cv.iterator();
		int sum=0;
		while(iSet.hasNext()) {
			sum+=(Integer)iSet.next();
		}
		System.out.println("* 총합계 = "+sum);
		System.out.println("* 평균 = "+sum/hm.size());
		System.out.println("* 최고값 = "+Collections.max(cv));
		System.out.println("* 최저값 = "+Collections.min(cv));

	} //main

} //class
