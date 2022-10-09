<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학교글 관리</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<style type="text/css">
.wrap {
	clear: both !important;
	margin: 0px auto;
	padding: 0;
	width: 1280px !important;
}

.left_menu {
	margin-top: 80px;
	width: 200px;
	float: left;
	background-color: #eee;
	border-right: 1px solid #ddd;
	/* height:100% 그냥 적용 안됨. 부모개념이 있어야 채워질 수 있음 */
	position: fixed; /*공중에 떠서 공간을 차지하지 않음*/
	height: auto; /*fixed를 해서 높이 100% 가능해짐*/
}

.left_menu h2 {
	font-size: 18px;
	padding: 30px;
}

.left_menu .menu {
	
}

.left_menu .menu li {
	
}

/*메뉴*/
.left_menu .menu li a {
	height: 30px;
	line-height: 30px;
	display: block;
	padding: 0 30px;
	font-size: 14px;
	color: #555;
}

.left_menu .menu li a:hover {
	color: #6199e6;
	font-weight: 700;
}

/* 본문 */
.right_content {
	width: 1080px;
	float: right;
	padding-left: 20px;
}

.right_content h1 {
	text-align: center;
	font-size: 2rem;
	margin-bottom: 40px;
}

.right_content article{
	text-align: center;
}

.right_content article h2 {
	margin-bottom: 10px;
	color: #222;
	font-size: 1.4rem;
}

.right_content article p {
	font-size: 14px;
	line-height: 28px;
	margin-bottom: 30px;
	color: #777;
}
</style>
</head>
<body>
	<div class="wrap">
		
		<div class="left_menu">
			<h2>우리학교 게시판</h2>
			<ul class="menu">
				<li><a href="#notice">우리학교 공지사항</a></li>
				<li><a href="#letter">우리학교 가정통신문</a></li>
				<li><a href="#meals">우리학교 식단조회</a></li>
				<li><a href="#homework">우리반 알림장</a></li>
				<br><br>
			</ul>
		</div>
		<section class="right_content">
			<h1>우리학교</h1>
			<article id="notice">
				<h2>공지사항</h2>
				<table>
					<tr></tr>
					<th>
				
				
				</table>
			</article>
			<!-- id는 중복되면 안됨 -->
			<article id="letter">
				<h2>가정통신문</h2>
				<p>nav
메뉴의 스타일 설정을 한다
position:fixed; 해준다. 이건 공중에 떠서 공간을 차지하지 않으며, 스크롤을 내려도 고정되어 있다.
그리고 height 100%를 준다.
여기서 fixed없이 height 100%를 준다면, 적용되지 않는다.

.menu li a
height 30px 지정 후 line-height도 똑같이 지정해서 글자가 상하 가운데 정렬이 되도록 한다.
a태그는 디스플레이 기본 inline이다.
롤오버 했을때 배경색을 지정해도 내용물 만큼만 채워지기 때문에 block으로 바꾼다.

.menu li a:hover
롤오버 했을 때 배경색상과, 글자색상을 변경한다nav
메뉴의 스타일 설정을 한다
position:fixed; 해준다. 이건 공중에 떠서 공간을 차지하지 않으며, 스크롤을 내려도 고정되어 있다.
그리고 height 100%를 준다.
여기서 fixed없이 height 100%를 준다면, 적용되지 않는다.nav
메뉴의 스타일 설정을 한다
position:fixed; 해준다. 이건 공중에 떠서 공간을 차지하지 않으며, 스크롤을 내려도 고정되어 있다.
그리고 height 100%를 준다.
여기서 fixed없이 height 100%를 준다면, 적용되지 않는다.

.menu li a
height 30px 지정 후 line-height도 똑같이 지정해서 글자가 상하 가운데 정렬이 되도록 한다.
a태그는 디스플레이 기본 inline이다.
롤오버 했을때 배경색을 지정해도 내용물 만큼만 채워지기 때문에 block으로 바꾼다.

.menu li a:hover
롤오버 했을 때 배경색상과, 글자색상을 변경한다nav
메뉴의 스타일 설정을 한다
position:fixed; 해준다. 이건 공중에 떠서 공간을 차지하지 않으며, 스크롤을 내려도 고정되어 있다.
그리고 height 100%를 준다.
여기서 fixed없이 height 100%를 준다면, 적용되지 않는다.

.menu li a
height 30px 지정 후 line-height도 똑같이 지정해서 글자가 상하 가운데 정렬이 되도록 한다.
a태그는 디스플레이 기본 inline이다.
롤오버 했을때 배경색을 지정해도 내용물 만큼만 채워지기 때문에 block으로 바꾼다.

.menu li a:hover
롤오버 했을 때 배경색상과, 글자색상을 변경한다nav
메뉴의 스타일 설정을 한다
position:fixed; 해준다. 이건 공중에 떠서 공간을 차지하지 않으며, 스크롤을 내려도 고정되어 있다.
그리고 height 100%를 준다.
여기서 fixed없이 height 100%를 준다면, 적용되지 않는다.

.menu li a
height 30px 지정 후 line-height도 똑같이 지정해서 글자가 상하 가운데 정렬이 되도록 한다.
a태그는 디스플레이 기본 inline이다.
롤오버 했을때 배경색을 지정해도 내용물 만큼만 채워지기 때문에 block으로 바꾼다.

.menu li a:hover
롤오버 했을 때 배경색상과, 글자색상을 변경한다nav
메뉴의 스타일 설정을 한다
position:fixed; 해준다. 이건 공중에 떠서 공간을 차지하지 않으며, 스크롤을 내려도 고정되어 있다.
그리고 height 100%를 준다.
여기서 fixed없이 height 100%를 준다면, 적용되지 않는다.

.menu li a
height 30px 지정 후 line-height도 똑같이 지정해서 글자가 상하 가운데 정렬이 되도록 한다.
a태그는 디스플레이 기본 inline이다.
롤오버 했을때 배경색을 지정해도 내용물 만큼만 채워지기 때문에 block으로 바꾼다.

.menu li a:hover
롤오버 했을 때 배경색상과, 글자색상을 변경한다nav
메뉴의 스타일 설정을 한다
position:fixed; 해준다. 이건 공중에 떠서 공간을 차지하지 않으며, 스크롤을 내려도 고정되어 있다.
그리고 height 100%를 준다.
여기서 fixed없이 height 100%를 준다면, 적용되지 않는다.

.menu li a
height 30px 지정 후 line-height도 똑같이 지정해서 글자가 상하 가운데 정렬이 되도록 한다.
a태그는 디스플레이 기본 inline이다.
롤오버 했을때 배경색을 지정해도 내용물 만큼만 채워지기 때문에 block으로 바꾼다.

.menu li a:hover
롤오버 했을 때 배경색상과, 글자색상을 변경한다nav
메뉴의 스타일 설정을 한다
position:fixed; 해준다. 이건 공중에 떠서 공간을 차지하지 않으며, 스크롤을 내려도 고정되어 있다.
그리고 height 100%를 준다.
여기서 fixed없이 height 100%를 준다면, 적용되지 않는다.

.menu li a
height 30px 지정 후 line-height도 똑같이 지정해서 글자가 상하 가운데 정렬이 되도록 한다.
a태그는 디스플레이 기본 inline이다.
롤오버 했을때 배경색을 지정해도 내용물 만큼만 채워지기 때문에 block으로 바꾼다.

.menu li a:hover
롤오버 했을 때 배경색상과, 글자색상을 변경한다nav
메뉴의 스타일 설정을 한다
position:fixed; 해준다. 이건 공중에 떠서 공간을 차지하지 않으며, 스크롤을 내려도 고정되어 있다.
그리고 height 100%를 준다.
여기서 fixed없이 height 100%를 준다면, 적용되지 않는다.

.menu li a
height 30px 지정 후 line-height도 똑같이 지정해서 글자가 상하 가운데 정렬이 되도록 한다.
a태그는 디스플레이 기본 inline이다.
롤오버 했을때 배경색을 지정해도 내용물 만큼만 채워지기 때문에 block으로 바꾼다.

.menu li a:hover
롤오버 했을 때 배경색상과, 글자색상을 변경한다nav
메뉴의 스타일 설정을 한다
position:fixed; 해준다. 이건 공중에 떠서 공간을 차지하지 않으며, 스크롤을 내려도 고정되어 있다.
그리고 height 100%를 준다.
여기서 fixed없이 height 100%를 준다면, 적용되지 않는다.

.menu li a
height 30px 지정 후 line-height도 똑같이 지정해서 글자가 상하 가운데 정렬이 되도록 한다.
a태그는 디스플레이 기본 inline이다.
롤오버 했을때 배경색을 지정해도 내용물 만큼만 채워지기 때문에 block으로 바꾼다.

.menu li a:hover
롤오버 했을 때 배경색상과, 글자색상을 변경한다

.menu li a
height 30px 지정 후 line-height도 똑같이 지정해서 글자가 상하 가운데 정렬이 되도록 한다.
a태그는 디스플레이 기본 inline이다.
롤오버 했을때 배경색을 지정해도 내용물 만큼만 채워지기 때문에 block으로 바꾼다.

.menu li a:hover
롤오버 했을 때 배경색상과, 글자색상을 변경한다</p>
			</article>
			<article id="meals">
				<h2>식단</h2>
			</article>
			<article id="homework">
				<h2>알림장</h2>
			</article>
		</section>
	</div>
</body>
</html>