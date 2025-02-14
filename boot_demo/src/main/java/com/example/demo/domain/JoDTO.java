package com.example.demo.domain;

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
	
	//** select Join 을 위한 생성자.
	//.JoDTO(j.jno, j.jname, j.captain, m.name, j.project, j.slogan) 순서가 같아야함.
	public JoDTO(int jno , String jname,String captain,
			String name ,String project , String slogan ){
		super.setName(name);
		this.jno=jno;
		this.jname=jname;
		this.captain=captain;
		this.project=project;
		this.slogan=slogan;
	}

	@Override
	public String toString() {
		return "JoDTO [jno=" + jno + ", jname=" + jname + ", captain=" + captain + ", project=" + project 
				+ ", id=" + getId() + ", name =" + getName() + ", age=" + getAge() + ", slogan="+ slogan + "]";
	}
	
	
}
