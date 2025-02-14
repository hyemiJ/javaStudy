package j11_APITest;
//** String 2
//=> String 의 메서드
//=> 문자열 추출
//   charAt, length, indexOf, lastIndexOf, substring, trim
//=> 메서드 적용시 변수의 값이 변경되는것이 아니고, 메서드가 적용결과를 return 할뿐. 
public class Ex02_String02 {
	public static void main(String[] args) {
		String name ="홍길동";
		String city = "            ~~~~~SeoulKorea~~~~~              ";
		String country = "   I Love Korea    ";
		System.out.println("name = "+name+".");
		System.out.println("city = "+city+".");
		System.out.println("country = "+country+".");
		System.out.printf("name charAt(1) = %s ,city charAt(10) = %s %n" , name.charAt(1),city.charAt(10));
		System.out.printf("name indexOf(길) = %d ,country indexOf(k) = %d %n" , name.indexOf("길"),country.indexOf("k"));
		System.out.printf("country indexOf(o,15) = %d %n" , country.indexOf("o",15));
		System.out.println();
		
		System.out.printf("country substring(13) = %s ,country substring(0,7) = %s %n" , country.substring(13),country.substring(0,7));
		System.out.println();
		System.out.printf("city trim() = %s ,country trim() = %s %n" , city.trim(),country.trim());
		
		//실습
		String url = "C:\\MTest\\myWork\\java01\\src\\j11_APITest\\Ex02_String02.java";
		// url에서 파일명만 추출. 
		int startIndex = url.lastIndexOf("\\");
		int endIndex = url.lastIndexOf(".");
		String result = url.substring(startIndex+1,endIndex);
		System.out.println(result);
		// url에서 확장자만 추출.
		result = url.substring(endIndex+1);
		System.out.println(result);
	}
	
}
