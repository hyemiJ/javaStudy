package j11_APITest;

import java.util.Arrays;


//** String 3
//=> String 의 메서드
//=> 문자열 변경
//  -> toLowerCase, toUpperCase, replace, split
//  -> Type 변경: int to String, String to int 

public class Ex03_String03 {
	public static void main(String[] args) {
		String name ="홍길동";
		String city = "            ~~~~~SeoulKorea~~~~~              ";
		String country = "   !I!Love!Korea!    ";
		
		System.out.printf("city trim toLowerCase() = %s , country trim toLowerCase() = %s %n" , city.trim().toLowerCase(),country.trim().toLowerCase());
		System.out.println();
		System.out.printf("city trim toUpperCase() = %s , country trim toUpperCase() = %s %n" , city.trim().toUpperCase(),country.trim().toUpperCase());
		System.out.println();
		System.out.println("country 의 Korea 를 대한민국으로 변경 = "+country.replace("Korea", "대한민국"));
		System.out.println("name 의 없는 김을 이로 바꾸자.= "+name.replace("김", "이"));
		System.out.printf("country trim replace( ! ,  ) = %s %n" , country.trim().replace("!", " "));
		System.out.println();
		String []result = country.trim().split("!");
		for (String string : result) {
			System.out.println(string);
		}
		System.out.println(Arrays.toString(result));
		
		//** String 3
		//=> String 의 메서드
		//=> 문자열 변경
//		    -> toLowerCase, toUpperCase, replace, split
//		    -> Type 변경: int to String, String to int 
		int i = 100, j = 123;
		//name = i+j ; // 타입 미스매치 , String = int
		//name = String.valueOf(i+j) ;
		//System.out.println(name);
		//double d = 123.321;
		//name = String.valueOf(d);
		System.out.println(String.valueOf( i < j ));
		
		
        // 4) 비교: compareTo
        // => 사전 순서로 비교 
        //    같으면 0, 이전이면 음수, 이후면 양수 return
        // => 문자열의 순서가 일치하면 : 다른 글자 갯수를 표시함 (abc:ab , abc:abcabcd)
        // => 완전다른 문자는 알파벳 순서의 차이를 return
        //   ( comparTo는 같은 위치의 문자만 비교하기 때문에, 
        //     첫번째 문자부터 순서대로 비교해서 다를 경우 바로 아스키값을 기준으로 비교처리를 한다. )
        //    abc : japan ->-9  abc:korea -> -10  abc:love -> -11 
		
		name = "abc";
		System.out.println("compareTo  abc =>"+name.compareTo("abc"));
		System.out.println("compareTo  ab =>"+name.compareTo("ab"));
		System.out.println("compareTo  a =>"+name.compareTo("a"));
		System.out.println("compareTo  bc =>"+name.compareTo("bc"));
		System.out.println("compareTo  c =>"+name.compareTo("c"));
		System.out.println("compareTo  abcabc =>"+name.compareTo("abcabc"));
		System.out.println("compareTo  love =>"+name.compareTo("love"));
		if(name.compareTo("abc")==0) System.out.println("name.compareTo(\"abc\")==0");
		
		//포함관계.
		System.out.println(country.contains("Korea"));
		
	}
}
