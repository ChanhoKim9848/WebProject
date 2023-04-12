let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		
		$("#btn-delete").on("click", () => {
			this.deleteById();
		});		
		
		$("#btn-update").on("click", () => {
			this.update();
		});		
	},

	save: function() {
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};

		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data), 

			contentType: "application/json; charset=utf-8",

			
			dataType: "json" 
		}).done(function(resp) { 
			alert("Posted Successfully!");
			location.href = "/";

		}).fail(function(error) {    // fail
			alert(JSON.stringify(error));
		});
	},
	
	deleteById: function() {
		
		let id = $("#id").text();

		$.ajax({
			type: "DELETE",
			url: "/api/board/"+id,
			dataType: "json" 
			
		}).done(function(resp) { 
			alert("Deleted Successfully!");
			location.href = "/";

		}).fail(function(error) {    // fail
			alert(JSON.stringify(error));
		});
	},
	
		update: function() {
			
		let id = $("#id").val();
			
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};

		$.ajax({
			type: "PUT",
			url: "/api/board/"+id,
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8",
			dataType: "json" 
		}).done(function(resp) { 
			alert("Edit Successful!");
			location.href = "/board/"+id;

		}).fail(function(error) {    // fail
			alert(JSON.stringify(error));
		});
	},
	
}

index.init();