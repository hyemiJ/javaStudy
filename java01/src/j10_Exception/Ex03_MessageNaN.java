package j10_Exception;

public class Ex03_MessageNaN {
	public static void main(String[] args) {

		try {
			double d1 = 1.5 / 0.0; //Infinity 무한수
			double d2 = 1.5 % 0.0; //NaN 
			
			System.out.printf("try , 실수 d1 = %f , d2 = %f , d1 * 100 = %f %n" , d1 , d2 , d1 * 100);
			if(Double.isInfinite(d1) || Double.isNaN(d2)) {
				System.out.println("isInfinite , isNaN ");
				//throw new Exception();
			}
			//System.out.printf("try , 정수 100/ 0 = %d , 100%0 = %d %n" ,100/0 , 100%0);
		} catch (Exception e) {
			System.out.println("catch , Exception(toString) : "+e.toString() );
			//System.out.println("catch , Exception(getMessage) : "+e.getMessage() );
			//System.out.println("catch , Exception(printStackTrace) : " );
			//e.printStackTrace();
		}finally {
			System.out.println("finally , 무조건실행 " );
		}
		System.out.println("program 종료");

	}
}
