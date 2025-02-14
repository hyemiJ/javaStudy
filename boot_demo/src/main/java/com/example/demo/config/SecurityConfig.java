package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.jwtToken.JwtAuthenticationFilter;

//** Spring_Boot Security
//=> 로그인 : Authentication(인증)
//=> API 사용권한 부여 : Authirization(인가)

//** Spring_Boot Security 인증 설정화일
//=> React Project 사용시 인증 설정에 사용됨
//=> React Project의 API 서버는 Ajax로 호출되기 때문에
//	 기존의 페이지 요청과는 다른점이 있고 이를위한 설정이 필요함.
//	-> CORS 설정
//	-> 스프링 시큐리티는 Get방식 이외의 호출시에는
//	   CSRF공격 방어를 위한 설정이 기본으로 활성화되어있으므로 이에대한 변경 필요함 
//	-> 아래 filterChain() 메서드 참고

//** @EnableWebSecurity
//=> SpringBoot Auto Configuration @들 중의 하나이며, 손쉽게 Security 설정을 할수있도록해줌.
//	 그러므로 설정파일을 의미하는 @Configuration 은 없어도 됨
//   ( SpringBoot3 부터는 반드시 넣어야함. )
//=> 스프링 시큐리티를 활성화하고 웹 보안 설정을 구성하는 데 사용됨.
//	 스프링 시큐리티의 필터 체인이 동작하여 요청을 인가하고 인증하도록 함.

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// 1) Filter 등록
		//http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class); 
		// => CorsFilter 사용하지 않으므로 변경함
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		// 2) HttpSecurity 빌더 설정 & return
		// => Boot3 부터는 빌더패턴 적용안되고 람다식만 적용됨
		return http.httpBasic(httpBasic -> httpBasic.disable()) // HTTP 기본 인증 비활성화
		        .formLogin(formLogin -> formLogin.disable()) // formLogin 비활성화
		        .logout(logout -> logout.disable()) // logout 비활성화
		        .csrf(csrf -> csrf.disable()) // CSRF 비활성화
		        .cors(cors -> {}) // CORS설정 활성화(기본값)_필수항목
		        .sessionManagement(session -> session
		            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 세션 비활성화 (무상태)
		        /*
		        => authorizeHttpRequests()
		        	-> HTTP 요청에 대한 인가 설정을 구성하는 데 사용됨.
		        	-> 다양한 인가 규칙을 정의할수 있으며, 경로별로 다른 권한 설정이 가능.
		         */  
		        .authorizeHttpRequests(auth -> auth
		        	//.requestMatchers(new AntPathRequestMatcher("/auth/memberlist")).hasRole("ADMIN")	
		        	//.requestMatchers("/auth/memberlist").hasAuthority("ROLE_ADMIN")
		        	.requestMatchers("/auth/memberlist").hasRole("ADMIN") 
			        .requestMatchers("/user/boardlist").hasRole("MANAGER")	
		        	.requestMatchers("/auth/userdetail","/auth/logout").hasRole("USER") 
		        	.requestMatchers(HttpMethod.OPTIONS ,"/**").permitAll()
		            //.anyRequest().authenticated()) // 모든 요청 인증 필요
		        	.anyRequest().permitAll())
		        .build();
	} //filterChain
}