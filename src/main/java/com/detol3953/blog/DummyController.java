package com.detol3953.blog;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.detol3953.blog.model.RoleType;
import com.detol3953.blog.model.User;
import com.detol3953.blog.repository.UserRepository;

// RestController:  returns not html file but data 
@RestController
public class DummyController {
	
	@Autowired //의존성 주입(Dependency Insertion)
	private UserRepository userRepository;
	
	
	
	// save함수는 id를 전달하지 않으면 insert를 해주고
	// save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
	// save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 한다.
	
	// if id is not given, save function inserts the data
	// if id is given, but there is a id data, it updates
	// if id is given, but there is no id data, it inserts
	
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
		userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "Failed to delete, the data does not exist!";
		}
		return "Id: "+id + "deleted successfully!";
	}
	
	// for email and password update
	@Transactional    
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser ) {
		// json 데이터를 요청 -> 메세지 컨버터의 Jackson 라이브러리가 Java Object 로 변환해서 받는다
		// json data request -> Jackson library of Message Converter changes the request to Java object and get request
		
		System.out.println("id: "+id);
		System.out.println("password: "+requestUser.getPassword());
		System.out.println("email: "+requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("Update Failed!");
		});
		
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		// userRepository.save(user);
		
		// 더티 체킹
		return null;
	}
	
	// http://localhost:8000/blog/dummy/user
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	// 한 페이지당 2건의 데이터를 리턴
	// one page returns 2 data 
	
	// 데이터 2개씩 id에 따라서 최신순으로 정렬
	// 2 data, sort by id from latest data
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction=Sort.Direction.DESC) Pageable pageable){
		Page<User> pagingUser = userRepository.findAll(pageable);
		
		List<User> users = pagingUser.getContent();
		return users;
	}
	
	// {id} 주소로 파라미터를 저장 받을 수 있다 
	// can get parameters from {id} address
	// http://localhost:8000/blog/dummy/user/3
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		// user/4을 찾으면 데이터에서 못 찾을 시 user 는 null이 될 것.
		//  if it cannot find user 4 then user returns null
		
		// return null 이 리턴이 되는 문제가 생김.
		// Optional로  User 객체의 null 여부를 판단해서 return
		// User Object is optional and check if it is null and return when it is not

		
		// Lambda equation
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("This user does not exist! id: " +id);
		});
		
//		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//		@Override
//		public IllegalArgumentException get() {
//			// TODO Auto-generated method stub
//			return new IllegalArgumentException("This user does not exist! id: "+id);
//		}
//	});
		// request: web browser
		// user object: java object
		// convert (web browser can understand) to json (Gson Library)
		// Spring boot = MessageConverter automatically activates when request
	   // by calling Jackson library which changes user object to json
		
		// 스프링부트는 메세지 컨버터가 작동되면서 자바 오브젝트를 json으로 변경해준다
		return user;
	}
	
	// http://localhost:8000/blog/dummy/join (Request)
	// http 의 body의 username, password, email 데이터를 가지고 요청하면 
	// body data username, password and email goes into the parameters
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("username: "+user.getId());
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		System.out.println("email: "+user.getEmail());
		System.out.println("username: "+user.getRole());
		System.out.println("username: "+user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 완료 Registration Done";
		
		
		
	}

}
