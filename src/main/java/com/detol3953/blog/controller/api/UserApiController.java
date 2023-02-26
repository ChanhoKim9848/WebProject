package com.detol3953.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.detol3953.blog.dto.ResponseDto;
import com.detol3953.blog.model.RoleType;
import com.detol3953.blog.model.User;
import com.detol3953.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) { // username, password, email
		System.out.println("UserApiController: save 호출");
		 // Insert into DB and return 
		user.setRole(RoleType.USER);
		userService.Registration(user);
		return new ResponseDto<Integer>(HttpStatus.OK, 1); 
		// 
		
	}

}
