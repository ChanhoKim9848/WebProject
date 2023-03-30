package com.detol3953.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.detol3953.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {
	
	//    http://localhost:8000/blog/
	//    http://localhost:8000/blog
	@GetMapping({"","/"})
	
	public String index(@AuthenticationPrincipal PrincipalDetail principal) { //컨트롤러에서 세션을 어떻게 찾는지?
		
		// /WEB-INF/views/index.jsp
		System.out.println("Login Username: "+principal.getUsername());
		return "index";
	}
}
