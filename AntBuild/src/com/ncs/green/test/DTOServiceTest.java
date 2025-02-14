package com.ncs.green.test;

import com.ncs.green.domain.UserDTO;
import com.ncs.green.service.DTOService;
/*

*** 애플리케이션 빌드(Build)
=> 소스코드파일을 실행가능한 독립(standalone) 소프트웨어로 변환하는 과정 또는 그에 대한 결과물
=> 프로젝트 소스코드의 java 코드와 프로젝트 내에 필요한 각종 xml, properties, jar 파일등을
   JVM이나 WAS가 인식할 수 있도록 패키징 해주는 과정이며 이를 도와주는 도구를 "빌드 관리 도구" 라함.

1. 애플리케이션 빌드(Build) & 배포의  수행 절차 4단계
	=> 1단계 : 배포 환경 구성하기
	=> 2단계 : 소스 검증하기
	=> 3단계 : 빌드 하기
	=> 4단계 : 배포 하기

2. 빌드 & 배포 툴
=> 빌드 자동화를 위한 툴은 언어마다 매우 다양
	Java는 Ant, Maven 을 주로 사용하고,
	여러가지 언어의 빌드 환경을 구성할 수 있는 오픈소스인 Gradle 도 많이 사용.
	Gradle 도 나온지는 오래됐지만, 구글이 안드로이드의 기본 빌드시스템으로 채택하면서 사용자가 급증하게됨.

=> Maven 과 Gradle 의 간단한 비교
	-> gardle의 장점은 은 maven 보다 빠른 성능과 간결한 설정을 들 수 있다.
	-> maven 의 단점을 보완한 최신 툴이고, 계속해서 많은 버전 업그레이드를 진행하고 있어서 사용자가 늘어남.
	-> gradle 의 빌드 스크립트는 groovy 라는 언어로 작성해야 하므로 
		maven 의 xml 에 비하면 친숙하진 않지만 확장성이 뛰어나다.
	-> maven은 프로젝트가 커질수록 빌드 스크립트의 내용이 길어지고 가독성이 떨어지는 반면,
		gradle은 훨씬 적은 양의 스크립트로 짧고 간결하게 작성할 수 있다.
		그러므로 gradle은 멀티프로젝트에 적합하며, 빌드속도는 다양한 시나리오상에서 10~100배 가량이 빠르다.

3. 배포 파일 형식
=> jar ( java archive _ archive  기록, 보관소)
	하나의 application 기능이 동작가능하도록 java파일 등을 압축하고 지원해줌.
	path 등의 경로를 유지하기 때문에 배포된 jar파일 사용시 각 파일들의 path 문제에서 벗어날 수 있음.
 
=> war ( web archive )
	jar와 달리 웹 어플리케이션을 지원하기 위한 압축방식.
	웹 어플리케이션을 지원하기 위해서 jsp, servlet, gif, html, jar 등
	웹 어플리케이션의 구성요소들을 하나로 묶어 압축하고 지원해주며
	jar와 같이 servlet context 접근을 위해 관련된 모든 파일들의 path를 유지해줌.

=> ear ( enterprise archive )
	하나의 웹 어플리케이션 단위를 넘어 실제 서버에서 배포하기 위한 단위.
	이를 위해서 jar와 war를 묶어서 각각의 기능을 지원해줌.
	즉 jar는 어플리케이션 레벨, war는 웹 어플리케이션 레벨 을 지원하도록 하는것.

*/

public class DTOServiceTest {

	public static void main(String[] args) {
		// 1) UserDTO 생성
		UserDTO dto = new UserDTO();
		dto.setId("banana");
		dto.setName("홍길동");
		dto.setLoginTime("2023/02/22 AM 10:04:04");
		
		// 2) 직접 출력
		System.out.println("** 직접 출력 => "+dto);
		
		// 3) DTOService 로 출력 
		DTOService service = new DTOService();
		service.setUserDTO(dto);
		System.out.println("** AntBuild Test **");
		System.out.println("** DTOService => "+service.getUserDTO());
		
	} //main

} //class
