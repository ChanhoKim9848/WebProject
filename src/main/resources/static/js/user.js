let index = { 
	init: function(){
		$("#btn-save").on("click", ()=>{
			this.save();
		});
	},
	
	save: function(){
		// alert("save function called in user")
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		}
		
	    // ajax 처리 
		$.ajax().done().fail()     // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		                                          // 3 data username, password and email change to json type with ajax communication
		                                          //  and request insert
		                                          // console.log(data) 
	}
}

index.init();