package j03_forWhile;

import java.util.Iterator;

//** Continue 
//=> Continue 문 이하의 구문을 실행하지 않고 다음 반복문 진행

//** Break
//=> 반복문 탈출

//** Label
//=> continue, break 가 적용될 반복문을 지정할 수 있도록 해줌
//=> 위치를 표시함
//   반드시 ":" 표시,
//   반드시 반복문 바로 위에 위치함.
//   -> Lable 다음에 반복문외의 문장이 오면 break, continue 에서 인식안됨 오류
public class Ex05_continueBreak {
	//** 과제
	//=> 5층건물, 1개층에 7개의 방이 있을때
	//=> 1) [1층, 1호] 형식으로 모두 출력하기
//	    [1,1] [1,2] [1,3]....[1,7]
//	    [2,1] [2,2] .........[2,7]
//	     ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
//	    [5,1] [5,2] .........[5,7]

	//=> 2) 4층 4호는 창고 이므로 출력하지않음.

	//=> 3) 3층은 방이 5개 입니다.
	public static void main(String[] args) {
		//모두 출력
		System.out.println("모두 출력하기");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.printf("[ %d , %d ] ",i , j);
			}
			System.out.println();
		}
		System.out.println();
		//4층 4호 창고 출력 막기
		System.out.println("4층 4호 창고 출력 막기");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 7; j++) {
				if (i ==4 && j ==4) continue;
				System.out.printf("[ %d , %d ] ",i , j);
			}
			System.out.println();
		}
		System.out.println();
		//3층 방은 5개
		System.out.println("4층 4호 창고 출력 막기+3층 방은 5개");
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 7; j++) {
				if (i ==4 && j ==4 ) continue;
				if(i ==3 && j>5 ) break;
				System.out.printf("[ %d , %d ] ",i , j);
			}
			System.out.println();
		}
		System.out.println();
		
		
		System.out.println("라벨이용");
		isLable:
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 7; j++) {
				if (i ==4 && j ==4 ) {
					System.out.println();//3)2를 건너뛰기 때문에 3을 추가
					continue isLable; //1)[4,3] 까지 출력후 i=5로 진행됨
				}
				if(i ==3 && j>5 ) break isLable ;
				System.out.printf("[ %d , %d ] ",i , j);
			}
			System.out.println(); //2) 이부분도 건너뛰게 되어버림.
		}
		System.out.println();
	}
}
