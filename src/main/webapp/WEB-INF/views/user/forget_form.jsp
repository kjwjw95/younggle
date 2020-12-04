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
<!--     <link rel="stylesheet" type="text/css" href="../css/main.css"> -->
<!--     <link rel="stylesheet" type="text/css" href="../css/navbar.css"> -->
		
		<style>
	        :root {
	            --input-padding-x: 1.5rem;
	            --input-padding-y: 0.75rem;
	        }
	
	        .login,
	        .image {
	            min-height: 30vh;
	        }
	
	        .login-heading {
	            font-weight: 200;
	        }
	
	        .btn-login {
	            font-size: 0.9rem;
	            letter-spacing: 0.05rem;
	            padding: 0.75rem 1rem;
	            border-radius: 2rem;
	        }
	
	        .form-label-group {
	            position: relative;
	            margin-bottom: 1rem;
	        }
	
	        .form-label-group>input,
	        .form-label-group>label {
	            padding: var(--input-padding-y) var(--input-padding-x);
	            height: auto;
	            border-radius: 2rem;
	        }
	
	        .form-label-group>label {
	            position: absolute;
	            top: 0;
	            left: 0;
	            display: block;
	            width: 100%;
	            margin-bottom: 0;
	            /* Override default `<label>` margin */
	            line-height: 1.5;
	            color: #495057;
	            cursor: text;
	            /* Match the input under the label */
	            border: 1px solid transparent;
	            border-radius: .25rem;
	            transition: all .1s ease-in-out;
	        }
	
	        .form-label-group input::-webkit-input-placeholder {
	            color: transparent;
	        }
	
	        .form-label-group input:-ms-input-placeholder {
	            color: transparent;
	        }
	
	        .form-label-group input::-ms-input-placeholder {
	            color: transparent;
	        }
	
	        .form-label-group input::-moz-placeholder {
	            color: transparent;
	        }
	
	        .form-label-group input::placeholder {
	            color: transparent;
	        }
	
	        .form-label-group input:not(:placeholder-shown) {
	            padding-top: calc(var(--input-padding-y) + var(--input-padding-y) * (2 / 3));
	            padding-bottom: calc(var(--input-padding-y) / 3);
	        }
	
	        .form-label-group input:not(:placeholder-shown)~label {
	            padding-top: calc(var(--input-padding-y) / 3);
	            padding-bottom: calc(var(--input-padding-y) / 3);
	            font-size: 12px;
	            color: #777;
	        }
	    </style>
	    
		<script type="text/javascript">
		function next() {
			if(document.getElementById("inputEmail").value == "") {
				alert("이메일 입력!!!");
				return;
			} else if(document.getElementById("inputName").value == "") {
				alert("이름 입력!!!");
				return;
			} else if(document.getElementById("inputTel").value == "") {
				alert("전화번호 입력!!!");
				return;
			} else {
				document.getElementById("forgetForm").action = "${root}/mem/forget";
				document.getElementById("forgetForm").submit();
			}
		}
		
		</script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous"></script>
	</head>
	
	<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="${root}/main.do">Happy House</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
				<c:if test="${member eq null }">
	                <li class="nav-item loggedIn">
	                    <span class="nav-link" data-target="#login-modal" data-toggle="modal">Login</span>
	                </li>
	                <li class="nav-item loggedIn">
	                    <a id="signupPage" class="nav-link" href="${root}/main.do?action=SIGNUP_FORM">Join</a>
	                </li>
	                <li class="nav-item loggedIn">
	                    <a id="signupPage" class="nav-link" href="${root}/main.do?action=MAP">Map</a>
	                </li>
				</c:if>
				<c:if test="${member ne null }">
	                <li class="nav-item">
	                    <a class="nav-link loggedOut" id="logout" href="${root}/main.do?action=LOGOUT">Logout</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link loggedOut" href="${root}/main.do?action=USER-INFO">UserInfo</a>
	                </li>
	                <li class="nav-item loggedIn">
	                    <a id="signupPage" class="nav-link" href="${root}/main.do?action=MAP">Map</a>
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
	
	    <div id="tab" class="container-fluid">
	        <div class="login d-flex align-items-center py-5">
	            <div class="container">
	                <div class="row">
	                    <div class="col-md-9 col-lg-8 mx-auto">
	                        <h2 class="login-heading mb-4">비밀번호 찾기</h2>
	                        <form method="post" id="forgetForm">
	                            <div class="form-label-group">
	                                <input type="email" id="inputEmail" name="inputEmail" class="form-control"  placeholder="Email" required autofocus>
	                                <label for="inputEmail">Your Email</label>
	                            </div>
	                            <div class="form-label-group">
	                                <input type="text" id="inputName" name="inputName" class="form-control userInfo" placeholder="Name" required>
	                                <label for="inputName">Your Name</label>
	                            </div>
	                            <div class="form-label-group">
	                                <input type="tel" id="inputTel" name="inputTel" class="form-control" placeholder="Tel" required>
	                                <label for="inputTel">Your Phone Number</label>
	                            </div>
	                            <button id="confirm"
	                                class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2"
	                                onclick="javascript:next()" type="button">Next</button>
	                        </form>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
		
		<%@ include file="./login.jsp" %>
		<script>
			$("#member").click(function() {
				$("#tab").load("main.do?action=MEMBER");
			});
		</script>
	</body>
</html>