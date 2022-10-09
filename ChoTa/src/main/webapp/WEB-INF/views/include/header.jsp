<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.profile {
	width: 30px;
	height: 30px;
	border-radius: 50%;
	border: 1px solid #fff;
	margin-right: -8px;
}

.member {
	height: 30px !important;
	text-align: center !important;
	text-decoration: none !important;
	float: left;
	font-size: 13px !important;
	color: #333 !important;
	font-weight: 500 !important;
	z-index: 20 !important;
}

a.member {
	margin-top: 10px;
}

#mainNav .navbar-brand {
	margin-left:-48px !important;
	font-weight: 900;
	font-size: 24px;
	color: #333 !important;
}

#mainNav .navbar-brand:hover {
	color: #6199e6 !important;
}

#mainNav.navbar-shrink {
	box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
	background-color: #fff;
}

#mainNav.navbar-shrink .navbar-brand {
	color: #333;
}

#mainNav.navbar-shrink .navbar-brand:hover {
	color: #6199e6;
}

#mainNav.navbar-shrink .navbar-nav .nav-item .nav-link {
	color: #333;
}

#mainNav.navbar-shrink .navbar-nav .nav-item .nav-link:hover {
	color: #6199e6;
}
</style>
<link rel='stylesheet' type='text/css'
	href='css/common.css?<%=new java.util.Date()%>'>
<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<script src="js/scripts.js"></script>
<!-- MVC에서 넘어온 헤더파일 -->
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=CHROME">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ChoTa</title>
<script src="js/ie.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<body>
	<header>
		<div class="inner">
			<!-- Navigation-->
			<nav class="navbar navbar-expand-lg navbar-light fixed-top py-3"
				id="mainNav">
				<div class="container px-4 px-lg-5">
					<a class="navbar-brand" href="../bteam">CHOTA</a>
					<ul class="navbar-nav ms-auto my-2 my-lg-0" id="gnb">
						<li class="nav-item"><a href="list.it">CHOTA소개</a></li>
						<li class="nav-item"><a href="list.sp">학교</a></li>
						<li class="nav-item"><a href="list.sc">일정</a></li>
						<li class="nav-item">
						<li><a href="list.yu">소셜스타</a></li>
						<li class="nav-item"><a href="list.pl">체험활동/도서</a></li>
						<li class="nav-item"><a href="list.qna">고객센터</a></li>
					</ul>
					<ul class="util">
						<!-- 로그인하지 않은 경우 -->
						<c:if test='${empty loginInfo}'>
							<li><a class='member' href='login'>로그인</a></li>
							<li><a class='member' href='member'>회원가입</a></li>
						</c:if>
						<!-- 로그인한 경우 -->
						<c:if test='${not empty loginInfo}'>
							<li class='items-center'>
								<!-- 프로필이미지가 없는 경우 기본 이미지가 보이게 --> <c:if
									test='${empty loginInfo.profile}'>
									<img class="profile member" src="img/chota_logo100.png">
								</c:if> <c:if test='${!empty loginInfo.profile}'>
									<img class='profile member' src='${loginInfo.profile}'>
								</c:if> <a class="member">${loginInfo.name}님</a> <a class='member'
								href='password'>비밀번호변경</a> <a class='member' href='logout'>로그아웃</a>
							</li>
						</c:if>
					</ul>
					<button class="navbar-toggler navbar-toggler-right" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
						aria-controls="navbarResponsive" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarResponsive">

					</div>
				</div>
			</nav>

		</div>

	</header>