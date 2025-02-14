
CREATE DATABASE nestjs;


CREATE TABLE `member` (
  `id` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `jno` int DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `point` float(7,2) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `rid` varchar(255) DEFAULT NULL,
  `uploadfile` varchar(255) DEFAULT NULL,
  `role_list` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('21woo', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '이원우', 23, 1, 'playfram 조장입니다.', 123.5, '2001-01-16', 'zzzzzz', 'aaa.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('2222', '$2a$10$kGQM0OaFPn1DVVwb8EDX3OP3QwHnIYV/ZV1t1Te0b4qMxyBDsl6KW', '2222', 22, 7, '2222', 500.0, '2024-09-01', '2222', 'eee.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('3333', '$2a$10$0JemSryeY71k7rZaK4rCuuQAUCnVENC8LL6uE57znlmEh/sxtPyyS', '3333', 33, 7, '3333', 10.11, '2024-09-01', '3333', 'eee.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('70', '$2a$10$hNNmqLcnuF.7pDLMAfMaDOWX/UKLmYgoccCHvJBDEb0FT2yjECRyi', '이름', 20, 7, 'insert test', 20.4, '1900-10-10', '', 'ht2.png', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('90', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '이순신', 34, 7, '조 없음', 293.45, '1999-08-05', NULL, 'eee.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('92', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', 'Gil Dong', 33, 7, '조 없음', 200.1, '1999-08-05', NULL, 'eee.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('93', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '정길동', 22, 7, '조 없음', 150.1, '2000-02-02', NULL, 'eee.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('94', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '김길동', 10, 7, 'test 중w', 0.0, NULL, NULL, 'eee.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('aaaa', '$2a$10$aDjIg5cV/TTbzPnCfU8.1ea7ReNpozYFcrFqkVLWk1mOCod6mWmi2', 'aaaa', 33, 1, 'aaa', 10.11, '', '', 'aaa.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('admin', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '홍길동', 22, 7, '조 없음', 253.99, '1999-08-05', 'apple', 'eee.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('apple', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '스티브', 33, 7, '관리조 입니다.', 100.0, '1987-07-07', 'admin', 'eee.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('asdf', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '유승범', 28, 3, '조원 입니다.', 92.0, '1999-08-05', 'qwer', 'ccc.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('asdf1234', '$2a$10$Q7ltAAoU3v1l5No0XxgA3uxyg8jOJwT/2Nlj9TJjtKRrp/JCKookG', 'aaaa', 11, 1, '', 100.0, '2024-09-09', '', 'icon-heart.png', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('asdfg', '$2a$10$npJ/d4JzQ7Hed5CbNU61vuaXHvyOApyo0dshdoCTFXd9KczDV0AL.', 'asdfg', 33, 7, '안녕하세요', 500.0, '2024-09-01', 'asdfg', 'basicman4.png', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('chelsea', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '심성용', 31, 3, '조장 입니다.', 103.0, '1999-08-05', 'apple', 'ccc.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('green', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '김그린', 33, 7, '안녕하세요', 500.0, '2024-07-30', 'banana', 'eee.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('gydbs99', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '방효윤', 30, 2, '안녕', 159.99, '1999-08-05', 'macbook', 'bbb.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('hyemi1110', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '정혜미', 31, 2, '욕쟁이 할마니', 161.99, '1999-08-05', 'min00', 'bbb.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('lovegihun', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '신의종', 17, 4, '초딩 중딩 고딩 코딩', 167.99, '1999-04-05', 'qkdrlfh456', 'ddd.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('macbook', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '이승현', 30, 2, '변경할꺼야', 160.0, '1999-08-05', 'gydbs99', 'bbb.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('min00', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '민기훈', 25, 2, '민기훈입니다', 57.3, '2000-12-08', 'hyemi1110', 'bbb.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('qkdrlfh456', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '방기로', 28, 4, '초미남 제네럴 갓 초사이언 삼군수도통제사 충무공', 212.99, '1999-04-05', 'Lovegihun', 'ddd.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('roletest', '$2a$10$lwZNeXf60tmpYWCJKC.uke46IBW9s3kHi3.KGF2nuOQc9Mc/xpLy6', '홍길동', 22, 7, 'SpringBoot Security Test', 300.5, '2000-02-02', 'apple', 'aaa.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('sexy', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '전용덕', 28, 3, '초미녀 세일러문', 92.0, '1999-08-05', 'user1', 'ccc.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('ssss', '$2a$10$hOAKlY6uNne2mZS/fwW.geztCFN6DbngDrbZvMSvsOynXRsOnRC16', 'ssss', 33, 7, 'ssss', 10.11, '2024-09-03', 'ssss', 'eee.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('user1', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '황지호', 30, 3, '뚱이', 99.0, '1999-08-05', 'sexy', 'ccc.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('wyeonj', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '우연정', 32, 1, '우린팀이니까의 우연정입니다', 132.0, '1992-07-17', 'yeon', 'aaa.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('yeon', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '신재연', 24, 1, '곤니찌와 신재연입니다', 124.0, '2000-07-27', 'wyeonj', 'aaa.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('yyyy', '$2a$10$gJNrTuO03TvYPlJSTGlHTOJQw2cKmpzfaO4i6PKfAc7lisFeLsaje', 'yyyy', 33, 12, 'yyyy', 10.11, '2024-09-01', '', 'basicman4.png', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('zzzzzz', '$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy', '고용기', 40, 1, '혜미누나 바보', 140.0, '1999-01-05', 'yeon', 'aaa.gif', NULL);
INSERT INTO `member`
(id, password, name, age, jno, info, `point`, birthday, rid, uploadfile, role_list)
VALUES('라온이', '$2a$10$KhI4z.XYRUwBzqGQbEPgdewA6X9yUqAVpQlJIiJVD.uTfJxgZgLpy', '라온이', 6, 7, '조라온', 10.11, '2017-10-23', '', 'eee.gif', NULL);