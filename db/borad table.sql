
-- 게시판과 댓글활용을 위한 테이블 만들기
USE mydb;

create table board(
seq int(5) Primary Key Auto_Increment,	
id varchar(10) not null,
title varchar(200) not null,
content Text(2000),
regdate DateTime default Current_TimeStamp,
cnt int default 0,
root int default 0,
step int default 0,
indent int default 0
);

-- > 댓글(root, step, indent)

-- 확인용
SELECT * FROM board

-- insert

insert into board(id, title, content) 
values('70','Spring 이란?','처음엔 복잡하고 난해하지만 친해지면 매우 편리하다');

insert into board(id, title, content) 
values('asdf','의존성 주입?','dependency injection_객체간의 의존관계를 객체 자신이 아닌 외부의 조립기가  수행한다');

insert into board(id, title, content) 
values('apple','느슨한 결합(loose coupling)','객체는 인터페이스에 의한 의존관계만을 알고 있으며 이 의존관계는 구현 클래스에 대한 차이를 모르는채 서로 다른 구현으로 대체가 가능');

insert into board(id, title, content) 
values('admin','Spring의 DI 지원','Spring Container가 DI 조립기(Assembler)를 제공');

insert into board(id, title, content) 
values('green','Spring 설정파일','Spring Container가 어떻게 일할 지를 설정하는 파일');

insert into board(id, title, content) 
values('chelsea','Spring 이란?','처음엔 복잡하고 난해하지만 친해지면 매우 편리하다');

insert into board(id, title, content) 
values('gydbs99','의존성 주입?','dependency injection_객체간의 의존관계를 객체 자신이 아닌 외부의 조립기가  수행한다');

insert into board(id, title, content) 
values('apple','느슨한 결합(loose coupling)','객체는 인터페이스에 의한 의존관계만을 알고 있으며 이 의존관계는 구현 클래스에 대한 차이를 모르는채 서로 다른 구현으로 대체가 가능');

insert into board(id, title, content) 
values('hyemi1110','Spring의 DI 지원','Spring Container가 DI 조립기(Assembler)를 제공');

insert into board(id, title, content) 
values('lovegihun','Spring 설정파일','Spring Container가 어떻게 일할 지를 설정하는 파일');

insert into board(id, title, content) 
values('macbook','Spring 이란?','처음엔 복잡하고 난해하지만 친해지면 매우 편리하다');

insert into board(id, title, content) 
values('min00','의존성 주입?','dependency injection_객체간의 의존관계를 객체 자신이 아닌 외부의 조립기가  수행한다');

insert into board(id, title, content) 
values('qkdrlfh456','느슨한 결합(loose coupling)','객체는 인터페이스에 의한 의존관계만을 알고 있으며 이 의존관계는 구현 클래스에 대한 차이를 모르는채 서로 다른 구현으로 대체가 가능');

insert into board(id, title, content) 
values('sexy','Spring의 DI 지원','Spring Container가 DI 조립기(Assembler)를 제공');

insert into board(id, title, content) 
values('user1','Spring 설정파일','Spring Container가 어떻게 일할 지를 설정하는 파일');

insert into board(id, title, content) 
values('wyeonj','Spring 이란?','처음엔 복잡하고 난해하지만 친해지면 매우 편리하다');

-- root값을 seq와 같게 세팅

update board set root = seq ;

-- 확인용
SELECT * FROM board

SELECT  * FROM  board ORDER  BY  root DESC , step ASC 
