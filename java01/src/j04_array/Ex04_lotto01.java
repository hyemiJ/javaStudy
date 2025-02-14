package j04_array;

import java.util.Arrays;
import java.util.Random;


public class Ex04_lotto01 {
	public static void main(String[] args) {
		
		// ** Lotto 번호 생성기 만들기 1
		//=> int 를 6개 담을 수 있는 배열 생성 : lotto
		//=> Random 으로 1~45 범위의 숫자를 생성해서 배열 초기화 하기
		//   (** 추가: 단, 중복은 허용하지 않음)
		//=> 출력
		int lotto[] = new int[6];
		Random random = new Random();
		int maxNumber =  1; // 최대값의 초기값은 1
		int minNumber = 45; // 최소값의 초기값은 45
		for (int i = 0; i < lotto.length; ) {
			boolean bool = true;
			int randomNumber = random.nextInt(45)+1;
			
			for (int j : lotto) {
				bool = randomNumber !=j; //같지 않아야 true , 같으면 false 
				if (!bool) break; //false 일때 멈추고 다시 진행되야함.
			}
			
			if (bool) { // 전부 같지 않아서 true 가 떨어진다면 실행할 실행문
				lotto[i] = randomNumber ; 
//				maxNumber = Math.max(maxNumber, randomNumber); //Math의 max 메서드
//				minNumber = Math.min(minNumber, randomNumber); //Math의 min 메서드
				if(maxNumber<randomNumber) {
					maxNumber = randomNumber;
				}else {
					minNumber = randomNumber;
				}
				i++;
			}
		}

		System.out.println(Arrays.toString(lotto));
		System.out.printf("최대값 %d , 최소값 %d %n", maxNumber,minNumber);
		Arrays.sort(lotto);
		System.out.println("sort (int) : "+Arrays.toString(lotto));
		
	     
//	    // 1) 배열 정의
//	    int[] lotto = new int[6];
//
//	    // 2) Random으로 숫자 추출 & 배열에 담기
//	    Random rn = new Random();
//
//	    for (int i = 0; i < lotto.length; i++) {
//	        int num = rn.nextInt(45) + 1; // 1~45 범위의 숫자 생성
//	        // 중복 확인 후 배열에 담기
//	        if (!isDuplicate(lotto, num)) {
//	            lotto[i] = num;
//	        } else {
//	            i--; // 중복이면 다시 시도
//	        }
//	    }
//
//	    // 3) 출력
//	    System.out.println("Lotto Numbers: " + Arrays.toString(lotto));
//
//	    // 4) 최대값 & 최소값 출력
//	    Arrays.sort(lotto);
//	    System.out.println("Minimum Value: " + lotto[0]);
//	    System.out.println("Maximum Value: " + lotto[lotto.length - 1]);
//	   
//	    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//	    // 배열 내 중복 확인 메서드
//	    public static boolean isDuplicate(int[] array, int num) {
//	        for (int value : array) {
//	            if (value == num) {
//	                return true;
//	            }
//	        }
//	        return false;
//	    }
	}
}
