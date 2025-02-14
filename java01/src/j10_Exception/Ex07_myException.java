package j10_Exception;

import java.util.Scanner;

//Age Exception 생성
// unchecked 로 결정 -> RuntimeException
// age의 값이 범위를 벗어난다면 오류 발생.
//1 .unchecked Exception
class AgeException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public AgeException() {
		super("unchecked , 나이 값이 범위를 벗어남");
	}
	public AgeException(String s) {
		super(s);
	}
}
//2. checked Exception
class AgeExceptionck extends Exception {
	private static final long serialVersionUID = 1L;
	public AgeExceptionck() {
		super("checked,나이 값이 범위를 벗어남");
	}
	public AgeExceptionck(String s) {
		super(s);
	}
}
class myException extends Exception{
	private static final long serialVersionUID = 1L;
	 public myException() {
		super("myException ,범위 초과");
	}
}


public class Ex07_myException {
	
	static Scanner sc = new Scanner(System.in);

	//1 .unchecked Exception
	public static int readAge() {
		System.out.println("unchecked 나이를 입력하세요");
		int age =Integer.parseInt(sc.nextLine());
		if(age <19 || age> 50) throw new AgeException();
		return age;
	}
	//2. checked Exception
	public static int readAgeck() throws AgeExceptionck{
		System.out.println("checked 나이를 입력하세요");
		int age =Integer.parseInt(sc.nextLine());
		if(age <19 || age> 50) throw new AgeExceptionck("점심 뭐먹지 ?");
		return age;
	}
	
	public static void main(String[] args) {
		
		//readAge();
		try {
			readAgeck();
		}catch (AgeExceptionck e) {
			System.out.println("main -> AgeExceptionck :"+e.toString());
		}catch (Exception e) {
			System.out.println("main -> Exception :"+e.toString());
		}
		
		
		
		
		
		
		
		 Scanner sci = new Scanner(System.in);
		int result=0;
		while (result<50) {
			System.out.println("1~9까지의 숫자를 입력하세요 합이 50이 되면 종료");
			try {				
				int i = Integer.parseInt(sc.nextLine());
				result += i;
				if(i <1 || i >9) {
					throw new myException();
				}
				System.out.println("result = "+result);
			} catch (myException e) {
				System.out.println(e.toString() );
			}
		}
		sci.close();
		sc.close();
		System.out.println("program 종료");
	}
}
