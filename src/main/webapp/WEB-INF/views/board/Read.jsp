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

		<form>
			<input type="hidden" id="boardId" value="${board.id}" />
			<div class="card-body">
				<textarea id="reply-content" class="form-control" rows="1"></textarea>
			</div>
			<div class="card-footer"">
				<button type="button" id="btn-reply-save" class="btn btn-primary">Comment</button>
			</div>
		</form>
	</div>

	<!-- Comments list,    댓글 리스트 -->
	<br />
	<div class="card">
		<div class="card-header">Comments</div>
		<ul id="reply-box" class="list-group">
			<c:forEach var="reply" items="${board.replies}">
				<li id="reply-${reply.id}" class="list-group-item d-flex justify-content-between">
					<div>${reply.content }</div>
					<div class="d-flex">
						<div class="font-italic">Author: ${reply.user.username } &nbsp;&nbsp;</div>
						<button onClick="index.replyDelete(${board.id}, ${reply.id})" class="badge">Delete</button>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>




<script src="../js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>



