package j04_array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;


public class Ex05_lotto02 {
	public static void main(String[] args) {
		// ** Lotto 번호 생성기 만들기 2
		//정렬 알고리즘
		int lotto[] = new int[6];
		Random random = new Random();
		//Random random = new Random(5); << 아래와 동일한 상수값을 주면 동일한 결과값이 나오게 됨.
		int maxNumber =  1; // 최대값의 초기값은 1
		int minNumber = 45; // 최소값의 초기값은 45
		for (int i = 0; i < lotto.length; ) {
			boolean bool = true;
			int randomNumber = random.nextInt(45)+1;
			
			for (int j : lotto) {
				bool = randomNumber !=j; //같지 않아야 true , 같으면 false 
				if (randomNumber==j) break; //false 일때 멈추고 다시 진행되야함.
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
		//일반 출력 결과
		System.out.println("정렬 전 : "+Arrays.toString(lotto));
		System.out.printf("최대값 %d , 최소값 %d %n", maxNumber,minNumber);
		
		//정렬 출력 (오름차순)
        // 4) 오름차순 정렬
        // => 순차정렬 (Sequence Sort)
        // => 정렬 알고리즘에서 가장 간단하고 기본이 되는 알고리즘으로
        //    배열의 처음과 끝을 탐색하면서 차순대로 정렬하는 가장 기초적인 정렬 알고리즘
        // ** 정렬 알고리즘 : 삽입(insert)정렬, 합병(Merge)정렬, 퀵(Quick)정렬...
        // => https://blog.naver.com/tepet/221690306235 
		minNumber = 45;
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i+1 ; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int tem = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tem;
				}
			}
		}
		// 정렬 후 
		System.out.println("정렬 후 : "+Arrays.toString(lotto));
		
		// ** 배열 Wrapper Class: Arrays
		// => Arrays 의 주요 메서드 : equals(null, null), sort(null)
		
		//my Number 생성 후 비교 하기.
		random = new Random();
		int myNumber [] = new int[6];
		for (int i = 0; i < myNumber.length; i++) {
			 myNumber[i] = random.nextInt(45)+1;
			for (int j = 0; j < i; j++) {
				if (myNumber[i]==myNumber[j]) {
					--i; break;
				}
				
			}
		}
		Arrays.sort(myNumber);
		System.out.println("정렬 된 :"+Arrays.toString(myNumber));
		
		if (Arrays.equals(lotto, myNumber)) {
			System.out.println("당첨 !");
		}else {
			System.out.println("다시 도전 !");
		}
		
		//*** Random 클래스
//		=> java.util 에 있으므로 import 필요하고, new 선언후 사용가능함.
//		=> Random() : 호출시마다 현재시간을 이용한 종자값이 자동 설정됨 
//		 Random(long seed) : 인자값으로 주어진 종자값이 설정됨 
//		 종자값 : 난수 만드는 알고리즘에서 사용되는 값
//		            ( 같으면 같은난수 얻음, setSeed() )
//		
//		=> Random().nextInt(큰수 - 작은수 + 1) + 작은수 
//		 Random().nextInt() , Random().nextLong() , Random().nextBoolean()
//		 Random().nextDouble() , Random().nextFloat()

		
		//**배열 활용 (섞기 Shuffle)
		//=> 길이가 10인 배열 정의 하고, 0~9 로 초기화
		//=> random 을 이용해서 배열의 임의의 위치에 있는 배열의 값과
		//   배열의 첫번째(0) 값과 교환하는일을 100번 반복해서 배열을 
		//   뒤섞이도록 한후, 출력하기.
		//=> 교재 139p 
		
		int card [] = { 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 };
		Random random3 = new Random();
		for (int i = 0; i < 100; i++) {
			int randomCardNumber = random3.nextInt(9)+1; //1~9 사이 범위 , //random3.nextInt(10); 0~9 사이 범위
			int tem = card[0];
			card[0] =card[randomCardNumber];
			card[randomCardNumber] = tem;
			
			System.out.println(Arrays.toString(card)+ (i+1)+" 회째");

		}
	}
}
