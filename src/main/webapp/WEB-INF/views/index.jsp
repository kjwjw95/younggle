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
    <c:import url="./nav.jsp"></c:import>
   
   	<div id="tab">
	    <header class="masthead">
	        <div class="container h-100">
	            <div class="row h-100 align-items-center mt=5">
	                <div class="col-12 text-center">
	                    <h1 class="font-weight-light">Welcome to Happy House!</h1>

						<form method="get" action="${root}/house"
							id="searchForm">
							<!--  <input type="hidden" name="action" id="hidden" value="SEARCH">-->
							<div class="row">
								<div class="input-group col-2 mt-2 ml-5">
									<select id="type" name="type" class="custom-select"
										id="inputGroupSelect01">
										<option selected value="all">All</option>
										<option value="dong">동</option>
										<option value="name">아파트 이름</option>
									</select>
								</div>
								<div class="form-label-group col-7 pr-0">
									<input id="keyword" name="keyword" type="search"
										class="form-control" placeholder="search" required autofocus>
								</div>
								<div class="col-2 pl-0">
									<button id="search"
										class="btn btn-primary btn-login text-uppercase font-weight-bold"
										type="button">검색</button>
								</div>
							</div>
						</form>
	                </div>
	            </div>
	        </div>
	    </header>
	
	    <div class="container-xl">
			<div class="text-center">
				<input type="checkbox" name="status" value="house1" checked="checked">
				주택 전월세 <input type="checkbox" name="status" value="house2"
					checked="checked"> 주택 매매 <input type="checkbox"
					name="status" value="apartment1" checked="checked"> 아파트 전월세
				<input type="checkbox" name="status" value="apartment2"
					checked="checked"> 아파트 매매
	
				<!-- <button id="sortDong" class="btn btn-grren btn-login ml-5"
					type="button">정렬(동)</button> -->
	
				<form method="get" action="${root}/map"
                  id="sortForm">
                	<input type="hidden"  name="keyword"  id="pre-keyword" value="${keyword}"> 
                	<input type="hidden" name="type"  id="pre-type" value="${type}">  
                	<input type="hidden" name="sortType" id="sortType" value="${sortType}">
	                <button id="sortPrice" class="btn btn-primary btn-login" type="button">거래금액 정렬
	                </button>
            	</form>
			</div>
			<div id="tab" class="table-responsive">
				<div class="table-wrapper">
	
					<c:if test="${msg  ne null}">
						<div>${msg}</div>
					</c:if>
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>NO</th>
								<th>동</th>
								<th>아파트 이름</th>
								<th>거래금액</th>
								<th>건축년도</th>
								<th></th>
							</tr>
						</thead>
						<tbody id = "searchResult">
							<c:if test="${houseDeals ne null}">
								<c:forEach var="houseDeal" items="${houseDeals}">
									<tr class="house" data-status="active">
										<td id="no">${houseDeal.no}</td>
										<td id="dong">${houseDeal.dong}</td>
										<td id="aptName">${houseDeal.aptName}</td>
										<td id="dealAmount">${houseDeal.dealAmount}</td>
										<td id="buildYear"><span class="label label-success">${houseDeal.buildYear}</span></td>
										<td id="house-${no}"><a href="${root}/main.do?action=HOUSE-DETAIL&no=${houseDeal.no}&id=${member.email}" class="btn btn-sm manage">보기</a></td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>

	        <c:if test="${navigation ne null}">
	            <table>
	                <tr>
	                    <td>${navigation.navigator}</td>
	                </tr>
	            </table>
	        </c:if>
	
			<form name="pageform" id="pageform" method="GET" action="${param.action}">
				<input type="hidden" name="action" id="action" value="${param.action}">
				<input type="hidden" name="pg" id="pg" value="">
				<input type="hidden" name="type" id="type" value="${param.type}">
				<input type="hidden" name="keyword" id="keyword" value="${param.keyword}">
				<input type="hidden" name="sortType" value="${param.sortType}">
			</form>

		</div>
    </div>

	<%@ include file="./user/login.jsp" %>
	
	
	<script>
    function pageMove(pg) {
        $("#pg").val(pg);
        
      var ac = document.getElementById("action").val;
        document.getElementById("pageform").action="main.do?action=" + ac;
		document.getElementById("pageform").submit();
   
    }
    
	$(document).ready(function() {
		$("#member").click(function() {
			$("#tab").load("${root}/mem/member");
		});

		$("#search").click(function() {
			const type = $("#type").val();
			if (type === 'all') {
				$('#searchForm').attr("action", "${root}/house/searchall");
			} else if (type == 'dong') {
				//$("#hidden").val("SEARCH-DONG");
				$('#searchForm').attr("action", "${root}/house/searchdong");
			} else if (type === 'name') {
				//$("#hidden").val("SEARCH-APARTMENT");
				$('#searchForm').attr("action", "${root}/house/searchapart");
			}
			$('#searchForm').submit();
		});
		$("#sortPrice").click(function() {
			const type = $("#pre-type").val();
			if (type === 'all') {
			//	$("#pre-hidden").val("searchallsort");
				$('#sortForm').attr("action", "${root}/house/searchallsort");
			} else if (type == 'dong') {
				$("#pre-hidden").val("SEARCH-DONG-SORT");
				$('#sortForm').attr("action", "${root}/house/searchdongsort");
			} else if (type === 'name') {
				$("#pre-hidden").val("SEARCH-APARTMENT-SORT");
				$('#sortForm').attr("action", "${root}/house/searchapartsort");
			}
			$('#sortForm').submit();
		});
	});
	</script>
</body>

</html>