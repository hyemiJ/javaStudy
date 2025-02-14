package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.domain.GuestBookDTO;
import com.example.demo.domain.PageRequestDTO;
import com.example.demo.domain.PageResultDTO;
import com.example.demo.entity.GuestBook;
import com.example.demo.repository.GuestBookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor//final 필드에 대해서만 생성자를 자동으로 생성
public class GuestBookServiceImpl implements GuestBookService {
	private final GuestBookRepository repository;
	//@RequiredArgsConstructor를 사용하기 위한 final
	//JPA 의 기본적인 CRUD 구현
	@Override
	public List<GuestBook> selectList() {
		return repository.findAll();
	}
	@Override
	public GuestBook selectOne(Long gno) {
		 Optional<GuestBook> result = repository.findById(gno);
		 if(result.isPresent()) return result.get(); 
		 //result 가 있으면 get 해서 해당 정보를 꺼냄.
		 else return null;
	}
	@Override
	public Long register(GuestBook entity) {
		entity = repository.save(entity); 
		// 처리 후, 자동 증가된 gno 값을 반환 (Auto-increment된 기본 키 확인 가능)
		//엔티티를 데이터베이스에 저장하는 역할
		//save 메서드는 새로운 엔티티를 저장 , 이미 존재하는 엔티티라면 업데이트.
		//저장된 엔티티는 데이터베이스에 저장된 값들과 동기화되어 다시 반환 , 즉 ,처리 입력완료가 된 entity를 반환
		return entity.getGno();
	}
	@Override
	public void delete(Long gno) {
//		if(!repository.existsById(gno)) {
//			throw new Exception("Date not found gno : "+gno);
//		} // gno가 존재하는지 확인후 Exception 생성
		repository.deleteById(gno);
	}
    @Override
    public List<GuestBookDTO> selectList2() {
        //List<GuestBook> list = repository.findAll(); //GuestBook 테이블에서 모든 데이터를 조회
        //Function<GuestBook, GuestBookDTO> fn =  entity -> entityToDto(entity) ;
        //Function<T,R> - 유일한 추상 메서드 R apply(T t); : t타입을 입력받아 R타입으로 리턴함.
        //GuestBook 엔티티를 GuestBookDTO로 변환하는 Function 객체를 정의
        // fn 함수는 각 GuestBook 객체를 받아 GuestBookDTO로 변환하는 작업
        //List<GuestBookDTO> list2 = list.stream().map(fn).collect(Collectors.toList()) ;
        //list.stream()은 GuestBook 리스트를 **스트림(stream)**으로 변환하여 각 요소에 대해 순차적으로 작업을 수행할 수 있도록 함.
        //map(fn)은 스트림의 각 GuestBook 객체에 대해 fn 함수(람다 표현식)를 적용하여 GuestBookDTO로 변환
        //collect(Collectors.toList())는 변환된 결과를 다시 **리스트(List)**로 수집하여 반환
        //1. collect() : Stream의 결과를 원하는 자료형으로 바꿔 반환해주는 최종연산자.
        //2. Collectors.toList() : Stream을 List 타입으로 바꿔줌
        //List<GuestBookDTO> list2 = list.stream().map(entity -> entityToDto(entity)).collect(Collectors.toList()) ;
        //return list2 ;
		return repository.findAll()
			.stream()
			.map(entity -> entityToDto(entity))
		    .collect(Collectors.toList());
    }
    
    //pageable을 이용한 paging 기능 추가
	@Override
	public PageResultDTO<GuestBookDTO, GuestBook> pageList(PageRequestDTO requestDTO) {
		//1. 조건완성
		//Pageable pageable= PageRequest.of(requestDTO.getPage()-1, requestDTO.getSize(), Sort.by("gno").descending());
		Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
		//Sort객체는 
		//2. repository 실행
        //=> pageable 을 인자로 하는 findAll 메서드 제공 (Page<E> Type 결과 return)
        //=> List select 후에 count 도 실행함
		Page<GuestBook> result = repository.findAll(pageable);
		//3. Function<EN , DTO> 정의
		//Function<GuestBook, GuestBookDTO> fn =  entity -> entityToDto(entity) ;
		//4. 결과 리턴
		//public PageResultDTO(Page<EN> result, Function<EN, DTO> fn) 
		//return new PageResultDTO(result, fn);
		return new PageResultDTO<>(result, entity -> entityToDto(entity));
	}
}
















