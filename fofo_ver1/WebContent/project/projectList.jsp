<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.ArrayList"%>

<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
			<th bgcolor="orange" width="100">프로젝트 이름</th>
			<th bgcolor="orange" width="200">최종 수정일</th>
		</tr>
		<c:forEach var="project" items="${ projectList }">
			<tr>					
				<td>${ project.projectName }</td>
				<td>${ project.lastUpdate }</td>
			</tr>
		</c:forEach>
</table>

<script src="../resources/js/project.js"></script>