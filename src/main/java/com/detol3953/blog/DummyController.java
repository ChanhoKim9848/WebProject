package com.detol3953.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.detol3953.blog.model.RoleType;
import com.detol3953.blog.model.User;
import com.detol3953.blog.repository.UserRepository;

@RestController
public class DummyController {
	
	@Autowired //의존성 주입(Dependency Insertion)
	private UserRepository userRepository;
	
	// http://localhost:8000/blog/dummy/join (Request)
	// http 의 body의 username, password, email 데이터를 가지고 요청하면 
	// body data username, password and email goes into the parameters
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("username: "+user.getId());
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		System.out.println("email: "+user.getEmail());
		System.out.println("username: "+user.getRole());
		System.out.println("username: "+user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 완료 Registration Done";
		
		
		
	}

}
