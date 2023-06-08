package com.detol3953.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.detol3953.blog.config.auth.PrincipalDetail;
import com.detol3953.blog.dto.ResponseDto;
import com.detol3953.blog.model.Board;
import com.detol3953.blog.model.Reply;
import com.detol3953.blog.service.BoardService;

@RestController
public class BoardApiController {
 
	@Autowired
	private BoardService boardService;

	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) { 
		
		// Insert into DB and return
		boardService.Post(board, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

	@DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id, @AuthenticationPrincipal PrincipalDetail principal) {
        boardService.DeletePost(id, principal);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
	
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @AuthenticationPrincipal PrincipalDetail principal, 
			@RequestBody Board board){
		boardService.EditPost(id, principal, board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	

	@PostMapping("/api/board/{boardId}/reply")
	public ResponseDto<Integer> replySave(@PathVariable int boardId, 
			@RequestBody Reply reply,
			@AuthenticationPrincipal PrincipalDetail principal) {
		
		// Insert into DB and return
		boardService.Comment(principal.getUser(), boardId,reply);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}	
	
	@DeleteMapping("/api/board/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
		boardService.DeleteComment(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	
}
