package j06_packageTest;

import java.util.Random;


//lotto 번호 생성기 만들기의 정렬 부분을 메서드로 완성하기.

//메서드명 : lottoSort , static 으로 정의
//6개의 정수가 인자로 받아 정렬.

public class Ex02_CallByRef_Lotto {

	public static void lottoSort(int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]>arr[j]) {
					int tem = arr[i];
					arr[i] = arr[j];
					arr[j] = tem;
				}
			}
		}
	}
	public static void lottoSortReverse(int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i]<arr[j]) {
					int tem = arr[i];
					arr[i] = arr[j];
					arr[j] = tem;
				}
			}
		}
	}
	
	//두 함수를 합쳐서 사용 할 수도 있다.
	public static void lottoSort(int [] arr, String s) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (s=="오름차순" ?arr[i]>arr[j] : arr[i]<arr[j]) {
					int tem = arr[i];
					arr[i] = arr[j];
					arr[j] = tem;
				}
			}
		}
	}
	
	public int[] lottoarr(int arr[]) {
		int lotto[] = arr;
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
		return lotto;
	}
	

	public static void main(String[] args) {
		Ex02_CallByRef_Lotto lotto = new Ex02_CallByRef_Lotto();

		int result[] = lotto.lottoarr(new int [6]);

		System.out.println("=====sort 전====");
		
		for (int i : result) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("=====sort 후==== lottoSort(result);");
		lottoSort(result);
		for (int i : result) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("=====sort 후==== lottoSortReverse(result);");
		lottoSortReverse(result);
		for (int i : result) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("=====sort 후==== lottoSort(result,\"오름차순\");");
		lottoSort(result,"오름차순");
		for (int i : result) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("=====sort 후==== lottoSort(result,\"내림차순\");");
		lottoSort(result,"내림차순");
		for (int i : result) {
			System.out.print(i+" ");
		}
	}

}
