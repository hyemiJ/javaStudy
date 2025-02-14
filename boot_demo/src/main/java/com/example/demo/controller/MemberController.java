package com.example.demo.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.JoDTO;
import com.example.demo.entity.Member;
import com.example.demo.service.JoService;
import com.example.demo.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@Controller
@RequestMapping(value = "/member")
public class MemberController {

	JoService joService;
	MemberService service;
	PasswordEncoder passwordEncoder;

	//QueryDSL test
	//List<JoDTO> findMemberJoinDSL()
	// -> sysout으로 확인
	@GetMapping("/joindsl")
	public String joinDSL() {
		List<JoDTO> list = service.joinDSL();
		for(JoDTO m : list) {
			System.out.println(m);
		}
		
		return "redirect:/home";
	}
	
	
	
	//pwUpdate
	@GetMapping("/pwUpdate")
	public void pwUpdate() {
	}
	
	@PostMapping("/pwUpdate")
	public String pwUpdate(HttpSession session,Member entity, Model model) {
		String uri ="/member/loginForm"; //성공시
		entity.setId((String)session.getAttribute("loginID"));
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		
		try {
			service.updatePassword(entity.getId(),entity.getPassword());
			log.info("password save (update) 성공 ! entity.getId() : "+entity.getId());
			//id 와 암호화된 비밀번호를 전송 
			session.invalidate();
			model.addAttribute("message", "패스워드 수정 성공 ! 다시 로그인하세요 !");
		} catch (Exception e) {
			log.error("password save (update) 실패 !"+e.toString());
			uri = "/member/pwUpdate";
			model.addAttribute("message", "패스워드 수정 실패 ! 다시하세요 ~");
		}
		
		
		return uri;
	}
	
	@GetMapping("/idDupCheck")
	public void idDupCheck(Model model, String id) {
		//새로운 id 가 테이블의 id 존재 여부를 확인해야함.
		// 그에 대한 결과를 전달해야함.
		if(service.selectOne(id)!=null) {//null이 아니면 , 고객이 있다는 뜻. 사용 불가능 
			model.addAttribute("idUse", "false");
		}else {//null이면 , 고객이 없다는 뜻. 사용 가능
			model.addAttribute("idUse", "true");
		}
	}


	// * memberList
	@GetMapping("/memberList")
	public void mList(Model model, HttpServletRequest request) {
		model.addAttribute("banana", service.selectList());
		//ServletContext context = request.getServletContext();
		String realPath = request.getServletContext().getRealPath("/");
		System.out.println(realPath);
	}

	
	@GetMapping("/memberDetail")
    public String detail(Model model, HttpSession session, String jCode) {
        String id = (String) session.getAttribute("loginID"); //
        String uri = "member/memberDetail";
        model.addAttribute("apple", service.selectOne(id));
        if ("U".equals(jCode)) {
        	model.addAttribute("joSelectAll", joService.selectList());
        	uri = "member/updateForm";        	
        }
        return uri;
    } // detail
	

    
	// * mUpdate 
	@PostMapping("/mupdate")
	public String mupdate(Model model , Member entity, HttpSession session,HttpServletRequest request) 
	throws IOException{
		String uri = "member/memberDetail";
		// 내정보를 출력을 위해 보관하여 임시 저장.
		model.addAttribute("apple",entity);
		
		// =====================================================
		//전달된 이미지 처리
		//1. 이미지 선택 여부를 확인
		MultipartFile uploadfilef = entity.getUploadfilef();
		if(uploadfilef!=null&&!uploadfilef.isEmpty()) {
			//물리적 저장위치 확인
			String realPath = request.getServletContext().getRealPath("/");
			realPath +="resources\\uploadImages\\";
			System.out.println(realPath);
			//이전 이미지 지우기
			if(!"basicman4.png".equals(entity.getUploadfile())) {				
				File oldfile = new File(realPath+entity.getUploadfile());
				if(oldfile.isFile()) {
					oldfile.delete();
				}
			}
			realPath += uploadfilef.getOriginalFilename();
			uploadfilef.transferTo(new File(realPath));
			entity.setUploadfile(uploadfilef.getOriginalFilename());
			
			
		}

		// =====================================================
		try {
			log.info("member save (update) 성공 !"+service.save(entity));
			//입력된 정보를 log를 통해 확인.
			model.addAttribute("message","수정 성공 !");
			session.setAttribute("loginName", entity.getName());
		} catch (Exception e) {
			log.error("member save (update) 실패 !"+e.toString());
			model.addAttribute("message","수정 실패 !");
			uri="member/updateForm";
		}
		return uri;
	}
	
	// * loginForm
	@GetMapping("/loginForm")
	public void mLoginForm(Model model) {}
	
	// * login
	@PostMapping("/login")
	public String mLogin(Model model, HttpServletRequest request, HttpSession session,Member entity, JoDTO jdto) {
		//String id = request.getParameter("id");
        // => 요청을 처리하는 매핑메서드의 인자로 ~DTO 등의 객체를 정의하면,
        //    Parameter 들의 name 과 일치하는 필드의 값들은 자동으로 담겨짐(setter 사용함)
		String password = entity.getPassword();
		String uri = "redirect:/home";
		entity = service.selectOne(entity.getId());
		if(entity !=null && passwordEncoder.matches(password, entity.getPassword())) {
			session.setAttribute("loginID", entity.getId());
			session.setAttribute("loginName", entity.getName());
			session.setAttribute("loginJno", entity.getJno());

		}else {
			model.addAttribute("message", "로그인 다시 하세요.");
			uri="member/loginForm";
		}
		return uri;
	}
	
	// * logout
	@GetMapping("/logout")
	public String mLogout(Model model,HttpSession session) {
		
		session.invalidate();
		return "redirect:/home";
	}
	
	// * joinForm
	@GetMapping(value = "/joinForm")
	public void joinForm(Model model) {
		model.addAttribute("joSelectAll", joService.selectList());
		//joList 에서 조목록을 이용하여 select-option 태그에서 사용
	}
	
	// * mjoin
	@PostMapping(value = "/mjoin")
	public String mjoin(Model model ,HttpServletRequest request , Member entity) throws IOException {
		String uri = "member/loginForm";
		//* passwordEncoder 적용
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
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
			String basicImagePath ="C:\\MTest\\myWork\\demo\\src\\main\\webapp\\resources\\images\\basicman4.png";
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
		MultipartFile uploadfilef = entity.getUploadfilef();
		//MultipartFile
		//-> uploadfile 들에 대한 모든 정보를 가지고 있고, 처리할 수 있도록 편한 메서드들을 제공 
		//getOriginalFilename() : string
		//transferTo(File destFile) : void
		//isEmpty() : boolean
		if(uploadfilef!=null && !uploadfilef.isEmpty()) {
			//realpath => C:\\MTest\\myWork\\demo\\src\\main\\webapp\\resources\\uploadImages
			file1 = realPath+uploadfilef.getOriginalFilename();
			uploadfilef.transferTo(new File(file1));//file1 경로에 저장 붙여넣기.
			file2 = uploadfilef.getOriginalFilename(); // 이름만 따와서 저장.
		}
		entity.setUploadfile(file2); // set하여 insert할때 저장하도록 함.
		
		// ========================================================
		try {
			log.info("member save (insert) 성공 !"+service.save(entity));
			//입력된 정보를 log를 통해 확인.
			model.addAttribute("message","회원가입 성공 ! 로그인 후 이용해주세요");
		} catch (Exception e) {
			log.error("member save (insert) 실패 !"+e.toString());
			model.addAttribute("message","회원가입 실패 ! 다시 이용해주세요");
			uri="member/joinForm";
		}
		return uri;
	}
	
	// * mdelete
	@GetMapping(value = "/mdelete")
	public String mdelete(RedirectAttributes rttr , HttpSession session) {
		
		
		String id =(String)session.getAttribute("loginID");
		
		try {
			service.delete(id);
			log.info("member delete 성공 !");
			session.invalidate();
			rttr.addFlashAttribute("message","삭제성공");
		} catch (Exception e) {
			log.error("member delete 실패 !"+e.toString());
			rttr.addFlashAttribute("message","삭제실패");
		}

		return "redirect:/home";
	}
	
}
