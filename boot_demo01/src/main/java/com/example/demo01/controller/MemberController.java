package com.example.demo01.controller;

import java.net.http.HttpRequest;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo01.domain.JoDTO;
import com.example.demo01.domain.MemberDTO;
import com.example.demo01.service.JoService;
import com.example.demo01.service.MemberService;

import lombok.AllArgsConstructor;

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//** @RequestMapping
//=> DefaultAnnotationHandlerMapping에서 컨트롤러를 선택할 때 대표적으로 사용하는 애노테이션. 
//=> DefaultAnnotationHandlerMapping은 클래스와 메서드에 붙은 @RequestMapping 애노테이션 정보를 결합해 최종 매핑정보를 생성한다.
//=> 기본적인 결합 방법은 클래스 레벨의 @RequestMapping을 기준으로 삼고, 
//   메서드 레벨의 @RequestMapping으로 세분화하는 방식으로 사용된다.

//** @RequestMapping 특징
//=> url 당 하나의 컨트롤러에 매핑되던 다른 핸들러 매핑과 달리 메서드 단위까지 세분화하여 적용할 수 있으며,
//   url 뿐 아니라 파라미터, 헤더 등 더욱 넓은 범위를 적용할 수 있다. 
//=> 요청과 매핑메서드 1:1 mapping 
//=> value="/mlist" 
//  : 이때 호출되는 메서드명과 동일하면 value 생략가능 그러나 value 생략시 404 (확인필요함)
//  : 해당 메서드 내에서 mv.setViewName("...."); 을 생략 
//또는 아래의 메서드를 사용하는 경우에는 void 로 작성 (view 를 return 하지않음) 하는 경우
//    요청명을 viewName 으로 인식 즉, mv.setViewName("mlist") 으로 처리함.
//또는 return "mlist" ( 즉, mlist.jsp 를 viewName으로 인식 )

//** @RequestMapping 속성
//=> value : URL 패턴 ( 와일드카드 * 사용 가능 )
//   @RequestMapping(value="/post")
//   @RequestMapping(value="/post.*")
//   @RequestMapping(value="/post/**/comment")
//   @RequestMapping(value={"/post", "/P"}) : 다중매핑 가능

//=> method 
//  @RequestMapping(value="/post", method=RequestMethod.GET)
//  -> url이 /post인 요청 중 GET 메서드인 경우 호출됨
//  @RequestMapping(value="/post", method=RequestMethod.POST)
//  -> url이 /post인 요청 중 POST 메서드인 경우 호출됨
//      GET, POST, PUT, DELETE, OPTIONS, TRACE 총 7개의 HTTP 메서드가 정의되어 있음.
//      ( 이들은 아래 @GetMapping ... 등으로도 좀더 간편하게 사용가능
//        그러나 이들은 메서드 레벨에만 적용가능     )  

//=> params : 요청 파라미터와 값으로도 구분 가능함.
//  @RequestMapping(value="/post", params="useYn=Y")
//  -> /post?useYn=Y 일 경우 호출됨
//  @RequestMapping(value="/post", params="useYn!=Y")
//  ->  not equal도 가능
//  @RequestMapping(value="/post", parmas="useYn")
//  > 값에 상관없이 파라미터에 useYn이 있을 경우 호출됨
//  @RequestMapping(value="/post", params="!useYn")
//  > 파라미터에 useYn이 없어야 호출됨
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// @RequestMapping 가 현재 클래스 단위 , 메서드 단위로 설정되어 있다.
// 계층적으로 구성되어 메서드는 /member/memberList를 읽고,
// viewResolver가 최종적으로 webapp/WEB-INF/views/member/memberList.jsp를 전달한다.

@AllArgsConstructor
@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	//@Autowired(required = false)
	MemberService service;
	
	//@Autowired(required = false)
	//JoService joservice;
	
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public void mList(Model model) {
		model.addAttribute("banana", service.selectList());
		
	}
	
	@RequestMapping(value = "/memberDetail", method = RequestMethod.GET)
	public void mDetail(Model model, MemberDTO dto,HttpSession session) {
		dto=service.selectOne((String)session.getAttribute("loginID"));
		model.addAttribute("apple", dto);
		
	}
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public void mLoginForm(Model model) {
		model.addAttribute("message", "로그인이 필요합니다");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String mLogin(Model model, HttpServletRequest request, HttpSession session,MemberDTO dto, JoDTO jdto) {
		//String id = request.getParameter("id");
        // => 요청을 처리하는 매핑메서드의 인자로 ~DTO 등의 객체를 정의하면,
        //    Parameter 들의 name 과 일치하는 필드의 값들은 자동으로 담겨짐(setter 사용함)
		String password = dto.getPassword();
		String uri = "redirect:/home";
		dto = service.selectOne(dto.getId());
		if(dto !=null && dto.getPassword().equals(password)) {
			session.setAttribute("loginID", dto.getId());
			session.setAttribute("loginName", dto.getName());
			System.out.println("성공 !");

		}else {
			System.out.println("실패 !");
			model.addAttribute("message", "로그인 다시 하세요.");
			uri="member/loginForm";
		}
		return uri;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String mLogout(Model model,HttpSession session) {
		
		session.invalidate();
		return "redirect:/home";
	}
	
}
