package aop02;

public class Girl implements Programmer {
	
	@Override
	public void doStudying() throws Exception {
		
		System.out.println("열심히 게시판을 만듭니다 => 핵심적 관심사항");
		
		//항상 Exception을 실행하도록 만든 코드
		if (true) {
			// 실패
			throw new Exception("~~ Error 404*100 => 예외발생");
		}
		
	} //doStudying

} //class
