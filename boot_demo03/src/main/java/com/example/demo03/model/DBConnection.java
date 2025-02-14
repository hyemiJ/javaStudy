package com.example.demo03.model;

import java.sql.Connection;
import java.sql.DriverManager;

//** DB 연결
//=> Connection 객체가 DB 연결및 연결정보를 관리함
//   즉, Connection 객체를 생성해야함

//** Connection 객체 생성
//=> 일반적인 생성문 
//    Connection cn = new Connection_구현클래스() -> XXX
//=> DB 연결정보를이용해서 생성후 그 생성값을 전달받음   

//** Connection 생성과정
//=> Class.forName : JDBC 드라이버 로딩
//=> DriverManager
//    getConnection() 메서드로 해당 JDBC 드라이버를 찾아 필요한 기본값으로 컨넥션을 생성해서 제공

//** JDBC 드라이버
//=> DBMS와 통신을 담당하는 자바 클래스
//    DBMS 별로 알맞은 JDBC 드라이버 필요
//    보통 jar 파일로 제공

//** DriverManager
//=> JDK(Java SE Development Kit)의 정적 클래스이며,
//    사용할 애플리케이션에 대해 사용가능한 JDBC(Java Database Connectivity) 드라이버 세트를 관리함.

public class DBConnection {
	public static Connection getConection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버를 찾음. => 드라이버를 못찾으면 오류 발생
			// => Connector mysql-connector-j-8.1.0.jar 내에서 "com.mysql.cj.jdbc.Driver" 를 찾음
            //    그러므로 실행전에 프로젝트에 ~.jar 연동  
			
			String url = "jdbc:mysql://@127.0.0.1:3306/mydb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true"; 
			Connection cn = DriverManager.getConnection(url, "root", "mysql") ;//url,user,password // portNo 가 틀리면 오류 url , 계정 틀리면 오류.
			System.out.println("JDBC connection 성공");
			return cn;
		} catch (Exception e) {
			System.out.println("JDBC connection Exception "+ e.toString()); // 오류발생
			return null;
		}
		
	}// 커넥션 제공 메서드 getConection()
	
	
	
}



