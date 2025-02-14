package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//** WebMvcConfigurer
//=> 스프링의 자동설정에 원하는 설정을 추가 설정할수있는 메서드들을 제공하는 인터페이스. 
//=> 스프링부트 컨트롤러 매핑메서드에서는 "/" 무시됨 -> addViewControllers 메서드로 해결 (boot3 부터는 "/" 지원됨) 
//=> CORS 방침 설정 -> addCorsMappings()

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	// => boot3 부터는 없어도 지원되지만 참고용 
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//WebMvcConfigurer.super.addViewControllers(registry);
		registry.addViewController("/").setViewName("redirect:/home");
	}
	
	//** React_Boot Project CORS 방침 설정 *****************************
	private final long MAX_AGE_SECS = 3600; //단위: 초
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 모든 경로에 대해 적용
		registry.addMapping("/**") //애플리케이션의 모든 엔드포인트에 대한 CORS매핑추가
				.allowedOrigins("Http://localhost:3000")
				.allowedMethods("*")
				//.allowedMethods("GET","POST","PUT","PATCH","DELETE","OPTIONS")
				// => CORS정책상 접근 가능한 origin인지 확인하기 위해 preflight를 보내는데, 이때 메소드가 'OPTION' 이므로 반드시 추가	
				//.allowedHeaders("*")
				.allowCredentials(true)
				// => credentials true와 origins "*" 값은 공존할 수 없음(그러므로 origins 속성값은 구체적으로 명시함) 
				.maxAge(MAX_AGE_SECS);
	} //addCorsMappings

} //class