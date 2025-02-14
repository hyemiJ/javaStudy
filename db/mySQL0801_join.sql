	select sno, name , s.jno, jname , captain
	from student s , jo j 
	where s.jno = j.jno ;
	

	select sno, name , s.jno, jname , captain
	from student s , jo j ;
	
SELECT s.sno , s.name , s.jno , j.jname , j.project 
FROM student s RIGHT OUTER JOIN jo j ON s.jno = j.jno;

CREATE TABLE test2
SELECT s.sno , s.name , s.jno , j.jname , j.project 
FROM student s RIGHT OUTER JOIN jo j ON s.jno = j.jno
WHERE s.sno>5;


SELECT j.jno,j.jname,j.captain,s.name, s.age, j.project, j.slogan 
FROM jo j LEFT OUTER JOIN student s 
ON j.captain = s.sno;

ALTER TABLE student2 ADD rno int(3) DEFAULT 10;
SELECT * FROM student2;

UPDATE student2 SET rno = 14 WHERE jno=3; 

SELECT s.sno , s.name , s.jno , s.rno , s2.name 짝꿍
FROM student2 s LEFT OUTER JOIN student2 s2 
ON s.rno = s2.sno;
student2 의 sno, name, jno, 
jname, captain, captain_name 조장이름 출력하기

SELECT s.sno ,s.name, s.jno, j.captain, s2.name 
FROM student2 s LEFT OUTER JOIN jo j 
ON s.jno = j.jno 
LEFT OUTER JOIN student2 s2 
ON s2.sno = j.captain ;

SELECT s.sno, s.name, s.jno,j.captain,s2.name
FROM student s LEFT OUTER JOIN jo j 
ON s.jno = j.jno 
LEFT OUTER JOIN student s2 
ON s2.sno = j.captain;
