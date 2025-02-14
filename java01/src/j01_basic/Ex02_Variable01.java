package j01_basic;

public class Ex02_Variable01 {

	public static void main(String[] args) {
		
		//===================================변수 정의 //값을 리터럴이라고 함.
		
		//1.적합성 테스트
		String name = "홍길동"; // ok.
		String irum = "홍길동"; //적합하지만 비추천 (변수명으로 역할을 명시적으로 확인 할 수 있도록 함.)
		//String 이름 = "홍길동"; //허용되나 금지 (한글을 허용하나 사용 금지. 한글을 지원하지 않는 라이브러리를 이용할때 오류가 생길 수 있음.)
		String Name = "홍길동";//허용되나 금지(대문자시작하면 클래스로 인지하기 때문에)
		
		//2.타입 체크
		
		//1)정수형 :byte(1) , short(2) , int(4) , long(8) 
		byte b = 10;
		short s = 100;
		int i = 12345678; // 선언과 동시에 초기화를 함.
		
		//	long l = 1234567890123;
		//정수 사용시 주의사항 
		// 자바는 정수의 리터럴을 int 로 취급한다.
		//int를 초과하는 정수 리터럴을 롱타입 리터럴이라고 표기해줘야함.
		//소문자로 ㅣ을 표기하면 숫자와 헷갈릴 수 있기 때문에 대문자로 표기해줌.		
		long l = 1234567890123L;
		System.out.printf("정수 테스트 b = %d, s = %d , i = %d , l = %d \n", b,s,i,l); 
		System.out.println();
		//자바스크립트의 백틱(`${a}`)같은 효과를 주는 printf
		// \n 줄바꿈
		//갯수가 맞지 않을때 컴파일 오류는 없지만 RunTime Error
		
		//2)실수형 : float(4) ,double(8)
		//실수 리터럴의 기본타입은 더블이다.
		double d =123.4567;
		
		//	float f = 123.456;
		//타입 미스메치의 오류. ->double을 float에 담을 수 없다 (8을 4에 담을 수 없다.)
		float f = 123.456f;
		//대문자 소문자 모두 허용(F/f)
		
		
		//3) boolean 형 : true(1) / false(0) 
		// True 와 False 는 아님(대소문자에 엄격하기 때문)
		// 모든 관계식의 결과는 boolean 타입으로 나오게 됨.
		boolean bool = true;
		System.out.printf("boolean 테스트 bool = %b \n",bool);
		System.out.printf("관계식 테스트 b(10)>s( 100)= %b \n",b>s);
		System.out.printf("실수형 테스트 d(123.4567)= %f , f(123.456f)=%5.2f \n ",d,f);
		System.out.println();
		
		//char 형 : 한글 영문 모두 한글자를 의미함.(2byte)
		// 2byte로 int 타입으로도 사용 가능.
		char aa = 'A';
		char bb = 'B', cc ='C';
		char kk = '가' , nn = '나';
		String ss = "한글자 이상 가능";
		System.out.println("소괄호 묶지 않고 :char(A)+char(B)+char(C) ="+aa+bb+cc);
		//문자열의 연산이 이루어짐 
		System.out.println("소괄호 묶어서 : (char(A)+char(B)+char(C)) ="+(aa+bb+cc));
		//연산자의 우선순위의 적용으로 인해 아스키코드화 되어 연산됨.
		System.out.println("소괄호 묶어서 : (char(A)+char(B)+char(C)+string(한글자이상가능)) ="+(aa+bb+cc+ss));
		// 연산 순서 : aa+bb => aa+bb+cc => aa+bb+cc+ss => 문자열 +aa+bb+cc+ss
		
		//char를 int로 출력 (타입 캐스팅:명시적 형변환)
		System.out.println("타입캐스팅 :(int)char(A)+(int)char(B)+(int)char(C) ="+(int)aa+(int)bb+(int)cc);
		System.out.printf("char 테스트 : (int)aa = %d , bb = %s , (int)kk = %d , nn = %s \n" ,(int) aa, bb, (int)cc, ss);
		//System.out.printf("char 테스트 : aa = %d , bb = %s , kk = %d , nn = %s \n" , aa, bb, cc, ss); //Error
		
		//int 를 char 로 출력 (타입 캐스팅 : 명시적 형변환)
		int ii = 66;
		System.out.println("타입캐스팅 :(char)int(66)="+(char)ii);
		
	}

}
