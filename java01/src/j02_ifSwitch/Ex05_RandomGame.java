package j02_ifSwitch;

import java.util.Random;
import java.util.Scanner;

//** 숫자 맞추기 게임
//=> 1~10 범위에서 숫자 하나를 입력받아
//=> Random 클래스의 추출번호 와 일치하면 금메달
//=> 차이가 1 이면 은메달, 차이가 2면 동메달, 아니면 꽝
//=> Math 클래스를 이용하세요 ~~
public class Ex05_RandomGame { // 교재 348p
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//당첨번호 정하기 -> 임의의 수를 추출하는 메서드 (Random(클래스) / Math.Random(Math의 메서드))
		Random random = new Random();
		
		//Math.random은  실수형으로 나옴 
		int happynumber = (int)(Math.random()*10)+1;
		//int happynumber = random.nextInt(10)+1; // ()인자로는 최대값 + 뒤에는 최소값 사이의 임의 정수를 제공.
		System.out.println("1~10의 수를 입력하세요");
		int mynumber = Integer.parseInt(scanner.nextLine());
//		int result ;
//		result = (happynumber>mynumber ? happynumber - mynumber : mynumber-happynumber);
//		switch (result) {
		switch (Math.abs(mynumber-happynumber)) { // 절대값을 나오게 하는 Math 의 메서드 abs
		case 0:
			System.out.println("금메달");
			break;
		case 1:
			System.out.println("은메달");
			break;
		case 2:
			System.out.println("동메달");
			break;
		default:
			System.out.println("꽝");
			break;
		}
		System.out.printf("입력번호는 %d , 당첨번호는 %d , 절대값 차는 %d", mynumber , happynumber , Math.abs(happynumber-mynumber));
		
		
		scanner.close();
	}

}
