<%-- <%@page import="com.ssafy.happyhouse.model.Member"%> --%>
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
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/navbar.css">
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
		integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg=="
		crossorigin="anonymous"></script>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="${root}/">Happy House</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
				<c:if test="${member eq null }">
	                <li class="nav-item loggedIn">
	                    <span class="nav-link" data-target="#login-modal" data-toggle="modal">Login</span>
	                </li>
	                <li class="nav-item loggedIn">
	                    <a id="signupPage" class="nav-link" href="${root}/mem/signup_form">Join</a>
	                </li>
	                <li class="nav-item loggedIn">
	                    <a id="signupPage" class="nav-link" href="${root}/map/">Map</a>
	                </li>
				</c:if>
				<c:if test="${member ne null }">
	                <li class="nav-item">
	                    <a class="nav-link loggedOut" id="logout" href="${root}/mem/logout">Logout</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link loggedOut" href="${root}/mem/user_info">UserInfo</a>
	                </li>
	                <li class="nav-item loggedIn">
	                    <a id="signupPage" class="nav-link" href="${root}/map/">Map</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link loggedOut" href="${root}/main.do?action=searchInter&id=${member.email }">Choice</a>
	                </li>
					<c:if test="${member.permission ne '0' }">
		                <li class="nav-item loggedIn">
		                    <a id="member" class="nav-link">member</a>
		                </li>
					</c:if>
                </c:if>
            </ul>
        </div>
    </nav>
    
	<header class="masthead">
	    <div class="container h-100">
	        <div class="row h-100 align-items-center mt=5">
	            <div class="col-12 text-center">
	                <h1 class="font-weight-light">관심 목록!</h1>
	            </div>
	        </div>
	    </div>
	</header>
	
    <div id="list" class="table-wrapper">
		<table class="table table-striped table-hover">
			<colgroup>
				<col width="25%"/>
				<col width="25%"/>
				<col width="35%"/>
				<col width="15%"/>
			</colgroup>
			<thead>
		        <tr>
		            <th>Email</th>
		            <th>Home_number</th>
		            <th>Date</th>
		            <th>Date</th>
		        </tr>
	        </thead>
			<c:forEach var="home" items="${list}" varStatus="status">
				<tr data-status="active">
					<td>${home.email}</td>
					<td>${home.no}</td>
					<td>${home.date}</td>
					<td><a href="${root}/main.do?action=HOUSE-DETAIL&no=${home.no}&id=${home.email}" class="btn btn-sm manage">보기</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</body>
</html>