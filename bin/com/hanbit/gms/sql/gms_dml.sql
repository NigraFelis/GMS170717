-- id, password, name, ssn regdate
INSERT INTO Member(id, name, password, ssn, regdate)
VALUES('hong', '홍길동', '1', '860305-1234567', SYSDATE);
INSERT INTO Member(id, name, password, ssn, regdate)
VALUES('kim', '김유신', '1', '900606-1232323', SYSDATE);
INSERT INTO Member(id, name, password, ssn, regdate)
VALUES('dong', '홍길동', '1', '700707-1234545', SYSDATE);
INSERT INTO Member(id, name, password, ssn, regdate)
VALUES('gil', '홍길동', '1', '600808-1235858', SYSDATE);
INSERT INTO Member(id, name, password, ssn, regdate)
VALUES('111', '박지성', '1', '911212-1234567', SYSDATE);
INSERT INTO Member(id, name, password, ssn, regdate)
VALUES('222', '이영표', '1', '821212-2234567', SYSDATE);
INSERT INTO Member(id, name, password, ssn, regdate)
VALUES('333', '임요환', '1', '731212-2234567', SYSDATE);
INSERT INTO Member(id, name, password, ssn, regdate)
VALUES('444', '서인국', '1', '641212-2234567', SYSDATE);
INSERT INTO Member(id, name, password, ssn, regdate)
VALUES('555', '정우성', '1', '551212-2234567', SYSDATE);
INSERT INTO Member(id, name, password, ssn, regdate)
VALUES('666', '장동건', '1', '461212-2234567', SYSDATE);
INSERT INTO Member(id, name, password, ssn, regdate)
VALUES('888', '김우열', '1', '701212-2234567', SYSDATE);

SELECT * FROM Member;
SELECT * FROM Member WHERE name='홍길동';
SELECT COUNT(*) AS count FROM Member;

UPDATE MEMBER
SET password='2'
WHERE id='hong';

DELETE FROM MEMBER WHERE id 


INSERT INTO Board(article_seq,id,title, content,hitcount,regdate)
VALUES(article_seq.nextval,'hong','홍길동 안녕',
'사랑의 이상은',0,SYSDATE);
INSERT INTO Board(article_seq,id,title, content,hitcount,regdate)
VALUES(article_seq.nextval,'kim','김유신 안녕',
'있는 가는',0,SYSDATE);
INSERT INTO Board(article_seq,id,title, content,hitcount,regdate)
VALUES(article_seq.nextval,'dong','dong 안녕',
'용기가 풀이 뛰노는 가장 운다.',0,SYSDATE);
INSERT INTO Board(article_seq,id,title, content,hitcount,regdate)
VALUES(article_seq.nextval,'gil','gil 안녕',
'미인을 낙원을 커다란 않는 할지라도 때에',0,SYSDATE);
INSERT INTO Board(article_seq,id,title, content,hitcount,regdate)
VALUES(article_seq.nextval,'111','박지성 안녕',
'얼음에 청춘의 있으며',0,SYSDATE);
INSERT INTO Board(article_seq,id,title, content,hitcount,regdate)
VALUES(article_seq.nextval,'222','이영표 안녕',
'인간에 청춘 발휘하기 있으랴?',0,SYSDATE);
INSERT INTO Board(article_seq,id,title, content,hitcount,regdate)
VALUES(article_seq.nextval,'222','이영표 안녕',
'그들의 위하여서',0,SYSDATE);
INSERT INTO Board(article_seq,id,title, content,hitcount,regdate)
VALUES(article_seq.nextval,'222','이영표 안녕',
'봄바람을 뛰노는 쓸쓸하랴',0,SYSDATE);
INSERT INTO Board(article_seq,id,title, content,hitcount,regdate)
VALUES(article_seq.nextval,'222','이영표 안녕',
'열락의 인간에 이상의 봄바람이다',0,SYSDATE);
INSERT INTO Board(article_seq,id,title, content,hitcount,regdate)
VALUES(article_seq.nextval,'333','임요환 안녕',
'인도하겠다는 피는 이 이상',0,SYSDATE);

SELECT* FROM MEMBER WHERE name ='홍길동';

INSERT INTO MEMBER (ID, PASSWORD, SSN, REGDATE) VALUES (66,66,66,SYSDATE);

INSERT INTO BOARD(ID,%s,%s,%s,%s,%s) VALUES(?, ?, ?,SYSDATE,article_seq,?);

SELECT * FROM MEMBER;
SELECT * FROM Board;
