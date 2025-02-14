package j02_ifSwitch;

import java.util.Scanner;

//** switch - case - break 문
//1. => switch(key) 문 인자의 Type은 int, char, String 만 가능
//2. => break : 무조건 탈출 (없으면 아래로 계속 default 까지 진행)
//3. => case 블럭에 구문이 없어도 됨 (아래 구문으로 진행됨)
//4. => case 블럭에는 복합구문에도 {....} 사용하지 않음 
//5. => case 값으로 변수 사용은 불가 그러나 변수를 사용하지 않은 수식은 허용

//** if ~ else if 와 비교 
//=> switch 가 더 효율적 ( direct 분기하므로 )   

public class Ex03_SwitchBasic {

	public static void main(String[] args) {
		//scanner. 활용
		//1)) (int)번호에 따른 메뉴 출력 
		//( ex) 1-> 회원가입 / 2-> 로그인 / 3-> 게시판 / 4 -> 짝수 홀수 알려주기(숫자입력 다시받기) / 이외의 숫자는 오류 처리하기)
		
		
		//1. scanner 생성.
		Scanner scanner = new Scanner(System.in);
		System.out.println("번호를 입력하세요");
		//2. 입력받고 처리할 로직 필요.
		int number = Integer.parseInt(scanner.nextLine());
		
		switch (number) {
		case 1:
			System.out.println("회원가입");
			break;
		case 2:
			System.out.println("로그인");
			break;
		case 3:
			System.out.println("게시판");
			break;
		case 4:
			System.out.println("숫자를 입력해 주세요");
			int num = Integer.parseInt(scanner.nextLine());
			if(num%2==0) {
				System.out.println("짝수입니다");
			}
			else {
				System.out.println("홀수입니다");
			}
			break;

		default:
			System.out.println("번호 오류 입니다.");
			break;
		}
		
		//2)) char 타입 받기
		System.out.println("직업코드를 입력하세요(알파벳 1개)");
		char code = scanner.nextLine().toUpperCase().charAt(0); // string 을 char 로 형변환을 위한 메서드로 charAt 을 이용.
		
		switch (code) {
		case 'A':
			System.out.println("예술가");
			break;
		case 'B':
			System.out.println("회사원");
			break;
		case 'C':
			System.out.println("요리사");
			break;

		default:
			System.out.println("학생");
			break;
		}
		//3)) String 타입 받기 예술가 인 경우 컬러를 입력받아 출력해보자.
		
		if (code =='A') {
			System.out.println("색을 영어로 입력하세요");
			String color = scanner.nextLine().toLowerCase();
			switch (color) {
			case "red":
				System.out.println("빨강");
				break;
			case "green":
				System.out.println("초록");
				break;
			case "pink":
				System.out.println("분홍");
				break;

			default:
				System.out.println("색깔입력완료");
				break;
			}
		}
		scanner.close();
		
	}

}
