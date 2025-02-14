SELECT 24*60*365;
SELECT 3*5000*365;
select -10, ABS(-10);

USE mydb;
SELECT sno , name , age ,(age-sno) , abs(age-sno) 
FROM student ; 


select 34.56789, FLOOR(34.56789);

select FLOOR(-34.56789), FLOOR(-34.1);

select 34.56789, Truncate(34.56789, 3), Truncate(34.56789, 0);

select Truncate(-34.56789, 3), Truncate(-34.1, 3);

select 34.56789, ROUND(34.56789), ROUND(34.123) ; 

select -34.56789, ROUND(-34.56789), ROUND(-34.123);

select ROUND(1477.56789, 3), ROUND(1577.56789, -3), ROUND(1277.56789, -3), 
			ROUND(1277.56789, -2), ROUND(1277.56789, 2) ;

		
select 34.56789, Truncate(123334.56789, -3), Truncate(123334.56789, -4);
		
select name, point, Floor(point), Truncate(point,1), Round(point, -2) from student; 

SELECT CEIL(10.0), CEIL(10.0423), CEIL(10.789) ;

SELECT CEIL(21/4) ;

select MOD(27,2) , MOD(27,3);


select sno, name, age from student where MOD(age,3) = 0;

select sno, name, age from student where Not MOD(age,3) = 0;

SELECT sno , name , floor(point) , point FROM student WHERE MOD(floor(point),2) = 0; 

SELECT LENGTH('MySql'), LENGTH('마이에스큐엘');

select LENGTH('My Sql'), CHAR_LENGTH('My Sql'), length('마이 에스큐엘'), CHAR_LENGTH('마이 에스큐엘');


select 'MySql' , UPPER('MySql'), LOWER('MySql');

UPDATE student SET name = 'banana' WHERE sno=90;
UPDATE student SET name = 'HongGil' WHERE sno=91;
UPDATE student SET name = 'Gil Dong' WHERE sno=92;


SELECT * FROM student;

SELECT name , LENGTH(name) , char_length(name) FROM student; 

select SUBSTR('WELCOME TO MySql', 4, 3) SUBSTR('WELCOME TO MySql' , -4, 3);   

-- student 에 birthday 컬럼 추가 default 값으로 "1999-09-27" 넣기

ALTER TABLE student ADD birthday varchar(10) DEFAULT "1999-08-05";

-- 각조에 생일 업데이트
UPDATE student SET birthday = "1999-01-05" WHERE jno=1;
UPDATE student SET birthday = "1999-04-05" WHERE jno=4;

-- 이달의 생일 아닌 사람 명단 출력
SELECT sno , name , age ,birthday FROM student 
WHERE substr(birthday,6,2)='08'; 

-- 오늘 생일인 사람 출력
SELECT sno , name , age ,birthday FROM student 
WHERE substr(birthday,6,2)='08' AND substr(birthday , 9,2)='05' ; 

-- 황씨 이씨 방씨 출력 -> like가 아닌 substr 와 in을 활용
SELECT sno, name FROM student 
WHERE (substr(name,1,1)) IN ("황","이","방");

-- 회원 보호 기능 -> substr 를 이용하여 방** 로 출력
SELECT sno, concat(substr(name,1,1),"**") FROM student; 


