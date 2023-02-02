package com.detol3953.blog.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.detol3953.blog.model.User;

// DAO
// 자동으로 bean 등록, Automatically register bean
// @Repository X
public interface UserRepository extends JpaRepository<User, Integer> {
    // 1, Repository of User Table
    // Primary Key = Integer
	
}
