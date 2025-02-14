
USE mydb;

CREATE VIEW myview02
AS
SELECT
	sno ,
	name ,
	s.jno ,
	jname ,
	captain
FROM
	student s
JOIN jo j
ON
	s.jno = j.jno;

SELECT * FROM myview02;

DESC myview02;

-- -------------------------------------------------------view 


-- -------------------------------------------------------8.5 DML

INSERT INTO student (name , age , jno , info) 
VALUES('김길동',33,7,'테스트용0805');

INSERT INTO student 
values(90,'이길동',34,7,"테스트용0805",55.45);

UPDATE jo2 SET jname= 'where없는 업데이트';
SELECT * FROM jo2;

UPDATE jo3 SET jno=9,jname='업데이트 test조' WHERE jno=4;
SELECT * FROM jo3;
UPDATE jo3 SET jno=4,jname='컴포nan트' WHERE jno=9;

SHOW tables;

SELECT * FROM testkey;

DELETE FROM testkey;

START TRANSACTION;
DELETE FROM student3 WHERE jno%2=0;
SELECT * FROM student3;
ROLLBACK;

SELECT * FROM student WHERE name LIKE '%기%';

SELECT jno , age ,count(*), sum(age), avg(age), max(age), min(age)
FROM student 
GROUP BY jno , age
ORDER BY jno;

select sno, name, jno, point, jno+point 보너스 from student;
select sno, name+info 나의정보 from student; 

select sno, CONCAT(name,'_', info) 나의정보 from student;

SELECT sno, concat('저는 만',(age-1),'세 ',name,'입니다.') 나의정보 FROM student; 

SELECT sno, concat('저는 만',(age-1),'세 ',name,'이고, ',jno,'조이고, 소개는 "',
info,'"입니다.' ) 나의정보 FROM student; 


SELECT sno+'번', name+'님' FROM student ;

SELECT sno||'번', name||'님' FROM student ;

SELECT sno , name , age , jno ,point, (age*jno) 보너스 , 보너스+point 년합계 , 년합계/12 월평균
FROM student;

SELECT
	sno ,
	name ,
	age ,
	jno ,
	point,
	(age * jno) 보너스 ,
	(age * jno)+ point 년합계 ,
	((age * jno)+ point)/ 12 월평균
FROM
	student;


UPDATE student SET point=point+(age*jno);
SELECT * FROM student ;

-- select sno, name, point from student where point = 우리반에서 point 의 최대값


SELECT sno, name , point 
FROM student
WHERE point>=(select avg(point) FROM student); 

SELECT sno,name , age
FROM student


WHERE age = (SELECT min(age) FROM student) ; 


-- student 에서 age  25 부터 30 까지 출력하기
SELECT sno , name , age FROM student
WHERE age>=25 AND age <=30;

SELECT sno , name , age FROM student
WHERE age BETWEEN 25 AND 30;

-- student 에서 age 25 미만  30 초과 출력하기	
SELECT sno , name , age FROM student
WHERE age<25 || age >30;

--  "홍" ~ "이" 사이의 출력
SELECT sno , name , age FROM student
WHERE name BETWEEN "민" AND "이허";

-- jno 가 7 아닌 자료 출력
SELECT sno , name , jno FROM student
WHERE NOT jno = 7;

-- info 가 "입니다" 아니면 모두 출력
SELECT name , info FROM student
WHERE NOT info="입니다";

-- info 가 "입니다" 포함하지 않으면 모두 출력
SELECT name , info FROM student
WHERE NOT info LIKE '%입니다%';

-- student 에서 info 가 NULL 인 자료 출력
SELECT
	name ,
	info
FROM
	student
WHERE
	info IS NULL;

SELECT
	name ,
	info
FROM
	student
WHERE
	info = NULL;
SELECT name , info FROM student
WHERE info != NULL;

-- student 에서 point 가 Not NULL 인자료 출력
SELECT name , point FROM student
WHERE point IS NOT NULL;

select * from student where jno=1 or jno=4 or jno=5 order by jno;
select sno, name, jno from student where jno IN(1, 4, 5) order by jno ;

select sno, name from student where name IN("홍길동","김길동", "이길동") order by jno ;

-- name 중에 2번째 글자가 "길" 인 자료 검색

SELECT sno , name , age FROM student 
WHERE name LIKE "_길%";

-- "김" 씨만 출력하기
SELECT sno , name , age FROM student 
WHERE name LIKE "김%";

-- info 에 "이"가 포함되어 있으면 출력
SELECT name , info 
FROM student
WHERE info LIKE "%이%";

-- info 에 두번째 글자가 "이"가 포함되어 있으면 출력
SELECT name , info 
FROM student
WHERE info LIKE "_이";

-- info 에 "초" "조"가 포함되어 있으면 출력
SELECT name , info
FROM student
WHERE info IN ("%초%","%조%"); -- 오류는 없으나 IN은 동일성을 비교하기 때문에 나오지 않음.

SELECT name , info
FROM student
WHERE info LIKE "%초%" OR info LIKE "%미%"; -- or로 통하여 조건을 사용

-- name 에 "김" "이" "박"으로 시작하는 이름 출력
SELECT sno , name , jno
FROM student
WHERE name LIKE "김%" OR name LIKE "이%" OR name LIKE "박%";
SELECT sno , name , jno
FROM student
WHERE name REGEXP '^김|^이|^박';

-- name 에 "김"이 아닌 경우 이름 출력
SELECT sno , name , jno
FROM student
WHERE name NOT LIKE "김%";

-- name 에 "동" 으로 끝나는 경우 출력
SELECT sno , name , jno
FROM student
WHERE name LIKE "%동";

-- student 에서 age 27~33 인 학생중 info 에 "다" 이 포함된 학생 출력하기

SELECT sno , name , age , info
FROM student
WHERE (age BETWEEN 27 AND 33) AND info LIKE "%다%"; 

SELECT sno , name , age , info
FROM student
WHERE (age BETWEEN 27 AND 33) AND info REGEXP "다"; 

-- 1, 3 조중에 신 또는 심 씨만 출력하기
SELECT sno , name , jno FROM student
WHERE jno IN (1,3) AND ( name LIKE "신%" OR name LIKE "심%");

SELECT sno , name , jno FROM student
WHERE jno IN (1,3) AND name REGEXP "^신|^심";

-- 1, 3 ,4 조중에 용 이 이름에 포함되면 출력하기
SELECT sno , name , jno FROM student
WHERE jno IN (1,3,4) AND ( name LIKE "%용%");
SELECT sno , name , jno FROM student
WHERE jno IN (1,3,4) AND ( name REGEXP "용");

-- 두번째 알파벳의 검색
SELECT sno , name , info FROM student
WHERE info LIKE "_l%";

CREATE TABLE IF NOT EXISTS divisions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    belts VARCHAR(200) NOT NULL
);

-- FIND_IN_SET('value', 컬럼명) : 컬럼에 'value' 가 있으면 선택


INSERT INTO divisions(name,belts)
VALUES ('O-1','white,yellow,orange'),
    ('O-2','purple,green,blue'),
    ('O-3','brown,red,black'),
    ('O-4','white,yellow,orange'),
    ('O-5','purple,green,blue'),
    ('O-6','brown,red'),
    ('O-7','black'),
    ('O-8','white,yellow,orange'),
    ('O-9','purple,green,blue'),
    ('O-10','brown,red');

SELECT * FROM divisions;

SELECT name , belts 
FROM  divisions 
WHERE find_in_set('red',belts); 

SELECT name , belts 
FROM  divisions 
WHERE belts LIKE "%red%";

SELECT *,find_in_set('black',belts) FROM divisions; 

 select * from student  LIMIT 3 ;
select * from student  LIMIT 2, 3 ;  
 

-- 조 순서대로 출력하면서 , 6번째 부터 5개 출력
SELECT * FROM student
ORDER BY jno LIMIT 5;

-- sno 가 짝수 이면서 , 나이 순으로 5명 출력하기
SELECT * FROM student
WHERE sno%2=0
ORDER BY age DESC
LIMIT 5;

select jno, name from student order by jno;
select DISTINCT jno, name from student order by jno;
SELECT DISTINCT jno  from student order by jno;

SELECT DISTINCT age FROM student ORDER BY age;

-- 조별로 sno 내림차순 정렬

SELECT jno , name ,sno
FROM student
ORDER BY  jno,sno desc;



