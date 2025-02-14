package iocDI03_jc;
//** Java Bean Configuration class를 이용한 DI
//=> Bean 컨테이너 : AnnotationConfigApplicationContext 사용
//              매개변수로 Java_config_class 를 사용 (JavaConfig01.class)           
//=> Test01 : 스피커 없는 TV
//** Java Bean Configuration class를 이용한 DI
//** Test01 : 스피커 없는 TV 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//** @Configuration 
//=> 해당 클래스가 스프링의 설정파일로 사용됨을 지정
//   이 클래스는 final이  아니어야 하며
//   파라미터 없는 기본생성자를 반드시 제공 해야 함

//** @Bean 과 메서드 이름으로 스프링 컨테이너가 사용할 빈 객체를 설정
//=> @Bean : 컨테이너가 생성하도록 해줌
//=> 메서드명 : BeanName (id) 으로 사용됨
//=> User Class 에서 getBean("BeanName") 에 사용됨

//** 비교
//  <bean id="tv" class="iocDI03_jc.SsTvi" />
//=> new 연산자로 직접 생성함.
//   싱글톤을 기본으로 함

//** Test1) : JC 만사용
//** Test2) : JC 에서 xml 과 병행사용
//** Test3) : JC 에서 xml, User클래스의 @ 병행사용
//** Test4) : xml 에서 JC, User클래스의 @ 병행사용

@Configuration
public class JavaConfig01 {
	
	@Bean
	public TV tv() {
		return new SsTVi();
	}
	
	@Bean
	public TV tvl() {
		return new LgTVi();
	}
	
}//class





