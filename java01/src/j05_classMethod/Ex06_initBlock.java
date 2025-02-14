package j05_classMethod;
//** 맴버 변수 초기화
//=> 선언과 동시에 초기화: 명시적 초기화(explicit initialization) 
//=> 초기화블럭 또는 생성자 (복잡한 경우) 
//
//** 수행순서
//=> 프로그램 로딩-> 클래스초기화블럭 -> main 메서드실행 
//-> 인스턴스 생성 (new) -> 인스턴스초기화 블럭 -> 생성자 실행
// 그러므로 인스턴스 초기화 블럭은 인스턴스 생성시마다 실행 됨

public class Ex06_initBlock {
	
	static int [] arr = new int[10]; //선언만 해놓음.
	static int count = 100; // 선언과 동시에 명시적으로 초기화
	
	String color ; // 선언만 해놓음.
	double num = 123.456; // 선언과 동시에 명시적으로 초기화 
	
	//초기화 블럭을 통해 초기화 할 수 있음.
	// 초기화 하는데 코드가 필요한 경우 작성하는 블럭. 초기화 블럭 내부에는 실행문 작성 가능.
	
	static {
		System.out.println("static의 초기화 블럭===");
		// static 변수 arr 초기화 : random 으로 2자리수 임의의 정수 채우기
		for (int i = 0; i < arr.length; i++) {
			arr[i]=(int)(Math.random()*89+11);
		}
		System.out.print("static의 초기화 블럭 arr : ");
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("static의 초기화 블럭===");
	} // static의 초기화 블럭
	
	{
		System.out.println("instance의 초기화 블럭===");
		color = "blue";
		num = Math.random()*10+1;
		System.out.println("instance 초기화 블럭의 num : "+num);
		count = 12345; //static 변수 까지 사용 가능함을 알 수 있음.
		System.out.println("instance의 초기화 블럭===");
	}// instance 의 초기화 블럭
	
	
	//생성자 메서드 추가
	// 클래스와 이름이 똑같아야함.
	public Ex06_initBlock () {
		System.out.println("생성자 실행");
	}//return 이 올 수 없음. , return의 명시의 타입 또는 void가 오지 않음.
	
	public static void main(String[] args) {
		
		System.out.println("main 메서드의 실행 블럭===");
		System.out.print("main 메서드 실행 블럭 arr : ");
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("인스턴스 생성 전 count : "+count);
		//System.out.println("인스턴스 생성 전 num"+num); //num 은 인스턴스 변수로 접근 불가
		//instance의 초기화 블럭
		Ex06_initBlock ex06 = new Ex06_initBlock(); //인스턴스 생성
		System.out.println("인스턴스 생성 후 count : "+ count);
		System.out.println("인스턴스 생성 후 첫 인스턴스의 num : "+ex06.num);
		Ex06_initBlock ex061 = new Ex06_initBlock(); //두번째 인스턴스 생성
		System.out.println("두번째 인스턴스 생성 후 count : "+ count);
		System.out.println("인스턴스 생성 후 첫 인스턴스의 num : "+ex06.num);
		System.out.println("인스턴스 생성 후 두번째 인스턴스의 num : "+ex061.num);
		System.out.println("main 메서드의 실행 블럭===");
	}

}
