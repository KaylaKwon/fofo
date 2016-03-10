<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="../resources/css/project.css" rel="stylesheet" type="text/css" />
	
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">


<%@ include file="../include/header.jsp"%>
<!-- <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>  -->

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.js"></script>
<script src="../resources/js/project.js"></script>
<script src="../resources/summernote-master/lang/summernote-ko-KR.js"></script>

<div class="content-wrapper">

	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>프로젝트 편집</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Formss</a></li>
			<li class="active">General Elements</li>
		</ol>
	</section>


	<!-- Main Content -->
	<div class="projectContent">
		<div role="tabpanel">

			<!-- Nav tabs -->
			<ul id="projectTab" class="nav nav-tabs" role="tablist">
				<li role="presentation" ><a href="#tab1" role="tab" aria-controls="tab1" data-toggle="tab">기본</a></li>
				<li id="liProjectTabAdd"><a href="#newTab"
					id="btnProjectTabAdd" role="tab">+</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="projectTab-content tab-content" onload="loader()">

				<div role="tabpanel" class="tab-pane active in" id="tab1">
					<div id="projectContent">
					
						<ul id="blockList" class="list-unstyled draggableList blockUnsortable">
							<li class="panel panel-info">
							
								<!-- <div class="block">
									<div class="blockMover"><span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span></div>
									<div class="blockContent"><p>hihi</p></div>
									<input class="btn btn-warning editBlockBtn" type="button" value="수정">
									<input class="btn btn-success endEditBlockBtn" type="button" value="완료" style="display: none;">
									<input class="btn btn-danger delBlockBtn" type="button" value="삭제">
								</div> -->
								
							</li>
						</ul>
						
						<div id="addBlock" class="table-hover">
							블록 추가 <span id="addBlockGlyp" class="glyphicon glyphicon-plus" aria-hidden="true"></span>
						</div>
					</div>




				</div>

			</div>
		</div>
	</div>


</div>


<!-- floating menu -->
<div id="floatMenu">
	
	<input id="editBlockOrder" class="btn btn-default" type="button" value="순서 편집">
	<input id="endEditBlockOrder" class="btn btn-primary" type="button" value="순서 편집 완료" style="display: none;">
	
	<!-- <ul>
		<li><a href="#">menu1</a></li>
		<li><a href="#">menu2</a></li>
		<li><a href="#">menu3</a></li>
		<li><a href="#">menu4</a></li>
		<li><a href="#">menu5</a></li>
	</ul> -->
</div>
<!-- //floatMenu -->
<%@ include file="../include/footer.jsp"%>

<script>
	
</script>