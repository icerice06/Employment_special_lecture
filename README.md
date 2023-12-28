# Employment_special_lecture
방학특강 게시판 만들기

https://docs.google.com/spreadsheets/d/1wwCUe7AXxIoeA6rm7cFMxB-Kirtab8oIuUUfj1iXOpc/edit#gid=1893687854


CREATE DATABASE IF NOT EXISTS Board_DB;

USE Board_DB;

-- 카테고리 테이블
CREATE TABLE Category (
    code INTEGER PRIMARY KEY AUTO_INCREMENT,  -- 카테고리 고유 코드
    name TEXT NOT NULL  -- 카테고리 이름
);

-- 게시물 테이블
CREATE TABLE List (
    detailed_code INTEGER PRIMARY KEY AUTO_INCREMENT,  -- 게시물 고유 ID
    password TEXT NOT NULL,  -- 게시물 비밀번호
    title TEXT NOT NULL,  -- 게시물 제목
    writer TEXT NOT NULL,  -- 게시물 작성자
    content TEXT NOT NULL,  -- 게시물 내용
    category_code INTEGER NOT NULL,  -- 카테고리 코드
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 게시물 생성 시간
    FOREIGN KEY (category_code) REFERENCES Category(code)  -- 외래 키 참조
);

-- 댓글 테이블
CREATE TABLE Comment (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,  -- 댓글 고유 ID
    comment_writer TEXT NOT NULL,  -- 댓글 작성자
    comment TEXT NOT NULL,  -- 댓글 내용
    list_detailed_code INTEGER NOT NULL,  -- 게시물 외래 키 참조
    FOREIGN KEY (list_detailed_code) REFERENCES List(detailed_code) -- 외래 키 참조
);
