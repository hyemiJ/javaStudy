package j12_GenericAndCollection;

import java.util.Enumeration;
import java.util.Properties;

//** Properties
//=> Properties는 HashMap의 구버전인 Hashtable을 상속받아 구현한 것으로, 
//	 Hashtable은 키와 값을 (Object, Object)의 형태로 저장하는데 비해 
//	 Properties는 (String, String)형태로 저장하는 보다 단순화된 컬렉션 클래스 이다. 

//=> Properties SourceCode header
//	 public class Properties extends Hashtable<Object, Object> {...

//=> 주로 애플리케이션의 환경설정과 관련된 속성을 저장하는데 사용되며 
//	 데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공한다. 
//	 그래서 간단한 입출력은 Properties를 활용하면 몇 줄의 코드로 쉽게 해결할 수 있다.

public class Ex13_Properties {

	public static void main(String[] args) {
		// 1. 정의
		// => 동일 Key 값은 허용되지않으며, 나중값이 적용됨
		// => 순서는 무관
		Properties pp = new Properties();
		
		// 2. 초기화 & 출력
		pp.setProperty("list", "StudentList.class");
		pp.setProperty("detail", "StudentDetail.class");
		pp.setProperty("insert", "StudentInsert.class");
		pp.setProperty("update", "StudentUpdate.class");
		pp.setProperty("delete", "StudentDelete.class");
		// pp.setProperty(111, "StudentDelete.class"); 컴파일오류
		System.out.println(pp);
		System.out.println("* pp.getProperty => "+pp.getProperty("list"));
		
		// 3. 순차처리
		// => Enumeration 활용
		// => propertyNames(): Properties 의 key 값들을 return
		Enumeration<?> epp = pp.propertyNames();
		while(epp.hasMoreElements()) {
			String eKey=(String)epp.nextElement();
			System.out.printf("* Enumeration key=%s, value1=%s, value2=%s \n",
								eKey, pp.getProperty(eKey), pp.get(eKey));
		}
	} //main

} //class
