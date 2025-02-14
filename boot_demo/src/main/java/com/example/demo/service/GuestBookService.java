package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.GuestBookDTO;
import com.example.demo.domain.PageRequestDTO;
import com.example.demo.domain.PageResultDTO;
import com.example.demo.entity.GuestBook;

public interface GuestBookService {
	// ** JPA CRUD 구현
	//=> JPA CRUD
	//=> JPA Pageable 을 이용한 Pageing
	List<GuestBook> selectList();
	
	GuestBook selectOne(Long gno);
	Long register(GuestBook entity); 
	//register : insert , update 모두 사용
	//			=> return : key값 -> 누구를 업데이트 했는지 알 수있음.
	void delete(Long gno);
	
	//list출력 테스트 => Entity 와 DTO를 용도별로 분리해서 사용
	//	     dtoToEntity() 와  entityToDto() 메서드추가 
	//   즉, default 메서드로 작성
	
	//1. dto -> entity
	//insert , update용도로 주로 사용.
	//그러므로 regdate,moddate는 제외가능.
	default GuestBook dtoToEntity(GuestBookDTO dto) {
		GuestBook entity = GuestBook.builder()
				.gno(dto.getGno())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(dto.getWriter())
				.build();
		return entity;
	}
	
	//2. entity -> dto
	//결과 출력 용으로 많이 사용
	//regdate , moddate 포함.
	default GuestBookDTO entityToDto(GuestBook entity) {
		return GuestBookDTO.builder()
				.gno(entity.getGno())
				.title(entity.getTitle())
				.content(entity.getContent())
				.writer(entity.getWriter())
				.regdate(entity.getRegdate())
				.moddate(entity.getModdate())
				.build();
	}
	
	// => DTO 적용 List
    List<GuestBookDTO> selectList2();
    
    //pageable을 이용한 paging 기능 추가
    PageResultDTO<GuestBookDTO, GuestBook> pageList(PageRequestDTO requestDTO);
    
    
    
    
}


























