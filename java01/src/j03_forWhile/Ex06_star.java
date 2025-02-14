package j03_forWhile;


public class Ex06_star {
	public static void main(String[] args) {
		//================================== 별찍기
		
		//반 삼각형
		//*을 1개씩 시작해서 , 갯수를 늘려나가는 9라인까지 출력.
		System.out.println("반 삼각형");
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		//삼각형
		//* 중심을 맞춰 찍어야함.
		System.out.println("삼각형");
		int endPoint = 9;
		int centerPoint = (endPoint+1)/2;
		for (int i = 1; i <= centerPoint; i++) {
			for (int space = i; space < centerPoint; space++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
//		// 2) 피라미드(삼각형)
//		// => 9행(마지막행), 9컬럼
//		int line = 5;
//		System.out.println("** 2) 피라미드(삼각형) **");
//		for (int i=1; i<=line; i++) {
//		// => 반복문1: space
//		for (int j=1; j<=line-i; j++) {
//		System.out.print(" ");
//		}
//		// => 반복문2: *
//		for (int j=1; j<=(i*2-1); j++) {
//		System.out.print("*");
//		}
//		System.out.println("");
//
//		} //for_i
		
		
		System.out.println();
		

		
		//마름모 삼각형
		System.out.println("마름모 삼각형");
		endPoint= 9;
		int star = 1;
		for (int i = 1; i <= endPoint; i++) {
			if (i>centerPoint) {
				for (int space = 0; space < i-centerPoint+1; space++) {
					System.out.print(" ");
				}				
				
			}else {
				for (int space = 0; space <= centerPoint-i; space++) {
					System.out.print(" ");
				}			
			}
			for (int j = 1; j <= star;j++) {
				System.out.print("*");
			}
			if (i>=centerPoint) {
				star-=2 ;
			}else {
				star+=2 ;
			}
			System.out.println();
		}
//		// 3) 다이아몬드
//		for (int i=1; i<=line; i++) {
//		//=> 반복문1: space
//		for (int j=1; j<=line-i; j++) {
//		System.out.print(" ");
//		}
//		//=> 반복문2: * 
//		for (int j=1; j<=(i*2-1); j++) {
//		System.out.print("*");
//		}
//		System.out.println("");
//		} //for_i
//
//		// => 하부출력
//		// => 총 그리는 line 갯수(위의 line-1=4) ~ 1 까지 감소 
//		for (int i=line-1; i>=1; i--) {
//		//=> 반복문1: space
//		for (int j=1; j<=line-i; j++) {
//		System.out.print(" ");
//		}
//		//=> 반복문2: *
//		for (int j=1; j<=(i*2-1); j++) {
//		System.out.print("*");
//		}
//		System.out.println("");
//		}
		
		//모래시계
		System.out.println("모래시계형");
		star = 9;
		endPoint = 9;
		for (int i = 1; i <= endPoint; i++) {
			if (i<=centerPoint) {
				for (int space = 0; space < i; space++) {
					System.out.print(" ");
				}				
				
			}else {
				for (int space = 0; space <= endPoint-i; space++) {
					System.out.print(" ");
				}			
			}
			for (int j = 1; j <= star;j++) {
				System.out.print("*");
			}
			if (i<centerPoint) {
				star-=2 ;
			}else {
				star+=2 ;
			}
			System.out.println();
			
//			// 4) 모래시계
//			//=> 다이아몬드를 반대로 출력
//			System.out.println("\n** 4) 모래시계 **");
//			//=> 상부
//			for ( i=line; i>=1; i--) {
//			//=> 반복문1: space
//			for (int j=1; j<=line-i; j++) {
//			System.out.print(" ");
//			}
//			//=> 반복문2: *
//			for (int j=1; j<=(i*2-1); j++) {
//			System.out.print("*");
//			}
//			System.out.println("");
//			}
//
//			//=>하부
//			for ( i=2; i<=line; i++) {
//			//=> 반복문1: space
//			for (int j=1; j<=line-i; j++) {
//			System.out.print(" ");
//			}
//			//=> 반복문2: * 
//			for (int j=1; j<=(i*2-1); j++) {
//			System.out.print("*");
//			}
//			System.out.println("");
//			} //for_i
		}
		
	}
}
