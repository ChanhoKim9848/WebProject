package com.detol3953.blog.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

// 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
// 그냥 주소가 / 이면 index.jsp 허용
// static 이하에 있는 /js/**, /css/**, /image/** 허용

// users who are not authenticated goes to /auth/**
// if the url is /... then index.jsp users are allowed to use
// static   /js/**, /css/** , /image/** allowed


@Controller
public class UserController {

	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}

	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("auth/kakao/callback")
	public @ResponseBody String kakaoCallback(String code) { // Controller function returns data
		
		// POST  type of key=value data request
		// Retrofit2
		// OkHttp
		// RestTemplate
		
		
		RestTemplate rt = new RestTemplate();
		
		// HttpHeaders Object Created
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		
		
		// HttpBody Object Created
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "90f7b1c8901f95fe46ffb6eb6d0632dc");
		params.add("redirect_uri", "http://localhost:8000/auth/kakao/callback");
		params.add("code", code);
		
		// HttpHeader and HttpBody into an object
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = 
				new HttpEntity<>(params, headers);
		
		
		// Http Request - POST type and Get response variance
		ResponseEntity<String> response = rt.exchange(
				"https://kauth.kakao.com/oauth/authorize",
				HttpMethod.POST,
				kakaoTokenRequest,
				String.class
				);
		
		return "Kakao Token Request Successful!" + response;
	}
	
	@GetMapping("/user/updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
}
