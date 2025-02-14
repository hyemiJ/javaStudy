package j10_Exception;
//** UnChecked Exception throws Test  
//=> RunTimeException 하의 ~~ : UnChecked Exception 
//=> java 의 컴파일러가 Exception 처리 확인하지 않음
// 즉, 반드시 try ~ catch 구문 을 적용하지 않아도 됨.
// 그러나 필요시엔 throws 로 처리 가능  
//=> 주로 프로그래머의 실수로 발생 가능한 오류들
//=> 상위의 메서드에서도 Exception 처리가 의무조항은 아님
// 즉, 반드시 try ~ catch 구문 구현 하지 않아도 컴파일 오류 없음.






public class Ex05_uncheckedThrows {
	//unchecked Exception 은 throws 했어도 call 한 메서드 내의 try-catch 구현은 의무가 아님

	public static void intByZero() throws ArithmeticException{
		int i = 10/0;
	}
	public static void arrayIndex() throws ArrayIndexOutOfBoundsException{
		int arr[] =new int[3];
		arr[3] =100;
	}

	//계속 상위로의 위임도 가능하다.
	//public static void callTest() {
	//public static void callTest() throws Exception{
	public static void callTest() throws ArithmeticException,ArrayIndexOutOfBoundsException{
		intByZero();
		arrayIndex();
	}

	public static void nullPointer() throws NullPointerException {
		String name = null;
		int i = name.length();
	}

	public static void classCast() throws ClassCastException {
		Object obj = new int [5];
		String s = (String)obj;
	}
	//ClassNotFoundException : checked Exception
	public static void classNot() throws ClassNotFoundException {
		//public static void classNot(){ //checked Exception 이기 때문에 컴파일 오류 발생
		Class<?> ccc = Class.forName("j10_Exception.Ex01_BasicException");
		System.out.println(ccc.getName());
	}

	//     ** ClassNotFoundException -> Checked Exception
	//     ** Class 라는 클래스
	//     => JVM에서 동작할 클래스들의 정보를 묘사하는 일종의 메타 클래스(Meta-Class)
	//        클래스의 이름, 멤버 필드와 메소드, 클래스 종류 등의 정보
	//     => forName() 메소드에 의해 반환된 Class 클래스의 인스턴스에는 "클래스명"의 정보가 담겨 있음.
	//        아래 클래스명을 없는것과 있는것 번갈아 적용해본다

	public static void main(String[] args) {
		System.out.println("program 시작");
		//unchecked Test call
		try {
			//classCast();
			//callTest();			
			nullPointer();
		} catch (NullPointerException e) {
			System.out.println("catch block ,unchecked Test call , NullPointerException(toString) : "+e.toString() );
		} catch (ClassCastException e) {
			System.out.println("catch block ,unchecked Test call , ClassCastException(toString) : "+e.toString() );
		}catch (Exception e) {
			System.out.println("catch block ,unchecked Test call , Exception(toString) : "+e.toString() );
		}
		System.out.println();
		//checked Test call
		try {
			classNot();			
		} catch (Exception e) {
			System.out.println("catch block ,checked Test call , Exception(toString) : "+e.toString() );
		}

		System.out.println("program 종료");
	}

}
