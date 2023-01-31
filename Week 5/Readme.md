# 30/01/2023


### 답글 테이블 생성 - Creating reply table 
![poster](./reply.jpg)

# 31/01/2023
### 연관관계 주인 

### JPA(Java Persistence API)
ORM(Object Relational Mapping)(객체-관계-매핑)
ORM: 객체와 데이터베이스의 관계를 매핑해주는 도구이다.
ORM is a tool to map objects to table to interact with relational database

JPA: 관계형 데이터베이스의 관리를 표현하는 자바 API
application programming interface specification that describes the management of relational data in enterprise Java applications.

   Main Page          ----------->      See Details
1. Board: Title                         Author: detol3953 -------------> Username: User
2. Board: Title2                        Title: Title      ----------> Board
3. Board: Title3                        Contents:
                                        Comments:            -----> Reply
                                        
                                        
                                        
  Java Program      ------------->      JPA    -------------------> Database
                                       Board (Id = 1)
                                       ---> User info 
                                       ---> User        one
                                       ---> Reply       multiple
                                       
Select * From Board Where Id = 1;
Id   Title   Content   userId   createDate      Reply X ---------> 1NF 1정규형 (Atomicity 원자성)                  Reply    Id       Content   userId   boardID
                                                                   한 컬럼에 여러가지 데이터를 넣을 수 없다                   1         ~~~~~~     2         1
                                                                   Cannot make multiple data in a column                                        3         1
1    Title1   ~~~~       2        31-01-2023            

<span style="color:red">1</span>


