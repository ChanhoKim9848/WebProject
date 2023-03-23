<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<%-- 로그인 폼 설정 , Login Form Settings --%>
<div class="container">
	<form action="#" method="post">
		<div class="form-group">
			<label for="username">Username:</label>
		    <input type="text"  name="username" class="form-control" placeholder="Enter Username" id="username">
		</div>
		
		<div class="form-group">
			<label for="password">Password:</label>
			 <input type="password"  name="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<div class="form-group form-check">
			<label class="form-check-label">
			 <input name="remember" class="form-check-input" type="checkbox"> Remember me
			</label>
		</div>
		<button id="btn-login" class="btn btn-primary">Login</button>
	</form>
   
</div>

<script src = "../js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>



