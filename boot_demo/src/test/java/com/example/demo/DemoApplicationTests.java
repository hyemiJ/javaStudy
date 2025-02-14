package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.domain.MemberRole;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class DemoApplicationTests {

	
	
	
	
	
	void contextLoads() {}

	@Autowired
	MemberRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//@Test
	void testList() {
		List<Member> list = repository.findByJno(7);
		for (Member member : list) {
			System.out.println(member);
		}
	}
	
	void insertMember() {
		Member member = Member.builder()
				                .id("roletest")
				                .password(passwordEncoder.encode("12345!"))
				                .name("홍길동")
				                .age(22)
				                .jno(7)
				                .info("SpringBoot Security Test")
				                .point(300.5)
				                .birthday("2000-02-02")
				                .rid("apple")
				                .uploadfile("aaa.gif")
				                .build();
		member.addRole(MemberRole.ADMIN);
		member.addRole(MemberRole.MANAGER);
		member.addRole(MemberRole.USER);
		repository.save(member);
	}
	
	
	void testRead() {
		String id = "roletest";
		Member member = repository.getWithRoles(id);
		log.info(member);
	}
	
	
	void addRole() {
		List<Member> list = repository.findAll();
		
		for(Member m : list) {
			Member member = Member.builder()
					                .id(m.getId())
				                    .password(m.getPassword())
				                    .name(m.getName())
				                    .age(m.getAge())
				                    .jno(m.getJno())
				                    .info(m.getInfo())
				                    .point(m.getPoint())
				                    .birthday(m.getBirthday())
				                    .rid(m.getRid())
				                    .uploadfile(m.getUploadfile())
				                    .build();
			if(m.getJno()==7) {
				member.addRole(MemberRole.ADMIN);
				member.addRole(MemberRole.MANAGER);
			}else if(m.getId().equals("21woo")||
					m.getId().equals("gydbs99")||
					m.getId().equals("chelsea")||
					m.getId().equals("qkdrlfh456")) {
				
				member.addRole(MemberRole.MANAGER);
			}
			member.addRole(MemberRole.USER);
			
			repository.save(member);
		}
	}
	
}
