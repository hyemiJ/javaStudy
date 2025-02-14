package j12_GenericAndCollection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

//** 해싱과 해시함수 => 정석 651p
//	해싱 => 해시 함수를 이용해서 데이터를 해시 테이블에 저장하고
//		   검색하는 기법

//** Map (key, Value)
//=> HashMap (Key 값의 중복을 허용하지 않고, 순서 유지를 보장받지 못한다.) 
//=> TreeMap (Key 값의 중복을 허용하지 않고, 키값으로 오름차순 정렬이 된다.)
//=> LinkedHashMap (Key 값의 중복을 허용하지 않고, 입력순서 유지를 보장받는다.)

//** HashMap : Key, Value 정보 지정
//=> key 는 유일, Value 는 중복 허용 
//=> null 값 허용 map.put(null, null) 또는 map.get(null) 가능

public class Ex10_HashMap {

	public static void main(String[] args) {
		// 1. HashMap
		// 1.1) 정의
		Map<Integer, String> hMap = new HashMap<>();
		
		//1.2) 초기화
		hMap.put(1, "Java");
		hMap.put(10, "Java");
		hMap.put(2, "그린");
		hMap.put(5, "Spring");
		hMap.put(new Integer(3), "Mysql"); //deprecated : 더이상 지원(권장)하지않음
		hMap.put(4, "Mybatis");
		hMap.put(4, "Mybatis"); // 키중복은 허용하지않으나 오류는 없음 
		hMap.put(null, "Null");
		
		//1.3) 출력 
		System.out.println(" HashMap 1 => "+hMap);
		System.out.println(" HashMap size => "+hMap.size());
		
		//1.4) 활용 : put, get, remove
		hMap.put(7, "JPA");
		System.out.println(" HashMap 2 => "+hMap);
		System.out.println(" HashMap get(5) => "+hMap.get(5));
		System.out.println(" HashMap remove(5) => "+hMap.remove(5)); // Value return
		System.out.println(" HashMap remove(null, 'Null') => "+hMap.remove(null, "Null")); // boolean return
		System.out.println(" HashMap 3 => "+hMap);

		//2. Map 구현클래스들 비교
		//=> 생성자의 인자로 위의 hMap 적용 가능
		//   단, key 값이 null 인경우 전달과정에서 런타임오류 java.lang.NullPointerException 발생
		//=> TreeMap
		Map<Integer, String> tMap = new TreeMap<>(hMap);
		System.out.println(" TreeMap => "+tMap);
		
		//=> LinkedHashMap : 입력순서 유지
		//=> 아래의 경우 전달되는 순서를 유지함
		Map<Integer, String> lhMap = new LinkedHashMap<>(hMap);
		System.out.println(" LinkedHashMap => "+lhMap);
		
		//** 새로운 Map 을 종류별로 작성하고 Test 해보기
		Map<String, String> testMap1 = new HashMap<>();
		testMap1.put("banana", "바나나");
		testMap1.put("브라운", "브라우니");
		testMap1.put("green", "김그린");
		testMap1.put("apple", "사과나무");
		System.out.println(" HashMap testMap1 => "+testMap1);
		
		Map<String, String> testMap2 = new TreeMap<>();
		testMap2.put("banana", "바나나"); 
		testMap2.put("브라운", "브라우니");
		testMap2.put("green", "김그린");
		testMap2.put("apple", "사과나무");
		System.out.println(" TreeMap testMap2 => "+testMap2);
		
		Map<String, String> testMap3 = new LinkedHashMap<>();
		testMap3.put("banana", "바나나");
		testMap3.put("브라운", "브라우니");
		testMap3.put("green", "김그린");
		testMap3.put("apple", "사과나무");
		System.out.println(" LinkedHashMap testMap3 => "+testMap3);
		
	} //main

} //class
