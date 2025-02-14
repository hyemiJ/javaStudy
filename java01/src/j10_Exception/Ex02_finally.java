package j10_Exception;

//반복문과 중첩


public class Ex02_finally {
	public static void main(String[] args) {
		int [] price = { 100, 200, 300 };
		
		for (int i = 0; i < price.length; i++) { //정상적인 구문.
		//for (int i = 0; i <= price.length; i++) {	//예외 처리 필요 구문.
			
			//if(i ==1) return; // 그렇다면 finally 는 실행 ? -> no
			try {
				//if(i == 1)return; //finally 실행 후 종료
				//if(i ==1) continue;  //finally 실행 후 다음 반복문 구문 진행
				if (i ==1)break;  //finally 실행 후 for문 종료 -> program 종료
				System.out.printf("price[%d] = %d %n", i , price[i]);
			} catch (Exception e) {
				System.out.println("catch , Exception : "+e.toString() );
			}finally {
				System.out.println("finally , 무조건실행 " );
			}
			System.out.println("for의 마지막라인 , i의 값 : "+i );
		}
		//return : void 메서드 종료 , continue , break
		
//		try {
//			System.out.println("try block, 5/0"+5/0);
//		} finally {
//			System.out.println("finally block");
//		}
		
		System.out.println("program 종료");
	}
}
