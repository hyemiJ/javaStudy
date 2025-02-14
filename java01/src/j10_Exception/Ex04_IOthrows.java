package j10_Exception;

import java.io.IOException;

//** Checked Exception 처리
//1) 직접 처리
//    => 해당 메서드 내에서 try ~ catch 블럭 처리
//2) 위임 처리 (throws Exception)
//    => Exception 처리를 상위 메서드로 위임(떠넘기기)


// => throws IOException
//    IOException의 처리를 상위의 메서드(현재메서드를 call 한 메서드) 로 떠넘김
// => throws 하는 Exception 은 모두 Checked 방식으로 처리 해야함
// => throws 하는 Exception 을 처리하는 구문에서는 Exception 적용범위가 더 넓어야함 
//    즉, throws Exception -> main 의 catch (IOException e) : 오류
public class Ex04_IOthrows {
	
	//1. 직접 처리
	public static String readString1() {
		byte [] bf = new byte[100];
		System.out.println("readString1 ) 문자를 입력하세요.");
		//System.in.read(bf);
		//컴파일 오류 : 
		
		try {
			System.in.read(bf);
		} catch (Exception e) {
			System.out.println("catch , Exception(toString) : "+e.toString() );
			//Exception 이라고 하면 괜찮으나 , runtimeException 으로는 대체가 불가하다 계보가 같지 않기 때문,
			//정확하게 IOException ( 만약 IOException 으로 사용시 import 필수)
		}
		return new String(bf) ;
	}
	
	//2. 위임 처리
	public static String readString2() throws IOException{ //2. 위임처리의 throws
		byte [] bf = new byte[100];
		System.out.println("readString2 ) 문자를 입력하세요.");
		//System.in.read(bf);
		//컴파일 오류 
		//try ... catch 를 직접 작성하지 않고 떠넘기자.
		// 방법 : header 에 thows를 추가
		System.in.read(bf);

		return new String(bf) ;
	}
	
	//public static void main (String[] args) throws Exception {//3. 메인에서도 위임 처리
	public static void main (String[] args) {
		//1. 직접처리
		//System.out.println("main ) readString 1 : "+readString1());
		//2.위임처리
		//System.out.println("main ) readString 2 : "+readString2());
		//Unhandled exception type IOException
		try {			
			System.out.println("main ) readString 2 : "+readString2());
		} catch (Exception e) {
			System.out.println("catch , Exception(toString) : "+e.toString() );
		} 
		//3. 메인에서도 위임 처리 -> 메인 메서드 헤더 확인
		//System.out.println("main ) readString 2 : "+readString2());
		
		System.out.println("program 종료");
	}
}
