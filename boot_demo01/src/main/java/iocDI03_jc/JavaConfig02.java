package iocDI03_jc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//** Java Bean Configuration class를 이용한 DI
//=> Test02 : 스피커 1개 사용 TV 
//	-> 생성자를 이용한 주입,
//	-> JC에서 xml 병행사용

//** JC 에서 xml 병행 사용하기 
//=> @ImportResource("iocDI03_jc/app09.xml")
//=> AiTVs 생성은 xml 로 

@ImportResource("iocDI03_jc/app09.xml")
@Configuration
public class JavaConfig02 {
	//1) 고전적 방법 (직접 new : 소스 재컴파일)
	@Bean
	// => 컨테이너에 의해 메서드가 실행되어 생성된 인스턴스가 컨테이너에 return
	public TV sstv() { return new SsTVs(); }
	
	//2) IOC/DI: 생성자 주입
	@Bean
	public TV lgtv() {
		//return new LgTVs(new Speaker(), "Blue", 9988000 );
		return new LgTVs(sp(), "Blue", 9988000 );
	}
	//@Bean
	// => xml 과 동시에 동일 id로 생성하면 싱글턴 적용으로 인스턴스는 1개만 생성
	//    그러나 xml 에서 id 없이 생성하면 별개로 취급 양쪽 모두 생성  
	//    그렇게 되면 @Autowired 에서 명시적으로 하지 않으면 오류 발생
	public Speaker sp() { return new Speaker(); }
	
	//3) IOC/DI: JC 에서 xml 병행 사용
	// => jc 에서 생성후 Speaker는 @Autowired 
	// => Speaker 를 jc 로 생성후 @Bean 의 적용에 따라 다른 결과
	@Bean
	public TV aitv() { return new AiTVs(); }
	

} //class
