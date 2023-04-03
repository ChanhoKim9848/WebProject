package com.detol3953.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.detol3953.blog.model.User;

import lombok.Getter;


// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션저장소에 저장을 해준다

@Getter
public class PrincipalDetail implements UserDetails{
	private User user;  // 콤포지션 Composition

	public PrincipalDetail(User user) {
		this.user = user;
	}
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; // true: not expired
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;  // true: not locked
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;  // true: password is not expired
	}

	@Override
	public boolean isEnabled() {
		return true;   // true: account is enable
	}
	@Override
	
	// 계정이 갖고있는 권한을 리턴한다
	// Return Role that account has
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()-> {return "ROLE_"+user.getRole();});
		
		return collectors;
	}
	
}
