package j08_abstractInterFace;

//** 캡슐화(Encapsulation)
//1. 은닉 (보호) : 접근 제어자를 이용
//=> 외부로부터 데이터를 보호하고,
// 내부적으로만 사용되는 부분은 감추어 준다 
//=> 접근 제어자
//  -> private(class) < default(package) <  protected(package+상속) < public(project)
//
//2. 단위 기능 모듈화
//=> 세분화 되어있는 모듈을 하나의 기능으로 처리할 수 있도록 묶어준다.
//=> 종합 감기약 처럼 
//=> 세분화 되어있는 모듈을 사용하면서 호출 순서에 따른 오류 등
// 발생가능한 논리적 오류를 예방하고, 생산성 및 유지보수 에 유리     

//** 실습
//=> 감기 증상 : 두통, 콧물, 몸살
class HeadacheCap {
	void take() {
		System.out.println("두통 해결 ! class ) HeadacheCap");
	}
}
class SinivelCap {
	void take() {
		System.out.println("콧물 해결 ! class ) SinivelCap");
	}
}
class BodyPainCap {
	void take() {
		System.out.println("몸살 해결 ! class ) BodyPainCap");
	}
}

//환자 발생 1 : BadCase Encapsulation
//증상 별로 복용 순서에 따라 복용.
//세분화 되어있는 모듈을 직접 사용 하는 경우 해당.

class ColdPatient{
	void takeHead(HeadacheCap hcap) {
		hcap.take();
	}
	void takeSinivel(SinivelCap scap) {
		scap.take();
	}
	void takeBodyPain(BodyPainCap bodycap) {
		bodycap.take();
	}
}
//순서를 정리하여 차이 보기.
class TotalCap{
	//필요한 인스턴스를 멤버변수로 정의 
	HeadacheCap hcap = new HeadacheCap();
	SinivelCap scap = new SinivelCap();
	BodyPainCap bodycap = new BodyPainCap();
	
	//복용 순서대로 미리 정의.
	void take() {
		hcap.take();
		scap.take();
		bodycap.take();
	}
}

class NewPatient{
	void takeTotal(TotalCap tCap) {
		tCap.take();
	}
}


public class Ex07_Encapsulation {
	public static void main(String[] args) {
//         1) 환자발생1 (BadCase Encapsulation) 
//         => 인스턴스 생성, 메서드 호출
//         => 단점: 메서드 호출 순서의 오류발생가능성
//                   논리적 호출순서가 아래처럼 정해져있는 기능이라면
//                 오류 발생 가능성 있음
//                   ( Head -> Sinivel -> BodyPain )
//         => 컴파일오류(확인가능) -> 런타임오류(확인가능) 
//            -> 논리적오류(Local Error, 확인어려움) : 이러한 오류 확률이 높아짐 
		ColdPatient cp = new ColdPatient();
		cp.takeBodyPain(new BodyPainCap());
		cp.takeSinivel(new SinivelCap());
		cp.takeHead(new HeadacheCap());
		
		System.out.println();
		NewPatient np = new NewPatient();
		np.takeTotal(new TotalCap());
	}
}
