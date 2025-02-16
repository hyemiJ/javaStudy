package aop04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// ** IOC/DI 적용
		// => 스프링컨테이너 생성
		// => 필요한 Bean 을 주입받는다
		
		AbstractApplicationContext sc =
				new GenericXmlApplicationContext("aop04.xml");
		Programmer programmerB=(Programmer)sc.getBean("boy");
		Programmer programmerG=(Programmer)sc.getBean("girl");
		
		try {
			System.out.println("** Boy Test **");
			System.out.println("* Boy 결과 => "+programmerB.doStudying(20));
			System.out.println("\n** Girl Test **");
			System.out.println("* Girl 결과 => "+programmerG.doStudying(30));
		} catch (Exception e) {
			System.out.println("\n** main Exception => "+e.toString());
		}
		sc.close();

	} //main

} //class
