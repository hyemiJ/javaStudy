package com.example.demo03.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo03.domain.JoDTO;
import com.example.demo03.domain.MemberDTO;
import com.example.demo03.service.JoService;
import com.example.demo03.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import pageTest.Criteria;
import pageTest.PageMaker;

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
	JoService joService;
	MemberService service;
	PasswordEncoder passwordEncoder;
	//PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	//주입받기 위해 , 생성되어있어야 하는데 , java-Config (DemoConfig.java)파일을 이용한다. 
	//-> 이런 파일을 보관하기 위해 새로운 폴더를 만든다.
	
	@GetMapping("/aximlist")
	public String aximlist(Model model) {
		model.addAttribute("banana", service.selectList());
		return "/axTest/axmemberList";
	}//aximlist
	
	//v1 : search 기능 : @GetMapping("/axmcri")
	//v2 : check 기능 추가
	@GetMapping({"/axmcri","/axmcheck"})
	public String axmcri(Model model,Criteria cri,PageMaker pageMaker , HttpServletRequest request) {
		String mappingName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		cri.setStartRowNumberendRowNumber();
		pageMaker.setCri(cri);
		pageMaker.setMappingName(mappingName);
		
		//mappingName에 따른 실행 분기.
		if(mappingName.contains("check")) {
			model.addAttribute("banana", service.mCheckList(cri));
			pageMaker.setTotalRowCount(service.mCheckCount(cri));
			
		}else {			
			model.addAttribute("banana", service.mPageList(cri));
			pageMaker.setTotalRowCount(service.totalRowsCount(cri));
		}
		model.addAttribute("pageMaker", pageMaker);
		return"/axTest/axmPageList";
	}
	
	@GetMapping("/idDupCheck")
	public void idDupCheck(Model model, @RequestParam("id") String id) {
		//새로운 id 가 테이블의 id 존재 여부를 확인해야함.
		// 그에 대한 결과를 전달해야함.
		if(service.selectOne(id)!=null) {//null이 아니면 , 고객이 있다는 뜻. 사용 불가능 
			model.addAttribute("idUse", "false");
		}else {//null이면 , 고객이 없다는 뜻. 사용 가능
			model.addAttribute("idUse", "true");
		}
	}
	
	@GetMapping("/mCheckList")
	public String mCheckList(Model model, Criteria cri, HttpServletRequest request, PageMaker pageMaker) {
		cri.setStartRowNumberendRowNumber();
		model.addAttribute("banana", service.mCheckList(cri));
		String mappingName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		pageMaker.setMappingName(mappingName);
		pageMaker.setCri(cri);
		pageMaker.setTotalRowCount(service.mCheckCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		return "member/mPageList";
	}
	
	@GetMapping("/mPageList")
	public void mPageList(Model model, Criteria cri, HttpServletRequest request, PageMaker pageMaker) {
		cri.setStartRowNumberendRowNumber();
		model.addAttribute("banana", service.mPageList(cri));
		String mappingName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		pageMaker.setMappingName(mappingName);
		pageMaker.setCri(cri);
		pageMaker.setTotalRowCount(service.totalRowsCount(cri));
		model.addAttribute("pageMaker", pageMaker);
	}

	// * memberList
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public void mList(Model model, HttpServletRequest request) {
		model.addAttribute("banana", service.selectList());
		//ServletContext context = request.getServletContext();
		String realPath = request.getServletContext().getRealPath("/");
		System.out.println(realPath);
	}
	// * memberDetail 
	// * Update 
	/*
	 * @RequestMapping(value = "/memberDetail", method = RequestMethod.GET) public
	 * String mDetail(Model model, MemberDTO dto,HttpSession session,
	 * 
	 * @RequestParam("jCode") String jCode) { String uri = "member/meberDetail";
	 * dto=service.selectOne((String)session.getAttribute("loginID"));
	 * model.addAttribute("apple", dto);
	 * 
	 * if("U".equals(jCode)) { uri = "member/updateForm"; } return uri; }
	 */
	
    @RequestMapping(value = "/memberDetail", method = RequestMethod.GET)
    public String detail(Model model, HttpSession session, @RequestParam("jCode") String jCode) {
        String id = (String) session.getAttribute("loginID"); //
        String uri = "member/memberDetail";
        model.addAttribute("apple", service.selectOne(id));
        if ("U".equals(jCode))
        	model.addAttribute("joSelectAll", joService.selectJoListService());
            uri = "member/updateForm";
        return uri;
    } // detail
    
	// * mUpdate 
	@RequestMapping(value = "/mupdate", method = RequestMethod.POST)
	public String mupdate(Model model , MemberDTO dto, HttpSession session,HttpServletRequest request) 
	throws IOException{
		String uri = "member/memberDetail";
		// 내정보를 출력을 위해 보관하여 임시 저장.
		model.addAttribute("apple",dto);
		
		// =====================================================
		//전달된 이미지 처리
		//1. 이미지 선택 여부를 확인
		MultipartFile uploadfilef = dto.getUploadfilef();
		if(uploadfilef!=null&&!uploadfilef.isEmpty()) {
			//물리적 저장위치 확인
			String realPath = request.getServletContext().getRealPath("/");
			realPath +="\\resources\\uploadImages\\";
			//이전 이미지 지우기
			if(!"basicman4.png".equals(dto.getUploadfile())) {				
				File oldfile = new File(realPath+dto.getUploadfile());
				if(oldfile.isFile()) {
					oldfile.delete();
				}
			}
			//Date date = new Date();
			//String dateFormat = ""+(date.getMonth()+1)+"_"+(date.getDay()+1)+"_"+date.getHours()+"_"+date.getMinutes()+"_";
			//System.out.println(dateFormat);
			realPath += uploadfilef.getOriginalFilename();
			uploadfilef.transferTo(new File(realPath));
			dto.setUploadfile(uploadfilef.getOriginalFilename());
		}

		// =====================================================
		if(service.update(dto)>0) {
			model.addAttribute("message","수정 성공 !");
			//이름변경을 고려하여 session에 보관한 loginName 도 수정해야함.
			session.setAttribute("loginName", dto.getName());
		}else {
			model.addAttribute("message","수정 실패 !");
			uri="member/updateForm";
		}// 문자열로 , 경로를 보낼때는 폴더명부터 입력해줘야함.
		return uri;
	}
	
	// * loginForm
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public void mLoginForm(Model model) {
		model.addAttribute("message", "로그인이 필요합니다");
	}
	
	// * login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String mLogin(Model model, HttpServletRequest request, HttpSession session,MemberDTO dto, JoDTO jdto) {
		//String id = request.getParameter("id");
        // => 요청을 처리하는 매핑메서드의 인자로 ~DTO 등의 객체를 정의하면,
        //    Parameter 들의 name 과 일치하는 필드의 값들은 자동으로 담겨짐(setter 사용함)
		String password = dto.getPassword();
		String uri = "redirect:/home";
		dto = service.selectOne(dto.getId());
		if(dto !=null && passwordEncoder.matches(password, dto.getPassword())) {
			session.setAttribute("loginID", dto.getId());
			session.setAttribute("loginName", dto.getName());
			session.setAttribute("loginJno", dto.getJno());
			System.out.println("성공 !");

		}else {
			System.out.println("실패 !");
			model.addAttribute("message", "로그인 다시 하세요.");
			uri="member/loginForm";
		}
		return uri;
	}
	
	// * logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String mLogout(Model model,HttpSession session) {
		
		session.invalidate();
		return "redirect:/home";
	}
	
	// * joinForm
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public void joinForm(Model model) {
		model.addAttribute("joSelectAll", joService.selectJoListService());
	}
	
	// * mjoin
	@RequestMapping(value = "/mjoin", method = RequestMethod.POST)
	public String mjoin(Model model ,HttpServletRequest request , MemberDTO dto) throws IOException {
		String uri = "member/loginForm";
		//* passwordEncoder 적용
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		//* 이미지 업로드처리 =====================================
		//1. 물리적인 실질 저장 위치 확인 : file1
		String realPath = request.getServletContext().getRealPath("/");
		//realpath => C:\MTest\myWork\demo02\src\main\webapp\
		//realpath + resources\\uploadImages
		realPath += "resources\\uploadImages\\";
		//2. realPath 존재 확인 , 없으면 생성 
		File file = new File(realPath);
		if(!file.exists()) file.mkdir(); 
		//3. basicman4.png 카피하기
		//기본 이미지가 upload 폴더에 없는경우 image 폴더에서 가져오기.
		file = new File(realPath+"basicman4.png");
		if(!file.exists()) {
			String basicImagePath ="C:\\MTest\\myWork\\demo03\\src\\main\\webapp\\resources\\images\\basicman4.png";
			FileInputStream fin = new FileInputStream(new File(basicImagePath));
			//입력 스트림 : 이미지를 읽어드림. -> 파일 입력 바이트 스트림 
			FileOutputStream fout = new FileOutputStream(file);
			//목적지 : realPath+basicman4.png 파일 바이트 스트림 생성
			FileCopyUtils.copy(fin, fout);
		}
		
		// 4. 저장 경로 완성하기
		// 물리적 저장위치 : file1
		// table 의 저장에 필요한 값-> 파일명 꺼내기 : file2
		String file1="" , file2="basicman4.png"; // 없을 때를 대비해 기본값 넣기.
		MultipartFile uploadfilef = dto.getUploadfilef();
		//MultipartFile
		//-> uploadfile 들에 대한 모든 정보를 가지고 있고, 처리할 수 있도록 편한 메서드들을 제공 
		//getOriginalFilename() : string
		//transferTo(File destFile) : void
		//isEmpty() : boolean
		if(uploadfilef!=null && !uploadfilef.isEmpty()) {
			//realpath => C:\\MTest\\myWork\\demo02\\src\\main\\webapp\\resources\\uploadImages
			file1 = realPath+uploadfilef.getOriginalFilename();
			uploadfilef.transferTo(new File(file1));//file1 경로에 저장 붙여넣기.
			file2 = uploadfilef.getOriginalFilename(); // 이름만 따와서 저장.
		}
		dto.setUploadfile(file2); // set하여 insert할때 저장하도록 함.
		
		// ========================================================
		if(service.insert(dto)>0) {
			model.addAttribute("message","회원가입 성공 ! 로그인 후 이용해주세요");
		}else {
			model.addAttribute("message","회원가입 실패 ! 다시 이용해주세요");
			uri="member/joinForm";
		}// 문자열로 , 경로를 보낼때는 폴더명부터 입력해줘야함.
		return uri;
	}
	
	// * mdelete
	@RequestMapping(value = "/mdelete", method = RequestMethod.GET)
	public String mdelete(RedirectAttributes rttr , MemberDTO dto , HttpSession session) {
		
		//dto = service.selectOne((String)session.getAttribute("loginID"));
		dto.setId((String)session.getAttribute("loginID"));
		if(service.delete(dto)>0) {
			System.out.println("delete 성공");
			session.invalidate();
			//model.addAttribute("message", "삭제성공");
			rttr.addFlashAttribute("message","삭제성공");
		}else {
			System.out.println("delete 실패");
			//model.addAttribute("message", "삭제실패");
			rttr.addFlashAttribute("message","삭제실패");
		}
		return "redirect:/home";
	}
	
}
