package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.UserDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import com.example.demo.jwtToken.TokenProvider;
import com.example.demo.service.BoardService;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/user")
@Log4j2
@AllArgsConstructor
// @CrossOrigin(origins = "http://localhost:3000") -> WebMvcConfig.java 참고
public class UserController {
	MemberService service;
	PasswordEncoder passwordEncoder;
	TokenProvider tokenProvider;
	BoardService bservice;
	// ** 로그인 확인 
    // => Session 체크해서 react state값 유지
    // => Session 객체는 각 User별로 관리됨 
    @GetMapping("/check-server")
    public ResponseEntity<?> checkLogin(HttpSession session) {
        log.info("** React_SpringBoot Connection 확인 중 **");
        return ResponseEntity.ok()
                .body(Map.of("checkLogin", "Login 확인하지않음",
                             "checkData", "** ** Server 연결 성공, Port:8080 **"     
                        ));
        // => Map.of()
        //    - java 9 버전 부터 추가, 간편하게 초기화 가능
        //      map.put(1, "sangwoo kang"); map.put(2, "james kang"); put(3, "stef you");
        //      -> Map.of(key_1, "Value_sangwoo kang",
        //                2, "james kang",
        //                3, "stef you" )
        //    - 그러나 10개 까지만 초기화 가능 (10개 이상은 ofEntries() 사용)
        //    - unmodifiable(수정불가능) map을 리턴하므로 초기화후 수정불가능 (Immutable 객체)
        //    - 초기화 이후에 조회만 하는경우 주로사용함.(Key 관리 등)
    }
  //===================================================================================
    //** 토큰 발행 전
    @PostMapping("/login01")
    public ResponseEntity<?> login01(@RequestBody Member entity,HttpSession session, Model model){
    	//1. 요청 분석
    	// 패스워드 보관
    	String password = entity.getPassword();
    	//2. 서비스 처리
    	//아이디와 패스워드 일치 여부 확인
    	entity = service.selectOne(entity.getId());
    	
    	if(entity!=null && passwordEncoder.matches(password, entity.getPassword())) {
    		// - 성공 : 로그인 정보를 session에 보관 , front로 보내기
    		session.setAttribute("loginID", entity.getId());
    		session.setAttribute("loginName", entity.getName());
    		
    		//전송할 userDTO 객체에 담아 빌더 패턴을적용하여 값 변경 예방을 위해 final로 정의
    		final UserDTO user = UserDTO.builder()
    				.id(entity.getId())
    				.username(entity.getName())
    				.build();
    				
    		//ResponseEntity<?> result = ResponseEntity.status(HttpStatus.OK).body(user);
    		//3. 결과 전송
    		return ResponseEntity.ok(user);
    	}else {
    		// - 실패
    		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("id 또는 password가 오류. entity =>"+entity);
    	}
    }//login
    
  //===================================================================================
  //** 토큰 발행 후 , Spring 인증 인가 받기 전
    @PostMapping("/login02")
    public ResponseEntity<?> login02(@RequestBody Member entity,HttpSession session, Model model){
    	//1. 요청 분석
    	// 패스워드 보관
    	String password = entity.getPassword();
    	//2. 서비스 처리
    	//아이디와 패스워드 일치 여부 확인
    	entity = service.selectOne(entity.getId());
    	
    	if(entity!=null && passwordEncoder.matches(password, entity.getPassword())) {
    		// - 성공 :** 토큰 생성 **,로그인 정보를 session에 보관 , front로 보내기
    		session.setAttribute("loginID", entity.getId());
    		session.setAttribute("loginName", entity.getName());
    		//** 토큰 생성 **
    		final String token = tokenProvider.create(entity.getId());
    		log.info("token subject(=>id) =>"+tokenProvider.validateAndGetUserId(token));
    		//전송할 userDTO 객체에 담아 빌더 패턴을적용하여 값 변경 예방을 위해 final로 정의
    		final UserDTO user = UserDTO.builder()
    				.token(token)
    				.id(entity.getId())
    				.username(entity.getName())
    				.build();
    				
    		//ResponseEntity<?> result = ResponseEntity.status(HttpStatus.OK).body(user);
    		//3. 결과 전송
    		return ResponseEntity.ok(user);
    	}else {
    		// - 실패
    		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("id 또는 password가 오류. entity =>"+entity);
    	}
    }//login
  //===================================================================================
    //*** Login03 : Role을 token에 포함한 이후 인증
    //=> tokenProvider.createToken(entity.claimList()) 사용
    @PostMapping("/login")
    public ResponseEntity<?> login03(@RequestBody Member entity, HttpSession session) {
        // 1) 요청분석
        String password = entity.getPassword();
        
        // 2) Service 처리 & 결과전송
        try {
            entity = service.selectOne(entity.getId());
            if ( entity!=null && 
                 passwordEncoder.matches(password, entity.getPassword()) ) {
                //=> 성공: token 생성 & 로그인정보 session에 보관 & Front로 전송
                //          session에 보관할 필요는 없지만 Test를 위해 보관함.  
                session.setAttribute("loginID", entity.getId());
                session.setAttribute("loginName", entity.getName());
                
                //=> token 생성
                
                final String token = tokenProvider.createToken(entity.claimList());
                 
                //=> 전송할 UserDTO 객체생성
                final UserDTO userDTO = UserDTO.builder()
                            .token(token)
                            .id(entity.getId())
                            .username(entity.getName())
                            .roleList(entity.getRoleList())
                            .build();
                log.info("로그인 성공 => "+HttpStatus.OK);
                return ResponseEntity.ok(userDTO);
            }else {
                throw new Exception("Data_NotFound");
                // => JPA 에서는 id 에 해당하는 Data 가 없는 경우 ~~.NoResultException 발생되기때문
            }
        } catch (Exception e) {
            log.error("로그인 실패 => "+HttpStatus.BAD_GATEWAY);
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("~~ id 또는 password 오류 ~~");
        }
        
    } //login03
    
    // ** BoardList
    @GetMapping("/boardlist")
    public ResponseEntity<?> boardlist() {
        List<Board> list = bservice.selectList();
        
       if ( list !=null && list.size() > 0 ) {    
           return ResponseEntity.ok().body(list);
       }else {
           log.info("** boardlist NotFound **");
           return ResponseEntity
                   .status(HttpStatus.BAD_GATEWAY) 
                   .body("boardlist NotFound");
       }
    } //boardlist
    
}
