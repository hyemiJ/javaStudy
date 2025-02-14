package com.example.demo03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo03.domain.JoDTO;
import com.example.demo03.service.JoService;
import com.example.demo03.service.MemberService;

import lombok.AllArgsConstructor;



@Controller
@RequestMapping(value="/jo")
@AllArgsConstructor
// => 모듬 맴버변수를 초기화하는 생성자 자동 추가 & 사용
//    그러므로 아래의 @Autowired는 생략 가능
public class JoController {
	
	JoService service;	
	MemberService mservice;
	
	// ** JoList : Member 와 Join
	@GetMapping("/joList")
	public void joList(Model model) {
		model.addAttribute("banana", service.joinTestService());
	} //joList
	
	// ** JoDetail
	// => 아랫쪽에 조원목록 출력 (추가기능) -> joDetail.jap 에 Member_List 출력 코드 추가  
	// => jo Table에서 selectOne  ->  apple 
	// => member Table에서 조건검색 jno=#{jno} -> banana 
	@GetMapping("/detail")
	public String detail(Model model, JoDTO dto, @RequestParam("jCode") String jCode) {
		
		String uri = "jo/joDetail";
		model.addAttribute("apple", service.selectJoListOneService(dto.getJno()));
		// => 수정요청시엔 수정폼으로 
		if ( "U".equals(jCode) ) uri = "jo/joUpdate";
		else {
			// ** 조원목록 출력하기 추가 ( detail 출력시에만 )
			// => MemberService 실행
			//	-> selectJoList 메서드 추가 : service, DAO 
			//	-> 실행결과는 banana 로 
			model.addAttribute("banana", service.jnosearch(dto.getJno()));
		}
		return uri;
	} //detail
	
	// ** Jo_Insert
	// => joInsert Form 출력
	@GetMapping(value="/joInsert")
	public void joInsert() {
	} //joInsert
	
	// => jo_insert 처리
	@PostMapping(value="/insert")
	public String insert(Model model, JoDTO dto, RedirectAttributes rttr) {
		// ** Insert Service 처리
		// => 성공: joList 로 redirect
		// => 실패: 재입력 유도 -> insert 폼 요청
		String uri="redirect:joList";
		
		if ( service.insertJoService(dto)>0 ) {
			rttr.addFlashAttribute("message", "~~ Jo_Insert 성공 ~~");
		}else {
			model.addAttribute("message", "~~ Jo_Insert 실패 , 다시 하세요 ~~");
			uri="jo/joInsert";
		}
		
		// 3) View 처리
		return uri;
	} //insert	
	
	// ** Update
	@PostMapping(value="/update")
	public String update(Model model, JoDTO dto, RedirectAttributes rttr) {
		
		// ** Update Service 처리
		// => 성공: joList 로 redirect
		// => 실패: 재수정 유도 -> joUpdate 폼으로
		// => 그러므로 출력가능하도록 dto 를 setAttribute
		model.addAttribute("apple", dto);
		String uri="redirect:joList";
		
		if ( service.updateJoService(dto)>0 ) {
			// 수정성공 -> JList 로 redirect
			rttr.addFlashAttribute("message", "~~ Jo 정보 수정 성공 ~~");
		}else {
			// 수정실패
			model.addAttribute("message", "~~ Jo 정보 수정 실패 , 다시 하세요 ~~");
			uri="jo/joUpdate";
		}
		
		// 3) View 처리
		return uri;
	} //update
	
	// ** Delete
	@GetMapping(value="/delete")
	public String delete(JoDTO dto, RedirectAttributes rttr) {
		
		// ** Delete Service 처리
		// => 성공, 실패 : joList 로 redirect
		String uri="redirect:joList";
		if ( service.deleteJoService(dto)>0 ) {
			rttr.addFlashAttribute("message", "~~ Jo 삭제 성공 !!! ~~");
		}else {
			rttr.addFlashAttribute("message", "~~ Jo 삭제 실패 !!! ~~");
		}
		// 3) View 처리
		return uri;
	} //delete

} //class
























/*
 * @Controller
 * 
 * @AllArgsConstructor
 * 
 * @RequestMapping(value = "/jo") public class JoController { JoService
 * jservice; MemberService mservice;
 * 
 * @RequestMapping(value = "/joList", method = RequestMethod.GET) public void
 * jList(Model model) { model.addAttribute("joList",
 * jservice.selectJoListService());
 * 
 * }
 * 
 * @RequestMapping(value = "/joDetail", method = RequestMethod.GET) public
 * String jDetail(Model model,HttpSession session , @RequestParam("jCode")
 * String jCode, JoDTO dto) { //int selectjno =
 * (int)session.getAttribute("loginJno");
 * //System.out.println("디테일의 선택된 jno (session.get) ="+selectjno); String uri =
 * "jo/joDetail"; dto = jservice.selectJoListOneService(dto.getJno());
 * 
 * if(dto.getJno()==selectjno) { }else { dto =
 * jservice.selectJoListOneService(dto.getJno()); }
 * 
 * System.out.println("디테일의 선택된 dto (service.listOne) ="+dto);
 * model.addAttribute("joselect", dto);
 * model.addAttribute("banana",jservice.jnosearch(dto.getJno()));
 * if("U".equals(jCode)) { uri="detail"; } return uri; }
 * 
 * @RequestMapping(value = "detail", method = RequestMethod.GET) public String
 * detailjno(Model model , @RequestParam("jCode") String jCode, JoDTO dto
 * ,HttpSession session) { String uri ="jo/joUpdate";
 * if(dto!=null&&"U".equals(jCode)) { model.addAttribute("joselect",dto); }else
 * { int jno = (int)session.getAttribute("loginJno"); dto =
 * jservice.selectJoListOneService(jno); model.addAttribute("joselect",dto); }
 * return uri; }
 * 
 * 
 * @RequestMapping(value = "/joInsert", method = RequestMethod.GET) public void
 * jInsert(Model model) { }
 * 
 * @RequestMapping(value = "/insert", method = RequestMethod.POST) public String
 * insert(RedirectAttributes rttr, JoDTO dto) { if(dto !=null) {
 * jservice.insertJoService(dto); rttr.addFlashAttribute("message","성공"); }else
 * { rttr.addFlashAttribute("message","실패"); } return "redirect:/home"; }
 * 
 * @RequestMapping(value = "/delete", method = RequestMethod.GET) public String
 * jdelete(RedirectAttributes rttr, JoDTO dto, @RequestParam("jno") String jno)
 * { dto = jservice.selectJoListOneService(Integer.parseInt(jno)); if(dto!=null)
 * { jservice.deleteJoService(dto); rttr.addFlashAttribute("message","성공");
 * }else { rttr.addFlashAttribute("message","실패"); } return "redirect:/home"; }
 * 
 * }
 */
