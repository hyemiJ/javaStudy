SELECT sno, name , jno, 
(SELECT jname FROM jo WHERE s.jno = jno) 조이름
FROM student s ;
-- 서브쿼리

-- 이름이 "정혜미" 인 학생과 같은 조원 출력하기
SELECT sno , name , jno 
FROM student s 
WHERE jno = (SELECT jno FROM student WHERE name='정혜미');


-- 조이름이 "모꼬지" 조의  조원 sno, name, jno  출력하기
SELECT sno, name ,jno
FROM student s 
WHERE jno = (SELECT j.jno FROM jo j WHERE jname = "모꼬지");

-- student 에서 "정혜미" age 이상인 학생 출력하기 
SELECT sno , name , age 
FROM student s
WHERE age >= (SELECT age FROM student s2 WHERE name ="정혜미");

-- student 에서 "정혜미" age 이상인 학생 출력하기 내림차순
SELECT sno , name , age 
FROM student s
WHERE age >= (SELECT age FROM student s2 WHERE name ="정혜미")
ORDER BY age desc;

--  jo 에서 조장 name 출력할때 join 사용
SELECT j.jno , j.jname , j.captain , s.name
FROM jo j JOIN student s 
ON j.captain = s.sno ;

--  jo 에서 조장 name 출력할때 sub query 사용
SELECT jno , jname , captain ,
(SELECT name FROM student s WHERE captain = sno) 조장
FROM jo ;

--  jo 에서 조장 name 출력할때 sub query 사용
SELECT sno, jname ,j.jno, captain, name captainName 
FROM student s, jo j
WHERE name = (SELECT name FROM student WHERE sno = j.captain);


-- student 에서 sno, name, jno, jname 출력, 조이름은 sub_Query 로 구현
SELECT sno , name , s.jno , 
(SELECT jname FROM jo j WHERE s.jno = j.jno) 조이름
FROM student s ;

-- student 에서 name="홍길동" 인 학생의 age 보다 
-- age 값이 크거나 같은 학생들의 sno, name, age, jno, jname 출력하기

SELECT sno, name , age , s.jno ,
(SELECT jname FROM jo j WHERE s.jno = j.jno) 조이름
FROM student s 
WHERE age > (SELECT age FROM student s2 WHERE name = "홍길동");

SELECT s.sno, s.name , s.age , s.jno , jname
FROM student s  JOIN jo j
ON s.jno = j.jno
WHERE age > (SELECT age FROM student s2 WHERE name = "홍길동");

SELECT sno ,name , age , s.jno , j.jname
FROM student s , jo j
WHERE s.jno = j.jno AND s.age > (SELECT age FROM student s2 WHERE name = "홍길동");


select count(*), count(info), sum(age), avg(age), max(age), min(age)
from student;

UPDATE student SET info=NULL WHERE name ="홍길동";

select count(*), count(info), sum(age), avg(age), max(age), min(age), max(age)+min(age)
from student;

SELECT sno , name , jno ,age ,point , (point*age)+jno 보너스 FROM student s ORDER BY 보너스 ;


select jno, count(*), sum(age) , avg(age), max(age), min(age) 
from student 
GROUP BY jno 
order by jno ; 

select jno ,count(*), sum(age) , avg(age), max(age), min(age) 
from student
WHERE age >= 20
GROUP BY jno 
order by jno ;


select jno ,count(*), sum(age) , avg(age), max(age), min(age) 
from student
GROUP BY jno 
HAVING count(*) >=4
order by jno ;

select jno, count(*), sum(age) , avg(age), max(age), min(age) 
from student 
WHERE age>=28
GROUP BY jno 
HAVING avg(age) >=30
order by jno ; 

-- 조별 통계목록에 조이름 출력하기 
select s.jno, jname , count(*), sum(age) , avg(age), max(age), min(age)  
FROM student s JOIN jo j
ON s.jno = j.jno 
GROUP BY s.jno
ORDER BY s.jno;

select s.jno, (SELECT jname FROM jo j WHERE s.jno = j.jno) , count(*), sum(age) , avg(age), max(age), min(age)
FROM student s
GROUP BY s.jno
ORDER BY s.jno;

select s.jno, (SELECT jname FROM jo j WHERE s.jno = j.jno) ,
count(*), sum(age) , avg(age), max(age), 
(SELECT s2.name FROM student s2 GROUP BY s2.name HAVING s2.age = max(age)), min(age)
FROM student s
GROUP BY s.jno
ORDER BY s.jno;


SELECT name 
FROM student 
where age =(SELECT max(s2.age) FROM student s2 );

select s.jno, jname , count(*), sum(age) , avg(age), max(age),
(SELECT s2.name 
FROM student s2
WHERE s2.jno = s.jno AND s2.age =max(s.age)) max_name
, min(age)
FROM student s JOIN jo j
ON s.jno = j.jno 
GROUP BY s.jno
ORDER BY s.jno;

SELECT sno,name , age FROM student s WHERE age =(SELECT max(age) FROM student s2)



select s.jno, jname , count(*), sum(age) , avg(age), max(age),
(SELECT s2.name 
FROM student s2
WHERE s2.jno = s.jno AND s2.age = min(s.age) LIMIT 1) min_name
, min(age)
FROM student s JOIN jo j
ON s.jno = j.jno 
GROUP BY s.jno
ORDER BY s.jno;


SELECT s1.jno, jname, max(s1.age),
(SELECT s2.name 
FROM student s2 
WHERE s2.jno =s1.jno AND s2.age = max(s1.age)) max_name
FROM student s1 , jo j 
WHERE s1.jno = j.jno
GROUP BY s1.jno
ORDER BY s1.jno;



-- view

CREATE VIEW myview01 
AS SELECT sno , name ,age, jno 
FROM student
WHERE name != '홍길동';

SELECT * FROM myview01;

DESC myview01 ;
DROP view myview01;

UPDATE myview01 SET age=40 WHERE name='고용기';

SELECT * FROM student s ;
SELECT * FROM myview01 m ;


CREATE VIEW myview02
AS SELECT sno , name , s.jno , jname , captain 
FROM student s JOIN jo j
ON s.jno = j.jno;

SELECT * FROM myview02 m;

SELECT m1.jno , m1.sno , m1.name , m1.jname , m1.captain , m2.name 조장
FROM myview02 m1 JOIN myview02 m2
ON m1.captain = m2.sno;

UPDATE myview02 SET jname = "컴포난트" WHERE jno =4 ;
SELECT * FROM jo;


CREATE OR REPLACE VIEW myview01 AS 
select s.jno, jname , count(*), sum(age) , avg(age), max(age),
(SELECT s2.name FROM student s2 WHERE s2.jno = s.jno AND s2.age =max(s.age)) max_name
, min(age)
FROM student s JOIN jo j
ON s.jno = j.jno 
GROUP BY s.jno
ORDER BY s.jno;


Create Or Replace View myview01 As
         select s.jno, jname , count(*), sum(age) , avg(age), max(age),
        (SELECT s2.name FROM student s2 WHERE s2.jno = s.jno AND s2.age =max(s.age)) max_name
        , min(age)
        FROM student s JOIN jo j
        ON s.jno = j.jno 
        GROUP BY s.jno
        ORDER BY s.jno;

select table_schema, table_name, definer from information_schema.views ;

select table_schema, table_name, definer, VIEW_DEFINITION 
from information_schema.views where TABLE_SCHEMA="mydb" ;


DROP VIEW myview02 ;

SHOW tables;


-- index

SELECT * FROM student s ;

SHOW INDEX FROM test;

DESC test;

CREATE INDEX myindex ON student(name);

ALTER TABLE student ADD INDEX myindex2(jno);

ALTER TABLE student DROP INDEX myindex2;

