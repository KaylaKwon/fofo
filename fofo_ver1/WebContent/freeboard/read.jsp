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
			<form role="gpost" method="post">
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
				<a href="/freeboard.do"><button id="listAll" class="btn btn-primary">LIST ALL</button></a>
			</div>
		</div>
	</div>
	<div class = "box box-success" >
		<form role="addcomt">
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
				<form class="timeline-item" role="comt" method="post">
					<input type="hidden" name="fPostId" value="${freepost.fPostId}">
					<c:choose>
						<c:when test="${freecomment.fCommentId == fmodifyCId}">
							<% System.out.println("modify_comment_movement success"); %>
								<span class="time">
									<i class="fa fa-clock-o"></i>${freecomment.fcommentDate}
								</span>
								<h3 class="timeline-header"><strong>${freecomment.fCommentId}</strong>- ${freecomment.userId}</h3>
								<div class="timeline-body">
								<input class="form-control" type="text" id="fCommentContent" name="fCommentContent" value="${freecomment.fCommentContent}"></div>
								<input type="hidden" name="fCommentId" value="${freecomment.fCommentId}">
								<input type="hidden" name="fmodifyCId" value="">
								<div class="timeline-footer">
									<button id="saveCbtn" type="submit" class="btn btn-primary btn-xs">Save</button>
									<button id="cancelCbtn" type="submit" class="btn btn-danger btn-xs">Cancel</button>
								</div>
						</c:when>
						<c:otherwise>
							<% //System.out.println("modify_comment_movement fail"); %>
							<span class="time">
							<i class="fa fa-clock-o"></i>${freecomment.fcommentDate}
							</span>
							<h3 class="timeline-header"><strong>${freecomment.fCommentId}</strong>- ${freecomment.userId}</h3>
							<div class="timeline-body">${freecomment.fCommentContent}</div>
							<input type="hidden" name="fCommentId" value="${freecomment.fCommentId}">
							<input type="hidden" name="fmodifyCId" value="${freecomment.fCommentId}">
							<div class="timeline-footer">
								<button id="modifyCbtn" type="submit" class="btn btn-primary btn-xs">Modify</button>
								<button id="removeCbtn" type="submit" class="btn btn-danger btn-xs">Delete</button>
							</div>
						</c:otherwise>
					</c:choose>
				</form>
			</li>
		</c:forEach>
	</ul>
	</section>
</div>
<%@ include file="../include/footer.jsp" %>


<script>
$(document).ready(function(){
	var formObj = $("form[role = 'gpost']");
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
	
	var formObj3 = $("form[role = 'addcomt']");
	console.log(formObj3);
	
	$("#addcomment").on("click", function(){
		formObj3.attr("action", "/addfreecomment.do");
		formObj3.attr("method", "post");
		formObj3.submit();
	});
	
	var formObj2 = $("form[role = 'comt']");
	console.log(formObj2);
	
	$("#saveCbtn").on("click", function(){
		formObj2.attr("action", "/modifyfreecomment.do");
		formObj2.attr("method", "post");
		formObj2.submit();
	});
	
	$("#cancelCbtn").on("click", function(){
		formObj2.attr("action", "/getfreeboard.do");
		formObj2.attr("method", "post");
		formObj2.submit();
	});
	
	$("#modifyCbtn").on("click", function(){
		formObj2.attr("action", "/modifyviewfreecomment.do");
		formObj2.attr("method", "post");
		formObj2.submit();
	});
	
	$("#removeCbtn").on("click", function(){
		formObj2.attr("action", "/removefreecomment.do");
		formObj2.attr("method", "post");
		formObj2.submit();
	});
});

</script>
