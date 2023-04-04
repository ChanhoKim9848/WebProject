package com.detol3953.blog.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.detol3953.blog.model.Board;
import com.detol3953.blog.model.User;
import com.detol3953.blog.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void Post(Board board, User user) {  // title, content
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	
	public List<Board> PostList(){
		return boardRepository.findAll();
	}
}
