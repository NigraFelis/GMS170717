-- id, password, name, ssn regdate

CREATE SEQUENCE article_seq
	START WITH		1000
	INCREMENT BY 	1
	NOCACHE
	NOCYCLE;
	
CREATE TABLE Member(
	name VARCHAR2(20),
	id VARCHAR2(10), 
	password VARCHAR2(10),
	ssn VARCHAR2(15),
	regdate DATE,
	PRIMARY KEY(id)
);

SELECT * FROM Member;
DROP TABLE Member;

CREATE TABLE Board(
	article_seq NUMBER,
	id VARCHAR2(20),
	title VARCHAR2(20),
	content VARCHAR2(20),
	hitcount VARCHAR2(20),
	regdate DATE,
	PRIMARY KEY(article_seq),
	FOREIGN KEY (id) REFERENCES Member(id)
		ON DELETE CASCADE
);

SELECT * FROM MEMBER WHERE name='홍길동';

Alter Table Board Modify(content VARCHAR2(100));

