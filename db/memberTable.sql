USE mydb; 

SHOW tables;

create  table member (    
id varchar(10) primary key,
password varchar(10) not null,
name varchar(30),
age int(3),
jno int(1),
info varchar(30),
point float(7,2),
birthday varchar(10),
rid varchar(10)
); 

DESC `member` ;

insert into member(id, password, name, age, jno, info, point, birthday)
select sno, sno, name, age, jno, info, point, birthday from student;  

SELECT * FROM `member`;

UPDATE `member` SET password='12345!';

UPDATE `jo` SET jno=7 WHERE jno=8;

update jo set captain='admin' where jno ='7';

SELECT * FROM jo;

UPDATE `member` SET id='hyemi1110' ,rid='min00' WHERE name='정혜미';

DELETE FROM `member` WHERE id = '2';
DELETE FROM jo WHERE jno=6;


SELECT * FROM `member` WHERE EXISTS (SELECT 1 FROM `member` m WHERE m.rid  IN ( NULL));

update member set id='qkdrlfh456', rid='Lovegihun' where id='4';
update member set id='lovegihun', rid='qkdrlfh456' where name='신의종';
UPDATE member SET id='hyemi1110' ,rid='min00' WHERE name='정혜미';
UPDATE member SET id='gydbs99', rid='macbook' WHERE name="방효윤";
UPDATE member SET id='min00', rid='hyemi1110', birthday='2000-12-08' WHERE name='민기훈';
update member set id='macbook', rid= 'gydbs99' where name='이승현';
update member set id='wyeonj' , rid='yeon', birthday='1992-07-17' where name='우연정';
update member set id='yeon', rid='wyeonj', birthday='2000-07-27' where name='신재연';
update member set id='21woo', rid='zzzzzz', birthday='2001-01-16' where name='이원우';
update member set id='zzzzzz', rid='yeon' where name='고용기';
UPDATE MEMBER SET id='asdf', rid ='qwer' WHERE name ='유승범';
UPDATE MEMBER SET id = 'user1', rid = 'sexy' WHERE name ='황지호';
UPDATE MEMBER SET id = 'sexy', rid = 'user1' WHERE name ='전용덕';
UPDATE member SET id = 'chelsea', rid ='apple' WHERE name='심성용';


update jo set captain='21woo' where jno=1;
UPDATE jo SET captain='gydbs99' WHERE jno=2;
UPDATE jo SET captain='chelsea' WHERE jno=3;
update jo set captain='qkdrlfh456' where jno=4;

insert into member values('apple','12345!','스티브',33,7,'관리조 입니다.',100,'1987-07-07','admin');
UPDATE member SET name='홍길동' WHERE id = 'admin';


UPDATE MEMBER SET password ='$2a$10$gt3GXeq4o86VskAZsS3GDe5X8ZkiJ3VRbS4UXKoLCmKKYAIw5PEXy';




