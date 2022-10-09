<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/reset.css">
<style type="text/css">
.slidePart {
	clear: both !important;
	margin: 0;
	padding: 0;
}

.slideContainer {
	width: 100%;
	position: relative;
}
/*-아래 pageBt abosolute로 위치를 잡기 위하여 부모에 position: relative 필요*/
.slideWrap {
	width: calc(100% * 6) !important;
	overflow: hidden;
	margin-left: calc(-100% * 1);
	position: relative;
	z-index: 1
}
/*총600장을 나열하기위하여 calc(100%*6) 또는 600%, 맨처음 1번째 이미지 가기위하여 margin-left: calc(-100%*0)*/
.slide {
	float: left;
}

.slide img {
	width: 100%;
}

.slideText {
	z-index: 5;
	position: absolute;
	top: 20%;
	left: 15%;
}

.slideText h1 {
	font-size: 5rem;
	color: #fff;
}

.slideText p {
	color: #fff;
	margin-top: 10%;
	font-size: 1.3rem;
}

.slideText button {
	border: none;
	background-color: #fff;
	border-radius: 30px;
	width: 40%;
	height: 50px;
	margin-top: 6%;
	color: #555;
	font-weight: 500;
}

.slideText button:hover {
	color: #6199e6;
}

.pageBtWrap {
	z-index: 3;
	position: absolute;
	left: 0;
	bottom: 7%;
	width: 100%;
	text-align: center;
}

.pageBtWrap li {
	display: inline;
}
/*부모요소를 text-align: center, li를 inline요소로 바꿔 중간 정렬, float: left 사용할 필요없음*/
.pageBtWrap li .pageBt {
	display: inline-block;
	width: 12px;
	height: 12px;
	border-radius: 50%;
	margin-left: 10px;
	background-color: #fff;
}

.pageBtWrap li .pageBt.addPageBt {
	background-color: #ff0;
}

/* 본문 중 본문 */
section {
	padding: 20px 0;
}

.content_color {
	clear: both;
	background-color: #272f41;
}

.content {
	clear: both;
	width: 1280px;
	max-width: 100%;
	margin: 0px auto;
	overflow: hidden;
}

.common {
	padding: 100px 0 10%;
}

h1.common_title {
	text-align: center;
	font-size: 2rem;
	font-weight: 900;
}

.common_part {
	margin-top: 60px;
}

.common_part ul {
	display: flex;
	justify-content: space-between;
}

.common_part li {
	display: block;
	text-align: center;
	background-color: #fff;
}

.common_part h2 {
	padding: 16px 0;
	text-align: center;
}

.common_part h2:hover {
	color: #6199e6;
}

.common_part p {
	font-size: 1rem;
	font-weight: normal;
	margin-bottom: 4px;
}

/* .place_txt span {padding-bottom: 10%; } */
.common_part img {
	margin-bottom: 20px;
}

.content_color h1 {
	color: #fff;
}

.content_color .common_part ul {
	justify-content: space-around;
}

.content_color .common_part li {
	border-radius: 30px;
}

.content_color .common_part img {
	border-radius: 30px 30px 0px 0px;
}

.content_color .common_part_part {
	background-color: #fff;
	border-radius: 0px 0px 30px 30px;
}

.common_new .common_part ul{
	margin-bottom: -1px;
}

.common_new .common_part img {
	margin-bottom: 0px;
}
</style>
<script>
	//슬라이드1 제이쿼리
	var winW = cnt = setId = 0;
	resizeFn(); //함수 호출
	function resizeFn() { //반응형 이미지크기 조정함수
		winW = $(window).innerWidth();
		$(".slide").css({
			width : winW
		//창크기에 슬라이드이미지 맞춤
		});
	};

	$(window).resize(function() {
		resizeFn(); //창크기 변경될 때마다 함수 반복 실행
	});

	autoplayFn(); //함수호출
	function autoplayFn() { //2.5초마다 슬라이드 자동 작동
		setId = setInterval(nextCountFn, 2500);
	};

	$(".pageBt").each(function(idx) { //page버튼 클릭시마다 해당 이미지로 이동
		$(this).click(function() {
			clearInterval(setId); //autoplay 함수 정지
			cnt = idx;
			mainslideFn();
		});
	});

	function nextCountFn() { //count(cnt)가 증가될 때마다 슬라이드 작동
		cnt++;
		mainslideFn();
	};

	function prevCountFn() { //count가 감소될 때마다 슬라이드 작동 
		cnt--;
		mainslideFn();
	};

	function mainslideFn() { //메인슬라이드 함수
		$(".slideWrap").stop().animate({
			left : (-100 * cnt) + "%"
		}, 600, function() {
			if (cnt > 2) {
				cnt = 0; //count가 끝가지 이동했을 대 다시 처음으로 돌아감
			}
			if (cnt < 0) {
				cnt = 2
			}
			$(".slideWrap").stop().animate({
				left : (-100 * cnt) + "%"
			}, 0)
		});
		$(".pageBt").removeClass("addPageBt");
		$(".pageBt").eq(cnt > 2 ? cnt = 0 : cnt).addClass("addPageBt");
	};
	//animation 사용시에는 stop을 넣어 부드럽게 하기(덜컹거리지 않음)
	//count변경시마다 버튼 색갈 변경됨
</script>
</head>

<body>
	<!------메인 슬라이드이미지 영역------>
	<section class="slidePart">
		<div class="slideContainer">
			<ul class="slideWrap">
				<li class="slide slide1"><img src="img/main3.jfif"></li>
				<li class="slide slide2"><img src="img/main1.jfif"></li>
				<li class="slide slide3"><img src="img/main2.jfif"></li>
				<li class="slide slide1"><img src="img/main3.jfif"></li>
				<li class="slide slide2"><img src="img/main1.jfif"></li>
			</ul>
			<ul class="pageBtWrap">
				<li><a href="#" class="pageBt addPageBt"></a></li>
				<li><a href="#" class="pageBt"></a></li>
				<li><a href="#" class="pageBt"></a></li>
			</ul>
			<div class="slideText">
				<h1>
					School Time<br>Creative
				</h1>
				<p>초등학생들의 에브리타임 ChoTa!</p>
				<a href="login"><button>시작하기 →</button></a>
			</div>
		</div>
	</section>
	<!------메인 슬라이드이미지 영역 end------>
	<!------본문 영역 start------>
	<section class="content">
		<div class="common">
			<h1 class="common_title">Program</h1>
			<div class="common_part">
				<ul>
					<li><a href="list.it"> <img src="img/contents_a.png"
							alt="main1">
							<h2>BRAND STORY</h2>
							<p>특별한 아카데미</p>
							<p>스토리를 시작합니다.</p> <br>
						<br>
					</a></li>
					<li><a href="list.sh"> <img src="img/contents_b.png"
							alt="main2">
							<h2>BUSINESS</h2>
							<p>상상 그 이상을 실현하는 초타의</p>
							<p>사업분야를 소개해 드립니다.</p> <br>
						<br>
					</a></li>
					<li><a href="list.pl"> <img src="img/contents_c.png"
							alt="main3">
							<h2>PRODUCT</h2>
							<p>아이들에게 꼭 필요한</p>
							<p>최고의 교재를 소개합니다.</p> <br>
						<br>
					</a></li>
					<li><a href="list.qna"> <img src="img/contents_d.png"
							alt="main4">
							<h2>INQUIRTY</h2>
							<p>궁금하신 사항을 문의해 주시면</p>
							<p>상세하게 답변해 드리겠습니다.</p> <br> <br>
					</a></li>
				</ul>
			</div>
		</div>
	</section>
	<section class="content_color">
		<div class="content">
			<div class="common">
				<h1 class="common_title">Our services</h1>
				<div class="common_part">
					<ul>
						<li><a href="list.it"> <img src="img/slide_a.jpg"
								alt="img1">
								<div class="common_part_part">
									<h2>우리아이 첫공부</h2>
									<p>초타는 보다나은 아이들의</p>
									<p>학습환경 조성을 위해</p>
									<p>지원합니다.</p>
									<br>
									<br>
								</div>
						</a></li>
						<li><a href="list.sh"> <img src="img/slide_b.jpg"
								alt="img2">
								<div class="common_part_part">
									<h2>아이들의 자기계발</h2>
									<p>공부 뿐만이 아니라 아이</p>
									<p>한명 한명의 개성을</p>
									<p>살리도록 위해 노력합니다.</p>
									<br>
									<br>
								</div>
						</a></li>
						<li><a href="list.pl"> <img src="img/slide_c.jpg"
								alt="img3">
								<div class="common_part_part">
									<h2>학교공부 기초튼튼</h2>
									<p>학교에서의 교과과정을</p>
									<p>이해할 수 있도록 최고의</p>
									<p>지원이 함께합니다.</p>
									<br>
									<br>
								</div>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<section class="content">
		<div class="common common_new">
			<h1 class="common_title">ChoTa Education</h1>
			<div class="common_part">
				<ul>
					<li><img src="img/edu1.jfif"></li>
					<li><img src="img/edu2.jfif"></li>
					<li><img src="img/edu3.jfif"></li>
				</ul>
				<ul>
					<li><img src="img/edu4.jfif"></li>
					<li><img src="img/edu5.jfif"></li>
					<li><img src="img/edu6.jfif"></li>
				</ul>
				<ul>
					<li><img src="img/edu7.jfif"></li>
					<li><img src="img/edu8.jfif"></li>
					<li><img src="img/edu9.jfif"></li>
				</ul>
			</div>
	</section>
	<!------본문 영역 end------>
</body>
</html>
