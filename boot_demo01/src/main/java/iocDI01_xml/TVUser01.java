package iocDI01_xml;

//** Test1. 절차지향
class SsTV {
	public void turnOn() { System.out.println("~~ SsTV turnOn ~~"); }
	public void turnOff() { System.out.println("~~ SsTV turnOff ~~"); }
	public void soundUp() { System.out.println("~~ SsTV soundUp ~~"); }
	public void soundDown() { System.out.println("~~ SsTV soundDown ~~"); }
} //SsTV
class LgTV {
	public void powerOn() { System.out.println("~~ LgTV powerOn ~~"); }
	public void powerOff() { System.out.println("~~ LgTV powerOff ~~"); }
	public void volumeUp() { System.out.println("~~ LgTV volumeUp ~~"); }
	public void volumeDown() { System.out.println("~~ LgTV volumeDown ~~"); }
} //LgTV

//** Test2. 객체지향: 다형성적용
//=> interface, 강제적인 규칙 부여가능 (메서드명 통일)
interface TV {
	void powerOn();
	void powerOff();
	void volumeUp();
	void volumeDown();
} //interface

class SsTVi implements TV {
	public SsTVi() { System.out.println("~~ SsTVi 기본 생성자 ~~"); }
	@Override
	public void powerOff() { System.out.println("~~ SsTVi powerOn ~~"); }
	@Override
	public void powerOn() { System.out.println("~~ SsTVi powerOff ~~"); }
	@Override
	public void volumeDown() { System.out.println("~~ SsTVi volumeUp ~~"); }
	@Override
	public void volumeUp() { System.out.println("~~ SsTVi volumeDown ~~"); }
} //SsTVi
class LgTVi implements TV {
	public LgTVi() { System.out.println("~~ LgTVi 기본 생성자 ~~"); }
	@Override
	public void powerOff() { System.out.println("~~ LgTVi powerOn ~~"); }
	@Override
	public void powerOn() { System.out.println("~~ LgTVi powerOff ~~"); }
	@Override
	public void volumeDown() { System.out.println("~~ LgTVi volumeUp ~~"); }
	@Override
	public void volumeUp() { System.out.println("~~ LgTVi volumeDown ~~"); }
} //LgTVi

//** Test3. Factory 패턴 (IOC/DI 입문)
//=> getBean 메서드의 매개변수로 요청을 전달
class BeanFactory {
	public TV getBean(String tv) {
		if (tv!=null && tv.equals("ss")) return new SsTVi();
		else if (tv!=null && tv.equals("lg")) return new LgTVi();
		else return null;
	} //getBean
} //BeanFactory

public class TVUser01 {

	public static void main(String[] args) {
		// Test1. 절차지향
		// => TV 교체 필요 : 완전재작성
		System.out.println("** Test1. 절차지향 **");
		/*SsTV tv = new SsTV();
		tv.turnOn();
		tv.soundDown();
		tv.soundUp();
		tv.turnOff();
		*/
		LgTV tv = new LgTV();
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
		
		// Test2. 객체지향
		// => 기본특징: 캡슐화, 상속, 추상, 다형성(*)
		// => 다형성적용
		// 	-> 관련성이 없는 두객체를 하나의 인터페이스로 묶어줌, 규칙성 부여
		//	-> 인터페이스에 정의된 메서드만 사용했다는 의미 (그러므로 교체가능)
		//	-> TV 교체 필요 : 우측의 클래스만 교체 (단, 소스코드수정-재컴파일 이 필요함)	
		System.out.println("\n** Test2. 객체지향 **");
		TV tvi = new LgTVi(); // SsTVi(), LgTVi()
		tvi.powerOn();
		tvi.volumeDown();
		tvi.volumeUp();
		tvi.powerOff();
		
		// Test3. 소스코드 수정없이 실시간 객체 교체
		// => 객체를 생성해서 교체해줄 역할자가 필요 : Factory 패턴 (IOC/DI 입문)
		// => user 클래스의 요구사항(필요한 클래스, 의존성_Dependency) 을 Factory 에게 전달하는방법
		// => 3가지 : xml, @, JavaConfig (JavaCode)
		System.out.println("\n** Test3. Factory 패턴 (IOC/DI 입문) **");
		BeanFactory bf = new BeanFactory();
		TV tvf = bf.getBean(args[0]);
		if (tvf!=null) {
			tvf.powerOn();
			tvf.volumeDown();
			tvf.volumeUp();
			tvf.powerOff();
		}else  System.out.println("** TV 선택 오류 **");

	} //main

} //class