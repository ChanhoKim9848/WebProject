package com.detol3953.blog.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.detol3953.blog.model.User;

// DAO
// 자동으로 bean 등록, Automatically register bean
// @Repository X
public interface UserRepository extends JpaRepository<User, Integer> {
    // 1, Repository of User Table
    // Primary Key = Integer
	
	

}
//JPA 네이밍 쿼리 전략 - Naming Query Strategy
// SELECT * FROM user WHERE username = ?1 AND password = ?2;
// User findByUsernameAndPassword(String username, String password); 

//@Query(value="SELECT * FROM user WHERE username = ?1 AND password = ?2;", nativeQuery = true)
//User login(String username, String password);