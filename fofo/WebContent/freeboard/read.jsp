<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/header.jsp"%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Free Board
        <small>Read</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="/home.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="/freeboard/listall.jsp">Community</a></li>
        <li class="active">Free Board</li>
      </ol>
      <br>
    </section>
    <section class="content">
    <div class = "box box-primary">
	    <div class="box-header">
	    	<h3 class="box-title">Free Board read</h3>
	    </div>
		<div class="box-body pad table-responsive">
			<form role="form" method="post">
				<input type="hidden" name="fPostId" value="${freepost.fPostId}">
			</form>
			
			<div class="box-body">
				<div class="form-group">
					<label for="exampleInputEmail1">Title</label>
					<input type="text" name='postTitle' class="form-control" value="${freepost.fPostTitle}" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Writer</label>
					<input type="text" name='userId' class="form-control" value="${freepost.userId}" readonly="readonly">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Content</label>
					<textarea class="form-control" name="fPostContent" rows="3" readonly="readonly">${freepost.fPostContent}</textarea>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Tags</label>
					<input type="text" name='fTags' class="form-control" value="${freepost.fTags}" readonly="readonly">
				</div>
			</div>
			
			<div class="box-footer">
				<button id="ModifyPost" type="submit" class="btn btn-warning">Modify</button>
				<button id="RemovePost" type="submit" class="btn btn-danger">REMOVE</button>
				<button id="listAll" type="submit" class="btn btn-primary">LIST ALL</button>
			</div>
		</div>
	</div>
	<div class = "box box-success">
	<form action="addfreecomment.do" method="post">
		<input class="hidden" name="fPostId" value="${freepost.fPostId}">
	    <div class="box-header">
	    	<h3 class="box-title">Add new comment</h3>
	    </div>
		<div class="box-body">
			<label for="exampleInputEmail1">Writer</label>
			<input class="form-control" type="text" placeholder="USER ID" name="userId">
			<label for="exampleInputEmail1">Comment Text</label>
			<Input class="form-control" type="text" placeholder="COMMENT TEXT" name="fCommentContent">
		</div>
		<div class="body-footer">
			<button id="addcomment" type="submit" class="btn btn-primary">ADD COMMENT</button>
		</div>
	</form>
	</div>
	<ul class="timeline">
		<li class="time-label" id="commentDiv"><span class="bg-green">Comment List</span></li>
		
		
		<c:forEach items="${clist}" var="freecomment">
			<li class="replyLi">
			<i class="fa fa-comments bg-blue"></i>
				<div class="timeline-item">
				<c:choose>
					<c:when test="${freecomment.fCommentId == fCommentId}">
						<% System.out.println("modify_comment_movement success"); %>
						<form role="comt" action="post">
							<input type="hidden" name="fPostId" value="${freepost.fPostId}">
							<input type="hidden" name="fCommentId" value="${freepost.fCommentId}">
							<span class="time">
								<i class="fa fa-clock-o"></i>${freecomment.fcommentDate}
							</span>
							<h3 class="timeline-header"><strong>${freecomment.fCommentId}</strong>- ${freecomment.userId}</h3>
							<div class="timeline-body">
							<input class="form-control" type="text" id="fCommentContent" name="fCommentContent" value="${freecomment.fCommentContent}"></div>
							<div class="timeline-footer">
								<a id="savebtn" class="btn btn-primary btn-xs">Save</a>
								<a id="cancelbtn" class="btn btn-danger btn-xs">Cancel</a>
							</div>
						</form>
					</c:when>
					<c:otherwise>
						<% //System.out.println("modify_comment_movement fail"); %>
						<span class="time">
						<i class="fa fa-clock-o"></i>${freecomment.fcommentDate}
						</span>
						<h3 class="timeline-header"><strong>${freecomment.fCommentId}</strong>- ${freecomment.userId}</h3>
						<div class="timeline-body">${fmComtId}${freecomment.fCommentContent}</div>
						<div class="timeline-footer">
							<a class="btn btn-primary btn-xs" href="/modifyviewfreecomment.do?fPostId=${freepost.fPostId}&fCommentId=${freecomment.fCommentId}">Modify</a>
							<a class="btn btn-danger btn-xs" href="/removefreecomment.do?fCommentId=${freecomment.fCommentId}&fPostId=${freepost.fPostId}">Delete</a>
						</div>
					</c:otherwise>
				</c:choose>
				</div>
			</li>
		</c:forEach>
	</ul>
	</section>
</div>
<%@ include file="../include/footer.jsp" %>


<script>
$(document).ready(function(){
	var formObj = $("form[role = 'form']");
	console.log(formObj);
	
	$("#ModifyPost").on("click", function(){
		formObj.attr("action", "/modifyviewfreeboard.do");
		formObj.attr("method", "post");
		formObj.submit();
	});
	
	$("#RemovePost").on("click", function(){
		formObj.attr("action", "/removefreeboard.do");
		formObj.attr("method", "post");
		formObj.submit();
	});
	$("#ListAll").on("click", function(){
		self.location = "/freeboard.do";
	});
	
	var formObj2 = $("form[role = 'comt']");
	console.log(formObj2);
	
	$("savebtn").on("click", function(){
		formObj2.attr("action", "/modifyfreecomment.do");
		formObj2.attr("method", "post");
		formObj2.submit();
	});
	
	$("cancelbtn").on("click", function(){
		formObj2.attr("action", "/getfreeboard.do");
		formObj2.attr("method", "post");
		formObj2.submit();
	});
});

</script>
