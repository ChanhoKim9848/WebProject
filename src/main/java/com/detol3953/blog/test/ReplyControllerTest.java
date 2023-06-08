package com.detol3953.blog.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.detol3953.blog.model.Board;
import com.detol3953.blog.model.Reply;
import com.detol3953.blog.repository.BoardRepository;
import com.detol3953.blog.repository.ReplyRepository;

@RestController
public class ReplyControllerTest {

	@Autowired
	private ReplyRepository replyRepository;

	@Autowired
	private BoardRepository boardRepository;

	@GetMapping("/test/board/{id}")
	public Board getBoard(@PathVariable int id) {
		return boardRepository.findById(id).get(); 
	}
		@GetMapping("/test/reply")
		public List<Reply> getReply() {
			return replyRepository.findAll();
	}
}
