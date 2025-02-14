-- createdproject.code definition

CREATE TABLE `code` (
  `main_type` varchar(16) NOT NULL,
  `main_type_name` varchar(32) DEFAULT NULL,
  `sub_type` varchar(16) NOT NULL,
  `sub_type_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`main_type`,`sub_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.packaging definition

CREATE TABLE `packaging` (
  `packaging_option_content` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `packaging_option_price` int NOT NULL,
  PRIMARY KEY (`packaging_option_content`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.products definition

CREATE TABLE `products` (
  `product_id` int NOT NULL AUTO_INCREMENT COMMENT '상품 pk',
  `product_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '상품 이름',
  `product_price` int NOT NULL COMMENT '상품 가격',
  `product_sizeinfo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '사이즈정보',
  `product_guide` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '상태 가이드',
  `product_main_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '메인 설명',
  `product_additional_description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci COMMENT '서브 설명',
  `like_count` int DEFAULT '0' COMMENT '관심 수',
  `status` int DEFAULT '0' COMMENT '상태',
  `stock_count` int NOT NULL COMMENT '업데이트날짜',
  `upload_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '카테고리',
  `category_id` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.regist definition

CREATE TABLE `regist` (
  `regist_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `mainimg` varchar(100) DEFAULT NULL,
  `description_img` varchar(100) DEFAULT NULL,
  `regist_option` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `teenager` int DEFAULT NULL COMMENT '청소년요금',
  `adult` int DEFAULT NULL COMMENT '어른요금',
  PRIMARY KEY (`regist_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.users definition

CREATE TABLE `users` (
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '아이디',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '비밀번호',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '이름',
  `birth_date` date NOT NULL COMMENT '생년월일',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '성별',
  `phone_number` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '핸드폰번호',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '이메일',
  `user_sequence` int NOT NULL COMMENT '인덱스',
  `is_withdrawn` tinyint(1) DEFAULT '0' COMMENT '탈퇴여부',
  `withdrawal_date` timestamp NULL DEFAULT NULL COMMENT '탈퇴날짜',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '가입날짜',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '정보수정날짜',
  `block_status` tinyint(1) DEFAULT NULL COMMENT '관리자 권한 접근제한',
  PRIMARY KEY (`user_id`),
  CONSTRAINT `users_chk_1` CHECK ((`gender` in (_utf8mb4'M',_utf8mb4'F')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.address definition

CREATE TABLE `address` (
  `address_id` int NOT NULL AUTO_INCREMENT COMMENT '주소pk',
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '해당유저',
  `postal_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '우편번호',
  `street_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '도로명주소',
  `detailed_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '상세주소',
  `recipient_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '받는사람',
  `recipient_phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '받는사람연락처',
  `is_default` tinyint(1) DEFAULT '0' COMMENT '기본배송지',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성날짜',
  PRIMARY KEY (`address_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.favorite definition

CREATE TABLE `favorite` (
  `user_id` varchar(50) NOT NULL,
  `product_id` int NOT NULL,
  `favorite_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`,`product_id`),
  KEY `favorite_products_FK` (`product_id`),
  CONSTRAINT `favorite_products_FK` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  CONSTRAINT `favorite_users_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.producthistory definition

CREATE TABLE `producthistory` (
  `user_id` varchar(100) DEFAULT NULL,
  `purchase_id` varchar(100) NOT NULL COMMENT '구매id',
  `purchase_number` int DEFAULT NULL COMMENT '주문번호',
  `address_id` int NOT NULL COMMENT '배송지id',
  `total` int DEFAULT NULL,
  `method` varchar(150) DEFAULT NULL,
  `reg_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`purchase_id`),
  UNIQUE KEY `producthistory_unique` (`purchase_number`),
  KEY `producthistory_customer_FK` (`user_id`),
  KEY `producthistory_addresses_FK` (`address_id`),
  CONSTRAINT `producthistory_addresses_FK` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `producthistory_customer_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.productimages definition

CREATE TABLE `productimages` (
  `product_id` int NOT NULL COMMENT '무슨상품인지',
  `image_order` int NOT NULL COMMENT '이미지 순서',
  `image_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '이미지 타입',
  `image_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '이미지 파일명',
  PRIMARY KEY (`product_id`,`image_order`,`image_type`),
  CONSTRAINT `FK_product_images_products` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.productoptions definition

CREATE TABLE `productoptions` (
  `product_id` int NOT NULL,
  `option_content` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `option_price` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`,`option_content`),
  CONSTRAINT `productoptions_products_FK` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.purchaselist definition

CREATE TABLE `purchaselist` (
  `user_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '회원id',
  `product_id` int NOT NULL COMMENT '상품id',
  `option_content` varchar(16) NOT NULL,
  `packaging_option_content` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '추가옵션id',
  `purchase_id` varchar(100) NOT NULL COMMENT '구매id',
  `product_cnt` int DEFAULT NULL,
  `product_total_price` int DEFAULT NULL,
  PRIMARY KEY (`user_id`,`product_id`,`packaging_option_content`,`purchase_id`),
  KEY `purchaselist_product_FK` (`product_id`),
  KEY `purchaselist_packaging_FK` (`packaging_option_content`),
  KEY `purchaselist_producthistory_FK` (`purchase_id`),
  KEY `purchaselist_productoptions_FK` (`product_id`,`option_content`),
  CONSTRAINT `purchaselist_customer_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `purchaselist_packaging_FK` FOREIGN KEY (`packaging_option_content`) REFERENCES `packaging` (`packaging_option_content`),
  CONSTRAINT `purchaselist_producthistory_FK` FOREIGN KEY (`purchase_id`) REFERENCES `producthistory` (`purchase_id`),
  CONSTRAINT `purchaselist_productoptions_FK` FOREIGN KEY (`product_id`, `option_content`) REFERENCES `productoptions` (`product_id`, `option_content`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.registedhistory definition

CREATE TABLE `registedhistory` (
  `regist_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `teenager_cnt` int DEFAULT NULL COMMENT '청소년요금합',
  `adult_cnt` int DEFAULT NULL COMMENT '어른요금합',
  `person_cnt` int DEFAULT NULL,
  `regist_cnt` int DEFAULT NULL COMMENT '총합산금액',
  `reg_date` timestamp NULL DEFAULT NULL,
  `regist_id` varchar(100) NOT NULL,
  PRIMARY KEY (`regist_id`),
  UNIQUE KEY `registedhistory_unique` (`reg_date`),
  KEY `registedhistory_regist_FK` (`regist_code`),
  KEY `registedhistory_customer_FK` (`user_id`),
  CONSTRAINT `registedhistory_customer_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `registedhistory_regist_FK` FOREIGN KEY (`regist_code`) REFERENCES `regist` (`regist_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.reviews definition

CREATE TABLE `reviews` (
  `review_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) NOT NULL,
  `product_id` int NOT NULL,
  `review_content` text NOT NULL,
  `review_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `like_dislike` tinyint(1) NOT NULL DEFAULT '1',
  `review_photo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  KEY `reviews_users_FK` (`user_id`),
  KEY `reviews_products_FK` (`product_id`),
  CONSTRAINT `reviews_products_FK` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  CONSTRAINT `reviews_users_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.cart definition

CREATE TABLE `cart` (
  `user_id` varchar(50) NOT NULL,
  `product_id` int NOT NULL,
  `option_content` varchar(16) NOT NULL,
  `packaging_option_content` varchar(32) NOT NULL,
  `product_cnt` int DEFAULT NULL,
  `product_total_price` int DEFAULT NULL,
  PRIMARY KEY (`user_id`,`product_id`,`option_content`,`packaging_option_content`),
  KEY `cart_productoptions_FK` (`product_id`,`option_content`),
  KEY `cart_packaging_FK` (`packaging_option_content`),
  CONSTRAINT `cart_packaging_FK` FOREIGN KEY (`packaging_option_content`) REFERENCES `packaging` (`packaging_option_content`),
  CONSTRAINT `cart_productoptions_FK` FOREIGN KEY (`product_id`, `option_content`) REFERENCES `productoptions` (`product_id`, `option_content`),
  CONSTRAINT `cart_users_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- createdproject.registdatecnt definition

CREATE TABLE `registdatecnt` (
  `regist_id` varchar(100) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `reg_date` timestamp NULL DEFAULT NULL,
  KEY `registdatecnt_registedhistory_FK` (`regist_id`),
  KEY `registdatecnt_customer_FK` (`user_id`),
  KEY `registdatecnt_registedhistory_FK_1` (`reg_date`),
  CONSTRAINT `registdatecnt_customer_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `registdatecnt_registedhistory_FK` FOREIGN KEY (`regist_id`) REFERENCES `registedhistory` (`regist_id`),
  CONSTRAINT `registdatecnt_registedhistory_FK_1` FOREIGN KEY (`reg_date`) REFERENCES `registedhistory` (`reg_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;