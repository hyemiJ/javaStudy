package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Products {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	// AUTO_INCREMENT를 처리하는 애노테이션
	
	@Column(name = "productId", nullable = false)
	private Long id;
	
	 @Column(name = "productName", nullable = false)
	private String name;
	 @Column(name = "productPrice", nullable = false)
	private int price;
	@Column(name = "productSizeinfo",columnDefinition = "text CHARACTER SET utf8mb4 ")
	private String size_info;
	@Column(name = "productGuide",columnDefinition = "text CHARACTER SET utf8mb4 ")
	private String guide;
	@Column(name = "productMainDescription",columnDefinition = "text CHARACTER SET utf8mb4 ")
	private String main_description;
	@Column(name = "productAdditionalDescription",columnDefinition = "text CHARACTER SET utf8mb4 ")
	private String sub_description;
	@Column(name = "likeCount", columnDefinition = "int default 0")
	private int like_conut;
	@Column(name = "status", columnDefinition = "int default 0")
	private int status;
	@Column(name = "stockCount", columnDefinition = "int default 0")
	private int stock_count;
	@Column(name = "uploadDate", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	private Timestamp uploadDate;
	@Column(name = "categoryId")
	private String categoryId;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<Productoptions> options;
}
