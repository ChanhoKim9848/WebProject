package com.detol3953.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;

	@Column(nullable = false, length = 100)
	private String title;

	@Lob // Big Data
	private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인됨,
							// Summernote library, board designed with <html> tags

	private int count; // visits

	@ManyToOne(fetch = FetchType.EAGER) // Many = Board, One = User, User can make multiple boards
	@JoinColumn(name = "userId")
	// 자바는 오브젝트 저장가능, DB는 못하며 Foreign Key 를 사용한다.
	private User user; // DB cannot save objects, however, Java can. Also, Foreign Key is used.

	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // 보드는 여러가지의 답변을 가질 수 있다. one board can have multiple
															// replies
															// mappedBy 연관관계 주인이 아니다 ( FK가 아니다), DB에 컬럼을 만들지 않는다
    @JsonIgnoreProperties({"board"})
	@OrderBy("id desc")
	private List<Reply> replies;

	@CreationTimestamp
	private Timestamp createDate; // the current time

}
