package iocDI03_jc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
//** Java Bean Configuration class를 이용한 DI
//=> Bean 컨테이너 : AnnotationConfigApplicationContext 사용
//              매개변수로 Java_config_class 를 사용 (JavaConfig01.class)           
//=> Test01 : 스피커 없는 TV
//=> interface, 강제적인 규칙 부여가능 (메서드명 통일)
interface TV {
	void powerOn();
	void powerOff();
	void volumeUp();
	void volumeDown();
} //interface

//@Component("tvs")
class SsTVi implements TV {
	public SsTVi() { System.out.println("🐻🐻 SsTVi 기본 생성자 🐻🐻"); }
	@Override
	public void powerOff() { System.out.println("🐻🐻 SsTVi powerOn 🐻🐻"); }
	@Override
	public void powerOn() { System.out.println("🐻🐻 SsTVi powerOff 🐻🐻"); }
	@Override
	public void volumeDown() { System.out.println("🐻🐻 SsTVi volumeUp 🐻🐻"); }
	@Override
	public void volumeUp() { System.out.println("🐻🐻 SsTVi volumeDown 🐻🐻"); }
} //SsTVi

//@Component("tv")
class LgTVi implements TV {
	public LgTVi() { System.out.println("🐇🐇 LgTVi 기본 생성자 🐇🐇"); }
	@Override
	public void powerOff() { System.out.println("🐇🐇 LgTVi powerOn 🐇🐇"); }
	@Override
	public void powerOn() { System.out.println("🐇🐇 LgTVi powerOff 🐇🐇"); }
	@Override
	public void volumeDown() { System.out.println("🐇🐇 LgTVi volumeUp 🐇🐇"); }
	@Override
	public void volumeUp() { System.out.println("🐇🐇 LgTVi volumeDown 🐇🐇"); }
} //LgTVi

public class TVUser08 {

	public static void main(String[] args) {
        // 1) BeanFactory (스프링컨테이너) 생성
        AbstractApplicationContext sc = new
                AnnotationConfigApplicationContext(JavaConfig01.class);

        // 2) 필요한 객체를 전달받고 Service 실행
 
		TV tv =(TV)sc.getBean("tv");
		
		if(tv !=null) {
			tv.powerOn();
			tv.powerOff();
			tv.volumeUp();
			tv.volumeDown();
		}else {
			System.out.println("tv 선택을 하지 않았습니다.");
			sc.close();
		}

		System.out.println("정상 종료 되었습니다.");

	}

}
