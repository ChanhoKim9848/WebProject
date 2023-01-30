package com.detol3953.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Board {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //auto_increment
	private int id;

	@Column(nullable=false,length=100)
	private String title;
	
	@Lob // Big Data
	private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인됨, 
	                                            // Summernote library, board designed with <html> tags
	
	@ColumnDefault("0")
	private int count; // visits
	
	@ManyToOne // Many = Board, One = User, User can make multiple boards
	@JoinColumn(name="userId")
	private User user; // DB cannot save objects, however, Java can. Also, Foreign Key is used.
	
	@CreationTimestamp
	private Timestamp createDate;   // the current time
	
}
