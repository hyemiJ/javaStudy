package j03_forWhile;
//** 반복문 의 3요소 : 반복자의 초기값, 조건식(true or false), 증감식
//=> for : for(초기값; 조건식; 증감식) {.....}
//=> while, do while : 초기값(before while_Loop), 
//                 조건식(true or false => while 조건문), 
//                 증감식(in while_Loop)

//** 반복자(iterator) 
//=> 반복문에서 횟수를 count 하는 변수
public class Ex01_loopBasic {

	public static void main(String[] args) {
		//1부터 100까지 누적합을 구하는 예제
		int startIndex = 1;
		int endIndex = 100;
		int result=0;
		
		for (int i = startIndex ; i <= endIndex; i++) {
			result +=i;
			//result = result + i;
		}
		System.out.println("결과는 :"+result);
		result = 0;
		int i = startIndex;
		while(i <= endIndex) {
			result += i++ ;			
	}
		System.out.println("결과는 :"+result);
		
		//do while
		result = 0;
		i = startIndex;
		do {
			result += i++;
		} while (i <= endIndex);
		System.out.println("결과는 :"+result);
		
		
		
	}
}
