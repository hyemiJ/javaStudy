package com.example.demo03.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
//import lombok.extern.log4j.Log4j2;

//** IOC/DI 적용 ( @Component 의 세분화 ) 
//=> 스프링 프레임워크에서는 클래스들을 기능별로 분류하기위해 @ 을 추가함.
//=> @Controller
//  -> 사용자 요청을 제어하는 Controller 클래스
//  -> DispatcherServlet이 해당 객체를 Controller객체로 인식하게해줌.     
//  -> interface Controller 의 구현의무 없어짐
//  -> 이로인해 메서드 handleRequest() 의 오버라이딩 의무 없어짐
//  -> 이로인해 메서드명, 매개변수, 리턴타입(ModelAndView, String, void 중 선택) 에 자유로워짐
//  -> 그리고 클래스 와 메서드 단위 매핑이 가능한 @RequestMapping 사용가능
//  -> 그러므로 하나의 컨트롤러 클래스에 여러개의 매핑메서드의 구현이 가능해짐
//  -> 그래서 주로 테이블(엔티티) 단위로 작성함 ( MemberController.java )

//=>  @Service : 비즈니스로직을 담당하는 Service 클래스
//=>  @Repository : DB 연동을 담당하는 DAO 클래스
//             DB 연동과정에서 발생하는 예외를 변환 해주는 기능 추가 

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
=> 스프링 제공 interface 인 Controller 구현한 컨트롤러클래스
(이 구현을 통해 스프링디스패쳐서블릿이 컨트롤러로 인식함)   
public class C01_mList implements Controller {
  
  @Autowired(required = false)
  MemberService service; 
  // IOC/DI 적용, 자동주입, 이미생성되어있어야 함 
  
  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
      // Member List
      //MemberService service = new MemberService();
      ModelAndView mv = new ModelAndView();
      mv.addObject("banana", service.selectList());
      mv.setViewName("member/memberList");
      return mv;
  } // 리턴 타입이 무조건 ModelAndView 타입만 가능함.
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

//** Model & ModelAndView **

//=> Model(interface)
//-> controller처리 후 데이터(Model) 을 담아서 반환 
//-> 구현클래스 : ConcurrentModel, ExtendedModelMap 등.
//-> 아래의 매핑 메서드들 처럼, ModelAndView 보다 심플한 코드작성 가능하므로 많이사용됨. 
//mv.setViewName("~~~~~") 하지않고 viewName 을 return 

//=> ModelAndView (class)
//-> controller처리 후 데이터(Model) 와 viewName 을 담아서 반환
//-> Object -> ModelAndView
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//** Logger 로그메세지

//** Lombok 지원 로그메시지  
//=> @Log4j Test
//  -> dependency 필요함 (pom.xml 확인)
//  -> 로깅레벨 단계 준수함 ( log4j.xml 의 아래 logger Tag 의 level 확인)
//      TRACE > DEBUG > INFO > WARN > ERROR > FATAL(치명적인)
//      <logger name="com.ncs.spring02">
//          <level value="info" />
//      </logger>    

//  -> Logger 사용과의 차이점 : "{}" 지원안됨 , 호출명 log
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//** Locale : (사건등의 현장), 다국어 지원 설정을 지원하는 클래스
//=> locale 값을 받아서 현재 설정된 언어를 알려줌 -> 한글 메시지 출력 가능

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//** Logger : 현재 위치상태를 보여줘서 에러 위치를 잡을수 있게 해 줄 수 있는 코드
//=> 로깅레벨 단계
//TRACE > DEBUG > INFO > WARN > ERROR > FATAL(치명적인)
//TRACE: Debug보다 좀더 상세한 정보를 나타냄
//DEBUG: 애플리케이션의 내부 실행 상황을 추적하기 위한 상세 정보 출력
//      ( Mybatis 의 SQL Log 확인 가능 )
//INFO : 상태변경과 같은 주요 실행 정보 메시지를 나타냄
//WARN : 잠재적인 위험(에러)를 안고 있는 상태일 때 출력 (경고성 메시지)
//ERROR: 오류가 발생했지만, 애플리케이션은 계속 실행할 수 있을 때 출력
//FATAL: 애플리케이션을 중지해야 할 심각한 에러가 발생 했을 때 출력
//=> 기본값은 INFO 레벨, 필요시 DEBUG, TRACE 레벨로 낮출 수있음 
// ( application.properties 에서 조정가능 )



//@Log4j2
@Controller
public class HomeController {	
	//** Logger 로그메세지
	// => Logger 생성 , 전역선언 static Final 활용.
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// view name Mapping
    // => viewName 생략이전
    //      public String home(Locale locale, Model model) {
    //        ~~~
    //        return "home";
    //     }
   // @GetMapping("/")
   // public String redirectToHome() {
       // return "redirect:/home";  
        // 기본 경로로 접속 시 "/home"으로 리다이렉트
    //}
	//@GetMapping("/home")
    //public void home(Locale locale, Model model) {
		@GetMapping(value ={"/","/index","/home"})
		public String home(Locale locale, Model model ,HttpServletRequest request) {
			String id = request.getRemoteAddr();
		logger.info("장난꾸러기 : "+id);
		
		
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate );
        return "home";
    } //home
	
	// BCryptPasswordEncoder test 
	//PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@GetMapping("/bcrypt")
	public String bcrypt() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String password = "12345!"; // 원본이라고 가정
		//1. encode : 동일한 원본(rawData)에 대해 각기 다른 결과(digestData)를 생성
		String digest1 = passwordEncoder.encode(password);
		String digest2 = passwordEncoder.encode(password);
		String digest3 = passwordEncoder.encode(password);
		String digest4 = passwordEncoder.encode("6789@");
		String digest5 = passwordEncoder.encode("#abcde");
		System.out.println("digest 1 = "+digest1);
		System.out.println("digest 2 = "+digest2);
		System.out.println("digest 3 = "+digest3);
		System.out.println("digest 4 = "+digest4);
		System.out.println("digest 5 = "+digest5);
		
		//2.matches (원본 , 다이제스트) -> boolean 으로 반환 
		System.out.println("digest 1 matches = "+passwordEncoder.matches(password, digest1));
		System.out.println("digest 2 matches = "+passwordEncoder.matches(password, digest2));
		System.out.println("digest 3 matches = "+passwordEncoder.matches(password, digest3));
		System.out.println("digest 4 matches = "+passwordEncoder.matches("6789@", digest4));
		System.out.println("digest 5 matches = "+passwordEncoder.matches(password, digest5));
		
		
		return "redirect:/home";
	}
    @GetMapping("/axtestform")
    public String axTestForm() {
    	return"axTest/axTestForm";
    }
	
	
}//class
