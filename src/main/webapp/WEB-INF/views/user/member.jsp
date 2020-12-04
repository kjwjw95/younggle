<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">

<head>
    <title>Happy House</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
		integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
		crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
		integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
		crossorigin="anonymous"></script>
</head>
<body>
    
	<header class="masthead">
	    <div class="container h-100">
	        <div class="row h-100 align-items-center mt=5">
	            <div class="col-12 text-center">
	                <h1 class="font-weight-light">User Search!</h1>
	                <form class="container" style="margin: 10px auto;">
	                    <div class="row">
	                        <div class="input-group col-2 mt-2 ml-5">
	                        </div>
	                        <div class="form-label-group col-7 pr-0">
	                            <input id="keyword" type="search" class="form-control" placeholder="search" required
	                                autofocus>
	                        </div>
	                        <div class="col-2 pl-0">
	                            <button id="search" class="btn btn-primary btn-login text-uppercase font-weight-bold"
	                                type="button">검색</button>
	                        </div>
	                    </div>
	            	</form>
	            </div>
	        </div>
	    </div>
	</header>
	
    <div id="list" class="table-wrapper">
		<table class="table table-striped table-hover">
			<thead>
		        <tr>
		            <th>Email</th>
		            <th>Name</th>
		            <th>Tel</th>
		        </tr>
	        </thead>
			<c:forEach var="member" items="${list}" varStatus="status">
				<tr data-status="active">
					<td>${member.email}</td>
					<td>${member.name}</td>
					<td>${member.tel}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<script>
		$(document).ready(function() {
			$("#search").click(function() {
				var input = $("#keyword").val();
				$("#list").load("${root}/mem/user_search" + "?input=" + input);
			});
		});
	</script>
	<%@ include file="./login.jsp" %>
</body>
</html>