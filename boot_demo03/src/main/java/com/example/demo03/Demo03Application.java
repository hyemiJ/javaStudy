package com.example.demo03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
// 자동설정으로 기본적으로 작동하는 springSecurity 를 제외시켜줌
@MapperScan("mapperInterface")
public class Demo03Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo03Application.class, args);
	}

}
