package j12_GenericAndCollection;

import java.util.HashMap;
import java.util.Map;

import j05_classMethod.Car;

public class Ex11_CarMap {

	public static void main(String[] args) {
		// 1. Map 정의
		Map<String, Car> cMap = new HashMap<>();
		
		// 2. 초기화
		cMap.put("H001",new Car(10, 20, "현대", 'A', "Silver"));
		cMap.put("H002",new Car(10, 20, "현대", 'A', "Black"));
		cMap.put("H003",new Car(10, 20, "현대", 'A', "Red"));
		cMap.put("K001",new Car(10, 20, "기아", 'A', "Yellow"));
		cMap.put("K002",new Car(10, 20, "기아", 'A', "Blue"));
		
		// 3. 실습 & 출력
		//=> "H003" 의 brand 수정하기
		cMap.get("H003").brand="Hyundai";
		cMap.get("H003").grade='D';
		//=> "H002" 삭제
		cMap.remove("H002");
		
		System.out.println(cMap);

	} //main

} //class
