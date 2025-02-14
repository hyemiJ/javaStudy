package com.example.demo.jwtToken;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.repository.MemberRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

//** 커스텀 인증필터(AuthenticationFilter) 클래스 만들기 & 등록하기
//=> 등록: SecurityConfig.java 의 filterChain 메서드 참고
 
@Component
@Log4j2
public class JwtAuthenticationFilter extends OncePerRequestFilter  {
	@Autowired
	private TokenProvider tokenProvider;
	@Autowired
	private MemberRepository memberRepository;
	
	//*** doFilterInternal()
	//=> 인증처리 담당 메서드
	//=> Role 을 token 에 포함하기전(1)/후(2) 선택적으로 사용
	//   (이 선택에 따라 UserController 의 login02/login03 도 선택적으로 사용함) 
	
	//1. Role을 token에 포함하기전 (~~_OLD)
	// => tokenProvider.validateAndGetUserId(token) 사용
	/*@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			// 1) request 에서 토큰 가져오기.		
			String token = parseBearerToken(request); // 아래쪽에 메서드 구현
			log.info("JwtAuthenticationFilter doFilterInternal(), token 확인 => "+token);
			
			// 2) 토큰 검증 & userId 가져오기
			// => JWT이므로 Authorization(인가) 서버에 요청하지않고 검증가능함.
			// => TokenProvider 의 검증메서드를 통해 검증후 id 전달받음 (위조된 경우 예외처리 됨)
			if ( token!=null && !token.equalsIgnoreCase("null") ) {
				String userId = tokenProvider.validateAndGetUserId(token);
				log.info("JwtAuthenticationFilter doFilterInternal(), userId 확인 => "+userId);
				
				// => userId 를 이용해서 roleList 가져오기
				Member member = memberRepository.getWithRoles(userId);
				log.info("JwtAuthenticationFilter doFilterInternal(), roleList 확인 => "+member.getRoleList());
				
				// => List -> ROLE_USER 형식 String 으로 변환후 인자로 넣어주기만 하면 됨
				//			  "ROLE_MANEGER,ROLE_USER"  (AuthorityUtils.commaSeparatedStri.... 에 맞추기 위함)      		
				String roleList = "";
				for (MemberRole r:member.getRoleList()) {
					roleList +=",ROLE_"+r;
				}
				roleList=roleList.substring(1); //첫번쨰 "," 없애기 위함 
				log.info(" doFilterInternal(), 완성된 roleList 확인 => "+roleList);
				
				// 3) 인증 완료 & 등록
				//=> id, password 등 인증정보를 UsernamePasswordAuthenticationToken 에 보관
				//=> SecurityContext에 인증된 Authentication을 저장 
				//=> SecurityContextHolder에 등록 (등록 되어야 인증된 user로 인식함)
				
				AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userId, 
						null,
						AuthorityUtils.commaSeparatedStringToAuthorityList(roleList));
				
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				// => SecurityContextHolder에 인증된 user등록.
				//    SecurityContextHolder에 등록해야 인증된 user라고 생각하고, user를 인식한다.
				//	-> SecurityContextHolder.createEmptyContext() 메서드로 SecurityContext 생성하고
				//  -> 여기에 SecurityContext 에 인증정보를 넣고
				//  -> 다시 SecurityContextHolder 에 컨텍스트로 등록함.
				SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
				securityContext.setAuthentication(authentication);
				SecurityContextHolder.setContext(securityContext);
			} //if
			
		} catch (Exception e) {
			log.error("JwtAuthenticationFilter doFilterInternal() Exception => "+e.toString());
		} 
		filterChain.doFilter(request, response);
	} //doFilterInternal
	*/ 
	//2. Role을 token에 포함하기
	// => tokenProvider.validateToken(token) 사용
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		try {
			// 1) request 에서 토큰 가져오기.
			String token = parseBearerToken(request);  //아래에 메서드 구현해놓음
			
			log.info("** JwtAuthenticationFilter, doFilterInternal(), token 확인=> "+token);
			
			if (token != null && !token.equalsIgnoreCase("null")) {
				
				// 2) 토큰 검증 & claims 가져오기
				Map<String, Object> claims = tokenProvider.validateToken(token);
				log.info("** Authenticated 결과 JWT claims: " + claims);
				String userId = (String) claims.get("userId");
				//String pw = (String) claims.get("pw");
				List<String> roleList = (List<String>)claims.get("roleList");
				
				// 3) 인증 완료
				// => 인증결과를 UsernamePasswordAuthenticationToken 에 담아 시큐리티가 사용하는 인증토큰을 만들고
				// => 이 인증토큰 값(Authentication)을 SecurityContextHolder를 이용하여 SecurityContext에 등록
				//	  ( SecurityContextHolder에 등록해야 인증된 user로 인식함)
				
				AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userId, // 컨트롤러에서 @AuthenticationPrincipal 로 사용가능 (AuthController userDetail() 확인) 
						null, // Password를 의미하며 보통은 null 로 처리
						roleList.stream()
								.map(str -> new SimpleGrantedAuthority("ROLE_"+str))
								.collect(Collectors.toList()) );
						// => Collection<? extends GrantedAuthority> Type 에 맞추기 위함
				
				//=> 아래의 경우처럼 객체를 생성자의 principal 로 전달할수도 있음  	
				// MemberDTO memberDTO = new MemberDTO(userId, pw, ~~~ , roleNames);
				// ~~~ = new UsernamePasswordAuthenticationToken(memberDTO, pw, memberDTO.getAuthorities());
				
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// => details 필드에 인증 소스인 request 값 set 
				
				// => SecurityContextHolder에 인증된 user등록.
				//	  ( 그래야만 인증된 user로 인식함)
				//	-> SecurityContext 생성
				//	-> 여기에 인증정보를 넣고
				//	-> 이렇게 인증정보를 담은 SecurityContext 를 SecurityContextHolder에 등록함.
				SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
				securityContext.setAuthentication(authentication);
				SecurityContextHolder.setContext(securityContext);
			} //if_token 존재
		} catch (Exception e) {
			log.error("doFilterInternal() Exception => "+e.toString());
		}

		filterChain.doFilter(request, response);

	} //doFilterInternal
 
	//*** parseBearerToken()
	//=> Request 객체의 Header 를 파싱해서 token 을 return
	private String parseBearerToken(HttpServletRequest request) {
		
		String bearerToken = request.getHeader("Authorization");
		if ( StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ") ) {
			return bearerToken.substring(7);
		}
		return null;
	} //parseBearerToken

} //class
