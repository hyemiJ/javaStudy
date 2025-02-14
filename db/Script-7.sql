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

CREATE TABLE `registedhistory` (
		  `regist_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
		  `user_id` varchar(100) DEFAULT NULL,
		  `teenager_cnt` int DEFAULT NULL COMMENT '청소년요금합',
		  `adult_cnt` int DEFAULT NULL COMMENT '어른요금합',
		  `person_cnt` int DEFAULT NULL,
		  `regist_cnt` int DEFAULT NULL COMMENT '총합산금액',
		  `reg_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
		  `active_date` timestamp NULL DEFAULT NULL,
		  `regist_id` varchar(150) NOT NULL,
		  PRIMARY KEY (`regist_id`),
		  UNIQUE KEY `registedhistory_unique` (`reg_date`),
		  KEY `registedhistory_regist_FK` (`regist_code`),
		  KEY `registedhistory_customer_FK` (`user_id`),
		  CONSTRAINT `registedhistory_customer_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
		  CONSTRAINT `registedhistory_regist_FK` FOREIGN KEY (`regist_code`) REFERENCES `regist` (`regist_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;