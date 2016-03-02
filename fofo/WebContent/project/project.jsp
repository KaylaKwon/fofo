<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<link href="/resources/dist/css/project/project.css" rel="stylesheet"
	type="text/css" />

<%@ include file="../include/header.jsp"%>
<script src="/resources/dist/js/project/project.js"></script>

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
				<li role="presentation" class="active">
					<a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a>
				</li>
				<li id="liProjectTabAdd">
					<a href="#newTab" id="btnProjectTabAdd" role="tab">+</a>
				</li>
			</ul>

			<!-- Tab panes -->
			<div class="projectTab-content tab-content">
				<div role="tabpanel" class="tab-pane active" id="home">...</div>
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