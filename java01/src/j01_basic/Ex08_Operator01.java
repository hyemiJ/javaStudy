package j01_basic;

public class Ex08_Operator01 {
	//연산자(Operator)는 특정한 연산을 나타내는 기호
	//피연산자(Operand)는 연산의 대상
	
	public static void main(String[] args) {
		//======================================사칙연산
		System.out.println("사칙연산");
		int a = 10, b = 3;
		System.out.println("a  = "+a+", b = "+b);//a  = 10, b = 3
		System.out.println("a + b = "+(a+b));//a + b = 13
		System.out.println("a - b = "+(a-b));//a - b = 7
		System.out.println("a * b = "+(a*b));//a * b = 30
		System.out.println("a / b = "+(a/b));//a / b = 3
		System.out.println("a % b = "+(a%b));//a % b = 1
		
		System.out.println();
		//======================================대입연산
		System.out.println("대입연산");
		System.out.println("a  = "+a+", b = "+b);//a  = 10, b = 3
		System.out.println("a += b = "+(a+=b));//a += b = 13
		
		System.out.println("a  = "+a+", b = "+b);//a  = 13, b = 3
		System.out.println("a -= b = "+(a-=b));//a -= b = 10
		
		System.out.println("a  = "+a+", b = "+b);//a  = 10, b = 3
		System.out.println("a *= b = "+(a*=b));//a *= b = 30
		
		System.out.println("a  = "+a+", b = "+b);//a  = 30, b = 3
		System.out.println("a /= b = "+(a/=b));//a /= b = 10
		
		System.out.println("a  = "+a+", b = "+b);//a  = 10, b = 3
		System.out.println("a %= b = "+(a%=b));//a %= b = 1
		
		System.out.println("a  = "+a+", b = "+b);//a  = 1, b = 3
		
		System.out.println();
		//======================================단항연산
		System.out.println("단항연산"); //1씩 증가
		a = 10;
		b = 3;
		System.out.println("a  = "+a+", b = "+b);
		
		System.out.println("++a :"+(++a));//출력선증가
		System.out.println("a  = "+a+", b = "+b);
		System.out.println("a++ :"+(a++));//출력후증가
		System.out.println("a  = "+a+", b = "+b);
		System.out.println("b++ :"+(b++));
		System.out.println("a  = "+a+", b = "+b);
		System.out.println("++b :"+(++b));
		System.out.println("a  = "+a+", b = "+b);
		System.out.println();
		//======================================관계연산
		System.out.println("관계연산");
		a = 10;
		b = 3;
		System.out.println("a  = "+a+", b = "+b);
		System.out.println("a==b :"+(a==b));
		System.out.println("a!=b :"+(a!=b));
		System.out.println("a<b :"+(a<b));
		System.out.println("a>b :"+(a>b));
		
		System.out.println();
		//======================================삼항연산
		System.out.println("삼항연산"); // 조건 ? 참 : 거짓
		//String 포함 모든 type 에 적용 가능하다.
		//a와 b 중 큰 값을 출력하기.
		a = 10;
		b = 3;
		int max = (a>b ? a : b);
		boolean bol = (a>b)? true : false;
		char cc = (a>b)? 'T' :'F';
		String ss = (a>b)?"a가 크다" : "b가 크다";
		//String 포함 모든 type 에 적용 가능하다.
		System.out.println("a  = "+a+", b = "+b);
		System.out.printf("int max = %d , boolean bol = %b , char cc = %c , String ss = %s  %n" ,max, bol , cc , ss);
		//결과 : int max = 10 , boolean bol = true , char cc = T , String ss = a가 크다 
		System.out.println();
		//======================================논리연산
		System.out.println("논리연산"); 
		//=집합연산 and(&&) , or(||) , not(!)
		System.out.println("a  = "+a+", b = "+b);
		
		//1)and -> 모두 짝수이면 true 다
		bol = (a%2==0)&&(b%2==0);
		System.out.println("a와 b 가 모두 짝수인가 ?"+bol);
		
		//2)or -> a,b 중 하나라도 짝수이면 true
		bol = (a%2==0)||(b%2==0);
		System.out.println("a와 b ,둘중 하나라도 짝수인가?"+bol);
		
		//3) ! -> 값을 부정
		System.out.println("a와 b ,둘중 하나라도 짝수인가?의 부정:"+!bol);
		
		
		
		
		System.out.println();
	}

}
