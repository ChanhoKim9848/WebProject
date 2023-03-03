package com.detol3953.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Builder pattern
                  //ORM -> Java ( other languages ) Object -> mapping tables 

@Entity // 유저 클래스가 데이터를 읽고 MySQL에 테이블 생성
               //  User class read data and makes a table in MySQL

// @DynamicInsert  // Insert 시에 null 인 field 를 제외
                                     // no null fields in table when insert
public class User {
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	// 프로젝트에서 연결된 DB의 넘버링 전략
	// The DB connected to this project has a numbering strategy
	// Oracle : Sequence,  MySQL:  Auto increment
	
	private int id; // Sequence, auto_increment
	  
	                   
	@Column(nullable = false, length = 30, unique=true)  // unique id (아이디 중복 생성방지)
	private String username; // account name
	
	@Column(nullable = false, length = 100) // Can't be Null, Hash password (encoded)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;

	// @ColumnDefault("user")
	// DB는 RoleType 이 없다, DB does not have RoleType
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum could be good for data's domain, // ADMIN, USER
	
	@CreationTimestamp // Time inserted automatically
	private Timestamp createDate;
	
	
	
	
	

}
