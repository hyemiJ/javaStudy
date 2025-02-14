package j04_array;

import java.util.Arrays;

public class Ex02_arrayType {

	public static void main(String[] args) {
        // ** 타입별로 배열을 정의 하고 출력해본다. 
        // => 묵시적 정의, 출력은 eachFor 구문으로 해도 됨. 
        // => int, long, float, char, String
        // => data 갯수는 5개
		
		
		//int 타입 배열
		System.out.println("int 타입의 배열");
		int number[] = {1,2,3,4,5,6};
		int sum =0;
		int count = 1;
		for (int i : number) {
			System.out.println("int 타입 배열 "+count+"번째 값 :"+i);
			sum += i;
			count++;
			System.out.println("int 타입 누적합 : " + sum);
		}
		System.out.println("Arrarys 래퍼 클래스 : "+ Arrays.toString(number));
		System.out.println();
		
		//long 타입 배열
		System.out.println("long 타입의 배열");
		long lon[] = new long[6];
		lon[0]=123L;
		lon[1]=123L;
		lon[2]=123L;
		lon[3]=123L;
		lon[4]=123L;
		lon[5]=123L;
		sum = 0;
		count = 1;
		for (long l : lon) {
			System.out.println("long 타입 "+count+"번째 값 :" + l);
			sum+=l;
			count++;
			System.out.println("long 타입 누적합 : " + sum);
		}
		System.out.println("Arrarys 래퍼 클래스 : "+ Arrays.toString(lon));
		System.out.println();
		
		//float 타입 배열
		System.out.println("float 타입의 배열");
		float flosum = 0;
		count = 1;
		float flo[] = {1.2f , 1.3f , 1.4f , 1.5f}; 
		for (float f : flo) {
			System.out.println("float 타입 "+count+"번째 값 :" + f);
			flosum+=f;
			count++;
			System.out.println("float 타입 누적합 : " + flosum);
		}
		System.out.println("Arrarys 래퍼 클래스 : "+ Arrays.toString(flo));
		System.out.println();
		
		//char 타입 배열
		System.out.println("char 타입의 배열");
		String chasum = "";
		count = 1;
		char cha[] = {'A' , 'B' , 'C' , 'D' , 'E' , 'F'}; 
		for (char c : cha) {
			System.out.println("char 타입 "+count+"번째 값 :" + c);
			chasum+=Character.toString(c);
			count++;
			System.out.println("char 타입 누적합 : " + chasum);
		}
		System.out.println("Arrarys 래퍼 클래스 : "+ Arrays.toString(cha));
		System.out.println();
		
		//String 타입 배열
		System.out.println("String 타입의 배열");
		String strSum = "";
		count = 1;
		String str[] = {"바나나","사과","오이","배고파","샌드위치"}; 
		for (String s : str) {
			System.out.println("String 타입 "+count+"번째 값 :" + s);
			strSum+= (s+" ");
			count++;
			System.out.println("String 타입 누적합 : " + strSum);
		}
		System.out.println("Arrarys 래퍼 클래스 : "+ Arrays.toString(str));
		System.out.println();
		
	}

}
