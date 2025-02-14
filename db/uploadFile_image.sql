USE mydb;

-- 확인용

SELECT * FROM `member` ;

ALTER TABLE `member` ADD uploadfile varchar(100) DEFAULT 'aaa.gif';

    update member set uploadfile='bbb.gif' where jno=2;
    update member set uploadfile='ccc.gif' where jno=3;
    update member set uploadfile='ddd.gif' where jno=4;
    update member set uploadfile='eee.gif' where jno=7;
    
   SELECT id , uploadfile FROM `member` m ;