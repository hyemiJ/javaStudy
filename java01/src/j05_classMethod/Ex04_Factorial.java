package j05_classMethod;

class Ex04_Factorial {
//	** 재귀적 호출 ( Recursive Call )
//	=> 메서드가 메서드 내부에서 자신을 호출
//	=> Factorial 연산에 주로 이용됨 
//	=> 5! = 5*4*3*2*1
//	   n! = n*(n-1)*(n-1-1)*(n-1-1-1)...*1 
	
	//nonStatic
	public int  factorial01(int n) {
		if (n==1) return 1;
		System.out.println("nonStatic ) n :"+ n);
		return n*factorial01(n-1);
	}// Ex04_Factorial은 noneStatic / factorial01은 nonStatic의 메서드 , noneStatic 은 곧 Instance 를 의미.
	
	//static
	public static int factorial02(int n) {
		if (n==1) return 1;
		System.out.println("static ) n :"+ n);
		return n*factorial02(n-1);
	}
	
	//메서드 내부에서 자기자신의 메서드를 호출 : 재귀적 호출  (Recursive Call)
	public static void main(String[] args) {
		
		Ex04_Factorial factorialtest = new Ex04_Factorial(); //noneStatic 임으로 인스턴스 생성후 사용할 수 있음.
		//noneStatic
		System.out.println("nonStatic , factorialtest.factorial01(5) : "+factorialtest.factorial01(5));
		
		//static
		System.out.println("static , factorialtest.factorial02(5) : "+factorialtest.factorial02(5));
		
	}
}
