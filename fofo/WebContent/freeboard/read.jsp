<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>

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
				<input type="text" name='postTitle' class="form-control" value="${freepost.userId}" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Content</label>
				<textarea class="form-control" name="postContent" rows="3" readonly="readonly">${freepost.fPostContent}</textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Tags</label>
				<input type="text" name='postTitle' class="form-control" value="${freepost.fTags}" readonly="readonly">
			</div>
		</div>
		
		<div class="box-footer">
			<a href = "/modifyviewfreeboard.do?fPostId=${freepost.fPostId}"><button type="submit" class="btn btn-warning">Modify</button></a>
			<button id="removePost" type="submit" class="btn btn-danger">REMOVE</button>
			<a href = "/freeboard.do"><button type="submit" class="btn btn-primary">LIST ALL</button></a>
		</div>
		
		</div>
	</div>
	</section>
</div>
<%@ include file="../include/footer.jsp" %>