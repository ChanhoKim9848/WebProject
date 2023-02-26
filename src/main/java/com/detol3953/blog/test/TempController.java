package com.detol3953.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {
	
	// http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		// 파일리턴 기본경로 file return path: src/main/resources/static
		// 리턴명 return name: /home.html
		// 풀경로 full path: src/main/resources/static/home.html
		return "/home.html";
	}
	
		
		@GetMapping("/temp/img")
		public String tempIng() {
			return "/a.jpg";
		}
		
		@GetMapping("/temp/jsp")
		public String tempjsp() {
			
			// prefix: /WEB-INF/views/
			// suffix: .jsp
			// fulle name: /WEB-INF/views/test.jsp
			return "test";
		}
		
	}

