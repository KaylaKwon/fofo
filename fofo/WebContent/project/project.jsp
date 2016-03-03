<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<link href="../resources/css/project.css" rel="stylesheet" type="text/css" />
	
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">


<%@ include file="../include/header.jsp"%>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.js"></script>
<script src="../resources/js/project.js"></script>

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
						<ul id="draggablePanelList" class="list-unstyled">
							<li class="panel panel-info">
								<div class="panel-heading">You can drag this panel.</div>
								<div class="panel-body">Content ...</div>
							</li>
							<li class="panel panel-info">
								<div class="panel-heading">You can drag this panel too.</div>
								<div class="panel-body">Content ...</div>
							</li>
						</ul>



						<div class="block">
							<div id="summernote"></div>
							
							<input class="btn btn-warning" type="button" value="수정">
							<input class="btn btn-danger" type="button" value="삭제">
						</div>
						
						
						<div id="addBlock" class="table-hover">
							<span id="addBlockGlyp" class="glyphicon glyphicon-plus" aria-hidden="true"></span>
						</div>
					</div>




				</div>

			</div>
		</div>
	</div>


</div>


<!-- floating menu -->
<div id="floatMenu">
	<ul>
		<li><a href="#">menu1</a></li>
		<li><a href="#">menu2</a></li>
		<li><a href="#">menu3</a></li>
		<li><a href="#">menu4</a></li>
		<li><a href="#">menu5</a></li>
	</ul>
</div>
<!-- //floatMenu -->
<%@ include file="../include/footer.jsp"%>

<script>
	
</script>