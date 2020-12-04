<%-- <%@page import="com.ssafy.happyhouse.model.Member"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Happy House</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/main.js"></script>

<style>
.container-xl {
	display: flex;
}

#infomation {
	display: flex;
}

.form-horizontal {
	display: flex;
	flex-direction: column;
}

.form-group {
	display: flex;
	height: 55px;
}
</style>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="${root}/">Happy House</a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<c:if test="${member eq null }">
					<li class="nav-item loggedIn"><span class="nav-link"
						data-target="#login-modal" data-toggle="modal">Login</span></li>
					<li class="nav-item loggedIn"><a id="signupPage"
						class="nav-link" href="${root}/mem/signup_form">Join</a></li>
					<li class="nav-item loggedIn"><a id="signupPage"
						class="nav-link" href="${root}/map/">Map</a></li>
				</c:if>
				<c:if test="${member ne null }">
					<li class="nav-item"><a class="nav-link loggedOut" id="logout"
						href="${root}/mem/logout">Logout</a></li>
					<li class="nav-item"><a class="nav-link loggedOut"
						href="${root}/mem/user_info">UserInfo</a></li>
					<li class="nav-item loggedIn"><a id="signupPage"
						class="nav-link" href="${root}/map/">Map</a></li>
					<li class="nav-item"><a class="nav-link loggedOut"
						href="${root}/main.do?action=searchInter&id=${member.email }">Choice</a>
					</li>
					<c:if test="${member.permission ne '0' }">
						<li class="nav-item loggedIn"><a id="member" class="nav-link">member</a>
						</li>
					</c:if>
				</c:if>
			</ul>
		</div>
	</nav>

	<div id="tab">
		<header class="masthead">
			<div class="container h-100">
				<div class="row h-100 align-items-center mt=5">
					<div class="col-12 text-center">
						<h1 class="font-weight-light">아파트 상세 정보</h1>
					</div>
				</div>
			</div>
		</header>

		<div style="text-align: center;" class="container-xl">
			<div>
				<div id="map" style="width: 500px; height: 400px"></div>
				<script type="text/javascript"
					src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d0220b58aee98e37c0ff8d6bbdd2eec4"></script>
				<script>
					var container = document.getElementById("map");
					var options = {
						center : new kakao.maps.LatLng(33.450701, 126.570667),
						level : 3,
					};

					var m = new kakao.maps.Map(container, options);
				</script>
			</div>

			<div id="infomation">
				<form class="form-horizontal" action="#">
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<button class="btn btn-default">번호</button>
						</div>
						<div class="col-sm-10">
							<input class="form-control" value=${no }>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<button class="btn btn-default">주택명</button>
						</div>
						<div class="col-sm-10">
							<input class="form-control" value=${AptName }>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<button class="btn btn-default">실거래금액</button>
						</div>
						<div class="col-sm-10">
							<input class="form-control" value=${dealAmount }>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<button class="btn btn-default">건축년도</button>
						</div>
						<div class="col-sm-10">
							<input class="form-control" value=${buildYear }>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<button class="btn btn-default">법정동</button>
						</div>
						<div class="col-sm-10">
							<input class="form-control" value=${dong }>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-6">
							<button class="btn btn-default">지번</button>
						</div>
						<div class="col-sm-10">
							<input class="form-control" value=${code }>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div id="inter" style="text-align: center;">

		<c:if test="${check eq false }">
			<button id="allowEdit"
				class="btn btn-primary btn-login text-uppercase font-weight-bold mb-2 col-2 mr-1"
				onClick="location.href='${root}/main.do?action=addInter&no=${no }&id=${member.email }'"
				type="button">관심추가</button>
		</c:if>
		<c:if test="${check eq true }">
			<button id="remove"
				class="btn btn-primary btn-login text-uppercase font-weight-bold mb-2 col-2 ml-1"
				onClick="location.href='${root}/main.do?action=removeInter&no=${no }&id=${member.email }'"
				type="button">관심삭제</button>
		</c:if>
	</div>
	<%@ include file="../user/login.jsp"%>
	<script>
		$("#member").click(function() {
			$("#tab").load("${root}/mem/member");
			$("#inter").empty();
		});
	</script>
</body>
</html>
