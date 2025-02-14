package j05_classMethod;

import com.sun.net.httpserver.Authenticator.Result;

//** static, instance(non_static) 비교
// * static (클래스종속)
// * => static 키워드를 붙이게 되면, 변수 또는 메서드가, 해당 클래스 수준에 속하게 됨.
// * => static 변수는 해당 클래스 수준에서 전역변수와 유사하게 동작하게 됨
// * => 클래스 로드 시 한번 할당되고, 모든 인스턴스가 static 변수를 공유하게 됨.
// * 
// * instance(non_static, 인스턴스종속)
// * => 따로 키워드를 붙이지 않고 사용하면 instance로 사용하게 되고, 객체 또는 인스턴스 수준에 속하게 됨.
// * => instance 변수는 객체 또는 인스턴스 수준에서 지역 변수(인스턴스에 종속적)로 동작함
// * => 각 인스턴스가 고유한 값을 가지므로, 한 인스턴스에서 변경해도 다른 인스턴스에 영향 주지 않음.
// * 
// * ** 호출규칙
// * => static 메서드: static 만, 인스턴스없이 호출가능 
// * => instance 메서드: static, instance(non_static) 모두 인스턴스없이 호출가능 


// 4칙 연산 계산기
public class Ex05_static {
	//멤버 변수 정의
	int result ;
	int instanceTotal ;
	static int staticTotal ;
	
	//멤버 메서드 정의
	//static 메서드
	public static int staticAdd(int i , int j , Ex05_static ex05) {
		//result = i+j; //  인스턴스 없이는 접근 불가.
		staticTotal += i+j; //인스턴스 없이 접근 가능
		
		//인스턴스 멤버에 접근(인스턴스가 필요하다.)
		ex05.instanceTotal = i+j;
		return i + j ;
	}
	//static 메서드
	public static int staticMin(int i , int j , Ex05_static ex05 ) {
		staticTotal += ( i - j );
		ex05.instanceTotal += ( i - j );
		return i - j;
	}
	//instance 메서드
	//인스턴스 메서드에서는 static 멤버변수와 noneStatic 멤버변수에 인스턴스없이 접근 가능.
	public int instanceMulti(int i , int j) {
		result = i * j;
		staticTotal +=result;
		instanceTotal += result;
		return i * j;
	}
	
	public int instanceDiv(int i , int j) {
		result = i / j;
		staticTotal +=result;
		instanceTotal += result;
		return i / j;
	}
	public static void main(String[] args) {
		//인스턴스 멤버(변수와메서드)에 접근하기위한 인스턴스 
		//2개의 인스턴스를 사용하여 비교해보자.
		Ex05_static ex051 = new Ex05_static();

		
		//1 ) static Call
		System.out.println("staticAdd(10, 3, ex051) add :"+staticAdd(10, 3, ex051));
		System.out.println("static 변수 )staticTotal : "+staticTotal);
		System.out.println("instance 변수 )instanceTotal : "+ex051.instanceTotal);
		//System.out.println(ex051.staticMin(10, 3, ex052)); //static을 static 하게 사용하라.
		//ex051.min(10, 3 , ex051) => 접근 경고 : 인스턴스 없이 메서드명만 사용 (동일 클래스의 static 멤버인 경우)
		//클래스명.멤버명(다른 클래스의 static 멤버인 경우)
		System.out.println("staticMin(10, 3 ,ex051) min :"+staticMin(10, 3 ,ex051));
		System.out.println("static 변수 )staticTotal : "+staticTotal);
		System.out.println("instance 변수 )instanceTotal : "+ex051.instanceTotal);
		System.out.println();
		//2) instance Call
		System.out.println("instance Call test");
		System.out.println("ex051.instanceMulti(10, 2) Multi :"+ex051.instanceMulti(10, 2));
		System.out.println("ex051.instanceDiv(10, 2) Div :"+ex051.instanceDiv(10, 2));
		
		System.out.println();
		//두번째 인스턴스
		Ex05_static ex052 = new Ex05_static();
		System.out.println("=====static 변수와 instance 변수 차이점===== ");
		System.out.println("static 변수 )staticTotal : "+staticTotal);
		System.out.println("instance 변수 )instanceTotal : "+ex052.instanceTotal);
		System.out.println("========메서드 사용======== ");
		System.out.println("staticAdd(10, 3, ex052) add :"+staticAdd(10, 3, ex052));
		System.out.println("=====메서드 사용후 결과===== ");
		System.out.println("static 변수 )staticTotal : "+staticTotal);
		System.out.println("instance 변수 )instanceTotal : "+ex052.instanceTotal);
		
	}
}
