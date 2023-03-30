package com.detol3953.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.detol3953.blog.model.User;
import com.detol3953.blog.repository.UserRepository;

@Service // Bean 등록
public class PrincipalDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	// 스프링이 로그인 요청을 가로챌 때 , username, password 변수 2개를 가로채는데
	// password 부분 처리는 알아서 한다.
	// username이 DB에 있는지 확인하면 됨
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()-> {
					return new UsernameNotFoundException("The User is Not Found. : "+username );
				});
		return new PrincipalDetail(principal); // 시큐리티의 세션의 유저정보가 저장됨.
		                                                                       // User Information saved in the session of Security 
	}
}
