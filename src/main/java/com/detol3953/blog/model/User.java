package com.detol3953.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


// ORM -> Java ( other languages ) Object -> mapping tables 
@Entity // User class read data and makes a table in MySQL
public class User {
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	// 프로젝트에서 연결된 DB의 넘버링 전략
	// The DB connected to this project has a numbering strategy
	// Oracle : Sequence,  MySQL:  Auto increment
	
	private int id; // Sequence, auto_increment
	
	@Column(nullable = false, length = 30)
	private String username; // account name
	
	@Column(nullable = false, length = 100) // Can't be Null, Hash password (encoded)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@ColumnDefault(" 'user' ")
	private String role; // Enum could be good for data's domain, // admin, user, manager
	
	@CreationTimestamp // Time inserted automatically
	private Timestamp createDate;
	
	
	
	
	

}
