package com.example.demo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoptionsId implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long productId;
	private String content;
}
