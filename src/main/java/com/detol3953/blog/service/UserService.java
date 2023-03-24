package com.detol3953.blog.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.detol3953.blog.model.RoleType;
import com.detol3953.blog.model.User;
import com.detol3953.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void Registration(User user) {
		
		String rawPassword = user.getPassword(); // original password
		String encPassword = encoder.encode(rawPassword); // hashed
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	

//	@Transactional(readOnly=true) // Select 할 때 트랜잭션 시작, 서비스가 종료될 때 트랜잭션 종료 (정합성)
//	  // when Select, Transaction starts and it stops when the service stops (consistency)
//	public User Login(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
}
