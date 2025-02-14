package j10_Exception;
//** 예외생성
//=> throw : 예외(Exception) 생성하기 (사전던지다)
//=> throws: 예외(Exception) 전달하기 (떠넘기기, 사전던지다)
//
//=> extends Exception => Checked Exception 
//=> extends RuntimeException => UnChecked 예외 (예외처리를 강제하지 않음)
public class Ex06_throw {

	public static void main(String[] args) {
		System.out.println("program 시작");
		
		//UnChecked Exception 생성
		//throw new RuntimeException();
		
		//Checked Exception 생성
//		try {
//			throw new Exception();			
//		} catch (Exception e) {
//			System.out.println("catch block ,throw new Exception();, Exception(toString) : "+e.toString() );
//		}
		
		//나의 Exception 만들기
		try {
			double result = 1.5/0.0 ;
			if(Double.isInfinite(result)) {
				//throw new Exception("인자를 통한 message 입력도 가능하다 result = "+ result); // 1회성 생성사용
			
				Exception myE = new Exception("인자를 통한 message 입력도 가능하다 result = "+ result);
				throw myE ; // 다회성 인스턴스 생성사용
			}
			System.out.println("reult = "+result);
		} catch (Exception e) {
			System.out.println("catch block , Exception(toString) : "+e.toString() );
		}
		
		System.out.println("program 종료");
	}

}
