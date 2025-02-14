package com.example.demo03.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo03.domain.BoardDTO;
import com.example.demo03.domain.JoDTO;
import com.example.demo03.domain.MemberDTO;
import com.example.demo03.domain.TestDTO;
import com.example.demo03.domain.UserDTO;
import com.example.demo03.service.BoardService;
import com.example.demo03.service.JoService;
import com.example.demo03.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping("/rest")
public class RESTController {
	
	MemberService service;
	PasswordEncoder passwordEncoder;
	JoService jservice;
	BoardService bservice;
	
	// test type 의 형태 리턴.
	@GetMapping("/hello")
	public String hello() {
		log.info("restController , hello method 🦉");
		return"<h2 style='text-align: center'>hello Rest API 🦉</h2>"; // test type 의 형태 리턴.
	}
	
	//사용자 정의 객체 리턴.
	//produces ->JSON(default) 포멧인지[produces = MediaType.APPLICATION_JSON_VALUE] 
	//produces -> xml 포멧인지 [produces = MediaType.APPLICATION_XML_VALUE] -> 태그와 value타입이 되어야함.
	@GetMapping(value="/getdto01", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public TestDTO getDTO01() {
		return new TestDTO(11,"rest", "restTest", "Test"); //사용자 정의 객체 리턴.
	}
	
	@GetMapping("/getmap")
	public Map<String,TestDTO> getMap() {
		Map<String,TestDTO> map = new HashMap<String,TestDTO>();
		
		map.put("one", new TestDTO(1,"rest1", "restTest", "Test"));
		map.put("two", new TestDTO(2,"rest2", "restTest", "Test"));
		map.put("삼", new TestDTO(3,"rest3", "restTest", "Test"));
		map.put("사", new TestDTO(4,"rest4", "restTest", "Test"));
		map.put("오", new TestDTO(5,"rest5", "restTest", "Test"));
		return map;
	}
	@GetMapping("/getlist")
	public List<MemberDTO> getList() {
		return service.selectList();
	}
	
	@GetMapping(value="/getjo", params = "jno" )
	public ResponseEntity<?> getjo(int jno){
		//출력 준비
		ResponseEntity<?> result = null;
		log.info("getjo_Method , jno ="+jno);
		JoDTO dto = jservice.selectJoListOneService(jno);
		if(dto!=null) {
			result = ResponseEntity.status(HttpStatus.OK).body(dto);
			log.info("getjo_Method , HttpStatus.OK ➡️ "+HttpStatus.OK);
		}else {
			result =ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("해당하는 조는 없습니다.");
			log.info("getjo_Method , HttpStatus.BAD_GATEWAY ➡️ "+HttpStatus.BAD_GATEWAY);
		}
		return result;
	}
	//@RequestParam 활용
	//id와 name 을 받아 일치하는지 확인.rest/idcheck/id=banana&name=홍길동
	@GetMapping(value = "/idcheck")
	//public ResponseEntity<?> idCheck( String id, String name){
	public ResponseEntity<?> idCheck(@RequestParam("id") String id,@RequestParam("name")String name){
		ResponseEntity<?> result = null;
		
		MemberDTO dto = service.selectOne(id);
		if(dto !=null && dto.getName().equals(name)) {
			result = ResponseEntity.status(HttpStatus.OK).body("성공 !<br>"+dto.toString());
			log.info("idCheck_Method id에 해당하는 name이 같음, String id ➡️ "+id+", String name ➡️ "+name);
		}else {
			result =ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("실패 ! 해당하는 멤버는 없습니다.");
			log.info("idCheck_Method id에 해당하는 name이 같지않음, String id ➡️ "+id+", String name ➡️ "+name);
		}
		return result;
	}
    // 4.3) @PathVariable
    // => URL 경로의 일부를 파라미터로 사용할때 이용
    //    http://localhost:8080/rest/order/outer/노랑
    // => 요청 URI 매핑에서 템플릿 변수를 설정하고 이를 매핑메서드 매개변수의 값으로 할당 시켜줌.
    //    이때 파라미터가 1개이면 @PathVariable 과 같이 name을 생략할수 있다
	@GetMapping("/order/{test1}/{test2}")
	public String[] order(@PathVariable("test1") String cartegory ,
				@PathVariable("test2") String color) {
		return new String[] {"cartegory : "+cartegory,"color : "+color};
	
	}
	
	//@RequestBody
    // => JSON 형식으로 전달된 Data를 컨트롤러에서 사용자정의 객체(DTO) _Java객체 로 변환할때 사용
    // => 요청 url : http://localhost:8080/rest/convert
    // => Payload : {"jno":33, "jname":"삼삼오오", "captain":"victory", "project":"RequestBody Test 중"}
	//requestBody가 있는경우
//	@PostMapping("/convert")
//	public ResponseEntity<TestDTO> convert(@RequestBody TestDTO dto){
//		ResponseEntity<TestDTO> result = null;
//		log.info("convert 인자로 전달된 test dto :"+dto);
//		dto.setProject("response 성공");
//		if(dto!=null) {
//			result = ResponseEntity.status(HttpStatus.OK).body(dto);
//		}else {
//			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
//		}
//		return result;
//	}
	
	//requestBody가 있는경우와 없는경우 비교해보기
	//requestBody가 없는 경우
//	@PostMapping("/convert")
//	public ResponseEntity<TestDTO> convert(TestDTO dto){
//		ResponseEntity<TestDTO> result = null;
//		log.info("convert 인자로 전달된 test dto :"+dto);
//		dto.setProject("response 성공");
//		if(dto!=null) {
//			result = ResponseEntity.status(HttpStatus.OK).body(dto);
//		}else {
//			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
//		}
//		return result;
//	}
	
	//consumes 적용 ->xml 방식 아니면 415 오류 
//	@PostMapping(value="/convert",consumes = MediaType.APPLICATION_XML_VALUE )
//	public ResponseEntity<TestDTO> convert(@RequestBody TestDTO dto){
//		ResponseEntity<TestDTO> result = null;
//		log.info("convert 인자로 전달된 test dto :"+dto);
//		dto.setProject("response 성공");
//		if(dto!=null) {
//			result = ResponseEntity.status(HttpStatus.OK).body(dto);
//		}else {
//			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
//		}
//		return result;
//	}
	//consumes 적용 
	@PostMapping(value="/convert",consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<TestDTO> convert(@RequestBody TestDTO dto){
		ResponseEntity<TestDTO> result = null;
		log.info("convert 인자로 전달된 test dto :"+dto);
		dto.setProject("response 성공");
		if(dto!=null) {
			result = ResponseEntity.status(HttpStatus.OK).body(dto);
		}else {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
		}
		return result;
	}
	//Ajax -> 비동기 통신
	//요청은 JSON 응답은 TEXT
	@PostMapping(value="/rslogin",consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> rslogin(@RequestBody MemberDTO dto , HttpSession session){
		ResponseEntity<String> result = null;
		// 패스워드 보관
		String password = dto.getPassword();
		//id 일치하는 dto 찾기
		dto = service.selectOne(dto.getId());
		
		//dto가 있고 , password가 일치하는지 확인.
		if(dto!=null && passwordEncoder.matches(password, dto.getPassword())) {
			//성공
			session.setAttribute("loginID", dto.getId());
			session.setAttribute("loginName", dto.getName());
			result =ResponseEntity.status(HttpStatus.OK).body("Login 성공");
		}else {
			//실패
			result=ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("login 실패");
		}
		return result;
	}
	
	//요청은 JSON 응답은 JSON
	@PostMapping(value="/rsloginjj",consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<UserDTO> rsloginjj(@RequestBody MemberDTO dto , HttpSession session){
		ResponseEntity<UserDTO> result = null;
		// 패스워드 보관
		String password = dto.getPassword();
		//id 일치하는 dto 찾기
		dto = service.selectOne(dto.getId());
		
		//dto가 있고 , password가 일치하는지 확인.
		if(dto!=null && passwordEncoder.matches(password, dto.getPassword())) {
			//성공
			session.setAttribute("loginID", dto.getId());
			session.setAttribute("loginName", dto.getName());
			//final UserDTO의 값을 변경을 예방하기 위해 final을 사용.
			final UserDTO userDTO = UserDTO.builder()
					.id(dto.getId())
					.username(dto.getName())
					.build();
			result =ResponseEntity.status(HttpStatus.OK).body(userDTO);
		}else {
			//실패
			result=ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
		}
		return result;
	}
	
    // 8) Join : rsjoin
    // => image 포함, "multipart/form-data" Type 으로 요청
    // => consumes, produces 설정
    // => FormData 형식으로 전달된 Data 는 JSON Format이 아니므로
    //    @RequestBody 필요없음 (Spring 이 자동으로 담아줌)  
    // => @ModelAttribute
    //        Parameter기반 형식의 Data를 전달 받을때 사용하며 생략가능함
    //         FormData 객체도 여기에 해당하여 @ModelAttribute 를 생략하고 받으며 @RequestBody 는 사용불가능함
    //        public ResponseEntity<?> rsjoin(@ModelAttribute MemberDTO dto) throws Exception {
	@PostMapping(value="/rsjoin", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	 public ResponseEntity<?> rsjoin(HttpServletRequest request, MemberDTO dto) throws Exception {
		 ResponseEntity<String> result = null;
		 //joinService를 처리해야함 . passwordEncoding 암호화 필요. multipartfile 처리 필요.
		
		 //* passwordEncoding 암호화 
		 dto.setPassword(passwordEncoder.encode(dto.getPassword()));
			
		 //* multipartfile 처리 필요. =====================================
			//1. 물리적인 실질 저장 위치 확인 : file1
			String realPath = request.getServletContext().getRealPath("/");
			realPath += "resources\\uploadImages\\";
		
			// 2. 저장 경로 완성하기
			// 물리적 저장위치 : file1
			// table 의 저장에 필요한 값-> 파일명 꺼내기 : file2
			String file1="" , file2="basicman4.png"; // 없을 때를 대비해 기본값 넣기.
			MultipartFile uploadfilef = dto.getUploadfilef();
			
			if(uploadfilef!=null && !uploadfilef.isEmpty()) {
				//realpath => C:\\MTest\\myWork\\demo02\\src\\main\\webapp\\resources\\uploadImages
				file1 = realPath+uploadfilef.getOriginalFilename();
				uploadfilef.transferTo(new File(file1));//file1 경로에 저장 붙여넣기.
				file2 = uploadfilef.getOriginalFilename(); // 이름만 따와서 저장.
			}
			dto.setUploadfile(file2); // set하여 insert할때 저장하도록 함.
			
			// ========================================================
			if(service.insert(dto)>0) {
				result = ResponseEntity.status(HttpStatus.OK).body("회원 가입 성공 !로그인 후 이용하세요");
			}else {
				result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("회원 가입 실패 ! 다시 가입하세요");
			}// 문자열로 , 경로를 보낼때는 폴더명부터 입력해줘야함.
		 
		 return result;
	 }
	
	//axios 반복문에 이벤트 적용하기
	//idbList(id별 boardList)
	//@PathVariable 사용. // url = "/rest/idblist/"+id;
	//@PathVariable("id") String id 변수명이 같을경우 생략이 가능하지만 기술하는것이 좋다.
	@GetMapping("/idblist/{id}")
	public ResponseEntity<?> idbList(@PathVariable("id") String id){
		ResponseEntity<?> result = null;
		//service, 결과 전송. -> idbList 추가
		List<BoardDTO> list = bservice.idbList(id);
		if(list!=null && list.size()>0) {
			result = ResponseEntity.status(HttpStatus.OK).body(list);
		}else {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("출력할 자료가 없습니다.");
		}
		return result;
	}
	
	//axiDelte
	//url = "rest/axidelete/"+id;
	//response : text return
	//ResponseEntity : constructor를 사용.
	@DeleteMapping("/axidelete/{id}")
	public ResponseEntity<?> axidelete(@PathVariable("id") String id, MemberDTO dto){
		if(service.delete(dto)>0) {
			return new ResponseEntity<String>("** 삭제 성공 **",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("** 삭제 실패 , Data Not Found **",HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/jnoenter/{jno}")
	public ResponseEntity<?> jnoenter(@PathVariable("jno") int jno, JoDTO dto){
		dto = jservice.selectJoListOneService(jno);
		if(dto!=null) {
			return new ResponseEntity<JoDTO>(dto,HttpStatus.OK);
		}else {
			return new ResponseEntity<JoDTO>(dto,HttpStatus.BAD_GATEWAY);
		}
	}
}//class
