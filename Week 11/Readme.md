# 23/03/2023

### 로그인 페이지 커스터마이징 - Login Page Customizing


인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용

그냥 주소가 / 이면 index.jsp 허용

static 이하에 있는 /js/**, /css/**, /image/** 허용




users who are not authenticated, they go to /auth/**

if the url is /... then users are allowed to use index page

static pages are viewed  /js/**, /css/** , /image/** 

#


### 유저가 로그인 되어있지 않다면, 로그인 화면으로 가진다

### If users are not logged in, they cannot go to index page


# 24/03/2023

### 비밀번호 해쉬암호화 - HASH PASSWORD

### 해쉬란
스트링형 비밀번호를 고정길이의 스트링값으로 변경해서 저장하는 방식

### Hashing
assigning a numeric or alphanumeric string to a piece of data by applying a hash function whose output values
are all the same number of bits in length

![poster](./Hash.jpg)

![poster](./Hash2.jpg)


# 26/03/2023

### CSRF - Cross-site request forgery , XSS - Cross-site Scripting

CSRF

a web security vulnerability that allows an attacker to induce users to perform actions that they do not intend to perform


XSS

자바스크립트로 공격하는 방식
Attacking with type of injection with JavaScript



![poster](./xss.jpg)


XSS, CSRF 방어법

Prevent XSS and CSRF

1. Using CSRF Token
2. Post Request


# 27/03/2023

### Spring Security Login

# 28/03/2023

### TROUBLE SHOOTING

Encoded password does not look like BCrypt -> Password should be Encoded

# 30/03/2023

로그인 요청 (/auth/loginProc) -> SecurityConfig.java 가 PrincipalDetailService.java에 있는 loadUserByUsername으로 username,password 전송 ->

username을 데이터베이스에서 비교 -> username의 password를 encodePWD()에 넣어서 데이터베이스 안에있는 해쉬화된 비밀번호와 비교해서 로그인

#
Login Request (/auth/loginProc) -> SecurityConfig.java gets username and password, and send it to loadUserByUsername method in PrincipalDetailService.java

compare username in Database -> put password of username in encodePWD() method and compare hashed password in database


# 31/03/2023

### Writing on Board
