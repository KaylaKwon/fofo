<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>


<%@ include file="../include/header.jsp"%>


<div class="container">
  <div class="well">
    
    <a href="#" id="btnProjectTabAdd"><i class="icon-plus-sign-alt"></i> Add Tab</a>
    <br><br>
    <ul class="nav nav-tabs" id="projectTabs">
        <li class="active"><a href="#tab1">Tab 1</a></li>
    </ul>
    
    <div class="projectTab-content">
        <div class="tab-pane active" id="tab1">Hello tab #1 content...</div>
    </div>
  </div>
</div>



<%@ include file="../include/footer.jsp"%>

<script>

</script>