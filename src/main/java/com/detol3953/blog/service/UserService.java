package com.detol3953.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.detol3953.blog.model.User;
import com.detol3953.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int Registration(User user) {
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService: Registration() : "+e.getMessage());
		}
		return -1;
	}
}
