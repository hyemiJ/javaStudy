package j03_forWhile;

public class Ex03_infinityLoop {

	public static void main(String[] args) {
		// for의 무한루프
		System.out.println("for 문의 무한루프");
		int count = 0;
		for( ; ; ){
			System.out.println("for의 count"+count++);
			if (count >10) break;
		}
		// 초기식. 조건식 . 증감식이 없으면 무한루프.
		System.out.println();
		//while 의 무한루프
		System.out.println("while 문의 무한루프");
		count =0;
		while (true) {
			System.out.println("for의 count"+count++);
			if (count >10) break;
		}
		//while 의 조건에 ture 가 들어간다면 무한루프.
		//if , break 가 없다면 무한루프
		System.out.println();
		//do while 의 무한루프
		System.out.println("do while 문의 무한루프");
		count = 0;
		do {
			System.out.println("for의 count"+count++);
			if (count >10) break;
		} while (true);
		//while 의 조건에 ture 가 들어간다면 무한루프.
		//if , break 가 없다면 무한루프
		System.out.println();
		
		
		//if문의 무조건 실행
		
		if(true)System.out.println("true");
//		else System.out.println("false");
		
		
	}

}
