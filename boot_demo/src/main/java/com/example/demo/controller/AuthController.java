package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.MemberRole;
import com.example.demo.domain.UserDTO;
import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/auth")
@Log4j2
@AllArgsConstructor
public class AuthController {

	MemberService service;
	
	//** 로그아웃
	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session){
		//세션 무효화
		session.invalidate();
		log.info("log out 성공");
		return ResponseEntity.ok("로그아웃 성공");
	}
    // ** User Detail
    @GetMapping("/userdetail")
    public ResponseEntity<?> userdetail(HttpSession session,
                                 @AuthenticationPrincipal String userId) {
        // => userID: 인증받은 token에서 get (스프링이 @AuthenticationPrincipal 으로 제공해줌)
        // => 요청 전달 : 스프링 시큐리티 필터 작동
        //    -> JwtAuthenticationFilter 클래스의 doFilterInternal() 메서드가 호출되어
        //    -> request 객체에서 token을 꺼내 분석하고, 인증되면
        //    -> SecurityContext에 인증된 Authentication 객체를 넣어두고 
         //       현재 스레드내에서 공유되도록 관리하고 있으며, 
         //    -> @AuthenticationPrincipal 으로 이 정보를 제공해줌.
         
        log.info("userdetail, 전달된 userId 확인 => "+userId);
        log.info("userdetail, session에 보관한 loginID 확인 => "+session.getAttribute("loginID"));
        // => session 값은 UserController 의 /login 요청 메서드에서 저장함.    
        // => 8080 서버의 session 값은 3000접속과는 origin이 다른 별개의 session 이므로
        //    3000 요청으로 호출되는 session의 값은 null 이다.
        //    ( SecurityConfig.java 의 filterChain 메서드의 
        //        sessionManagement()~~ chain 설정값과는 무관함 )
        
        Member entity = service.selectOne(userId);
        if ( entity!=null ) {
            return ResponseEntity.ok(entity);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                                .body("userDetail failed.");
        }
        
    }//userdetail 
	
	private List<MemberRole> roleList = new ArrayList<>();
    // ** MemberList
     @GetMapping("/memberlist")
     public ResponseEntity<?> memberlist() {
         List<Member> list = service.selectList();
        if ( list !=null && list.size() > 0 ) {    
            return ResponseEntity.ok().body(list);
        }else {
            log.info("** memberlist NotFound **");
            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY) 
                    .body("memberlist NotFound");
        }
     } //memberlist
}
