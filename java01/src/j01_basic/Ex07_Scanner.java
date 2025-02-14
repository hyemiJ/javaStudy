package j01_basic;

import java.util.Scanner;

public class Ex07_Scanner {

	public static void main(String[] args) {
		//==============================scanner정의 (생성)
		Scanner sc = new Scanner(System.in);
		//String name = new String("홍길동")과 구문이 같지만 우리는 생략하고 쓴다..
		// 기능의 클래스이기 때문에 생성자가 꼭 필요.
		System.out.println("이름을 입력하세요");
		//입력된 값을 문자열로 저장
		String name = sc.nextLine(); //nextLine(string) 과 nextInt(int) 를 많이 사용.
		//입력 완료할때까지 대기함 (입력완료 : Enter키)
		//입력 완료 되면 , 입력된 값을 return.
		System.out.println("나이를 입력하세요");
		//		int age = sc.nextInt();
		// => 변환불가 Data 입력시 : java.lang.NumberFormatException
        
		int age = Integer.parseInt(sc.nextLine());
		// => 다른 타입 입력시: java.util.InputMismatchException 
		
		
		System.out.println("주소를 입력하세요");
		String addr = sc.nextLine();
		System.out.println("키를 입력하세요");
		double height =Double.parseDouble(sc.nextLine());
		
		System.out.println("이름 :"+name);
		System.out.println("나이 :"+age);
		System.out.println("주소 :"+addr);
		System.out.println("키 :"+height);
		
		sc.close();
	}

}
