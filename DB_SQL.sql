DROP DATABASE IF EXISTS `articleManager`;
CREATE DATABASE `articleManager`;
USE `articleManager`;

# 게시글 테이블 생성
CREATE TABLE article (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	boardId INT(10) UNSIGNED NOT NULL,
	memberId INT(10) UNSIGNED NOT NULL,
	title CHAR(100) NOT NULL,
	`body` TEXT NOT NULL
);

-- ALTER TABLE article ADD COLUMN memberId INT(10) UNSIGNED NOT NULL AFTER updateDate;
-- ALTER TABLE article ADD COLUMN boardId INT(10) UNSIGNED NOT NULL AFTER updateDate;
SELECT * FROM article;
UPDATE article SET boardId = 2 WHERE boardId = 0;

# 회원 테이블 생성
CREATE TABLE `member` (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	loginId CHAR(30) NOT NULL,
	loginPw CHAR(100) NOT NULL,
	`authLevel` SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '권한 레벨 (3=일반,7=관리자)', 
	`name` CHAR(20) NOT NULL,
	nickname CHAR(20) NOT NULL,
	cellphoneNum CHAR(20) NOT NULL,
	email CHAR(20) NOT NULL,
	delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '탈퇴 여부 (0=탈퇴 전, 1=탈퇴 후)',
	delDate DATETIME COMMENT '탈퇴 날짜'
);

SELECT * FROM `member`;

# 게시판(board) 테이블 생성
CREATE TABLE board (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	`code` CHAR(50) NOT NULL UNIQUE COMMENT 'notice(공지사항) free(자유) QnA(질의응답)...',
	`name` CHAR(20) NOT NULL UNIQUE COMMENT '게시판 이름',
	delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '삭제 여부 (0=삭제 전, 1=삭제 후)',
	delDate DATETIME COMMENT '삭제 날짜'
);

# 게시판(board) 테스트 데이터 생성
INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'NOTICE',
`name` = '공지사항';

INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'FREE',
`name` = '자유';

INSERT INTO board
SET regDate = NOW(),
updateDate = NOW(),
`code` = 'QnA',
`name` = '질의응답';

SELECT * FROM board;

INSERT INTO `member` (
    id
,   regDate
,   updateDate
,   loginId
,   loginPw
,   `authLevel`
,   `name`
,   nickname
,   cellphoneNum
,   email
,   delStatus
,   delDate
) VALUES (
    NULL
,   NOW()
,   NOW()
,   'admin2'
,   '12342'
,   7
,   '관리자'
,   '관리자'
,   '01012345678'
,   'asdf@gmail.com'
,   0
,   NULL
);

INSERT INTO `member` (
    id
,   regDate
,   updateDate
,   loginId
,   loginPw
,   `authLevel`
,   `name`
,   nickname
,   cellphoneNum
,   email
,   delStatus
,   delDate
) VALUES (
    NULL
,   NOW()
,   NOW()
,   'test'
,   'test'
,   3
,   '김철수'
,   '작전철수'
,   '01022222222'
,   'asdf@gmail.com'
,   0
,   NULL
);

INSERT INTO `member` (
    id
,   regDate
,   updateDate
,   loginId
,   loginPw
,   `authLevel`
,   `name`
,   nickname
,   cellphoneNum
,   email
,   delStatus
,   delDate
) VALUES (
    NULL
,   NOW()
,   NOW()
,   'ㅅㄷㄴㅅ'
,   'ㅅㄷㄴㅅ'
,   3
,   '김영희'
,   '영희와철수'
,   '01023457823'
,   'asdfasdf@gmail.com'
,   0
,   NULL
);

SELECT LAST_INSERT_ID();

SELECT * FROM article;

INSERT INTO article (
	id,
	regDate,
	updateDate,
	memberId,
	title,
	`body`
) VALUES (
    NULL
,   NOW()
,   NOW()
,   3
,   '제목1'
,   '내용1'
);

INSERT INTO article (
	id,
	regDate,
	updateDate,
	memberId,
	title,
	`body`
) VALUES (
    NULL
,   NOW()
,   NOW()
,   3
,   '제목2'
,   '내용2'
);

INSERT INTO article (
	id,
	regDate,
	updateDate,
	memberId,
	title,
	`body`
) VALUES (
    NULL
,   NOW()
,   NOW()
,   3
,   '제목3'
,   '내용3'
);

# 게시글 데이터 대량 생성
INSERT INTO article (regDate, updateDate, memberId, boardId, title, `body`)
SELECT NOW(), NOW(), FLOOR(RAND() * 2) + 2, FLOOR(RAND() * 3) + 1, CONCAT('제목__',RAND()), CONCAT('내용__',RAND())
FROM article;

SELECT * FROM article ORDER BY id DESC;

# 회원 데이터 대량 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = CONCAT('loginId',SUBSTRING(RAND() * 1000 FROM 1 FOR 2)),
loginPw = CONCAT('loginPw',SUBSTRING(RAND() * 1000 FROM 1 FOR 2)),
`name` = CONCAT('name',SUBSTRING(RAND() * 1000 FROM 1 FOR 2)),
`nickname` = CONCAT('name',SUBSTRING(RAND() * 1000 FROM 1 FOR 2));

SELECT * FROM `member`;

SELECT
ROw_num()
,    a.id
,   a.regDate
,   a.updateDate
,   a.title
,   a.body
,   m.id AS memberId
,   m.loginId
,   m.authLevel
,   m.name
,   m.nickname
,   m.cellphoneNum
,   m.email
,   m.delStatus AS memberDelStatus
,   m.delDate AS memberDelDate
,   b.id AS boardId
,   b.`code` AS boardCode
,   b.`name` AS boardName
,   b.delStatus AS boardDelStatus
,   b.delDate AS boardDelDate
FROM
    article AS a
INNER JOIN
    `member` AS m
ON
    a.memberId = m.id
INNER JOIN
    board AS b
ON
    b.id = a.boardId
LIMIT 1, 10;
    






















