package com.example.demo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String main_type;
	private String sub_type;
}
