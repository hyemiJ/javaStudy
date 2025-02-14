package iocDI02_anno;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


//** @ Annotation 애너테이션 활용방법 *********************

//1. xml 에 context 네임스페이스 추가 [NameSpaces] 이용
//=> Component-scan 설정  : 
//<context:component-scan base-package="d0714.iocEx05" />
//   
//2. 소스코드 
//=> import 확인  : org.springframework.context.support.*;
//=> 생성을 원하는 TV 클래스 위에 @Component("tv") 설정

//=> @Component("tv") 
//  <bean ....> </bean> -> xml
//  new 생성자() -> Java Code

//3.Test : 오류 메시지 확인 하기
//=> @ Test1 생성 -> <bean ... />
//=> @ Test2 id명 미 지정(둘다 beanName 없이) 
//=> ...NoSuchBeanDefinitionException: 
//               No bean named 'tv' is defined ....
//=> @ Test3 id명 중복되는 경우 (둘다 beanName  ("tv") 지정 )  
//=> ...annotation.ConflictingBeanDefinitionException: ....
//   ...non-compatible bean definition of same name and class ...

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

public class TVUser05 {

	public static void main(String[] args) {
        // 1) BeanFactory (스프링컨테이너) 생성
        AbstractApplicationContext sc = new
                GenericXmlApplicationContext("iocDI02_anno/app05.xml");

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
