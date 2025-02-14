package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // baseEntity를 위한 설정 추가(자동 감지 리스너를 작동시킴)
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
//자동설정으로 기본적으로 작동하는 springSecurity 를 제외시켜줌
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
