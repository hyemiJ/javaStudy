package com.example.demo03.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoDTO extends MemberDTO {
	private int jno;
	private String jname;
	private String captain;
	private String project;
	private String slogan;
	
}
