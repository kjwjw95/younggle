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
    
    	<!-- Main Content -->
   	<div id="tab">
		<div class="card col-sm-12 mt-1" style="min-height: 850px;">
			<div class="card-body">
			<script>
			let colorArr = ['table-primary','table-success','table-danger'];
			$(document).ready(function(){
				$.get("${root}/map/map"
					,{act:"sido"}
					,function(data, status){
						$.each(data, function(index, vo) {
							$("#sido").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
						});
					}
					, "json"
				);
			});
			$(document).ready(function(){
				$("#member").click(function() {
					$("#tab").load("${root}/mem/member");
				});
				$("#sido").change(function() {
					$.get("${root}/map/map"
							,{act:"gugun", sido:$("#sido").val()}
							,function(data, status){
								$("#gugun").empty();
								$("#gugun").append('<option value="0">선택</option>');
								$.each(data, function(index, vo) {
									$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
								});//each
							}//function
							, "json"
					);//get
				});//change
				$("#gugun").change(function() {
					$.get("${root}/map/map"
							,{act:"dong", gugun:$("#gugun").val()}
							,function(data, status){
								$("#dong").empty();
								$("#dong").append('<option value="0">선택</option>');
								$.each(data, function(index, vo) {
									$("#dong").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
								});//each
							}//function
							, "json"
					);//get
				});//change
				$("#dong").change(function() {
					$.get("${root}/map/map"
							,{act:"apt", dong:$("#dong").val()}
							,function(data, status){
								console.log('data', data);
								$("#add").empty();
								$("#searchResult").empty();
								initMap()
								$.each(data.content, function(index, vo) {
									let str = "<tr class="+colorArr[index%3]+">"
									+ "<td>" + vo.no + "</td>"
									+ "<td>" + vo.dong + "</td>"
									+ "<td>" + vo.aptName + "</td>"
									+ "<td>" + vo.jibun + "</td>"
									+ "<td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
									$("#searchResult").append(str);
									$("#searchResult").append("<br>");
									var input = {
										no: vo.no,
										dong: vo.dong,
										aptName: vo.aptName,
										jibun: vo.jibun,
										code: vo.code,
										lat: vo.lat,
										lng: vo.lng
									};
									addMarker(input);
								});//each
								$("#pagenation-bar").empty();
								$("#pagenation-bar").append(data.navigation.navigator);
							}//function
							, "json"
					);//get
				});//change
			});//ready
			</script>
			시도 : <select id="sido">
				<option value="0">선택</option>
			</select>
			구군 : <select id="gugun">
				<option value="0">선택</option>
			</select>
			읍면동 : <select id="dong">
				<option value="0">선택</option>
			</select>
			<table style="width: 100%">
				<colgroup>
					<col width="70%"/>
					<col width="30%"/>
				</colgroup>
				<thead>
					<tr>
						<th>
							<div>
								<table class="table mt-2">
									<colgroup>
										<col width="15%"/>
										<col width="30%"/>
										<col width="35%"/>
										<col width="20%"/>
									</colgroup>
									<thead>
										<tr>
											<th>번호</th>
											<th>법정동</th>
											<th>아파트이름</th>
											<th>지번</th>
										</tr>
									</thead>
									<tbody id="searchResult">
									</tbody>
								</table>
							</div>
						</th>
						<th>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>
							<div id="map" style="height: 570px; margin: auto;"></div>
						</th>
						<th>
							<div id="add">
							</div>
						</th>
					</tr>
				</tbody>
			</table>
			<script src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
			<script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAFd9ynPa_kFMj1CEN4UK77Du1yw5L8yC0&callback=initMap"></script>
			<script>
				var multi = {lat: 37.5665734, lng: 126.978179};
				var map;
				function initMap() {
					map = new google.maps.Map(document.getElementById('map'), {
						center: multi, zoom: 12
					});
				}
				function addMarker(input) {
					var marker = new google.maps.Marker({
						position: new google.maps.LatLng(parseFloat(input.lat),parseFloat(input.lng)),
						label: input.no,
						title: input.no
					});
					map.setCenter(marker.getPosition());
					map.setZoom(15);
					
					marker.addListener('click', function() {
						bounceMarker(marker);
						map.setZoom(17);
						$("#add").empty();
						$("#add").append("<div class=\"form-label-group\"><input type=\"text\" style=\"width: 200px; margin:0px 30px 30px 20px\" class=\"form-control\" readonly value="+input['no']+"><label>번호</label></div>");
						$("#add").append("<div class=\"form-label-group\"><input type=\"text\" style=\"width: 200px; margin:0px 30px 30px 20px\" class=\"form-control\" readonly value="+input['dong']+"><label>법정동</label></div>");
						$("#add").append("<div class=\"form-label-group\"><input type=\"text\" style=\"width: 200px; margin:0px 30px 30px 20px\" class=\"form-control\" readonly value="+input['aptName']+"><label>아파트이름</label></div>");
						$("#add").append("<div class=\"form-label-group\"><input type=\"text\" style=\"width: 200px; margin:0px 30px 30px 20px\" class=\"form-control\" readonly value="+input['jibun']+"><label>지번</label></div>");
						$("#add").append("<div class=\"form-label-group\"><input type=\"text\" style=\"width: 200px; margin:0px 30px 30px 20px\" class=\"form-control\" readonly value="+input['code']+"><label>지역코드</label></div>");
						$("#add").append("<div class=\"form-label-group\"><input type=\"text\" style=\"width: 200px; margin:0px 30px 30px 20px\" class=\"form-control\" readonly value="+input['lat']+"><label>위도</label></div>");
						$("#add").append("<div class=\"form-label-group\"><input type=\"text\" style=\"width: 200px; margin:0px 30px 30px 20px\" class=\"form-control\" readonly value="+input['lng']+"><label>경도<label></div>");
					});
					marker.setMap(map);
				}
				function bounceMarker(marker) {
					if (marker.getAnimation() !== null) {
						marker.setAnimation(null);
					} else {
						marker.setAnimation(google.maps.Animation.BOUNCE);
					}
				}
			</script>
			</div>
			<table>
				<tr>
					<td id="pagenation-bar"></td>
				</tr>
			</table>
		</div>
	</div>
	<%@ include file="../user/login.jsp" %>
	<script>
	 function pageMove(pg) {
	        $("#pg").val(pg);
	       console.log('넘어는 가..?')
	        $.get("${root}/map/map"
					,{act:"apt", dong:$("#dong").val(), pg}
					,function(data, status){
						$("#add").empty();
						$("#searchResult").empty();
						initMap();
						$.each(data.content, function(index, vo) {
							let str = "<tr class="+colorArr[index%3]+">"
							+ "<td>" + vo.no + "</td>"
							+ "<td>" + vo.dong + "</td>"
							+ "<td>" + vo.aptName + "</td>"
							+ "<td>" + vo.jibun + "</td>"
							+ "<td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
							$("#searchResult").append(str);
							$("#searchResult").append("<br>");
							var input = {
								no: vo.no,
								dong: vo.dong,
								aptName: vo.aptName,
								jibun: vo.jibun,
								code: vo.code,
								lat: vo.lat,
								lng: vo.lng
							};
							addMarker(input);
						});//each
						
						$("#pagenation-bar").empty();
						$("#pagenation-bar").append(data.navigation.navigator);
					}//function
					, "json"
			);//get
	    }
	</script>
  </body>
</html>
