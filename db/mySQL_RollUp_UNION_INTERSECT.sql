USE mydb;

select jno, age , count(*), avg(age) from student group by jno, age order by jno, age;

select age, jno , count(*), avg(age) from student group by age, jno order by age, jno;

-- select jno, count(*), avg(age) from student Group By jno With RollUp ;

select ifnull(jno,'전체통계'), ifnull(age,concat(jno,'조별통계')) , count(*), avg(age) from student Group By jno, age With RollUp;


SELECT * FROM student s ;

select sno, name from student UNION select sno, info from student2 ;

SELECT sno, name FROM student UNION SELECT jno , jname FROM jo;

-- 비슷한 데이터들의 차집합
SELECT sno, name FROM student EXCEPT SELECT sno , name FROM student2;
SELECT sno, jno FROM student EXCEPT SELECT captain , jno FROM jo;
-- 다른 데이터들의 합집합
select sno, name from student INTERSECT select sno, info from student2 ; -- left

SELECT sno, name FROM student UNION ALL SELECT jno , jname FROM jo; -- RIGHT


delimiter $$
CREATE PROCEDURE doit_pric()
BEGIN
	DECLARE customer_cnt int ;
	DECLARE add_number INT;
	SET customer_cnt = 0;
	SET add_number = 100;

SET customer_cnt = ( SELECT COUNT(*) FROM student );

END $$
delimiter;
END



