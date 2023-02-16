package com.detol3953.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.detol3953.blog.repository.UserRepository;


//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해준다.
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;


}
