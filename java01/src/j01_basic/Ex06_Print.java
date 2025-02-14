package j01_basic;

import java.util.Date;

public class Ex06_Print {

	public static void main(String[] args) {
		//==================================== ** Escape 문자 : 역할이 정해져 있는 문자
       // => \n 줄바꿈, \t 탭간격, ...    
        
		//경로 출력과 사용
		
		String path ="C:\\MTest\\myWork\\java01\\src\\j01_basic"; 
        //Escape 문자가 두개 씩 들어간 이유 : 역할이 정해져 있어서 오류가 생길 수 있기 때문에 
        //경로는 이렇게 표시하자 자바 내 약속됨.(역할성의 Escape 문자로 사용되지 않음을 표시하기 위한 \\)
       System.out.println("path :"+path);
       //결과 : path :C:\MTest\myWork\java01\src\j01_basic
        
       
       //"KOREA"  따옴표를 포함한 출력
       System.out.println("따옴표를 포함한 출력 :" +"\"KOREA\",'KOREA' ");
       //큰따옴표는 Escape 적용 , 작은 따옴표는 Escape 사용하지 않아도 인정.
       //결과 : 따옴표를 포함한 출력 :"KOREA",'KOREA' 
       System.out.println("Escape t 를 이용한 출력 : abc\tcde\t123\t456");
       System.out.println("\n");
       System.out.println('\n'); //한 문자만 출력하는 경우 작은 따옴표 허용
       System.out.println('\''); //char ' 출력
       System.out.println('A'); 
       System.out.println('가'); 
       
        // ===================================** print, println, printf
       // => 출력형식
       // % : 출력형식을 의미하는 문자열은 반드시 %로 시작,
       System.out.print("print 줄바꿈 적용X");
       System.out.println("(println)");
       System.out.print("print+Escape n : 줄바꿈 적용O \n");
       System.out.print("print+Escape t +Escape n : 간격 적용+줄바꿈 적용\t간격\t간격 \n");
       System.out.println(); // 줄바꿈의 용도
       System.out.printf("반지름이 %d인 원의 넓이 는 %10.2f 입니다. \n", 10, 10*10*Math.PI); 
        
        // ====================================** 날짜출력
        // => java.util.Date 
        // => import
       System.out.println();
       Date now = new Date();
//       java.util.Date now = new java.util.Date();
       System.out.println(now);
       System.out.printf("오늘의 날짜는 %tY년 %tm월 %td일 ",now ,now , now);
       System.out.println();

        // %d : 정수 , %f 실수, %s 문자 
        // %,d : 정수에 3자리마다  , 표시 
        // %t : 날짜 시간  
        // %n , \n : 줄바꿈
        // $ 사용하면 매개변수의 갯수를 줄일 수 있음
        // => %2$d : 2번째 매개변수 정수
       //날짜 표시 (tY / tm / td)
       System.out.printf("오늘의 날짜는 %tY년 %1$tm월 %1$td일",now );
       System.out.println();
       //요일 표시(tA)
       System.out.printf("오늘의 날짜는 %tY년 %1$tm월 %1$td일, %1$tA 입니다",now );
       System.out.println();
       //시간 표시 (tH / tM / tS)
       System.out.printf("지금 시간은 %tH시 %1$tM분 %1$tS초",now );
       System.out.println();
       
       
        // -는 왼쪽 정렬방식
       System.out.printf("**(12345의 자리 정렬 방식) 10d = %1$10d , 20d = %1$20d  -20d =%1$-20d 확인하세요 %n",123456789 );
       System.out.println("양수는 우측정렬의 의미 , 음수는 좌측정렬의 의미");

	}

}
