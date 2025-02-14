package com.example.demo03.controller;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo03.domain.BoardDTO;
import com.example.demo03.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import pageTest.Criteria;
import pageTest.PageMaker;

@AllArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {

	BoardService service; 
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/bCheckList")
	public String bCheckList(Model model, Criteria cri, PageMaker pageMaker , HttpServletRequest request) {
		
		cri.setStartRowNumberendRowNumber();
		
		model.addAttribute("banana", service.bCheckList(cri));

		logger.info(cri.toString());
		logger.info("cri.check:", Arrays.toString(cri.getCheck()));
		String mappingName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		
		logger.info("mappingName : "+mappingName);
		pageMaker.setMappingName(mappingName);
		pageMaker.setCri(cri);
		pageMaker.setTotalRowCount(service.checkRowsCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/bPageList";
	}//bCheckList
	
	
	
	
	//* PageNation =>Criteria 활용
	//**Board PageList
	//=> ver01 : 사용 Criteria 사용 
	@GetMapping("/bPageList")
	public void bPageList(Model model, Criteria cri, PageMaker pageMaker , HttpServletRequest request) {
		//1) Criteria 처리
		// =>Ver01: Criteria currPage, rowPerPage 값들은 Parameter로 전달되어 cri에 set 
		cri.setStartRowNumberendRowNumber();
		
		//2) Service 
		//=> 출력대상 rows들을 select, 
		// -> 버전 1 .
		model.addAttribute("banana", service.bPageList(cri));
		// -> 버전 2. searchType , keyword 사용한 조건 포함.
		// -> sql문 추가.->impl에서 mapper interface 호출시 교체.
		
		//3) view 처리
		// => pageMaker 에서 uri를 완성하기 위해 mappingName을 처리해야함.
		String mappingName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		
		logger.info(cri.toString());
		logger.info("mappingName : "+mappingName);
		pageMaker.setMappingName(mappingName);
		pageMaker.setCri(cri);
		pageMaker.setTotalRowCount(service.totalRowsCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		
		
	}//bPageList
	
	
	
	//본글 리스트
	@GetMapping("/boardList")
	public void boardList(Model model) {
		model.addAttribute("banana",service.selectList());
	}
	
	//본글 상세보기
	/*
	 * @RequestMapping(value = "/detail" , method=RequestMethod.GET) public String
	 * boardDetail(Model model ,RedirectAttributes rttr, HttpSession session,
	 * 
	 * @RequestParam("jCode") String jCode ,
	 * 
	 * @RequestParam("seq") int seq, BoardDTO dto) { String uri =
	 * "/board/boardDetail"; dto = service.selectOne(seq);
	 * model.addAttribute("message","진입성공"); if ("U".equals(jCode)) {
	 * uri="/board/boardUpdate"; } else { if(dto!=null &&
	 * !dto.getId().equals(session.getAttribute("loginID"))){ //=> 조회수 증가에 대한 조건.
	 * //=> 수정된 값 출력. dto.setCnt(dto.getCnt()+1); service.update(dto); } }
	 * model.addAttribute("apple",dto); return uri; }
	 */
	@GetMapping("/detail")
	public String bdetail(HttpSession session, Model model, 
	@RequestParam("jCode") String jCode,
	@RequestParam("seq") int seq) {
	String uri="board/boardDetail";
	BoardDTO dto = service.selectOne(seq);

	// ** 조회수증가
	// => Update 요청이 아닌경우
	// => 로그인ID 와 글쓴이ID 가 다른 경우
	if ("U".equals(jCode)) uri="board/boardUpdate";
	else {
	if ( dto!=null && !dto.getId().equals((String)session.getAttribute("loginID")) ) {
	// => 조회수증가 (board 수정, 수정된값 출력)
	// => dto 의 값 수정후 board Update
	dto.setCnt(dto.getCnt()+1);
	service.update(dto);
	}
	}
	model.addAttribute("apple", dto);
	return uri;
	} //bdetail

	//본글 boardInsert
	@GetMapping("/boardInsert")
	public void boardInsert() {
		
	}
	
	//본글 insert
	@PostMapping("insert")
	public String insert(Model model ,RedirectAttributes rttr, BoardDTO dto) {
		String uri="redirect:boardList";
		if(service.insert(dto)>0) {
			rttr.addFlashAttribute("message","수정성공");
		}else {
			uri="/board/boardInsert";
			model.addAttribute("message","수정실패");
		}
		return uri;
	}
	
	//본글 update
	@PostMapping("update")
	public String update(Model model , BoardDTO dto) {
		String uri = "/board/boardDetail";
		model.addAttribute("apple",dto);
		if(service.update(dto)>0) {
			model.addAttribute("message","업데이트성공");
		}else {
			uri="/board/boardUpdate";
			model.addAttribute("message","업데이트실패");
		}
		return uri;
	}
	
	//본글 삭제
	@GetMapping("/delete")
	public String delete( RedirectAttributes rttr,BoardDTO dto) {
		String uri = "redirect:boardList";
		if(service.delete(dto)>0) {
			rttr.addAttribute("message","삭제성공");
		}else {
			 uri = "/board/boardDetail";
			 rttr.addAttribute("message","삭제실패");
		}
		//model.addAttribute("banana",service.selectList());
		return uri;
	}
	
	//댓글 등록폼 이동 -> BoardDTO dto가 requestScope가에 유지됨.
	@GetMapping("/replyInsert")
	public void replyInsert(BoardDTO dto) {
		// => 답글처리를위해 부모글의 root, step, indent 를 인자로 전달받으면,
		//    이 인자에 담겨진 값은 requestScope 과 동일 
		// => 그러므로 response 전송 전까지는 서버(Jsp)에서 사용가능
		//    단, 객체명의 첫문자를 소문자로 해서 접근가능 ( ${boardDTO.~~} )
		
	}
	
	//댓글 등록
	@PostMapping("/replyInsert") // 매핑형식이 다르기 때문에 , 요청명이 동일하더라도 관계가 없음.
	public String replyInsert(Model model, RedirectAttributes rttr,BoardDTO dto) { // 메서드 이름 동일은 오버로드를 활용하여 ,리턴타입이 다르거나 인자를 다르게 쓰면 됨.
		String uri = "redirect:boardList";
		//답글을 저장 및 등록해야함.
		//성공시에는 boardList에서 확인.
		//실패시에는 재입력 유도 (replyInsert)
		
        // => dto 값 확인
        //    -> id, title, content : 사용가능
        //    -> 부모글의 root : 사용가능
        //    -> 부모글의 step, indent : 1씩 증가
		dto.setStep(dto.getStep()+1);
		dto.setIndent(dto.getIndent()+1);
		
		//service 처리
		if(service.rinsert(dto)>0) {
			rttr.addFlashAttribute("message", "답글 입력 성공");
		}else {
			uri="/board/replyInsert";
			model.addAttribute("message", "답글 입력 실패");
		}
		
        // => Sql 처리
        //    -> replyInsert, step 의 Update
		
		return uri;
	}
	
	
	
}//class Controller
