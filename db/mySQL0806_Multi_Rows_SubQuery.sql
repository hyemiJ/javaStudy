e
USE mydb;

SELECT REPLACE ('abce','a','b');

-- 성만 정인 경우 변경하여 출력하기
SELECT sno , name , concat(REPLACE(substr(name,1,1),'정',"jeong"),substr(name,2)) FROM student;

SELECT sno, name, replace(name, '리', 'Lee') name FROM student WHERE name LIKE '리%' 
UNION 
SELECT sno, name, name FROM student WHERE name NOT LIKE '리%' ORDER BY sno;

SELECT LPAD('ABC',10,'0');

SELECT RPAD('ABC',10,'@');

select sno, name, RPAD(substr(name,1,1), char_length(name), '*') name2 from student;

SELECT birthday FROM student s ;

SELECT rpad(substr(birthday,1,1),4,"*") FROM student s ; 
SELECT rpad(substr(birthday,5,4),6,"*") FROM student s ; 

SELECT name, birthday, concat(rpad(substr(birthday,1,1),4,"*"),rpad(substr(birthday,5,4),6,"*")) 생일 FROM student ;


SELECT '010-1234-1234';
SELECT substr('010-1234-5678',1,5); 
SELECT substr('010-1234-5678',9,2);

SELECT rpad(substr('010-1234-5678',1,5),8,"*"); 
SELECT rpad(substr('010-1234-5678',9,2),4,"*"); 

-- 010-1234-1234 :  010-1***-1***  연습 해 보세요 ~~
SELECT concat(rpad(substr('010-1234-5678',1,5),8,"*"),rpad(substr('010-1234-5678',9,2),5,"*"));
 


-- 날짜 관련 함수
SELECT sysdate(),NOW(),current_timestamp ; 
SELECT current_timestamp(); 
SELECT current_timestamp(); 

select now() 오늘, now()+1 내일, now()-1 어제 ,sysdate() 오늘, sysdate()+1 내일, sysdate()-1 어제 ; --  지원 안됨

alter table student add now  DateTime default NOW() ;	

DESC student ;
SELECT * FROM student s ;

UPDATE student SET now = current_timestamp WHERE jno = 7;



select DATE_FORMAT(now(), '%Y-%m-%d %H:%i:%s') as "now 24",  
        DATE_FORMAT(now(), '%Y년 %m월 %d일 %H시 %i분 %s초') as "now 24",  	
        DATE_FORMAT(now(), '%Y%m%d%H%i%s') as "now 24",  
        DATE_FORMAT(sysdate(), '%Y%m%d%H%i%s') as "sysdate 24";
        
       
SELECT date_format(now,'%Y년 %m월 %d일 %H시 %i분 %s초') FROM student s ;

SELECT date_format(birthday , '%y년 %m월 %d일') , date_format(now,'%Y년 %m월 %d일 %H시 %i분 %s초') FROM student ;


select sno, name, jno, IF(jno=7,'관리자','학생') ifTest from student;

select sno, name, jno, IF(jno%2=0, '짝수조', '홀수조') 짝홀 from student;

select sno, name, jno, IF(jno=1, '1조', IF(jno =2 , '2조',IF(jno=3,'3조',IF(jno=4,'4조','7조')))) 짝홀 from student;

select IFNull(Null, 123) , IFNull('Test', 123);


SELECT name ,info, ifnull(info , 'error') FROM student; 

SELECT sno ,name ,info FROM student; 


INSERT INTO student (sno , name , age , jno , info ,birthday, now ) 
VALUES((SELECT ifnull(max(s2.sno),1)+1 FROM student s2) ,
'한길동',22 , 7 , 'ifnull test','2000-02-02',current_timestamp );

DELETE FROM student5 WHERE sno = 2;

CREATE TABLE student5 SELECT * FROM student 
WHERE 1=2;

SELECT * FROM student5;

select Max(sno), Max(sno)+1, IFNULL(Max(sno), 0) from student5;	

DELETE FROM student5 WHERE sno >3; 

INSERT INTO student5 (sno , name , age , jno , info ,birthday, now ) 
VALUES((SELECT ifnull(max(s2.sno),0)+1 FROM student5 s2) ,
'한길동',22 , 7 , 'ifnull test','2000-02-02',current_timestamp );


SELECT sno, name ,jno , 
CASE 
WHEN jno=1 THEN "일조"
WHEN jno=2 THEN "이조"
WHEN jno=3 THEN "삼조"
WHEN jno=4 THEN "사조"
ELSE "칠조"
END 조이름
FROM student; 

SELECT sno, name ,jno , 
CASE jno
WHEN 1 THEN "일조"
WHEN 2 THEN "이조"
WHEN 3 THEN "삼조"
WHEN 4 THEN "사조"
ELSE "칠조"
END 조이름
FROM student; 

-- name 의 성이 우 인경우 woo 로 출력
SELECT sno , name ,
IF (name LIKE "우%", REPLACE(name, substr(name,1,1) ,"Woo"), name) 우씨찾기,
CASE jno
WHEN 1 THEN "우린팀이니까"
WHEN 2 THEN "모꼬지"
WHEN 3 THEN "OOC"
WHEN 4 THEN "컴포난트"
ELSE "칠조"
END 조이름 
FROM student ;

SELECT sno, name, jno ,
CASE WHEN jno=1 THEN '일조'
WHEN jno=2 THEN '이조'
WHEN jno=3 THEN '삼조'
WHEN jno =4 THEN '사조'
WHEN jno =5 THEN '오조'
ELSE 'Test 조'
END cTest ,
IF(name LIKE "우%", "Woo", '')
FROM student
ORDER BY jno;

-- student 에서 point 값 에 따라 grade 구분

200점 초과~ 500점 이하 :  'VVIP회원',  
150점 초과~ 200점 이하  :  'VIP회원',
100점 초과~ 150점 이하  :  '일반' 
해당안되면 : 'Error' 로  나누고,  point 에는 '점' 을 붙여 출력

	    
	    
	    SELECT * FROM student s ;
	   
	   SELECT sno , name , concat(ifnull(point,0),"점"),
	   CASE 
	   WHEN point > 200 AND point <= 500 THEN "VVIP회원"
	   WHEN point > 150 AND point <= 200 THEN "VIP회원"
	   WHEN point > 100 AND point <= 150 THEN "일반회원"
	   ELSE "Error"
	   END '회원등급'
	   FROM student
	  ORDER BY point desc ;
	  
	  -- between 사용해보기
	   SELECT sno , name , concat(ifnull(point,0),"점"),
	   CASE 
	   WHEN ifnull(point,0) BETWEEN 201 AND 500 THEN "VVIP회원"
	   WHEN ifnull(point,0) BETWEEN 151 AND 200 THEN "VIP회원"
	   WHEN ifnull(point,0) BETWEEN 101 AND 150 THEN "일반회원"
	   ELSE "Error"
	   END 회원등급
	   FROM student;
	  -- 실수형Data 를 적용하는 경우엔 경계 값에서 사각지대 가 있을 수 있으므로 주의
	  
	  UPDATE student SET point = 200.1 WHERE sno =92;
	 UPDATE student SET point = 150.1 WHERE sno =93;
	-- 값 누락 확인

	-- jno 가 jo Table 에 있는 경우만 student 출력하기
	SELECT * FROM student s
	WHERE NOT EXISTS (SELECT j.jname FROM jo j WHERE s.jno=j.jno);
	
	-- jno가 jo 테이블에 없는 학생들의 info를 조없음으로 수정하기
	START TRANSACTION ;
	UPDATE student s SET info="조 없음"
	WHERE NOT EXISTS (SELECT 1 FROM jo j WHERE s.jno=j.jno);
	SELECT name , jno , info FROM student s ;
	COMMIT ;
	
	-- 조장 아닌 학생만 출력하기
	SELECT * FROM student s 
	WHERE  NOT EXISTS (SELECT 1 FROM jo j WHERE s.sno=j.captain);
	
	-- student 에서 조장만 출력하기
	SELECT * FROM student s 
	WHERE EXISTS (SELECT 1 FROM jo j WHERE s.sno=j.captain);
 
	-- IN 복습 : 1,4,5 만 출력
	SELECT * FROM student s
	WHERE jno IN (1,4,5); 
	
	-- IN + sub_Query 와 비교 ( 조장 출력하기 )
	SELECT * FROM student s
	WHERE s.sno IN (SELECT j.captain FROM jo j WHERE s.sno =j.captain);

	SELECT * FROM student s 
	JOIN jo j 
	ON s.sno =j.captain ;

	select sno, name, jno from student
    where jno=(select jno from jo where jname="모꼬지");
   
	select jno, jname, captain, 
    (select name from student where sno=j.captain) 조장이름 from jo j;
   
   --  student 중 jo 테이블의 captain 에 id 가 존재하면 "조장" / 아니면 "조원" 출력하기 
   SELECT s.sno , s.name , s.jno ,age,
   IF(EXISTS (SELECT j.captain FROM jo j WHERE j.captain = s.sno ),"조장" , "조원") 조장조원 FROM student s;
  
  	
   
