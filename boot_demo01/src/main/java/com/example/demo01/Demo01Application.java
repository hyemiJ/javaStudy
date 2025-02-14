package com.example.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//** @SpringBootApplication
//=> 해당 클래스가 Springboot의 설정 클래스임을 명시하며
//   해당 클래스를 메인으로 실행됨
//=> 해당 클래스가 있는 Package를 기본 Package로 간주함
//   그러므로 같은 Package 내의 클래스들은 Scan 됨.
//  ( 즉, @ComponentScan 을 이미 포함하고 있음 ) 
//=> 소스코드 내부를 보면 다양한 @들을 내포하여 기본동작을 실행하고 자동설정한다

@SpringBootApplication
public class Demo01Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo01Application.class, args);
	}

}
