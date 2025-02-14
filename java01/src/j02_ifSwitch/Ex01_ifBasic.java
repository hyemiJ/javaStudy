package j02_ifSwitch;

public class Ex01_ifBasic {

	public static void main(String[] args) {
		//=====================================삼항식
		boolean rain = true; // 지역변수
		String result =(rain ==true) ? "study java" : "그럼에도 불구하고 study";
		
		//if 의 단일 구문
		//else 구문은 생략 가능하고 , 필요시에만 사용하면 됨.
		if(rain) result="study java";
		else result="그럼에도 불구하고 study";
		
		//if의 복합 구문(compound Statement)
		//여러문장을 정의하는 경우 , 중괄호를 사용.
		rain = true; // main의 지역변수
		if (rain) {
			int i = 100; // if 구문에 종속된 지역변수.(정의된 블럭 내에서만 유효함)
			System.out.println("비가 오면 ?");
			System.out.println(result);
			System.out.println("if의 지역변수 i  :"+ i);
		}else {
			//System.out.println("if의 지역변수 i  :"+ i); // i는 사용 불가 지역.컴파일 에러.
		}
		//if 의 복합 조건식
		// 날씨가 좋고 공휴일이면 공원에 산책을 간다.
		//아니면 집에서 요리를 한다
		//rain은 false, day가 "red"이면
		String day = "Red";
		if(!rain&&(day=="Red")) {
			System.out.println("공원에 산책을 간다");
		}else {
			System.out.println("집에서 요리를 한다");
		}
		
		if (!rain) {
			if (day=="Red") {
				System.out.println("비가 안오는 공휴일");
			}else {
				System.out.println("비가 안오는 평일");
			}
		}else {
			System.out.println("비가 오는 모든날");
		}
		
		
	}

}
