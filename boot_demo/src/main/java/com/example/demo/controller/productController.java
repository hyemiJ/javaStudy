package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.ProductoptionsService;
import com.example.demo.service.ProductsService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@AllArgsConstructor
@RequestMapping(value = "/products")
public class productController {
	
	ProductsService service;
	ProductoptionsService opservice;
	
	@GetMapping("/cate/{sub_type_name}")
	public String cate(Model model,@PathVariable("sub_type_name") String subTypeName) {
		model.addAttribute("code", subTypeName);
		System.out.println(subTypeName);
		
		model.addAttribute("banana", service.findByCategoryId(subTypeName));
		return "/products/productList";
	}
	
	@GetMapping("/cate/{categoryid}/{id}")
	public String detail(Model model,@PathVariable("categoryid") String categoryId,@PathVariable("id") Long productId) {
		model.addAttribute("apple", service.findById(productId));
		model.addAttribute("option",opservice.findByProductId(productId) );
		return "/products/productDetail";
	}
}
