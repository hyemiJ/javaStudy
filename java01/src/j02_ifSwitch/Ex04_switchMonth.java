package j02_ifSwitch;

import java.util.Scanner;

//** 실습과제 
//1. 월을 입력 받아서 (Scanner 사용)
//2. 몇일까지 인지,  
//  => 1,3,5,7,8,10,12월 => ?월은 31일 까지 입니다.
//  => 4,6,9,11 월 => ?월은 30일 까지 입니다.
//  => 2 월 => ?월은 28일 (2023년도기준) 까지 입니다.
//3. 무슨 계절인지 출력 하기
//   => 3~5:봄 , 6~8:여름, 9~11:가을, 12~2:겨울

//** switch case 구문으로 작성 하세요 ~~
public class Ex04_switchMonth {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 월 입니까 ?");
		int month = Integer.parseInt(sc.nextLine());
		int day ;
		String season = null ; // 숫자형이 아닌경우 초기화를 하지 않으면 , 컴파일 오류가 발생.
		// 컴파일 오류를 방지하기 위해 초기화 값으로 null 을 지정
		
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		case 2:
			day = 28;
			break;
		default:
			day = 31;
			break;
		}
		
		if (month>=3 && month <6) {
			season = "봄";
		}
		if (month>=6 && month <9) {
			season = "여름";
		}
		if (month>=9 && month <12) {
			season = "가을";
		}
		if (month==12 || month <3) {
			season = "겨울";
		}
		System.out.printf("%d월은 %d일 까지 있고 ,  계절은 %s 입니다. %n", month , day , season );
		sc.close();
	}

}
