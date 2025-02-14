SELECT * FROM student ; -- student

SHOW tables; -- 테이블들 보여줘

DROP TABLE test4; -- 기존 많은 테이블 정리

CREATE TABLE test AS SELECT * FROM student ; -- alter 를 위한 복사

SELECT * FROM test; -- test

SELECT * FROM jo; -- jo

ALTER TABLE test ADD PRIMARY KEY (sno); -- ALTER ADD 테스트 

ALTER TABLE test ADD unique (name); -- ALTER ADD 테스트 

ALTER TABLE test ADD CHECK(age >= 15 AND age <100); -- ALTER ADD 테스트

-- ALTER TABLE test ADD FOREIGN KEY (sno) references jo(jno);

UPDATE test SET jno=8 WHERE name='홍길동';

ALTER TABLE test ADD FOREIGN KEY (jno) references jo(jno);

ALTER TABLE test ADD adress varchar(20) DEFAULT '경기도 성남시';

ALTER TABLE test ADD score float(7,3);

UPDATE test SET score=50;

ALTER TABLE test DROP COLUMN score;

-- ALTER TABLE test DROP COLUMN jno; -- foreign key 제약조건을 지닌 COLUMN 

ALTER TABLE test DROP COLUMN age; -- CHECK 제약조건을 지닌 COLUMN 

ALTER TABLE test DROP point;

SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'test' ;

SELECT constraint_name, constraint_type
FROM information_schema.table_constraints
WHERE table_name = 'student' ;

-- ALTER TABLE DROP CONSTRAINTS test_ibfk_1;

ALTER TABLE test DROP COLUMN jno;

ALTER TABLE test RENAME COLUMN adress TO address1 ;
ALTER TABLE test RENAME COLUMN sno TO 학생아이디 ;


DESC test ;
DESC student ;
ALTER TABLE mydb.student DROP CONSTRAINT student_chk_1;
ALTER TABLE student ADD CHECK(age >= 15 AND age <100); 

ALTER TABLE student MODIFY age int CHECK(age >0 AND age<200);
-- ALTER TABLE student MODIFY mydb.student_chk_3 CHECK(age >0 AND age<200);

ALTER TABLE mydb.student DROP CONSTRAINT student_chk_1;
ALTER TABLE mydb.student DROP CONSTRAINT student_chk_3;

-- 실습 준비

ALTER TABLE test ADD score float(7,3);

ALTER TABLE test MODIFY score int(10);

ALTER TABLE test ADD point float(5,2);



-- insert INTO test(point) SELECT point FROM student ;

-- UPDATE test SET point SELECT point FROM student ;

UPDATE test t
JOIN student s ON t.name = s.name
SET t.point = s.point;

ALTER TABLE test MODIFY point int(10);
ALTER TABLE test MODIFY point float(7,3);

UPDATE test SET score =123;
ALTER TABLE test MODIFY score varchar(10);
ALTER TABLE test MODIFY score int(10);


ALTER TABLE test MODIFY point float(7,3);

ALTER TABLE test MODIFY name varchar(3);

DROP TABLE student3 ;
truncate student3;

START TRANSACTION;
DELETE from student3;
SELECT * FROM student3;

ROLLBACK;



