package iocDI01_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//** 스프링이 제공하는 BeanFactory
//=> 스프링 컨테이너
//=> AbstractApplicationContext 와 GenericXmlApplicationContext 계층도 
//=> Object -> DefaultResourceLoader (C) -> AbstractApplicationContext (A) 
//          -> GenericApplicationContext (C) -> GenericXmlApplicationContext (C) 

//  public abstract class AbstractApplicationContext extends DefaultResourceLoader
//          implements ConfigurableApplicationContext, DisposableBean {....

//  public class GenericXmlApplicationContext extends GenericApplicationContext {...

//=> 컨테이너는 xml (설정화일), @, JavaCode (JavaConfig) 등의 
//   전달사항을 통해 요구하는 클래스를 생성, 보관, 제공

//** xml (설정화일)


public class TVUser02 {

	public static void main(String[] args) {
        // 1) BeanFactory (스프링컨테이너) 생성
        AbstractApplicationContext sc = new
                GenericXmlApplicationContext("iocDI01_xml/app02.xml");
//         => 설정화일(xml구문_요구사항 목록) 을 매개변수로 전달
//         => GenericXmlApplicationContext("app02.xml");
//            xml 문을 "src/main/resources"  에 두면 패키지는 생략가능 
        
        
        // 2) 필요한 객체를 전달받고 Service 실행
//         => Spring 컨테이너는 getBean 메서드를 실행해서 해당객체를 제공
//         => 실시간으로 소스코드 수정없이 전달받음 
		TV tv =(TV)sc.getBean("tv");
		//getBean 의 리턴타입이 object 타입임으로 강제 형변환이 필요.
		if(tv !=null) {
			tv.powerOn();
			tv.powerOff();
			tv.volumeUp();
			tv.volumeDown();
		}else {
			System.out.println("tv 선택을 하지 않았습니다.");
			sc.close();
		}
        // 3) 싱글톤(Singleton) Test
        // => 스프링 프레임웤의 모든 작업은 싱글톤을 기본으로함.
        // => 싱글톤 (한개의 인스턴스만 허용 하는것) 적용 Test
        // => 설정화일의 scope 속성 에 "prototype"_ss / "singleton"_lg (default 는 싱글톤)
        // => 생성자 실행횟수와 아래의 주소값 확인해보기
        //    SsTVi 2개, LgTVi(prototype) 2개 씩 인스턴스 작성 후 확인 
		System.out.println();
		System.out.println("싱글톤(Singleton) Test.");
		
		TV tv1 = (TV)sc.getBean("tv");
		TV tv2 = (TV)sc.getBean("tv");
		System.out.println("싱글톤 테스트 tv1 : "+tv1);
		System.out.println("싱글톤 테스트 tv2 : "+tv2);
		
		System.out.println("TV 교체 ,");
		tv1 = (TV)sc.getBean("tvl");
		tv2 = (TV)sc.getBean("tvl");
		System.out.println("싱글톤 테스트 tv1 : "+tv1);
		System.out.println("싱글톤 테스트 tv2 : "+tv2);
	}

}
