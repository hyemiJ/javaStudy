package com.example.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.GuestBookDTO;
import com.example.demo.domain.PageRequestDTO;
import com.example.demo.domain.PageResultDTO;
import com.example.demo.entity.GuestBook;
import com.example.demo.entity.TestKey;
import com.example.demo.entity.TestKeyId;
import com.example.demo.service.CodeService;
import com.example.demo.service.GuestBookService;
import com.example.demo.service.TestKeyService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequiredArgsConstructor
public class HomeController {

	private final GuestBookService service;
	private final TestKeyService tservice;
	private final CodeService cservice;

	@GetMapping({ "/", "/home" })
	public String home(Locale locale, Model model, HttpServletRequest request) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("code", cservice.selectPCList());

		return "home";
	} // home

	@GetMapping("/axtestform")
	public String axTestForm() {

		return "axTest/axTestForm";
	}// axTestForm
	//JPA start ============================================================
	//guestBook ()===========================================================
	@GetMapping("/ginsert")
	public String ginsert() {
		GuestBook entity = GuestBook.builder().title("JPA insert Test").content("입력이 잘되요").writer("admin").build();
		log.info("guest insert =>" + service.register(entity));
		return "redirect:/";
	}// ginsert

	@GetMapping("/gupdate")
	public String gupdate() {
		GuestBook entity = GuestBook.builder().gno(3L).title("JPA update Test").content("수정이 잘되요").writer("admin")
				.build();
		log.info("guest update =>" + service.register(entity));
		return "redirect:/";
	}// gupdate

	@GetMapping("/glist")
	public String glist() {
		// v1 : GuestBook entity
		// List<GuestBook> list= service.selectList();
		// for (GuestBook g : list) {
		// System.out.println(g+", regdate = "+g.getRegdate()+", moddate =
		// "+g.getModdate());
		// }
		// v2 : GuestBookDTO dto
		List<GuestBookDTO> list = service.selectList2();
		for (GuestBookDTO g : list) {
			System.out.println(g + ", regdate = " + g.getRegdate() + ", moddate = " + g.getModdate());
		}
		return "redirect:/";
	}// glist

	@GetMapping("/gdelete")
	// => 쿼리 스트링으로 Test : gdelete?gno=__
	public String gdelete(Long gno) {
		// try~ catch를 통해 처리가 정확히 이루어 졌는지 확인함 (레포지토리 내에 return이 없기 때문에)
		try {
			if (service.selectOne(gno) != null) {
				service.delete(gno);
				log.info("⭐⭐ gdelete 성공 => " + gno);
			} else {
				throw new Exception("Data not Found");
			}
			// 없는 번호를 제거한다고 하는 경우는 SQL에서는 에러가 아니지만 자바에서는 에러로 취급해야함
		} catch (Exception e) {
			log.error("⚠️gdelete Exception => " + e.toString() + "⚠️");

		}
		return "redirect:/";
	}// gdelete

	// ** JPA Pageing & Sort
	// => PageRequestDTO(페이징 조건들) -> PageResultDTO(최종결과)
	// => 사용객체들 : Page<Entity>, Pageable(i) -> PageRequest(구현체) 등.
	@GetMapping("/gpage")
	public String gpage(int crrentPageNumber) {
		PageRequestDTO requestDTO =PageRequestDTO.builder().page(crrentPageNumber).size(5).build();
		
		PageResultDTO<GuestBookDTO, GuestBook> resultDTO = service.pageList(requestDTO);
		
		System.out.println("🙊paging & sort : crrentPageNumber:"+crrentPageNumber);
		System.out.println("startPage 1️⃣ : "+resultDTO.getStartPage());
		// startPage = ((int)(Math.ceil(currentPage/(double)size)) * size) - size + 1;
		System.out.println("endPage : "+resultDTO.getEndPage());
		//endPage = totalPage > (끝번호(int)(Math.ceil(currentPage/(double)size)) * size) 
		//                             ? (끝번호(int)(Math.ceil(currentPage/(double)size)) * size) 
		//                             : totalPage;
		System.out.println("totalPage : "+resultDTO.getTotalPage());//repository.findAll(pageable);
		for (GuestBookDTO g : resultDTO.getDtoList()) {
			System.out.println(g);
		}
		
		return "redirect:/";
	}// gpage
	
	//testkey (복합키)===========================================================
	//tsave
	@GetMapping("/tsave")
	public String tsave() {
		TestKey entity = TestKey.builder()
								.id("apple")
								.no(1)
								.name("홍길동")
								.count(1)
								.build();
		try {
			tservice.save(entity);
			log.info("save 성공 ! entity =>"+entity);
		} catch (Exception e) {
			log.error("save Exception =>"+e.toString());
		}
		
		return"redirect:/";
	}//tsave
	
	//tupdate
	@GetMapping("/tupdate")
	public String tupdate() {
		TestKey entity = TestKey.builder()
				.id("apple")
				.no(1)
				.name("스티브")
				.count(1)
				.build();
		try {
			tservice.save(entity);
			log.info("save 성공 ! entity =>" + entity);
		} catch (Exception e) {
			log.error("save Exception =>" + e.toString());
		}
		
		return"redirect:/";
	}//tupdate
	
	//tcountupdate : 있으면 컬럼 값의 증가
	//INSERT INTO my_entity (id, name, count)
	//VALUES (:id, :name, 1)
	//ON DUPLICATE KEY UPDATE count = count + 1;
	// 새로운 커스텀 sql 구문이 필요함.
	// QueryString => /tcountupdate?id=apple&no=2&count=5
	@GetMapping("/tcountupdate")
	public String tcountupdate(String id , int no , int count) {
    	try {//실행 결과를 알기위한 trycatch 분기
    		tservice.updateCount(id,no,count);
    		log.info("tcountupdate=> id :"+id+", no : "+no+" , count :"+count);
		} catch (Exception e) {
			log.error("tcountupdate Exception =>"+e.toString());
		}
		return"redirect:/";
	}//tcountupdate
	
	//tdupupdate : 없으면 입력 , 있으면 컬럼 값의 증가
	// QueryString => /tdupupdate?id=apple&no=2&name=홍길동&count=5
	@GetMapping("/tdupupdate")
	public String tdupupdate(String id, int no, String name, int count) {
		try {
			tservice.dupUpdateCount(id, no, name, count);
			log.info("tcountupdate=> id :"+id+", no : "+no+" , name : "+name+" , count :"+count);
		} catch (Exception e) {
			log.error("tupupdate Exception =>"+e.toString());
		}
		return"redirect:/";
	}//tdupupdate
	
	//tcalc : 계산 로직 구현하여 테이블로 저장할 값을 계산.
	// QueryString => /tcalc?id=banana&no=1&count=5
	@GetMapping("/tcalc")
	public String tcalc(String id, int no, int count) {
		log.info("result =>"+tservice.calcCount(id, no, count));
		return"redirect:/";
	}//tcalc
	
	//tlist
	@GetMapping("/tlist")
	public String tlist() {
		List<TestKey> list = tservice.selectList();
		for(TestKey t : list) {
			System.out.println(t);
		}
		return"redirect:/";
	}//tlist
	
	//tdetail => 쿼리 스트링으로 확인 /tdetail?id=apple&no=1
    @GetMapping("/tdetail")
    public String tone(TestKeyId pk) {
         System.out.println(tservice.selectOne(pk));
        return "redirect:home";
    } //tdetail
    
	//tdelete => 쿼리 스트링으로 확인 /tdelete?id=apple&no=1
    @GetMapping("/tdelete")
    public String tdelete(TestKeyId pk) {
    	try {//실행 결과를 알기위한 trycatch 분기
    		if(tservice.selectOne(pk)!=null) {    			
    			tservice.delete(pk);
    			log.info("TestkeyId id :"+pk.getId()+", no : "+pk.getNo()+" 삭제 성공 !");
    		}
    		else throw new Exception("TestkeyId id :"+pk.getId()+", no : "+pk.getNo()+" is not found !");
		} catch (Exception e) {
			log.error(e.toString());
		}
        return "redirect:home";
    } //tdelete
	
}// class
