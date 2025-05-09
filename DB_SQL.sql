DROP DATABASE IF EXISTS `articleManager`;
CREATE DATABASE `articleManager`;
USE `articleManager`;

# 게시글 테이블 생성
CREATE TABLE article (
	id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	regDate DATETIME NOT NULL,
	updateDate DATETIME NOT NULL,
	title CHAR(100) NOT NULL,
	`body` TEXT NOT NULL
);

ALTER TABLE article ADD COLUMN memberId INT(10) UNSIGNED NOT NULL AFTER updateDate;

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

SELECT LAST_INSERT_ID();























