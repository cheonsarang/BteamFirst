<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=CHROME">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>실습용 테마</title>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <script src="https://kit.fontawesome.com/c47106c6a7.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<<<<<<< HEAD
	 <header>
=======
    <header>
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
        <div class="inner">
            <h1><a href="#">HANUL301</a></h1>
            <ul id="gnb">
                <li><a href="list.st">JDBC(학생목록조회)</a></li>
                <li><a href="list.cu">고객관리(Mybatis)</a></li>
<<<<<<< HEAD
                <li><a href="list.hr">Mybatis(사원목록조회)과제</a></li>
                <li><a href="list.js">JSTL사용</a></li>
                <!--  list.jsp(jstl폴더안에있음)을 연결하세요. -->
                <li><a href="#">게시판</a></li>
            </ul>

 

            <ul class="util">
                <li><a href="#">로그인</a></li>
                <li><a href="#">회원가입</a></li>
            </ul>

        </div>

    </header>
	
=======
                <li><a href="list.hr">Mybatis(사원목록조회)</a></li>
                <li><a href="list.js">JSTL사용</a></li>
                <!-- list.jsp(jstl폴더안에있음)을 연결 -->
                <li><a href="notice.st">게시판</a></li>
            </ul>
            <ul class="util">
            	<% if(request.getParameter("id")!=null){ %>
	            	<li><a href="#">로그아웃</a></li>
	                <li><a href="#">회원정보</a></li>
            	<%}else{ %>
	                <li><a href="login.st">로그인</a></li>
	                <li><a href="join.st">회원가입</a></li>
                <%} %>
            </ul>
        </div>
    </header>
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
</body>
</html>