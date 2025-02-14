package aop01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// ** IOC/DI 적용
		// => 스프링컨테이너 생성
		// => 필요한 Bean 을 주입받는다
		
		AbstractApplicationContext sc =
				new GenericXmlApplicationContext("aop01.xml");//스프링 컨테이너 생성
		Programmer programmerB=(Programmer)sc.getBean("boy");// "boy"라는 id를 가진 Bean을 가져와 Programmer 타입의 programmerB 객체에 할당
		Programmer programmerG=(Programmer)sc.getBean("girl");// "girl"이라는 id를 가진 Bean을 가져와 Programmer 타입의 programmerG 객체에 할당
		programmerB.doStudying();
		programmerG.doStudying();//programmerB와 programmerG 객체의 doStudying() 메서드를 호출
		sc.close();//스프링 컨테이너 종료
	} //main

} //class
//이 클래스는 스프링의 의존성 주입을 통해 Programmer 타입의 Bean 객체(boy와 girl)를 주입받고,
//doStudying() 메서드를 실행하여 각각의 프로그래머가 공부하는 동작을 수행
