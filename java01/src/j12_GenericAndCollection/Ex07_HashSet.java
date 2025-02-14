package j12_GenericAndCollection;


import java.util.HashSet;
import java.util.Iterator;

//** Set  
//=> 원소의 중복을 허용하지 않고, 순서가 없음
//=> HashSet, TreeSet, LinkedHashSet

//** HashSet
//=> HashSet은 해쉬 테이블에 원소를 저장하기 때문에 성능면에서 가장 우수,
//	 하지만 원소들의 순서가 일정하지 않은 단점이 있다.

//** Iterator(반복자) 클래스를 이용한 처리 (출력등..)
//=> 배열 -> Set
//=> Set -> Iterator : 순차 처리 적용

public class Ex07_HashSet {

	public static void main(String[] args) {
		// 1) 정의 
		HashSet<String> sSet = new HashSet<String>();
		
		// 2) 초기화
		sSet.add("Java");
		sSet.add("MySql");
		sSet.add("Web_Servlet");
		sSet.add("Web_JSP");
		sSet.add("Java"); // 오류는 없고 허용만하지않음
		sSet.add("Spring");
		sSet.add("SpringBoot");
		
		sSet.remove("Spring");
		
		// 3) 출력
		// => 인덱스 개념이 없으므로 순서대로 순회하는것은 불가능하지만
		//    eachFor 적용은 가능함
		for (String s:sSet) {
			System.out.println(s);
		}
		System.out.println("** size => "+sSet.size());
		
		// 4) 반복자 적용
		//=> Iterator 활용
		//=> 순차적으로 비교하면서 원하는값을 찾기.삭제 가능 
		//   모든 변경사항은 원본 sSet 에 반영됨
		Iterator<String> iSet = sSet.iterator();
		while(iSet.hasNext()) {
			//if (iSet.next().contains("p")) iSet.remove();
			// => 주의 : next() 를 반복문 내부에서 2회 이상 사용은 주의
			//          hasNext() 값이 false 인 상태에서 접근 할 수 있기 때문
			//          단, else if 로 처리하는 경우에는 가능할 수 있음 
			// => 그러므로 여러번 비교가 필요한 경우라면 임시변수에 담아서사용
			
			String test = iSet.next(); 
			// 단, 리터럴에 "-" 포함되면 next() 메서드에서 오류발생함 "_" 는 무관
			if (test.contains("b")) iSet.remove();
			else if (test.equals("SpringBoot")) { 
				iSet.remove();
				sSet.add("Error"); 
				// => Iterator 에서 add 는 불가능 > iSet.add() 불가능하지만
				// => 반복문 내부에서 sSet(Set Type) 에 접근가능
			}
		} //while
		
		// => iSet 출력을 위해 재사용 하려면
		//    시작점을 처음으로 되돌려야함 
		//    Iterator 에서는 자료를 포인트하는 커서가 있고, 
		//    반복을 마치면 커서는 마지막에 도달됨 -> hasNext() 값 무조건 false
		//    이 커서의 위치를 처음으로 맞추기 위해 재할당함.
		iSet = sSet.iterator();
		while(iSet.hasNext()) {
			System.out.println("** 삭제후 iSet => "+iSet.next());
		} //while
		// => 삭제후 원본 sSet 출력 
		for (String s:sSet) {
			System.out.println(s);
		}

	} //main

} //class
