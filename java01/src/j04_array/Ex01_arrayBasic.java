package j04_array;

import java.util.Arrays;

public class Ex01_arrayBasic {
	public static void main(String[] args) {
		//배열의 필요성
		//과제 : 학생들의 성적을 처리하자.
		
		int s1 = 90, s2 = 80, s3 = 40 , s4 = 79 , s5 = 12;
		int sum = s1+s2+s3+s4+s5;
		double avg = (double)sum/5;
		
		//예를 들어 학생수가 방대하다면 처리를 어떻게 할까 ? => 배열의 필요성
		//동일한 특성을 가진 자료들을 하나의 묶음으로 처리할 수 있다.
		
		//1) 명시적 선언 (new 연산자 사용)
		int[] score1 = new int[5];
		int score2[] = new int[5];
		
		int score[] ; //변수명만 먼저 정의.
		int len = 5;
		//배열을 사용전에 크기를 명시.
		score = new int [len];// 크기 정의.
		score[0]=11;
		score[1]=14;
		score[2]=21;
		score[3]=41;
		score[4]=54;
		//score[0]="11"; 타입이 맞지 않은 컴파일 오류
		//score[5]=55; // 컴파일 오류(문법상의 오류)는 아니지만 런타임 오류가 발생.(Index 5 out of bounds for length 5)
		
		sum=0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		System.out.println("score 는  "+score+", score의 길이는 "+score.length);
		System.out.println("score 배열의 합계는 "+sum);
		System.out.println("Arrays 의 래퍼클래스 활용 :  "+Arrays.toString(score));
		
		
        // ** eachFor (쉬운, 간편한 for 구문)
        // for each 문 : JDK5.0 부터 지원되는 향상된 for 문 
        // for (변수타입 변수명 : 배열이름 ) { 실행부  }
        // => 배열의 요소의 갯수(배열의 크기) 만큼 반복 하며
        //    배열  score 가 가지고 있는 값을 순차적으로  변수(s) 에 전달 
        // => 주의사항
        //    배열의 값만 순차적으로 사용가능하며 read만 가능. write 불가능
        //    (순차처리, readOnly)
        sum=0;
        for (int s : score) {
			System.out.println(s);
			sum+=s;
			System.out.println("순차합계"+sum);
		}
        System.out.println();
        //묵시적 선언(선언과 동시에 초기화)
        System.out.println("묵시적 선언");
        
        char[] grade = {'A' , 'B', 'C' , 'D' , 'E'}; 
        //배열을 표기하는것은 [] 이지만 , 데이터를 표현하기위해서는 {}를 사용한다.
        for (char c : grade) {
			System.out.println(c);
		}
		//gade의 크기 출력, Arrays.toString 사용
		System.out.println("grade의 크기 : "+grade.length);
		System.out.println("grade 의 래퍼클래스 활용 :  "+Arrays.toString(grade));
		
	}
}
