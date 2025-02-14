package j01_basic;

public class Ex03_Variable02 {

	public static void main(String[] args) {
		//=========================================================치환 
		
		String cup1 = "사이다", cup2 = "콜라";
		System.out.println("cup1은 "+cup1+"cup2는 "+cup2);
		String temp = cup1;  //임시변수 temp
		cup1 = cup2;
		cup2 = temp;
		System.out.println("cup1은 "+cup1+"cup2는 "+cup2);
		System.out.println();
		
		//===================================기본자료형의 Wrapper Class
		//기본 자료형을 지원해주는 클래스 (모든 기본 자료형에 있음)
		// 해당 클래스명은 기본 자료형의 첫글자를 대문자로 하면 됨.
		//1)정수형
		System.out.println("정수형의 값의 범위");
		System.out.println("byte = "+Byte.MIN_VALUE+"~"+Byte.MAX_VALUE);
		System.out.println("short = "+Short.MIN_VALUE+"~"+Short.MAX_VALUE);
		System.out.println("int = "+Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
		System.out.println("long = "+Long.MIN_VALUE+"~"+Long.MAX_VALUE);
		System.out.println();
		
		//2)실수형
		System.out.println("실수형의 값의 범위");
		System.out.printf("float = %f ~ %f \n", Float.MIN_VALUE, Float.MAX_VALUE);
		System.out.printf("double = %f ~ %f \n", Double.MIN_VALUE, Double.MAX_VALUE);
		System.out.println();
		
		//==================오버플로우 와 언더플로우 (OverFlow / UnderFlow)
		//1)정수형
		short sMax = Short.MAX_VALUE;
		short sMin = Short.MIN_VALUE;
		System.out.printf("sMax 는 %d , sMin 은 %d \n", sMax,sMin);
		System.out.printf("오버 플로우 : sMax 는 %d , sMax+1 은 %d \n", sMax, (short)(sMax+1));
		System.out.printf("언더 플로우 : sMin 는 %d , sMin-1 은 %d \n", sMin,(short) (sMin-1));
		//결과 : 최대값에서 오버플로우 발생시 최소값으로 변경 , 최솟값에서 언더플로우 발생시 최대값으로 변경
		System.out.println("short의 연산결과 int형으로 형변환");
		System.out.printf("오버 플로우 : sMax 는 %d , sMax+1 은 %d \n", sMax,(sMax+1));
		System.out.printf("언더 플로우 : sMin 는 %d , sMin-1 은 %d \n", sMin,(sMin-1));
		System.out.println();
		
		//2)실수형
		//by Zero test
		float f = 1234.5678f;
		System.out.println("실수형 f, by Zero test1 나누기(f/0) :"+(f/0));
		System.out.println("실수형 f, by Zero test1 나머지 (f%0):"+(f%0));
        // => Infinity (무한수)
        //    -> 양의 무한대(positive infinity): 오버플로우(Overflow)
        //    -> 음의 무한대(negative infinity): 언더플로우(Underflow)
        
        // => 실수형에만 있는 특수값(언더플로우)
        // -> 실수형으로는 표현할수 없는 가장 작은값으로서
        //    양의 최소값보다 작은값이 되는경우를 의미하며
        //    이때 변수의 값은 0 이 됨.
		// =========정수형 by Zero test 비교 
		short max = 32767;
//		System.out.println("정수형 max, by Zero test2 나누기(max/0) :"+(max/0));
//		System.out.println("정수형 max, by Zero test2 나머지 (max%0):"+(max%0));
		//컴파일 오류는 일어나지 않고 런타임 오류가 발생(Exception in thread "main" java.lang.ArithmeticException: / by zero)

		
		
	}

}
