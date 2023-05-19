let index = {
	init: function() {
		$("#btn-save").on("click", () => { // function(){}, ()=>{} this를 바인딩 하기 위해서 (binding this)
			this.save();
		});
		$("#btn-update").on("click", () => { // function(){}, ()=>{} this를 바인딩 하기 위해서 (binding this)
			this.update();
		});
/*		$("#btn-login").on("click", () => { // function(){}, ()=>{} this를 바인딩 하기 위해서 (binding this)
			this.login();
		}); */
	},

	save: function() {
		// alert("save function called in user")
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};

		// ajax 호출시 default가 비동기 호출
		// calling ajax and its default is asynchronous call

		// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		// 3 data username, password and email change to
		//  json type with ajax communication  and request insert
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), // http body data
			
			contentType: "application/json; charset=utf-8",
			 // body 데이터가 어떤타입인지  (MIME)
			//  indicates what type of body data is
			
			dataType: "json" // 요청을  서버로해서 응답이 왔을때 데이터 문자열이 json 타입이라면 JavaScript 오브젝트로 변경.
			// if the data request from the server is json type then changes to JavaScript object.

			// 회원가입 수행 요청 - Registeration Request
		}).done(function(resp) {   // done
			alert("Registered Successfully!");
			console.log(resp);

			// 회원가입 후 메인화면 리턴
			// return m ain page after the register
			location.href = "/";

		}).fail(function(error) {    // fail
			alert(JSON.stringify(error));
		});
	},
	update: function() {
		let data = {
			id: $("#id").val(),
			username:$("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		$.ajax({
			type: "PUT",
			url: "/user",
			data: JSON.stringify(data), // http body data
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {   // done
			alert("Profile Editted Successfully!");
			console.log(resp);
			location.href = "/";
		}).fail(function(error) {    // fail
			alert(JSON.stringify(error));
		});
	},	
	
	
	
	
	
/*		login: function() {
		// alert("save function called in user")
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
		};

		$.ajax({
			type: "POST",
			url: "/api/user/login",
			data: JSON.stringify(data), // http body data
			
			contentType: "application/json; charset=utf-8",
			 // body 데이터가 어떤타입인지  (MIME)
			//  indicates what type of body data is
			
			dataType: "json" // 요청을  서버로해서 응답이 왔을때 데이터 문자열이 json 타입이라면 JavaScript 오브젝트로 변경.
			// if the data request from the server is json type then changes to JavaScript object.

			// 회원가입 수행 요청 - Registeration Request
		}).done(function(resp) {   // done
			alert("Login Successful!");

			// 회원가입 후 메인화면 리턴
			// return main page after the register
			location.href = "/";

		}).fail(function(error) {    // fail
			alert(JSON.stringify(error));
		});   
	}
	*/
}

index.init();