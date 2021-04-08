# JPA 게시판

</br>

### 🎈 Prolog

📌 [@Yaans](https://github.com/KOO-YS) 님의 JPA 강의를 토대로 간단한 Spring Data JPA 게시판을 구현해보기 (실습)

</br>

### 💡 목표

- JPA 이용하여 게시판 CRUD 구현하기
- ~~Restful API 

</br>

### 💡 개발환경

- Intelli J IDEA

- Spring Boot 2.4.1
- jdk 1.8.0
- MySQL 8.0
- Bootstrap 4.0

</br>

### 💡 기능 명세

- 간단한 로그인 및 사용자 등록
- 게시글 목록 조회
- 페이징 처리 (Pageable 사용해보기)
- 게시글 상세 조회
- 게시글 작성 (파일 업로드)
- 게시글 수정
- 게시글 삭제

</br>

### 💡 Entity

- 회원
  - 아이디
  - 비밀번호
  - 이름
  - 이메일
- 게시판
  - 게시글 번호
  - 게시글 작성자
  - 게시글 제목
  - 게시글 내용
  - 게시글 업로드 날짜
  - 원본 파일명 (단일 파일 업로드)
  - 서버에 등록된 파일명 (단일 파일 업로드)
  - [게시글 조회수]

</br>

### 🎈 Epilogue

- JPA에 대해 더 공부하자 !
- 편리한 클래스 매핑 툴을 알아냈다! `ModelMapper`

</br>

### 😱

- ~~스프링 시큐리티 (암호화)~~  `완료`
- RESTful API

  

