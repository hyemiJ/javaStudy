package j10_Exception;

//** Exception 계층구조 
//=> Object -> Throwable -> Exception, Error, 
//                     Exception -> RuntimeException, IOException 
//
//=> Error: 프로그램 코드에 의해 수습될 수 없는 심각한 오류
//=> Exception
// -> 프로그램 코드에 의해 수습될 수 있는 오류로, 프로그래머가 예외처리를 할 수 있음
// -> 반드시 예외 처리를 해야하는 Checked Exception과,
//    예외 처리를 하지 않아도 되는 Unchecked Exception으로 나뉜다.
//=> IOException
// -> Checked Exception
// -> 파일 및 입출력 작업에서 발생하는 Exception
//=> RuntimeException
// -> Unchecked Exception
// -> 개발자의 실수로 발생하는 Exception.
//
//** Exception Test
//=> Exception 처리하지않는 경우
//      -> Exception 발생위치에서 비정상종료 
//=> Exception 처리하는 경우
//     -> Exception 발생시 대응을 하여 정상진행가능



public class Ex01_BasicException {
	public static void main(String[] args) {
		//1. exception 처리 하지 않은 경우
		
		int x = 6, y = 3 , result = 0;
		String ss = "123000";
		String [] names = {"김밥","오이","당근","시금치","우엉"};
		result = x/y;
		//=> 런타임 시의 오류 
		
		System.out.println("result ( x/y ) ="+result);
		
		//2. exception 처리 하는 경우
		try {
			//result = x/0;
			result = x/2;
			System.out.println("result ( x/0 ) ="+result);
			System.out.println("result+=Integer.parseInt(ss) ="+(result+=Integer.parseInt(ss)));
			//System.out.println(names[6]);
			System.out.println(names[3]);
			//ss=null;
			System.out.println(ss.length());
		} 
		catch (Exception e) {
			System.out.println("catch ) exception : "+e.toString());
			
		}
		finally {
			System.out.println("finally : 무조건 실행");
			System.out.println("result = "+result);
		}
		
		System.out.println("program 종료");
	}
}
