<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>

<%@ include file="../include/header.jsp"%>

<div class="content-wrapper">
<form action="freeboard.do" method="post">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Free Board
        <small>View</small>
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
	    	<h3 class="box-title">Free Board</h3>
	    </div>
		<div class="box-body pad table-responsive">
			<table>
		    	<tr>
			    	<th><a href = "/freeboard/write.jsp"><button class="btn bg-purple margin">Write</button></a></th>
			    	<th style="width: 820px"></th>
				    <th><div class="btn-group">
				    	<button type="button" class="btn bg-purple">recent</button>
				    	<button type="button" class="btn bg-purple">like</button>
				    	<button type="button" class="btn bg-purple">view</button>
			    	</div></th>
		    	</tr>
    		</table>
			<table class="table table-bordered text-center">
				<tr>
					<th style="width: 15px">PostNum</th>
					<th style="width: 600px">TITLE</th>
					<th>WRITER</th>
					<th>REGDATE</th>
					<th style="width: 40px">VIEWCNT</th>
				</tr>
				
				<c:forEach items="${list}" var="freepost">
					<tr>
						<td>${freepost.fPostId}</td>
						<td><a href='/freeboard.do?postId=${freepost.fPostId}'>${freepost.fPostTitle}</a></td>
						<td>${freepost.userId}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${freepost.fPostDate}"/></td>
						<td><span class="badge bg-red">${freepost.fHitNum }</span></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</section>
	</form>
</div>


<%@ include file="../include/footer.jsp"%>

<script>
	var result = '${msg}';
	if(result == 'SUCCESS'){
		alert("처리 완료");
	}
</script>