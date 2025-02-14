-- insert into test4 values("id","name","phone");

select * from test4 ;

desc test4;

-- 주석 개꿀

select name from test4 ;

show tables;

select * from friend ;

INSERT INTO friend VALUES ('홍길동', '010-1234-1234', '경기도 성남시')
ON DUPLICATE KEY UPDATE addres = '경기도 성남시';

-- 장바구니의 예시
create  table testkey (    
	id varchar(10),
	no int,
	name varchar(10),
	count int,
	CONSTRAINT pk_id PRIMARY KEY(id, no)
	);

INSERT INTO testkey (id, no, name ,count)
        VALUES ('banana', 1, '홍길동', 1);
       
       select * from testkey;
      
INSERT INTO testkey (id, no, name,count)
        VALUES ('banana', 1, '홍길동', 1)
        ON DUPLICATE KEY UPDATE name = '김길동';
       
       select * from testkey;

INSERT INTO testkey (id, no, name, count)
        VALUES ('banana', 1, '김길동', 1)
        ON DUPLICATE KEY UPDATE count = count+5;
       
       select * from testkey;
     
select * from jo;

		-- 회원
     CREATE TABLE parent(
         p_id int(10),
         p_name varchar(20) NOT NULL,
         phone varchar(13),
         CONSTRAINT PRIMARY KEY(p_id)
     );
    
    	-- 게시판
         CREATE TABLE child (
         seq int(5) primary key,
        id int(10),
        title varchar(20), 
        Foreign Key(id) References parent(p_id) 
     );
    
 insert into parent values (1,"바나나","010-1111-1111");
 insert into parent values (2,"Apple","010-2222-1111");
 insert into parent values (3,"Green","010-3333-1111");
 
 select * from parent;

insert into child values (10,1,"참조 관계 실습");
insert into child values (11,2,"참조 관계 실습");
insert into child values (12,2,"참조 관계 실습");
insert into child values (13,3,"참조 관계 실습");
-- insert into child values (14,4,"참조 관계 실습");
     
 select * from child;
 
-- 업데이트
-- 1의 아이디를 4로 변경
-- update parent set p_id=4 where p_id =1;

-- delete from parent where p_id = 2;

-- 자식 테이블을 수정
-- 외래키를 3에서 1로 변경(부모 참조키가 있는 번호)
update child set id=1 where seq =13;

-- truncate child;


      CREATE TABLE child2 (
				seq int(5) primary key,
				id int(10),
				title varchar(20), 
				Foreign Key(id) References parent(p_id) 
				ON DELETE CASCADE 
				ON UPDATE CASCADE
			);
insert into child2 values (10,1,"참조 관계 실습2");
insert into child2 values (11,2,"참조 관계 실습2");
insert into child2 values (12,2,"참조 관계 실습2");
insert into child2 values (13,3,"참조 관계 실습2");

select * from child2;

update parent set p_name ="사과나무" where p_id =2;


update parent set p_id =5 where p_id =1;

delete from parent where p_id=2;


insert into jo values(8,"테스트", 30 , "팔팔프로젝트","건강하게 살자");

insert into student(name , age , jno , info , point) values("홍길동",22,7,"관리자",99.99);

select sno ,name , s.jno , project from student s ,jo j where s.jno =j.jno;

select sno ,name , s.jno , project from student s ,jo j where s.jno =j.jno order by jno;

select s.name 이름, j.jno 조번호, captain 조장 , project ,slogan from student s ,jo j where s.sno =j.captain ;

create table student2 as select * from student ;
create table jo2 as select * from jo ;

drop table jo2;
drop table student2 ;
drop table jo3 ;

create table student2 (sno int(2) ,
name varchar(20) not null,
age int(2),
jno int(2),
info varchar(30),
point double(5,2) default 100,
primary key(sno));

-- create table student3 (sno int(2) ,
-- name varchar(20) not null,
-- age int(2),
-- jno int(2),
-- info varchar(30),
-- point double(5,2) default 100,
-- primary key(sno));

create table jo2 (jno int(2) ,
jname varchar(30),
captain int(2),
project varchar(30),
slogan varchar(30),
primary key(jno),
foreign key(captain) references student2(sno)
);


-- create table jo3 (jno int(2) ,
-- jname varchar(30),
-- captain int(2),
-- project varchar(30),
-- slogan varchar(30),
-- primary key(jno),
-- foreign key(captain) references student3(sno)
-- ON DELETE CASCADE 
-- ON UPDATE CASCADE);

create table jo4 (jno int(2) ,
jname varchar(30),
captain int(2),
project varchar(30),
slogan varchar(30),
primary key(jno));

create table student4 (sno int(2) ,
name varchar(20) not null,
age int(2),
jno int(2),
info varchar(30),
point double(5,2) default 100,
primary key(sno),
foreign key(jno) references jo4(jno)
ON DELETE CASCADE 
ON UPDATE CASCADE);
-- 
insert into student2 select * from student where sno!=91;
insert into student3 select * from student where sno!=91;
insert into jo2 select * from jo where jno!=8;
insert into jo3 select * from jo where jno!=8;
insert into jo4 select * from jo where jno!=8;
insert into student4 select * from student where sno!=91;

-- delete from student2 where captain=2;
-- 
-- update student2 set sno=16 where captain=2;

update student3 set sno=16 where sno=5;

update jo4 set jno = 200 where jno = 3;