# README.md

# # RESTAPI 프로젝트

## ## 프로젝트 구조

- API 서버 (java 8) - spring boot 사용

### ### API 서버

## Controller

- BoardController - REST구조의 조회,작성,수정,삭제를 처리할 컨트롤러
- BoardLikeController - 좋아요 기능을 처리할 컨트롤러

## Service

- BoardService -  BoardService 추상화 인터페이스
- BoardServiceImpl - BoardService 인터페이스 구현제
- BoardLikeService-  BoardService 추상화 인터페이스
- BoardLikeServiceImpl - BoardService 인터페이스 구현제

## DTO

- BoardDTO - Board의 객체를 담아 json으로 매핑을 처리할 DTO
- MemberDTO - Member의 객체를 담아 인증값을 구현

## Entity

- Member - Member 의 데이터 테이블
- MemberRepository - MemberRepository 추상 인터페이스
- Board - Board의 데이터 테이블
- BoardRepository - BoardRepository 추상 인터페이스
- BoardLike - BoardLike의 데이터 테이블
- BoardLikeRepository - BoardLikeRepository 추상 인터페이스

## Util

- MemberEnum - 사용자의 인증값을 열거형 클래스로 정의

## DML

```sql
INSERT INTO member (id, account_id, account_type, nickname, quit) VALUES(2, '23', 'REALTOR', '공인 중개사', 'N');
INSERT INTO member (id, account_id, account_type, nickname, quit) VALUES(3, '42', 'LESSOR', '임대인', 'N');
INSERT INTO member (id, account_id, account_type, nickname, quit) VALUES(4, '32', 'LESSEE', '임차인', 'N');
INSERT INTO member (id, account_id, account_type, nickname, quit) VALUES(5, '47', 'LESSEE', '임차인', 'N');
```

### ### 시나리오 및 실행결과

### 게시판 글 목록 조회

1. GET “localhost:8080/board” 입력
2. Headers {”account_type”:”Realtor 47”}
![Untitled](https://user-images.githubusercontent.com/80050148/217252572-60d32a3a-27fb-4d5b-9e1e-bb428bdb395a.png)  
3. 요청 시 MemberEnum 로 split(” “)을 이용해 객체를 배열에 담아 사용자의 권한과 ID를 분리
4. 사용자 인증값 확인시 id와 권한이 노출된다.
    
    ![Untitled](https://user-images.githubusercontent.com/80050148/217252851-a1c7d004-295c-403f-a130-797812ed570d.png)
    
5. Headers 미입력시
    
![Untitled](https://user-images.githubusercontent.com/80050148/217253052-68a25e04-37ca-469d-8f9b-0f546df04864.png)

    
6. 외부사용자 확인 게시판은 목록만 조회된다.

### 게시판 글 작성

1. POST “localhost:8080/board” 입력
2. Headers {”account_type”:”Realtor 47”}
    
   ![image](https://user-images.githubusercontent.com/80050148/217253162-540e96ec-6132-4743-9af1-d2bd2cbf4af0.png)
    
3. 요청 시 MemberEnum 로 split(” “)을 이용해 객체를 배열에 담아 사용자의 권한과 ID를 분리
4. Body {"title":"글쓰기","content":"성공"} 입력 후 정상 insert 된다.
    
    ![image](https://user-images.githubusercontent.com/80050148/217253230-b69923c2-3cb7-43a4-a94a-9298688ef0a5.png)
    
   ![image](https://user-images.githubusercontent.com/80050148/217253274-878cc7c3-8c9e-405d-8071-4e42e210125f.png)
    
5. Headers 미입력시
    
    ![image](https://user-images.githubusercontent.com/80050148/217253308-0fd21817-51c6-4a89-b28c-7a1a5f5e63d9.png)
    
6. 외부사용자 확인 게시판은 목록만 조회된다.

### 게시판 글 수정

1. PUT “localhost:8080/board/글아이디” 입력
2. Headers {”account_type”:”Realtor 47”}
    
    ![image](https://user-images.githubusercontent.com/80050148/217253352-21017c07-1274-4a6d-b0b2-975265b2936d.png)
    
3. 요청 시 MemberEnum 로 split(” “)을 이용해 객체를 배열에 담아 사용자의 권한과 ID를 분리
4. Body {"title":"수정","content":”성공"} 입력 후 정상 insert 된다.
    
    ![image](https://user-images.githubusercontent.com/80050148/217253406-9b49661d-9168-4590-830f-eb0b721b0623.png)
    
5. Headers 미입력시
    
    ![image](https://user-images.githubusercontent.com/80050148/217253469-637b281b-dd94-49d3-82dc-96487ee7b434.png)
    
    ![image](https://user-images.githubusercontent.com/80050148/217253527-a35f0ace-bafa-4db5-930b-ad78766887f4.png)
    
    ![image](https://user-images.githubusercontent.com/80050148/217253573-2e96f50a-5672-41b5-af7c-d7aafbb160a0.png)
    
6. 외부사용자 확인 게시판은 목록만 조회된다.

### 게시판 글 삭제

1. PUT “localhost:8080/board/글아이디” 입력
2. Headers {”account_type”:”Realtor 47”}
    
    ![image](https://user-images.githubusercontent.com/80050148/217253637-340672ac-2c12-4a0e-ae64-687d9ee076d5.png)
    
3. 요청 시 MemberEnum 로 split(” “)을 이용해 객체를 배열에 담아 사용자의 권한과 ID를 분리
4. url만 입력 후 요청 시
    
    ![image](https://user-images.githubusercontent.com/80050148/217253689-e8b391b7-0d97-45ae-b9d3-a5e6c4906983.png)
    
5. Headers 미입력시
    
    ![image](https://user-images.githubusercontent.com/80050148/217253736-6f0b5282-fc38-4971-8f8f-61444f13610e.png)
    
    ![image](https://user-images.githubusercontent.com/80050148/217253789-3d171d96-b58d-4472-aa41-bcec2d79d452.png)
    
    ![image](https://user-images.githubusercontent.com/80050148/217253843-2464931e-e3bb-4363-a494-dc3d010658d6.png)
    
6. 외부사용자 확인 게시판은 목록만 조회된다.

### 게시판 글 좋아요

1. POST “localhost:8080/like/글아이디” 입력
2. Headers {”account_type”:”Realtor 47”}
    
    ![image](https://user-images.githubusercontent.com/80050148/217253880-0d356200-0912-4f26-b6c6-56350391cd45.png)
    
3. 요청 시 MemberEnum 로 split(” “)을 이용해 객체를 배열에 담아 사용자의 권한과 ID를 분리
4. url만 입력 후 요청 시
    
    ![image](https://user-images.githubusercontent.com/80050148/217253923-e6231ed4-339a-4db9-a4c7-006b1f5b441f.png)
    
5. Board 테이블의 likeCnt 증가
    
    ![image](https://user-images.githubusercontent.com/80050148/217253961-4402b14f-5d3a-4ae2-a938-7bdec0adaa2e.png)
    
6. 좋아요 재 요청 시
    
    ![image](https://user-images.githubusercontent.com/80050148/217253997-2d7a1b54-e6d4-450a-a438-f2908438c541.png)
    
7. Headers 미입력시
 
    
    ![image](https://user-images.githubusercontent.com/80050148/217254240-032226a9-6235-4a6c-8b88-8c7b127d0343.png)
    
8. 외부사용자 확인 게시판은 목록만 조회된다.
