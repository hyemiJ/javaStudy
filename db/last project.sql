USE lastProject;

-- 이전 기록
 
-- CREATE TABLE products (
-- product_id INT PRIMARY KEY AUTO_INCREMENT,
--     product_name VARCHAR(100) NOT NULL,
--     product_price int NOT NULL,
--     like_count INT DEFAULT 0,
--     stock_count INT NOT NULL,
--     upload_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 기본값으로 현재 날짜와 시간
--     category_id INT(3), -- 카테고리 ID는 NULL을 허용하여 카테고리가 없을 수 있음
--     FOREIGN KEY (category_id) REFERENCES categories(category_id) 
--     ON UPDATE CASCADE  -- 카테고리 ID가 변경되면 상품 테이블도 변경
--     ON DELETE SET NULL -- 카테고리가 삭제되면 상품의 카테고리 값을 NULL로 설정
--     );


-- create 구문 --------------------------------------------------------------------------------------



CREATE TABLE code (
main_type varchar(16) , -- pk.
main_type_name varchar(32),
sub_type varchar(16),
sub_type_name varchar(64),
 CONSTRAINT code_pk PRIMARY KEY (main_type,sub_type) 
); 

INSERT INTO code values('01PC','카테고리','C1','문구/사무');
INSERT INTO code values('01PC','카테고리','C2','패션/생활');
INSERT INTO code values('01PC','카테고리','C3','인테리어 소품');
INSERT INTO code values('01PC','카테고리','C4','공예품');
INSERT INTO code values('01PC','카테고리','C5','주방/식기');


INSERT INTO code values('02PI','이미지타입','slide','슬라이드 형식');
INSERT INTO code values('02PI','이미지타입','main','메인 형식');


INSERT INTO code values('03PS','상품 상태',0,'준비중');
INSERT INTO code values('03PS','상품 상태',1,'판매중');
INSERT INTO code values('03PS','상품 상태',2,'매진 입고 예정');
INSERT INTO code values('03PS','상품 상태',3,'매진 입고 미정');
 
-- INSERT INTO code values('004','포장상태',0,'굿즈 기본 포장');


	CREATE TABLE products (
	product_id INT AUTO_INCREMENT, -- pk 자동증가
    product_name VARCHAR(128) NOT NULL, -- 상품 이름은 NULL 일 수 없음
    product_price int NOT NULL, -- 상품 가격은 NULL 일 수 없음
    product_sizeinfo text NOT NULL,
    product_guide text ,
    product_main_description text, 
    product_additional_description text,
    like_count INT DEFAULT 0, -- 찜카운트는 디폴트 0
    status int DEFAULT 0,
    stock_count INT NOT NULL, -- 재고는 NULL 일 수 없음.
    upload_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 기본값으로 현재 날짜와 시간
    category_id varchar(16), -- 카테고리 ID는 NULL을 허용하여 카테고리가 없을 수 있음
    CONSTRAINT products_pk PRIMARY KEY (category_id)
    );
   

   CREATE TABLE productimages(
   product_id int NOT NULL, 
   image_order int NOT null, 
   image_type varchar(16) NOT NULL,
   image_name varchar(64) NOT NULL ,
   CONSTRAINT product_images_fk FOREIGN KEY (product_id) REFERENCES products(product_id),
   CONSTRAINT product_images_pk PRIMARY KEY (product_id,image_order,image_type) 
  );
 
   
 	CREATE TABLE productoptions(
 	product_id int NOT NULL,
 	option_content varchar(16) NOT NULL,
 	option_price int NOT NULL DEFAULT 0,
 	CONSTRAINT productoptions_fk FOREIGN KEY (product_id) REFERENCES products(product_id),
 	CONSTRAINT productoptions_pk PRIMARY KEY (product_id,option_content) 
 	);

 	CREATE TABLE packagingoptions(
 	packaging_option_content varchar(32) NOT NULL,
 	packaging_option_price int NOT NULL,
 	CONSTRAINT packaging_options_pk PRIMARY KEY (packaging_option_content) 
 	);
 -- ----------------------------------------------------------------------------------
 
 CREATE TABLE `regist` (
  `registcode` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `mainimg` varchar(100) DEFAULT NULL,
  `descriptionimg` varchar(100) DEFAULT NULL,
  `registoption` varchar(100) DEFAULT NULL,
  `teenager` int DEFAULT NULL COMMENT '청소년요금',
  `adult` int DEFAULT NULL COMMENT '어른요금',
  PRIMARY KEY (`registcode`)
);
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
) ;
CREATE TABLE `producthistory` (
  `user_id` varchar(100) DEFAULT NULL,
  `purchase_id` varchar(100) NOT NULL COMMENT '구매id',
  `purchase_number` int DEFAULT NULL COMMENT '주문번호',
  address_id INT NOT NULL comment'배송지id',
  `total` int DEFAULT NULL,
  `method` varchar(150) DEFAULT NULL,
  `regdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`purchase_id`),
  UNIQUE KEY `producthistory_unique` (`purchase_number`),
  KEY `producthistory_customer_FK` (`user_id`),
  CONSTRAINT `producthistory_addresses_FK` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`),
  CONSTRAINT `producthistory_customer_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ;

CREATE TABLE `purchaselist` (
  `user_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '회원id',
  `product_id` int  NOT NULL COMMENT '상품id',
  `packaging_option_content` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '추가옵션id',
  `purchase_id` varchar(100)  NOT NULL COMMENT '구매id',
  `productcnt` int DEFAULT NULL,
  `totalpay` int DEFAULT NULL,
  PRIMARY KEY (`user_id`,`product_id`,`packaging_option_content`,`purchase_id`),
  KEY `purchaselist_product_FK` (`product_id`),
  KEY `purchaselist_packageoption_FK` (`packaging_option_content`),
  KEY `purchaselist_producthistory_FK` (`purchase_id`),
  CONSTRAINT `purchaselist_customer_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `purchaselist_producthistory_FK` FOREIGN KEY (`purchase_id`) REFERENCES `producthistory` (`purchase_id`),
  CONSTRAINT `purchaselist_packageoption_FK` FOREIGN KEY (`packaging_option_content`) REFERENCES packagingoptions (`packaging_option_content`),
  CONSTRAINT `purchaselist_product_FK` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ;


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
) ;

-- -------------------------------------------------------------------------------------
 
 CREATE TABLE users (
    user_id VARCHAR(50) PRIMARY KEY,         
    password VARCHAR(255) NOT NULL,          
    name VARCHAR(100) NOT NULL,               
    birth_date DATE NOT NULL,                 
    gender CHAR(1) CHECK (gender IN ('M', 'F')), 
    phone_number VARCHAR(15) NOT NULL,        
    email VARCHAR(100) NOT NULL,              
    user_sequence INT NOT NULL,  
    is_withdrawn BOOLEAN DEFAULT FALSE,       
    withdrawal_date TIMESTAMP NULL,           
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
 
 CREATE TABLE addresses (
    address_id INT AUTO_INCREMENT PRIMARY KEY,  
    user_id VARCHAR(50),                        
    postal_code VARCHAR(10),                   
    street_address VARCHAR(255),             
    detailed_address VARCHAR(255),            
    recipient_name VARCHAR(100),                
    recipient_phone VARCHAR(15),               
    is_default BOOLEAN DEFAULT FALSE,           
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) 
);
 
CREATE TABLE user_statistics (
    user_id VARCHAR(50) PRIMARY KEY,            
    last_login TIMESTAMP,                      
    login_count INT DEFAULT 0,                  
    purchase_count_total INT DEFAULT 0,         
    purchase_amount_total INT DEFAULT 0,        
    last_purchase TIMESTAMP,                    
    purchase_value_average INT AS (purchase_amount_total / purchase_count_total), 
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
); -- 추후 구매내역 구현시 create
 
 
-- Project.customer definition

CREATE TABLE `customer` (
  `userid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `addressdetail` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `zipcode` varchar(100) NOT NULL,
  `phone` int DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Project.packageoption definition

CREATE TABLE `packageoption` (
  `extraoptionid` varchar(100) NOT NULL,
  `extraprice` int DEFAULT NULL,
  `extraoption` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`extraoptionid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Project.product definition

CREATE TABLE `product` (
  `productid` varchar(100) NOT NULL,
  `name` varchar(250) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `category` varchar(150) DEFAULT NULL,
  `likecnt` int DEFAULT NULL,
  `productcnt` varchar(100) DEFAULT NULL COMMENT '상품재고',
  `regdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Project.regist definition

CREATE TABLE `regist` (
  `registcode` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `mainimg` varchar(100) DEFAULT NULL,
  `descriptionimg` varchar(100) DEFAULT NULL,
  `registoption` varchar(100) DEFAULT NULL,
  `teenager` int DEFAULT NULL COMMENT '청소년요금',
  `adult` int DEFAULT NULL COMMENT '어른요금',
  PRIMARY KEY (`registcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Project.`option` definition

CREATE TABLE `option` (
  `productid` varchar(100) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `optionprice` int DEFAULT NULL,
  KEY `option_product_FK` (`productid`),
  CONSTRAINT `option_product_FK` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Project.producthistory definition

CREATE TABLE `producthistory` (
  `userid` varchar(100) DEFAULT NULL,
  `purchaseeid` varchar(100) NOT NULL COMMENT '구매id',
  `purchasenumber` int DEFAULT NULL COMMENT '주문번호',
  `total` int DEFAULT NULL,
  `method` varchar(150) DEFAULT NULL,
  `regdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`purchaseeid`),
  UNIQUE KEY `producthistory_unique` (`purchasenumber`),
  KEY `producthistory_customer_FK` (`userid`),
  CONSTRAINT `producthistory_customer_FK` FOREIGN KEY (`userid`) REFERENCES `customer` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Project.productregist definition

CREATE TABLE `productregist` (
  `productid` varchar(100) DEFAULT NULL,
  `filename` varchar(100) DEFAULT NULL,
  KEY `productregist_product_FK` (`productid`),
  CONSTRAINT `productregist_product_FK` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='상품등록 페이지';


-- Project.registedhistory definition

CREATE TABLE `registedhistory` (
  `registcode` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `userid` varchar(100) DEFAULT NULL,
  `teenagercnt` int DEFAULT NULL COMMENT '청소년요금합',
  `adultcnt` int DEFAULT NULL COMMENT '어른요금합',
  `personcnt` int DEFAULT NULL,
  `registcnt` int DEFAULT NULL COMMENT '총합산금액',
  `regdate` timestamp NULL DEFAULT NULL,
  `registid` varchar(100) NOT NULL,
  PRIMARY KEY (`registid`),
  UNIQUE KEY `registedhistory_unique` (`regdate`),
  KEY `registedhistory_regist_FK` (`registcode`),
  KEY `registedhistory_customer_FK` (`userid`),
  CONSTRAINT `registedhistory_customer_FK` FOREIGN KEY (`userid`) REFERENCES `customer` (`userid`),
  CONSTRAINT `registedhistory_regist_FK` FOREIGN KEY (`registcode`) REFERENCES `regist` (`registcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Project.delivery definition

CREATE TABLE `delivery` (
  `purchaseeid` varchar(100) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `addressdetail` varchar(250) DEFAULT NULL,
  `zipcode` varchar(100) DEFAULT NULL,
  `recipient` varchar(100) DEFAULT NULL,
  `recipientphone` int DEFAULT NULL,
  `deliveryid` varchar(100) NOT NULL,
  PRIMARY KEY (`deliveryid`),
  KEY `delivery_customer_FK` (`purchaseeid`),
  CONSTRAINT `delivery_customer_FK` FOREIGN KEY (`purchaseeid`) REFERENCES `customer` (`userid`),
  CONSTRAINT `delivery_producthistory_FK` FOREIGN KEY (`purchaseeid`) REFERENCES `producthistory` (`purchaseeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Project.purchaselist definition

CREATE TABLE `purchaselist` (
  `userid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '회원id',
  `productid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '구매id',
  `extraoptionid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '추가옵션id',
  `deliveryid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '배송지id',
  `productcnt` int DEFAULT NULL,
  `extracnt` int DEFAULT NULL,
  `totalpay` int DEFAULT NULL,
  PRIMARY KEY (`userid`,`productid`,`extraoptionid`,`deliveryid`),
  KEY `purchaselist_product_FK` (`productid`),
  KEY `purchaselist_packageoption_FK` (`extraoptionid`),
  KEY `purchaselist_delivery_FK` (`deliveryid`),
  CONSTRAINT `purchaselist_customer_FK` FOREIGN KEY (`userid`) REFERENCES `customer` (`userid`),
  CONSTRAINT `purchaselist_delivery_FK` FOREIGN KEY (`deliveryid`) REFERENCES `delivery` (`deliveryid`),
  CONSTRAINT `purchaselist_packageoption_FK` FOREIGN KEY (`extraoptionid`) REFERENCES `packageoption` (`extraoptionid`),
  CONSTRAINT `purchaselist_product_FK` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Project.registdatecnt definition

CREATE TABLE `registdatecnt` (
  `registid` varchar(100) DEFAULT NULL,
  `userid` varchar(100) DEFAULT NULL,
  `regdate` timestamp NULL DEFAULT NULL,
  KEY `registdatecnt_registedhistory_FK` (`registid`),
  KEY `registdatecnt_customer_FK` (`userid`),
  KEY `registdatecnt_registedhistory_FK_1` (`regdate`),
  CONSTRAINT `registdatecnt_customer_FK` FOREIGN KEY (`userid`) REFERENCES `customer` (`userid`),
  CONSTRAINT `registdatecnt_registedhistory_FK` FOREIGN KEY (`registid`) REFERENCES `registedhistory` (`registid`),
  CONSTRAINT `registdatecnt_registedhistory_FK_1` FOREIGN KEY (`regdate`) REFERENCES `registedhistory` (`regdate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 -- -----------------------------------------------------------------------------------------------
 CREATE TABLE favorite (
userid varchar(100) NOT NULL, -- FK 이자 PK
product_id varchar(100) NOT NULL, -- FK 이자 PK
favorite_date DATE NOT NULL,
CONSTRAINT favorite_pk PRIMARY KEY (id,product_id)
)

CREATE TABLE cart (
userid varchar(100) NOT NULL, -- FK 이자 PK
product_id varchar(100) NOT NULL, -- FK 이자 PK
option_content varchar(100) NOT NULL, -- FK 이자 PK
packaging_option_content varchar(100) NOT NULL, -- FK 이자 PK
product_count INT NOT NULL,
product_total_price INT NOT NULL,
CONSTRAINT cart_pk PRIMARY KEY (id,product_id,option_content,packaging_option_content)
)
 	
-- create 구문 --------------------------------------------------------------------------------------
   
   
   DROP TABLE productoptions ;
   
  SELECT * FROM productoptions c ;
  SELECT * FROM products;
  SELECT * FROM product_images;
  
 -- insert 구문 --------------------------------------------------------------------------------------
 

-- -------------------------------------------
INSERT INTO packaging values('굿즈 기본 포장',0);
INSERT INTO packaging values('굿즈 부직포 가방',2000);
INSERT INTO packaging values('굿즈 천 포장',4000);

-- 1) 취객 선비 3인방 셋팅. ==============================================================
-- 1. products
INSERT INTO products(product_name,product_price,stock_count,category_id,
product_sizeInfo, product_guide,product_main_description,product_additional_description) 
	values('취객선비 3인방 변색 잔세트',26000,100,'kitchGoods',
'상품 크기 :윗면 지름 46mm, 바닥면 지름 44mm, 높이 58mm
        상품 소재 : 유리
        상품 구성 : 유리잔 낱개 3개, 패키지',
      '* 해당 제품은 품절로 현재는 구매 불가합니다. (재입고 7/4)',
     '국립박물관문화재단 소장품 번호 5769
        [전 김홍도 필 평안감사향연도]에 등장하는.
        취객 선비 3인방을 모티브로 디자인된 변색 소주잔 입니다.',
       '온도에 반응하는 시온 안료 프린팅으로,
        잔에 차가운 술이 담기면
        선비들의 얼굴이 붉게 물들며
        즐거운 술자리 분위기를 연출합니다.');
-- 2. productoptions      
INSERT INTO productoptions(product_id,option_content)
 	values(1, '취객선비 3인방 변색 잔세트');
       
       
-- 2) 박물관 키링 세팅 ==============================================================
 -- 1. products
INSERT INTO products (
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_main_description,
    product_additional_description
) 
VALUES (
    '박물관 키링(신라의 미소)',
    20000,
    90,
    'C2',  -- 'C2'는 '패션/생활' 카테고리에 해당 
    '상품 크기 :포장크기: 85X170X30mm\n상품 구성 : 키링 1개',
    '국립 경주박물관 주요 유물 <얼굴무늬 수막새>를 주제로 한 박물관 기념 키링입니다. 유물의 형태를 구현하고 섬세한 자수가 어우러진 키링입니다.',
    '국립박물관 유물의 아름다움을 일상에서 마주할 수 있도록 활용도 높은 문구 및 생활소품으로 기획했습니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id,option_content)
 	values(2, '박물관 키링(신라의 미소)');

-- 3)스프링 수첩 세팅 ==============================================================
 -- 1. products
INSERT INTO products (
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_main_description,
    product_additional_description
) 
VALUES (
    '반가사유상 캐릭터 스프링 수첩',
    3000,
    59,
    'C1',  -- 'C1'은 '문구/사무' 카테고리에 해당
    '상품 크기 : 75x120mm\n상품 구성 : 스프링수첩 1개(2종 택1), opp 봉투, 약 70장(1,2장 오차 있음)',
    '국립중앙박물관 대표 유물 \'반가사유상\'이 귀엽고 친근한 캐릭터로 재탄생하였습니다. 반가사유상 캐릭터의 잔잔한 미소와 존재감 있는 색상이 특징인 상품입니다.',
    '수첩의 내부는 무선이며 반가사유상 캐릭터가 은은하게 프린트 되어있어 다양하게 사용하기 좋습니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id,option_content)
 	values(3, '하트 뿅뿅(블루)');
INSERT INTO productoptions(product_id,option_content)
 	values(3, '좋은 생각(퍼플)');

-- 4)흑자 달항아리 세팅 ==============================================================
 -- 1. products
INSERT INTO products (
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '흑자 달항아리',
    224000,
    23,
    'C4',  -- 'C4'는 '공예품' 카테고리에 해당 
    '상품 크기 :(소)140x140x150mm, (중)200X200X220mm, (대)300X300X320mm\n상품 소재 : 도자기\n상품 구성 : 달항아리 1개(3종 택1), 패키지',
    '중, 대 크기는 수도권 내 퀵 발송만 가능합니다.(택배 발송 불가, 퀵비 별도부과)',
    '짙은 흙을 바탕으로 작업한 흑자 귀얄 달항아리는 표면에 분청사기 장식 기법 중 하나인 \'귀얄기법\'을 응용하여 작품을 완성하였습니다.',
    '기존의 백자달항아리와는 달리 표면에 자연스러운 붓터치감이 특징이며, 공간의 무게감을 줌으로써 오브제나 화기로 사용이 가능합니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id,option_content)
 	values(4, '소');
INSERT INTO productoptions(product_id,option_content,option_price)
 	values(4, '중 퀵 발송, 별도 부가',220000);
INSERT INTO productoptions(product_id,option_content,option_price)
 	values(4, '대 퀵 발송, 별도 부가',722000);

-- 5)에디션2 세팅 ==============================================================
 -- 1. products
INSERT INTO products (
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '롱롱타임플라워 초충도 에디션2',
    65000,
    120,
    'C3',  -- 'C3'은 '인테리어 소품' 카테고리에 해당 
    '상품 크기 : (꽃, 잎) 100~170mm 이내\n(두께) 약1mm\n패키지 크기 : 338x400mm\n상품 소재 : 종이\n상품 구성 : 1세트에 7개입(꽃,잎,곤충), 패키지, opp봉투',
    '* 해당 제품은 한정 상품으로 현재는 구매 불가합니다. (재입고 예정없음)',
    '국립박물관문화재단 상품 브랜드 <뮷즈>와\n<나난> 작가의 콜라보 상품입니다.\n네이버 쇼핑 \'뮤지엄숍\'에서 판매 중입니다.',
    '국립중앙박물관 소장품 \'초충도\'를 활용하여\n나난 작가와 국립박물관 상품 브랜드 \'뮷즈(MU:DS)\'가 협업하여 제작한 상품입니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id,option_content)
 	values(5, '소');
INSERT INTO productoptions(product_id,option_content,option_price)
 	values(5, '중 퀵 발송, 별도 부가',220000);
INSERT INTO productoptions(product_id,option_content,option_price)
 	values(5, '대 퀵 발송, 별도 부가',722000);
 	
 -- 6)아로마 캔들 세팅 ==============================================================

 -- 1. products
 INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '고려청자 모티브 아로마 캔들',
    35000,
    50,
     'C3',  -- 'C3'은 '인테리어 소품' 카테고리에 해당
    '상품 크기 : 90x120mm',
    '* 향의 강도는 개인에 따라 다를 수 있습니다.',
    '고려청자의 고유한 디자인과 색감을 반영한 아로마 캔들입니다.',
    '천연 성분만을 사용하여 제작되었습니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (6, '연꽃 향');
INSERT INTO productoptions(product_id, option_content)
VALUES (6, '백단 향');
INSERT INTO productoptions(product_id, option_content)
VALUES (6, '매화 향');

 -- 7)노트북 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '조선 왕조 의궤 노트북',
    18000,
    200,
    'C1',  -- 'C1'은 '문구/사무' 카테고리에 해당
    '상품 크기 : 150x210mm',
    '* 표지가 물에 젖으면 변형될 수 있습니다.',
    '조선 왕조의 의궤를 참고하여 디자인된 노트북입니다.',
    '튼튼한 제본과 두꺼운 종이로 오랫동안 사용할 수 있습니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (7, 'A5');
INSERT INTO productoptions(product_id, option_content)
VALUES (7, 'A6');
INSERT INTO productoptions(product_id, option_content)
VALUES (7, 'B5');

 -- 8)전통펜 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '전통 문양 고급 펜 세트',
    50000,
    100,
    'C1',  -- 'C1'은 '문구/사무' 카테고리에 해당
    '상품 크기 : 펜 길이 140mm',
    '* 잉크 리필 가능',
    '한국 전통 문양이 새겨진 고급 펜 세트입니다.',
    '선물용으로 좋은 패키지에 담겨 있습니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (8, '청동');
INSERT INTO productoptions(product_id, option_content)
VALUES (8, '은색');
INSERT INTO productoptions(product_id, option_content)
VALUES (8, '금색');

 -- 9)티셔츠 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '훈민정음 티셔츠',
    45000,
    70,
    'C2',  -- 'C2'는 '패션/생활' 카테고리에 해당
    '상품 크기 : S, M, L, XL',
    '* 세탁 시 뒤집어서 세탁하세요.',
    '훈민정음의 글자를 디자인한 한정판 티셔츠입니다.',
    '고급 원단을 사용하여 편안한 착용감을 제공합니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (9, 'S');
INSERT INTO productoptions(product_id, option_content)
VALUES (9, 'M');
INSERT INTO productoptions(product_id, option_content)
VALUES (9, 'L');
INSERT INTO productoptions(product_id, option_content)
VALUES (9, 'XL');

 -- 10)컵 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '한국 전통 문양 컵',
    30000,
    50,
    'C5',  -- 'C5'은 '주방/식기' 카테고리에 해당
    '상품 크기 : 80x100mm',
    '* 식기세척기 사용 가능',
    '한국 전통 문양이 새겨진 고급 컵입니다.',
    '선물용으로 좋은 패키지에 담겨 있습니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (10, '단일 색상');

 -- 11)한복 인형 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '한복 인형',
    40000,
    30,
     'C3',  -- 'C3'은 '인테리어 소품' 카테고리에 해당
    '상품 크기 : 250mm',
    '* 손세탁 권장',
    '전통 한복을 입은 인형입니다.',
    '한국의 아름다운 전통 의상을 재현한 인형입니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (11, '남아');
INSERT INTO productoptions(product_id, option_content)
VALUES (11, '여아');

 -- 12)전통 문양 접시 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '전통 문양 접시 세트',
    55000,
    40,
    'C5',  -- 'C5'은 '주방/식기' 카테고리에 해당
    '상품 크기 : 200x200mm',
    '* 전자레인지 사용 가능',
    '한국 전통 문양이 새겨진 고급 접시 세트입니다.',
    '선물용으로 좋은 패키지에 담겨 있습니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (12, '청자색');
INSERT INTO productoptions(product_id, option_content)
VALUES (12, '백자색');
 -- 13)베개 커버 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '한국 전통 문양 베개 커버',
    25000,
    100,
    'C3',  -- 'C3'은 '인테리어 소품' 카테고리에 해당
    '상품 크기 : 450x450mm',
    '* 손세탁 권장',
    '한국 전통 문양이 새겨진 고급 베개 커버입니다.',
    '인테리어 소품으로 좋은 패키지에 담겨 있습니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (13, '꽃무늬');
INSERT INTO productoptions(product_id, option_content)
VALUES (13, '흑백 줄무늬');
 -- 14)머그컵 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '한글 디자인 머그컵',
    20000,
    80,
    'C5',  -- 'C5'은 '주방/식기' 카테고리에 해당
    '상품 크기 : 90x100mm',
    '* 식기세척기 사용 가능',
    '한글 디자인이 새겨진 머그컵입니다.',
    '선물용으로 좋은 패키지에 담겨 있습니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (14, '흰색');
INSERT INTO productoptions(product_id, option_content)
VALUES (14, '검정색');

 -- 15)우산 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '한국 전통 문양 우산',
    35000,
    150,
    'C2',  -- 'C2'는 '패션/생활' 카테고리에 해당
    '상품 크기 : 1000mm',
    '* 손세탁 권장',
    '한국 전통 문양이 새겨진 고급 우산입니다.',
    '패션 아이템으로도 훌륭한 제품입니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (15, '노란색');
INSERT INTO productoptions(product_id, option_content)
VALUES (15, '검정색');

 -- 16)쿠션 커버 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '한국 전통 무늬 쿠션 커버',
    20000,
    40,
    'C3',  -- 'C3'은 '인테리어 소품' 카테고리에 해당
    '상품 크기 : 450x450mm',
    '* 손세탁 권장',
    '한국 전통 무늬가 새겨진 고급 쿠션 커버입니다.',
    '인테리어 소품으로 훌륭한 제품입니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (16, '청색');
INSERT INTO productoptions(product_id, option_content)
VALUES (16, '적색');

 -- 17)담요 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '한복 패턴 담요',
    50000,
    30,
    'C3',  -- 'C3'은 '인테리어 소품' 카테고리에 해당
    '상품 크기 : 1500x2000mm',
    '* 손세탁 권장',
    '전통 한복 패턴이 들어간 고급 담요입니다.',
    '인테리어 소품으로 훌륭한 제품입니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (17, '소');
INSERT INTO productoptions(product_id, option_content,option_price)
VALUES (17, '중',4000);
INSERT INTO productoptions(product_id, option_content,option_price)
VALUES (17, '대',8000);

 -- 18)에코백 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '전통 문양 에코백',
    30000,
    50,
    'C2',  -- 'C2'는 '패션/생활' 카테고리에 해당
    '상품 크기 : 380x420mm',
    '* 세탁기 사용 가능',
    '한국 전통 문양이 새겨진 고급 에코백입니다.',
    '패션 아이템으로도 훌륭한 제품입니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (18, '흰색');
INSERT INTO productoptions(product_id, option_content)
VALUES (18, '검정색');

 -- 19)러그 세팅 ==============================================================
 -- 1. products
INSERT INTO products(
    product_name,
    product_price,
    stock_count,
    category_id,
    product_sizeInfo,
    product_guide,
    product_main_description,
    product_additional_description
) 
VALUES (
    '한국 전통 무늬 러그',
    75000,
    40,
    'C3',  -- 'C3'은 '인테리어 소품' 카테고리에 해당
    '상품 크기 : 2000x3000mm',
    '* 세탁기 사용 불가, 손세탁 권장',
    '한국 전통 무늬가 들어간 고급 러그입니다.',
    '인테리어 소품으로 훌륭한 제품입니다.'
);
-- 2. productoptions
INSERT INTO productoptions(product_id, option_content)
VALUES (19, '소');
INSERT INTO productoptions(product_id, option_content,option_price)
VALUES (19, '중',40000);
INSERT INTO productoptions(product_id, option_content,option_price)
VALUES (19, '대',90000);

 -- 20) 세팅==============================================================
 -- 1. products
-- 2. productoptions
