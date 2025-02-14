package j03_forWhile;


//반복문의 중첩
//if 와의 중첩
//for 의 for 중첩
public class Ex02_multLoop {
	public static void main(String[] args) {
		//if와의 중첩
		//1~100까지의 정수중 3의 배수의 합을 구하는 예제
		
		//for + if(for 에서 1씩 증가)
		int result = 0;
		for (int i = 3; i <= 100; i++) {
			if (i %3 ==0) {
				result += i;
			}
		}
		System.out.println("결과는 : "+ result);
		
		//for + if ( for에서 3씩 증가.)
		result =0;
		for (int i = 3; i <= 100; i+=3) {
			if (i %3 ==0) {
				result += i;
			}
		}
		System.out.println("결과는 : "+ result);
		
		//for + for 
		//5층 건물, 1개 층에서 7개의 방이 있다.
		//[1층 , 1호] 형식으로 출력
		 for (int x = 1; x <= 5; x++) {
			for (int y = 1;y <=7; y++) {
				System.out.printf("[ %d 층 , %d 호 ] ", x , y);
			}
			System.out.println();
		}
		
		
		
		
	}
}
