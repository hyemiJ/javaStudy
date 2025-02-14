package aop02;

//** Aop 구현
// 1 단계 : 핵심적 관심사항 과  공통적 관심사항 분리
//=> 핵심적 관심사항만 구현
//=> 공통적 관심사항(Aspect) 분리 : 별도의 클래스로 분리 -> MyAspect.java

public class Boy implements Programmer {

	@Override
	public void doStudying() throws Exception {
		
		System.out.println("열심히 회원 관리를 만듭니다 => 핵심적 관심사항");
		
		//항상 Exception을 실행하지 않도록 만든 코드
		if (1==2) {
			// 실패
			throw new Exception("~~ Error 500*100 => 예외발생");
		}
		
	} //doStudying
} //class
