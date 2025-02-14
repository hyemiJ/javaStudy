package j04_array;

import java.util.Arrays;

public class Ex03_multiArray {

	public static void main(String[] args) {
		//** 다차원 배열
		//1차원 배열이 2개 모이면 2차원 배열
		//1차원 배열이 3개 모이면 3차원 배열 ...2차원 이상은 거의 안쓰임
		
		//1) 명시적 정의
		int [][] mul = new int[2][3];
		// mul = { {10, 20, 30} , { 11 , 22 , 33} } 1차원 배열(길이가 3인 배열)이 2개 있다.
		mul[0][0] = 10;
		mul[0][1] = 20;
		mul[0][2] = 30;
		
		mul[1][0] = 11;
		mul[1][1] = 22;
		System.out.println(mul[1][2]); //결과 : 0
		// 값을 할당 하지 않으면 , 디폴트값이 0 이 들어가 있음.
		mul[1][2] = 33; 
		
		mul[0][2] = mul[0][0]+mul[0][2] ;
		//배열의 각 값을 더해서 저장할 수 도 있음.
		
		for (int i = 0; i < mul.length; i++) {
			for (int j = 0; j < mul[i].length; j++) {
				System.out.printf("mul [%d , %d] = %d %n" , i , j , mul[i][j] );
			}
		} //배열의 값 출력
		
		//2)묵시적 정의
		//명시적으로 배열의 크기를 정하지 않았기 때문에 , 각각의 크기를 가질 수 있음.
		//(크기 지정과 동시에 값 지정.)
		int [][]mul2 = {{100, 200, 300}, {111, 222} , {777}};
		
		for (int i = 0; i < mul2.length; i++) {
			for (int j = 0; j < mul2[i].length; j++) {
				System.out.printf("mul2 [%d , %d] = %d %n" , i , j , mul2[i][j] );
			}
		} 
		for(int[] i: mul2) {
            for(int j:i) {
                System.out.println(j);
            }
        }
		   System.out.println(Arrays.deepToString(mul2));  //결과 : [[100, 200, 300], [111, 222], [777]]
	}

}
