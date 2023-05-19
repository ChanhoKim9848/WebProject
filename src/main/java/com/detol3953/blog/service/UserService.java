package com.detol3953.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.detol3953.blog.model.User;
import com.detol3953.blog.repository.UserRepository;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void Registration(User user) {
		// 회원가입시 패스워드를 인코딩 하지 않으면 시큐리티 로그인을 이용할 수 없다.
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		userRepository.save(user);
	}
	
	@Transactional
	public void EditProfile(User user) {
		// 수정시에는 영속성 컨텍스트 User 오브젝트를영속화를 시키고, 영속화된 User 오브젝트를 수정
		// select 해서 User 오브젝트를 DB로 부터 가져오는 이유는 영속화를 하기 위해서
		// 영속화된 오브젝트를 변경하면 자동으로 DB에 update문을 날려줌
		User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("fail to find the user");	
		}); 
		
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		persistance.setPassword(encPassword);
		persistance.setEmail(user.getEmail());
	
		
		// 회원수정 함수 종료 시 = 서비스 종료 = 트랜잭션 종료 = Commit이 자동으로 된다
		// 영속화된 persistance 객체의 변화가 감지되면 더티체킹이 되어 update 문을 날려준다
	}

	
//	@Transactional(readOnly = true) // Select할 때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료 (정합성)
//	public User 로그인(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
}