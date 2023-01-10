-- 가장 기본
INSERT INTO MEMBER (MID, EMAIL, UPW, JOIN_DATE) VALUES ('ADMIN', 'ADMIN@admin.com', 'admin', sysdate);

COMMIT;
-- 추가계정, 추가게시글 2개씩
INSERT INTO MEMBER (MID, EMAIL, UPW, JOIN_DATE) VALUES('lsk','lsk@wb.com','lsk',sysdate);
INSERT INTO MEMBER (MID, EMAIL, UPW, JOIN_DATE) VALUES('user1','user1@wb.com','user1',sysdate);
COMMIT;
-- 여기까지 검증완료
INSERT INTO Review_Post (RP_NO, MID, RP_CONTENT, RP_TITLE, RP_AUTHOR, READ_DATE, REG_DATE, PHRASE,RP_READ_CHECK)
VALUES ((SELECT NVL(MAX(RP_NO),0)+1 FROM Review_Post), 'user1', '1CONTENT', '1TITLE', 'author1', sysdate, sysdate, 'phrase', 0)
;
INSERT INTO Review_Post (RP_NO, MID, RP_CONTENT, RP_TITLE, RP_AUTHOR, READ_DATE, REG_DATE, PHRASE,RP_READ_CHECK)
VALUES ((SELECT NVL(MAX(RP_NO),0)+1 FROM Review_Post), 'lsk', '2CONTENT', '2TITLE', 'author2', sysdate, sysdate, 'phrase2', 0)
;
COMMIT;


--게시글
--원글 
INSERT INTO Review_Post (RP_NO, MID, RP_CONTENT, RP_TITLE, RP_AUTHOR, READ_DATE, REG_DATE, PHRASE,RP_READ_CHECK)
VALUES ((SELECT NVL(MAX(RP_NO),0)+1 FROM Review_Post), 'user1', 'CONTENT', '&NUMBER TITLE', 'author3', sysdate, sysdate, 'PHRASE', 0)
;
COMMIT;
-- 게시판목록보기
SELECT * FROM Review_Post ORDER BY RP_NO DESC;
SELECT * FROM Review_Post;
SELECT MAX(RP_NO) FROM Review_Post;
SELECT NVL(MAX(RP_NO),0) FROM Review_Post;
SELECT NVL(MAX(RP_NO),0)+1 FROM Review_Post;

--캘린더

--CREATE TABLE Cal_Post (
--	id	NUMBER NOT NULL,
--	MID	VARCHAR2(20)		NOT NULL,
--	title	VARCHAR(50)		NOT NULL,
--	CP_CONTENT	VARCHAR2(1000)		NOT NULL,
--	CP_AUTHOR	VARCHAR2(50)		NOT NULL,
--	CP_READ_CHECK	NUMBER(1)		NOT NULL,
--	START1	DATE		NOT NULL,
--	END1	DATE		NULL,
--	ALLDAY	NUMBER(1)		NULL,
--	TEXTCOLOR	 VARCHAR(50)	NOT NULL,
--	BACKGROUNDCOLOR	VARCHAR2(50)	NULL
--);

insert into cal_post(id, MID, title, CP_CONTENT, CP_AUTHOR, CP_READ_CHECK, START1, END1, ALLDAY, TEXTCOLOR	, BACKGROUNDCOLOR)
values(cal_seq.nextval,'user1','제목','내용 - test','author1',1,to_date('2023-01-02','YY-MM-DD'), to_date('2023-01-03','YY-MM-DD'),1,'white','green'); 

DESC Review_Post;
DESC MEMBER;