package com.detol3953.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.detol3953.blog.config.auth.PrincipalDetail;
import com.detol3953.blog.model.Board;
import com.detol3953.blog.model.User;
import com.detol3953.blog.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void Post(Board board, User user ) {  // title, content
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	@Transactional(readOnly=true)
	public Page<Board> PostList(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly=true)
	public Board Read(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("Cannot Read! : cannot find id!");
				});
	}
	
	  @Transactional
	    public void DeletePost(int id, PrincipalDetail principal) {
	        Board board = boardRepository.findById(id).orElseThrow(() -> {
	            return new IllegalArgumentException("Cannot see this post! : The user does not exist!");
	        });

	        if (board.getUser().getId() != principal.getUser().getId()) {
	            throw new IllegalStateException("You do not have a permission to delete this post!");
	        }
	        boardRepository.delete(board);
	  }
	  
//	  @Transactional
//	  public void EditPost(int id, Board requestBoard) {
//		  Board board = boardRepository.findById(id)
//				  .orElseThrow(()->{
//	            return new IllegalArgumentException("Cannot find the post! : The user does not exist!");
//	        }); // 영속화 완료
//		  board.setTitle(requestBoard.getTitle());
//		  board.setContent(requestBoard.getContent());
//		  // 해당 함수 종료시 (서비스가 종료될 때 ) 트랜잭션 종료 -> 더티체킹 (자동 업데이트, DB flushing)
//		  // This Method ends (Service shutdown) and Transaction ends -> Dirty Checking (Automatic update)
//	  }
	  
	  @Transactional
	    public void EditPost(int id, PrincipalDetail principal, Board requestBoard) {
	        Board board = boardRepository.findById(id).orElseThrow(() -> {
	            return new IllegalArgumentException("Cannot find the post! : The user does not exist!");
       
	        });
	        if (board.getUser().getId() != principal.getUser().getId()) {
	            throw new IllegalStateException("You do not have a permission to delete this post!");
	        }
	  		  board.setTitle(requestBoard.getTitle());
			  board.setContent(requestBoard.getContent());	   
	  }
}
