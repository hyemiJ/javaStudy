package j01_basic;

public class Ex04_Casting {

	public static void main(String[] args) {
//		===============================================형변환(Type Casting)
		//1. 자동 (프로모션 promotion , 확대 형변환)
		// => 큰자료형에 작은자료형을 대입하면 : 자동으로 형변환이 이루어짐
		
		double d = 123.456 ;// double은 8byte (실수형)
		int i = 123456;  // int는 4byte (정수형)
		
		System.out.println("double d="+ d);
		System.out.println("int i ="+ i);
		
		
		d=i; // 자동 형변환 발생(int -> double)
		// int 형 변수 i의 값을 double 형 변수 d에 대입하면 자동 형변환 발생
		System.out.println("자동 형변환 double = int ; =>"+ d);
		
		
		
		
		//2. 강제 (디모션, demotion, 축소 형변환)
		// => 작은자료형에 큰자료형을 대입 : 자동으로 이루어지지않음
		// =>자료형 타입이 다른 경우에도 명시적 형변환이 필요함
		
		//i =d; // 프로모션 불가능 . 컴파일 오류. 명시적 형변환이 필요함.
		d=555.555 ;// double형 값
		i =123456;// int형 값
		System.out.println("double d="+ d);
		System.out.println("int i ="+ i);
		i =(int)d;// double 형 변수 d의 값을 int 형 변수 i에 강제 형변환
		System.out.println("강제 형변환 int =(int)double; =>"+ i);
		
		
		String sss = "가나다";
		//i = (int)sss; //강제 형변환 불가
		
		
		//같은 크기 다른 타입. (int / float - 4byte)
		float f = 123.456f; // float은 4byte (실수형)
		int n = 100;// int는 4byte (정수형)
		System.out.println("float f="+ f);
		System.out.println("int n ="+ n);
		f = n; // 자동 형변환 발생 (int -> float)
		System.out.println("f=n 넣은 후 :float f="+ f);
		System.out.println("f=n 넣은 후 :int n ="+ n);
		
		f=123.456f;
		//n=f; //오류: float 값을 int에 대입할 수 없음
		System.out.println("float f="+ f);
		System.out.println("int n ="+ n);
		n =(int)f; // 강제적 형변환 (float -> int)
		System.out.println("n =(int)f;  후 :float f="+ f);
		System.out.println("n =(int)f;  후 :int n ="+ n);
		System.out.println();
		
		//정수형 연산
		//4byte 이하의 정수형 연산의 결과는 무조건 int 타입으로 처리됨.
		short s1 =10, s2 = 20 , s3 = 30;
		//s3 = s1+s2; //int 를 short으로 변환할 수없다고 타입 미스매치 오류 뜸.
		s3 =(short)(s1+s2);//강제 형변환 필요 (int -> short)
		
		//char 타입은 int 변환이 가능함
		char c = 'C';
		n = 100;
		System.out.println("(char)c="+ c+", (int)n ="+ n);
		
		n=n+c;// char 타입이 int로 변환되어 더해짐
		System.out.println("(int)n=(int)n+(char)c 후: c="+ c+", n ="+ n);
		System.out.println("(char)n ="+ (char)n);// n을 char로 다시 변환하여 출력
		System.out.println();
		
		//long의 자동 형변환
		// long(정수형 8byte) , float(실수형 4byte) 은 타입도 , 크기도 다름.
		long longL = 10000L;
		float fff = longL;
		System.out.println("long longL :"+longL);
		System.out.println("float fff:"+fff);
		//길이는 float가 작지만 float의 표현범위는 long 보다 더 크기때문에 자동형변환이 일어남.
		
	
	}

}
