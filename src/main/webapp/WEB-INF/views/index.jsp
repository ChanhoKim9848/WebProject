<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<%-- ( 웹사이트 제목 title ) --%>
<title>detol3953's Blog</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<%-- ( 상단 네비게이션 바  Navigation Bar ) --%>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="/blog/">Home</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/user/login">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="/user/join">Register</a></li>
			</ul>
		</div>
	</nav>
	<br>

<%-- 프로필 --%>
	<div class="container">
	    <!-- <div class="card m-2" style="width: 400px">  -->
		<div class="card m-2"">
		
		<%-- 프로필 사진 --%>
			<!-- <img class="card-img-top" src="img_avatar1.png" alt="Card image"> -->
			<div class="card-body">
				<h4 class="card-title">제목 적는 부분 - Title</h4>
				<p class="card-text">내용 적는 부분 - Contents</p>
				<a href="#" class="btn btn-primary">상세보기 - Details</a>
			</div>
		</div>
	    <!-- <div class="card m-2" style="width: 400px">  -->
		<div class="card m-2"">
		
		<%-- 프로필 사진 --%>
			<!-- <img class="card-img-top" src="img_avatar1.png" alt="Card image"> -->
			<div class="card-body">
				<h4 class="card-title">제목 적는 부분 - Title</h4>
				<p class="card-text">내용 적는 부분 - Contents</p>
				<a href="#" class="btn btn-primary">상세보기 - Details</a>
			</div>
		</div>
	    <!-- <div class="card m-2" style="width: 400px">  -->
		<div class="card m-2"">
		
		<%-- 프로필 사진 --%>
			<!-- <img class="card-img-top" src="img_avatar1.png" alt="Card image"> -->
			<div class="card-body">
				<h4 class="card-title">제목 적는 부분 - Title</h4>
				<p class="card-text">내용 적는 부분 - Contents</p>
				<a href="#" class="btn btn-primary">상세보기 - Details</a>
			</div>
		</div>
	</div>


	<%-- ( 하단바 세팅 - Footer Setting ) --%>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Created by Chanho Kim</p>
		<p>📞Contact: +821085423953</p>
		<p>🏴Busan</p>
	</div>
</body>
</html>


