package j03_forWhile;

import java.util.Random;
import java.util.Scanner;

public class Ex04_randomGame2 {

	public static void main(String[] args) {
		//랜덤게임 -> 금메달이 될때까지 무한루프를 만들것.
		Scanner sc = new Scanner(System.in);
		int count = 0;
		Random random = new Random();
		int happynumber = random.nextInt(10)+1;
//		int newnumber = null;
		while (true) {
			System.out.println("1~10까지의 수를 입력하세요");
			int newnumber = Integer.parseInt(sc.nextLine());
			switch (Math.abs(happynumber-newnumber)) {
			case 0:
				System.out.println("금메달 종료 !" );
				break;
			case 1:
				System.out.println("은메달 다시도전 !" );
				break;
			case 2:
				System.out.println("동메달 다시도전 !" );
				break;
			default:
				System.out.println("꽝 다시도전 !" );
				break;
			}
			count++;
			if(Math.abs(happynumber-newnumber)==0) {
				System.out.printf("도전횟수 %d ,  성공을 축하드립니다",count);
				break;
			}
		}

	}

}
