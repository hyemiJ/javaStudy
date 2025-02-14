package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Jo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Jo {
	@Id
	private int jno;
	private String jname;
	private String captain;
	private String project;
	private String slogan;
	
}
