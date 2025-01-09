# 쇼핑몰 프로젝트

## 소개
이 프로젝트는 학습 목적으로 개발된 작은 쇼핑몰 애플리케이션이다. Apache Tomcat, JSP, Servlet, MyBatis, 그리고 MySQL을 기반으로 구현되었으며, 웹 애플리케이션 개발 전반에 대한 실습과 이해를 목표로 한다.

## 주요 기능
1. **회원 관리**
   - 회원가입 및 로그인/로그아웃 기능
   - 회원 정보 수정 및 삭제

2. **상품 관리**
   - 상품 목록 조회
   - 상품 상세 정보 보기
   - 상품 검색 기능

3. **장바구니**
   - 장바구니에 상품 추가
   - 장바구니 상품 수정 및 삭제

4. **주문 관리**
   - 주문 생성
   - 주문 내역 조회

## 기술 스택
- **서버**: Apache Tomcat 10.x
- **프론트엔드**: HTML, CSS, JavaScript, JSP
- **백엔드**: JSP 3.x, Servlet
- **데이터베이스**: MySQL 8.x
- **ORM**: MyBatis

## 프로젝트 구조
```
shoppingmall/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/       # Servlet 컨트롤러
│   │   │   ├── dao/              # 데이터 접근 객체 (DAO)
│   │   │   ├── service/          # 서비스 로직
│   │   │   └── dto/           	  # 데이터 모델(겸 dto 객체) -> 편의상 하나의 dto를 재사용한다.
│   │   └── webapp/
│   │       ├── WEB-INF/          # JSP 및 설정 파일
│   │       └── images/           # 이미지 파일
├── resources/
│   └── mybatis-config.xml        # MyBatis 설정 파일
└── README.md                      # 프로젝트 설명
```

## 데이터베이스 테이블 설계
![image](https://github.com/user-attachments/assets/0145c36f-1f5b-4486-a7ad-d56183688e09)

### **member** 테이블

| 필드 이름  | 데이터 타입    | 설명           |
|------------|----------------|----------------|
| userid     | VARCHAR(20)    | 기본 키 (PK)   |
| passwd     | VARCHAR(255)   | 비밀번호       |
| username   | VARCHAR(20)    | 사용자 이름    |
| post       | VARCHAR(6)     | 우편번호       |
| addr1      | VARCHAR(500)   | 주소 1         |
| addr2      | VARCHAR(500)   | 주소 2         |
| phone1     | VARCHAR(3)     | 전화번호 1     |
| phone2     | VARCHAR(4)     | 전화번호 2     |
| phone3     | VARCHAR(4)     | 전화번호 3     |
| email1     | VARCHAR(20)    | 이메일 1       |
| email2     | VARCHAR(20)    | 이메일 2       |

---

### **orderinfo** 테이블

| 필드 이름    | 데이터 타입    | 설명           |
|--------------|----------------|----------------|
| num          | INT            | 기본 키 (PK)   |
| userid       | VARCHAR(10)    | 사용자 ID      |
| gCode        | VARCHAR(20)    | 상품 코드      |
| gSize        | CHAR(1)        | 상품 크기      |
| gColor       | VARCHAR(10)    | 상품 색상      |
| gAmount      | INT            | 상품 수량      |
| orderName    | VARCHAR(10)    | 주문자 이름    |
| post         | VARCHAR(5)     | 우편번호       |
| addr1        | VARCHAR(500)   | 주소 1         |
| addr2        | VARCHAR(500)   | 주소 2         |
| phone        | VARCHAR(11)    | 전화번호       |
| orderDay     | DATE           | 주문 날짜      |

---

### **cart** 테이블

| 필드 이름  | 데이터 타입    | 설명           |
|------------|----------------|----------------|
| num        | INT            | 기본 키 (PK)   |
| userid     | VARCHAR(20)    | 사용자 ID      |
| gCode      | VARCHAR(20)    | 상품 코드      |
| gSize      | CHAR(1)        | 상품 크기      |
| gColor     | VARCHAR(10)    | 상품 색상      |
| gAmount    | INT            | 상품 수량      |
| gCartDate  | DATE           | 장바구니 날짜  |

---

### **goods** 테이블

| 필드 이름   | 데이터 타입    | 설명           |
|-------------|----------------|----------------|
| gCode       | VARCHAR(20)    | 기본 키 (PK)   |
| gCategory   | VARCHAR(20)    | 상품 카테고리  |
| gName       | VARCHAR(50)    | 상품 이름      |
| gContent    | VARCHAR(4000)  | 상품 설명      |
| gPrice      | INT            | 상품 가격      |
| gImage      | VARCHAR(20)    | 상품 이미지    |

## 라이선스
이 리포지토리는 학습 목적으로 생성 되었으며, 누구나 참고 후 재편집이 가능하다.
