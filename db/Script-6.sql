ALTER TABLE project.regist ADD hightlight_1 varchar(150) NULL;
ALTER TABLE project.regist ADD hightlight_2 varchar(150) NULL;
ALTER TABLE project.regist ADD hightlight_3 varchar(150) NULL;
ALTER TABLE project.regist ADD hightlight_4 varchar(150) NULL;
ALTER TABLE project.regist ADD package_detail varchar(200) NULL;
ALTER TABLE project.regist ADD restrict_detail varchar(200) NULL;
ALTER TABLE project.regist ADD reserve_restrict varchar(200) NULL;
ALTER TABLE project.regist ADD etc_detail varchar(200) NULL;



INSERT INTO project.code
(main_type, main_type_name, sub_type, sub_type_name)
VALUES('04RS', '예약', '1', '체험예약');

INSERT INTO project.regist
(regist_code, name, regist_option, teenager, adult, hightlight_1, hightlight_2, hightlight_3, hightlight_4, package_detail, restrict_detail, reserve_restrict, etc_detail)
VALUES('04RS', '영롱한 자개소반 미니어처 만들기', '문화체험', 5000, 10000,
'빛에 따라 색이 달라지는 오묘한 매력의 자개로 나만의 나전칠기 작품을 만들어 보세요.',
'우리나라 전통 소반을 귀여운 미니어처로 제작하여 세상에 단 하나뿐인 작품을 간직할 수 있어요.',
'직접 디자인한 영롱한 자개소반을 소중한 사람에게 선물해보는 건 어떠세요?',
'소반 미니어처 외에 손거울, 스마트폰 그립톡, 머리끈 등 자개를 이용한 다양한 제품을 만들 수 있습니다.',
'자개로 굿즈 만들기 체험',
'음주 상태의 참여자는 서비스 이용이 거부될 수 있습니다. 이 경우 입장이 불가합니다.',
'그룹 규모: 참여자 수 1-25인.',
'유모차 및 휠체어 이용이 불가합니다.');

ALTER TABLE project.registedhistory MODIFY COLUMN regist_id int auto_increment auto_increment NOT NULL;


INSERT INTO project.registedhistory
(regist_code, user_id, teenager_cnt, adult_cnt, person_cnt, regist_cnt, active_date)
VALUES('04RS', 'user1', 2,1, 3, 20000,   '2024-10-07');

INSERT INTO project.registimages
(regist_code, image_order, image_type, image_name)
VALUES('04RS', 1, 'main', 'reserve01.jpg');
INSERT INTO project.registimages
(regist_code, image_order, image_type,image_name)
VALUES('04RS', 2, 'main', 'reserve02.JPG');
INSERT INTO project.registimages
(regist_code, image_order, image_type, image_name)
VALUES('04RS', 3, 'main', 'reserve03.JPG');
INSERT INTO project.registimages
(regist_code, image_order, image_type, image_name)
VALUES('04RS', 4, 'main', 'reserve04.JPG');
INSERT INTO project.registimages
(regist_code, image_order, image_type, image_name)
VALUES('04RS', 5, 'main', 'reserve05.JPG');
INSERT INTO project.registimages
(regist_code, image_order, image_type, image_name)
VALUES('04RS', 6, 'main', 'reserve06.JPG');
INSERT INTO project.registimages
(regist_code, image_order, image_type, image_name)
VALUES('04RS', 7, 'main', 'reserve07.JPG');

INSERT INTO project.registimages
(regist_code, image_order, image_type, image_name)
VALUES('04RS', 1, 'detail', '예약설명1.jpg');
INSERT INTO project.registimages
(regist_code, image_order, image_type, image_name)
VALUES('04RS', 2, 'detail', '예약설명2.jpg');
INSERT INTO project.registimages
(regist_code, image_order, image_type, image_name)
VALUES('04RS', 3, 'detail', '예약설명3.jpg');
-- 



-- 기훈


INSERT INTO project.cart
(user_id, product_id, option_content, packaging_option_content, product_cnt, product_total_price, cart_date)
VALUES('user1', 2, '박물관 키링(신라의 미소)', '굿즈 부직포 가방', 3, 66000, '2024-09-27 17:56:35');
INSERT INTO project.cart
(user_id, product_id, option_content, packaging_option_content, product_cnt, product_total_price, cart_date)
VALUES('user1', 2, '박물관 키링(신라의 미소)', '굿즈 기본 포장', 2, 40000, '2024-09-24 17:56:35');
INSERT INTO project.cart
(user_id, product_id, option_content, packaging_option_content, product_cnt, product_total_price, cart_date)
VALUES('user1', 4, '대 퀵 발송, 별도 부가', '굿즈 천 포장', 2, 1900000, '2024-09-12 17:59:18');

-- 효윤 9.27

ALTER TABLE `users` 
ADD COLUMN `is_admin` tinyint(1) DEFAULT 0 COMMENT '관리자 여부 (1: 관리자, 0: 일반 사용자)';

users DESC;


UPDATE `users`
SET `is_admin` = 1
WHERE user_id = '11';


ALTER TABLE users MODIFY user_sequence INT NOT NULL AUTO_INCREMENT;

WITH ranked_users AS (
  SELECT user_id, 
         ROW_NUMBER() OVER (ORDER BY user_id) + (SELECT MAX(user_sequence) FROM users) AS new_sequence
  FROM users
  WHERE user_sequence = 0
)
UPDATE users u
JOIN ranked_users ru ON u.user_id = ru.user_id
SET u.user_sequence = ru.new_sequence;

INSERT INTO project.address
(address_id, user_id, postal_code, street_address, detailed_address, recipient_name, recipient_phone, is_default, created_at)
VALUES(5, 'user1', '12426', '경기 가평군 가평읍 불기산길 2 (상색리, 주식회사 블레스 F&T)', '103-1031', '집', '010-1234-4567', 0, '2024-10-01 00:00:00');
INSERT INTO project.address
(address_id, user_id, postal_code, street_address, detailed_address, recipient_name, recipient_phone, is_default, created_at)
VALUES(6, 'user1', '46760', '부산 강서구 르노삼성대로 14 (신호동)', '104동 901호', '회사', '010-0000-0000', 0, '2024-10-02 00:00:00');
INSERT INTO project.address
(address_id, user_id, postal_code, street_address, detailed_address, recipient_name, recipient_phone, is_default, created_at)
VALUES(7, 'fgdsgfdgf23', '12426', '경기 가평군 가평읍 불기산길 2 (상색리, 주식회사 블레스 F&T)', '104동 901호', '집', '89041-5555-5555', 0, '2024-10-02 00:00:00');
INSERT INTO project.address
(address_id, user_id, postal_code, street_address, detailed_address, recipient_name, recipient_phone, is_default, created_at)
VALUES(8, 'qwer123', '07049', '서울 동작구 양녕로 153-9 (상도동, 약수선원)', '123동 123호', '집', '010-1234-6789', 0, '2024-10-02 00:00:00');
INSERT INTO project.address
(address_id, user_id, postal_code, street_address, detailed_address, recipient_name, recipient_phone, is_default, created_at)
VALUES(9, 'qwer12345', '46760', '부산 강서구 르노삼성대로 14 (신호동)', '104동 901호', '집', '010-0987-6543', 0, '2024-10-02 00:00:00');
INSERT INTO project.address
(address_id, user_id, postal_code, street_address, detailed_address, recipient_name, recipient_phone, is_default, created_at)
VALUES(10, 'qwer1230', '02830', '서울 성북구 아리랑로 3 (동소문동6가, 기업은행)', '104동 901호', '집', '010-1111-2222', 0, '2024-10-02 00:00:00');
INSERT INTO project.address
(address_id, user_id, postal_code, street_address, detailed_address, recipient_name, recipient_phone, is_default, created_at)
VALUES(11, 'qwer444', '22852', '인천 서구 로봇랜드로 33 (원창동)', '104동 901호', '집', '010-1111-1111', 0, '2024-10-02 00:00:00');


ALTER TABLE project.address CHANGE recipient_name `location_name:` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '받는곳';
ALTER TABLE project.address MODIFY COLUMN `location_name:` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '받는곳';
ALTER TABLE project.address ADD recipient_name varchar(50) NULL COMMENT '수령인';

-- no
SELECT gender , count(*) AS count FROM  users u JOIN orders o ON u.user_id = o.user_id JOIN ordersdetail o2 ON o.purchase_number = o2.purchase_number WHERE o2.product_id=13
GROUP BY u.gender; 

-- 성별당 구매 횟수
SELECT u.gender, COUNT(od.purchase_number) AS purchase_count
FROM ordersdetail od
JOIN orders o ON od.purchase_number = o.purchase_number
JOIN users u ON o.user_id = u.user_id
GROUP BY u.gender;

ALTER TABLE users ADD login_count INT NOT NULL DEFAULT 0 COMMENT '로그인횟수';


-- 상품 아이디 1 에 대한 구매 성별

SELECT u.gender, COUNT(od.purchase_number) AS purchase_count
FROM ordersdetail od
JOIN orders o ON od.purchase_number = o.purchase_number
JOIN users u ON o.user_id = u.user_id
WHERE od.product_id =15
GROUP BY u.gender;

SELECT 
    u.gender,                       -- 성별
    od.product_id,                  -- 상품 ID
    COUNT(od.purchase_number) AS purchaseCount -- 각 성별에 따른 상품 구매 횟수
FROM 
    ordersdetail od
LEFT JOIN 
    orders o ON od.purchase_number = o.purchase_number -- orders와 ordersdetail을 purchase_number로 조인
LEFT JOIN 
    users u ON o.user_id = u.user_id  -- orders와 users를 user_id로 조인
WHERE 
    od.product_id = 15        -- 특정 productId에 대한 정보
AND 
    u.gender IN ('M', 'F')            -- 성별이 M 또는 F인 경우만 필터링
GROUP BY 
    u.gender,                         -- 성별별 그룹화
    od.product_id                     -- 상품별 그룹화
ORDER BY 
    u.gender;                         -- 성별로 정렬


SELECT u.gender, COUNT(od.purchase_number) AS purchase_count
FROM ordersdetail od
LEFT JOIN orders o ON od.purchase_number = o.purchase_number
LEFT JOIN users u ON o.user_id = u.user_id
WHERE od.product_id = 15
AND u.gender in('M','F')
GROUP BY u.gender;



-- 상품 구매일별로 구매 횟수를 뽑아내기
SELECT o.reg_date , COUNT(od.purchase_number) AS purchase_count
FROM ordersdetail od
JOIN orders o ON od.purchase_number = o.purchase_number
JOIN users u ON o.user_id = u.user_id

WHERE od.product_id = 15
GROUP BY o.reg_date;

-- 상품별 찜을 한 성별 뽑기
SELECT u.gender, COUNT(*) 
FROM products p 
JOIN favorites f ON f.product_id = p.product_id 
JOIN users u ON f.user_id = u.user_id 
WHERE p.product_id = 3
GROUP BY u.gender;


-- 구매 디테일에서 해당 상품 해당 옵션 구매율

SELECT o.product_id, sum(o.product_cnt) , o.option_content , o.packaging_option_content FROM ordersdetail o 
JOIN productoptions p ON p.option_content = o.option_content  AND o.product_id = p.product_id 
JOIN packaging p2 ON  p2.packaging_option_content =o.packaging_option_content 
WHERE o.product_id =9 
GROUP BY o.option_content ,o.packaging_option_content ;

-- SELECT o.product_id, o.product_cnt, o.option_content, o.packaging_option_content
-- FROM ordersdetail o
-- JOIN productoptions p ON p.option_content = o.option_content
-- JOIN packaging p2 ON p2.packaging_option_content = o.packaging_option_content
-- WHERE o.product_id = 15 AND p.product_id  = 9;


-- 19번 이미지 insert
INSERT INTO project.productimages
(product_id, image_order, image_type, image_name)
VALUES(19, 1, 'main', 'pictureFlower5.jpg');
INSERT INTO project.productimages
(product_id, image_order, image_type, image_name)
VALUES(19, 1, 'slide', 'pictureFlower5.jpg');
INSERT INTO project.productimages
(product_id, image_order, image_type, image_name)
VALUES(19, 2, 'main', 'pictureFlower2_1.jpg');
INSERT INTO project.productimages
(product_id, image_order, image_type, image_name)
VALUES(19, 2, 'slide', 'pictureFlower3.jpg');
INSERT INTO project.productimages
(product_id, image_order, image_type, image_name)
VALUES(19, 3, 'main', 'pictureFlower2_2.jpg');
INSERT INTO project.productimages
(product_id, image_order, image_type, image_name)
VALUES(19, 3, 'slide', 'pictureFlower2.jpg');
INSERT INTO project.productimages
(product_id, image_order, image_type, image_name)
VALUES(19, 4, 'main', 'pictureFlower2_3.jpg');
INSERT INTO project.productimages
(product_id, image_order, image_type, image_name)
VALUES(19, 4, 'slide', 'pictureFlower1.jpg');


-- 19 번 이미지 돌리기
UPDATE project.productimages
SET image_name='pictureFlower5.jpg'
WHERE product_id=19 AND image_order=1 AND image_type='main';
UPDATE project.productimages
SET image_name='pictureFlower5.jpg'
WHERE product_id=19 AND image_order=1 AND image_type='slide';
UPDATE project.productimages
SET image_name='pictureFlower2_1.jpg'
WHERE product_id=19 AND image_order=2 AND image_type='main';
UPDATE project.productimages
SET image_name='pictureFlower3.jpg'
WHERE product_id=19 AND image_order=2 AND image_type='slide';
UPDATE project.productimages
SET image_name='pictureFlower2_2.jpg'
WHERE product_id=19 AND image_order=3 AND image_type='main';
UPDATE project.productimages
SET image_name='pictureFlower2.jpg'
WHERE product_id=19 AND image_order=3 AND image_type='slide';
UPDATE project.productimages
SET image_name='pictureFlower2_3.jpg'
WHERE product_id=19 AND image_order=4 AND image_type='main';
UPDATE project.productimages
SET image_name='pictureFlower1.jpg'
WHERE product_id=19 AND image_order=4 AND image_type='slide';


-- 유저 가데이터

INSERT INTO Users (user_id, password, name, birth_date, gender, phone_number, email, is_withdrawn, withdrawal_date, updated_at, created_at, block_status, is_admin, login_count)
VALUES 
('user001', '1', '김철수', '1990-01-15', 'M', '010-1234-5678', 'kimcheolsu@example.com', 0, NULL, '2024-10-10', '2020-01-01', 0, '0', 10),
('user002', '2', '이영희', '1985-05-22', 'F', '010-2345-6789', 'leeyounghee@example.com',  0, NULL, '2024-10-10', '2020-02-10', 0, '0', 20),
('user003', '3', '박민수', '1978-11-03', 'M', '010-3456-7890', 'parkminsu@example.com',  0, NULL, '2024-10-09', '2020-03-15', 1, '0', 15),
('user004', '4', '최지현', '1992-04-12', 'F', '010-4567-8901', 'choijihyun@example.com',  0, NULL, '2024-10-08', '2020-04-20', 0, '0', 7),
('user005', '5', '정우성', '1988-07-19', 'M', '010-5678-9012', 'jungwoosung@example.com',  1, '2022-05-01 10:00:00', '2022-04-30', '2019-05-01', 1, '0', 12),
('user006', '6', '김수현', '1995-02-28', 'F', '010-6789-0123', 'kimsuhyun@example.com',  0, NULL, '2024-10-07', '2020-06-01', 0, '0', 5),
('user007', '7', '이동욱', '1983-10-15', 'M', '010-7890-1234', 'leedongwook@example.com',  0, NULL, '2024-10-06', '2020-07-01', 1, '0', 8),
('user008', '8', '박은정', '1991-12-11', 'F', '010-8901-2345', 'parkunjung@example.com',  0, NULL, '2024-10-05', '2020-08-15', 0, '0', 9),
('user009', '9', '이재호', '1987-06-30', 'M', '010-9012-3456', 'leejaeho@example.com',  0, NULL, '2024-10-04', '2020-09-10', 0, '0', 18),
('user010', '10', '김소희', '1994-03-22', 'F', '010-0123-4567', 'kimsohee@example.com',  0, NULL, '2024-10-03', '2020-10-01', 1, '0', 11),
('user011', '11', '한기준', '1980-09-07', 'M', '010-2345-6789', 'hankijun@example.com',  0, NULL, '2024-10-02', '2020-11-20', 0, '0', 22),
('user012', '12', '오은지', '1993-08-12', 'F', '010-3456-7890', 'oeunji@example.com',  0, NULL, '2024-10-01', '2020-12-05', 0, '0', 16),
('user013', '13', '박상민', '1979-04-04', 'M', '010-4567-8901', 'parksangmin@example.com',  1, '2023-01-15 10:00:00', '2023-01-14', '2020-01-15', 1, '0', 5),
('user014', '14', '서지현', '1991-11-23', 'F', '010-5678-9012', 'seojihyun@example.com', 0, NULL, '2024-09-25', '2021-01-01', 0, '0', 6),
('user015', '15', '류수영', '1985-02-14', 'M', '010-6789-0123', 'ryusuyoung@example.com',  0, NULL, '2024-08-30', '2021-03-10', 0, '0', 13);


USE project;

DROP PROCEDURE IF EXISTS
insertFavoritesAndUpdateLike;

DELIMITER $$

CREATE PROCEDURE project.insertFavoritesAndUpdateLike (
    IN inputUserId  VARCHAR(50),
    IN inputProductId  int
)
BEGIN 
    INSERT INTO project.favorites (user_id, product_id)
    VALUES (inputUserId , inputProductId);

    UPDATE project.products 
    SET like_count = like_count + 1
    WHERE product_id = inputProductId;

    IF ROW_COUNT() = 0 THEN 
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'procedure 실패';
    END IF;
END$$

DELIMITER ;

SELECT VERSION();

DESCRIBE favorites;

CALL project.insertFavoritesAndUpdateLike ('user006',9);

SHOW PROCEDURE STATUS WHERE Db = 'project';

SHOW GRANTS FOR 'root'@'localhost';



