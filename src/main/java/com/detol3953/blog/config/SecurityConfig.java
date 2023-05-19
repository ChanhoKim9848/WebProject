package com.detol3953.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.detol3953.blog.config.auth.PrincipalDetailService;


@Configuration // 빈 등록 (객체 생성)
@EnableWebSecurity // 필터 체인에 등록 (스프링 시큐리티 활성화)
@EnableGlobalMethodSecurity(prePostEnabled=true) // 특정 주소 접근시 권한 및 인증을 pre(미리) 체크하겠다.
public class SecurityConfig{
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}
	
	
	
	
	// 1. Bean 어노테이션은 메서드에 붙여서 객체 생성시 사용

	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	// 2. 시큐리티가 로그인할 때 어떤 암호화로 인코딩해서 비번을 비교할지 알려줘야 함.
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	@Bean 
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         
	        http
	        .csrf().disable() //csrf 토큰 비활성화 (테스트시 걸어두는게 좋음)
	        
	        .authorizeRequests()
	          .antMatchers("/","/auth/**","/js/**","/css/**", "/images/**", "/dummy/**", "/image/**")
	          .permitAll()
              .anyRequest()
              .authenticated()
           
           .and()
              .formLogin()
              .loginPage("/auth/loginForm")
              .loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 로그인을 가로챈다.
	       .defaultSuccessUrl("/"); //정상적으로 요청이 완료       
	        return http.build();
	    }
	
	// 참고 : .headers().frameOptions().disable() // 아이프레임 접근 막기
	// 참고 : .csrf().disable() // csrf 토큰 비활성화 (테스트시 걸어주는 것이 좋음)
}