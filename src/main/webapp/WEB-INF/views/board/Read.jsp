<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">

	<button class="btn btn-secondary" onclick="history.back()">Back</button>

	<!--  자신의 글만 수정하거나 삭제 가능  -->
	<!-- User can only delete or edit their posts  -->
	<c:if test="${board.user.id == principal.user.id }">

		<!-- Edit 버튼 누를 시 updateForm 으로 가짐  -->
		<!-- Edit button goes to updateForm  -->
		<a href="/board/${board.id}/updateForm" class="btn btn-warning">Edit</a>
		<button id="btn-delete" class="btn btn-danger">Delete</button>
	</c:if>
	<br /> <br />

	<div>
		Post Number : <span id="id"><i>${board.id} </i></span>&nbsp;&nbsp;&nbsp; Author : <span><i>${board.user.username} </i></span>
	</div>
	<br />
	<div>
		<h3>${board.title}</h3>
	</div>
	<hr />

	<div class="form-group">
		<div>${board.content}</div>
	</div>
	<hr />



	<!-- Comment, 댓글 -->
	<div class="card">
		<div class="card-body">
			<textarea class="form-control" rows="1"></textarea>
		</div>
		<div class="card-footer"">
			<button class="btn btn-primary">Comment</button>
		</div>
	</div>

	<!-- Comments list,    댓글 리스트 -->
	<br />
	<div class="card">
		<div class="card-header">Comments</div>
		<ul id="comment--box" class="list-group">
			<li id="comment--1" class="list-group-item d-flex justify-content-between">
				<div>Contents</div>
				<div class="d-flex">
					<div class="font-italic">Author: detol &nbsp;&nbsp;</div>
					<button class="badge">Delete</button>
				</div>
			</li>
		</ul>

	</div>
</div>




<script src="../js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>



