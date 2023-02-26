package com.detol3953.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
// 사용자 요청 (User Request) - > 응답(Data)
@RestController
public class HttpController {
	
	
	private static final String TAG="HttpController: ";
	
	//localhost:8080/blog/http/lombok
	@GetMapping("/http/lombok")
	public String lombok() {
		Member m = Member.builder().username("detol3953").password("detol3953").email("detol3953@naver.com").build();
		System.out.println(TAG+"getter:"+m.getUsername());
		m.setUsername("detol");
		System.out.println(TAG+"setter:"+m.getUsername());
		return "lombok test 완료";
		
	}
	
	
	// http://localhost:8080/http/get   (Select)
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get request: "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
	// http://localhost:8080/http/post  (Insert)
	@PostMapping("/http/post")  // text/plain, application/json
	public String postTest(@RequestBody Member m) {
		return "post request: "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
	// http://localhost:8080/http/put   (Update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put request"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
	// http://localhost:8080/http/delete     (Delete)
	@DeleteMapping("/http/delete")
	public String deleteTest(@RequestBody Member m) {
		return "delete request"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
}
