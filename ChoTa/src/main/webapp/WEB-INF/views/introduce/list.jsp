<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

   	<!-- font -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&family=Roboto:wght@100;300;400;500;700&display=swap" rel="stylesheet">

<!-- style -->
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/intro_social/reset.css">
<link rel="stylesheet" href="vendor/scrollbar/jquery.scrollbar.css">
<!-- <link rel="stylesheet" href="vendor/jquery/ui/jquery-ui.min.css"> 공통코드layout에 있음-->
<link rel="stylesheet" href="css/intro_social/common.css">
<link rel="stylesheet" href="css/intro_social/normal.css">

<link rel="stylesheet" href="vendor/swiper/swiper-bundle.min.css">

 
<title>Insert title here</title>
</head>
<body>
	

   <main id="layout_body" class="cate_intro homepage">
			<section class="sec_head_comm">
				<div class="w_container">
					<h2 class="page_tit"><span class="line_wrap_m">초등학생들의 에브리타임! &nbsp;</span>ChoTa</h2>
					<p class="page_desc">
						페이지 생성부터 게시판, 갤러리 기능까지<br>
						간편하게 적용하면 쉽게 나만의 홈페이지를 완성할 수 있습니다.
					</p>
					<div class="visual">
						<video autoplay loop muted playsinline>
							<source src="img/intro/sub_homepage.mp4" type="video/mp4">
						</video>
					</div>
				</div>
			</section><!--// sec_head_comm -->

			<section class="sec_intro">
				<div class="part_area sec1">
					<div class="part w_container left">
						<div class="text_area">
							<h3 class="part_tit">무제한 페이지 생성</h3>
							<div class="part_desc">
								<span class="line_wrap_rev">새로운 페이지를 만들고 디자인 꾸미기를 통해 꾸며보세요.</span>
								원하는 유형의 페이지로 자유롭게 구성할 수 있습니다.
							</div>
						</div>

						<div class="img_area">
							<img src="img/intro/homepage_sec1_05.png" aria-hidden="true" class="img3 shadow">
							<img src="img/intro/homepage_sec1_04.png" aria-hidden="true" class="img2 shadow">
							<img src="img/intro/homepage_sec1_03.png" aria-hidden="true" class="img1 shadow">
						</div>
					</div><!--// part -->
				</div><!--// part_area -->

				<div class="part_area sec2">
					<div class="part w_container right">
						<div class="text_area">
							<h3 class="part_tit">커뮤니티 게시판</h3>
							<div class="part_desc">
								자유로운 커뮤니티 공간을 개설해보세요.<br>
								비밀글, 파일첨부, 댓글 기능을 모두 제공합니다.
							</div>
						</div>

						<div class="img_area">
							<img src="img/intro/homepage_sec2_a.png" aria-hidden="true" class="img1 shadow">
							<img src="img/intro/homepage_sec2_b.png" aria-hidden="true" class="img2">
						</div>
					</div><!--// part -->
				</div><!--// part_area -->

				<div class="part_area sec3">
					<div class="part w_container left">
						<div class="text_area">
							<h3 class="part_tit">다채로운 이미지 갤러리</h3>
							<div class="part_desc">
								여러 이미지를 추가해 나만의 포트폴리오를 구성해 보세요.
								다양한 스타일의 갤러리를 지원합니다.
							</div>
						</div>

						<div class="img_area">
							<img src="img/intro/homepage_sec3.png" aria-hidden="true" class="img1 shadow">
						</div>
					</div><!--// part -->
				</div><!--// part_area -->

				<div class="part_area sec4">
					<div class="part w_container right">
						<div class="text_area">
							<h3 class="part_tit">고객 맞춤 상담 문의 폼</h3>
							<div class="part_desc">
								<span class="line_wrap_rev">문의하기 양식을 드래그앤드롭 방식으로 </span>
								<span class="line_wrap_rev">손쉽게 만들어 보세요. 접수된 문의내역은 </span>
								자동으로 메일로 발송되어 즉시 확인 가능합니다.
							</div>
						</div>

						<div class="img_area">
							<img src="img/intro/homepage_sec4.png" aria-hidden="true" class="img1 shadow">
						</div>
					</div><!--// part -->
				</div><!--// part_area -->

				<div class="part_area sec5">
					<div class="part w_container left">
						<div class="text_area">
							<h3 class="part_tit">이벤트 팝업 노출</h3>
							<div class="part_desc">
								<span class="line_wrap"><span class="line_wrap_rev">팝업 노출 기간부터 화면 배치까지 </span>
								<span class="line_wrap_rev">간편하게 설정 가능합니다. </span></span>
								접속 환경에 따른 노출 여부도 제어 가능합니다.

								<div class="modal_location">
									<p>팝업 위치</p>
									<ul>
										<li></li>
										<li class="is_active"></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
										<li></li>
									</ul>
								</div>
							</div>
						</div>

						<div class="img_area">
							<img src="img/intro/homepage_sec5.png" aria-hidden="true" class="img1 shadow">
						</div>
					</div><!--// part -->
				</div><!--// part_area -->

				<div class="part_area sec6">
					<div class="part w_container right">
						<div class="text_area">
							<h3 class="part_tit">자유로운 메뉴 생성</h3>
							<div class="part_desc">
								<span class="line_wrap_rev">상단 메뉴와 하단 메뉴를 자유롭게 구성할 수 있습니다.</span>
								원하는 메뉴 구조로 자유롭게 배치해 보세요.
							</div>
						</div>

						<div class="img_area">
							<img src="img/intro/homepage_sec6_a.png" aria-hidden="true" class="img1 shadow">
							<img src="img/intro/homepage_sec6_b.png" aria-hidden="true" class="img2 shadow">
							<img src="img/intro_social/ico_cursor_hand.png" aria-hidden="true" class="img3">
						</div>
					</div><!--// part -->
				</div><!--// part_area -->
			</section><!--// sec_intro -->

			<section class="sec_others">
				<div class="w_container">
					<h3 class="sec_tit">이 외 기능들</h3>

					<ul class="list">
						<li class="item new">
							<a href="/intro/shopping">
								<img src="img/intro/ico_shopping.svg" aria-hidden="true" class="ico">
								<h4 class="tit">쇼핑 기능</h4>
								<p class="desc">
									<span class="line_wrap_rev">상품 등록, 주문, 결제 문의 연동까지 </span>
									<span class="line_wrap_rev">커머스에 필요한 모든 기능을 담았습니다.</span>
								</p>
								<span class="go">쇼핑 기능 살펴보기</span>
							</a>
						</li>
						<li class="item">
							<a href="/intro/design">
								<img src="img/intro/ico_design.svg" aria-hidden="true" class="ico">
								<h4 class="tit">디자인 기능</h4>
								<p class="desc">
									<span class="line_wrap_rev">한 번의 클릭으로 고퀄리티 </span>
									<span class="line_wrap_rev">디자인을 완성해 보세요.</span>
								</p>
								<span class="go">디자인 기능 살펴보기</span>
							</a>
						</li>
						<li class="item">
							<a href="/intro/member">
								<img src="img/intro/ico_member.svg" aria-hidden="true" class="ico">
								<h4 class="tit">회원 기능</h4>
								<p class="desc">
									<span class="line_wrap_rev">회원가입, 로그인 기능 등 </span>
									<span class="line_wrap_rev">효율적인 회원 관리 기능을 제공합니다.</span>
								</p>
								<span class="go">회원 기능 살펴보기</span>
							</a>
						</li>
						<li class="item">
							<a href="/intro/setting">
								<img src="img/intro/ico_setting.svg" aria-hidden="true" class="ico">
								<h4 class="tit">설정 기능</h4>
								<p class="desc">
									<span class="line_wrap_rev">검색엔진최적화(SEO), 문자/이메일 </span>
									<span class="line_wrap_rev">자동 발송도 쉽게 설정할 수 있습니다.</span>
								</p>
								<span class="go">설정 기능 살펴보기</span>
							</a>
						</li>
					</ul>
				</div>
			</section><!--// sec_others -->

			<section class="sec_start_comm">
				<div class="w_container">
					<p class="txt">
						<span class="line_wrap_m">직접 사용해 보는 것 만큼 </span>좋은 방법은 없습니다<br>
						<span class="line_wrap_m">지금 바로 </span>ChoTa를 시작하세요
					</p>
					<a href="/template" class="btn_fill_blue">시작하기</a>
				</div>
			</section><!--// sec_start_comm -->
		</main><!--// #layout_body -->

    
<!--     <script src="/vendor/jquery/1.12.4/jquery.min.js"></script> 공통코드layout에 있음 -->
<!-- 	<script src="vendor/jquery/ui/jquery-ui.min.js"></script> 공통코드layout에 있음 -->
	<script src="vendor/number/jquery.number.min.js"></script>
	<script src="vendor/scrollbar/jquery.scrollbar.min.js"></script>
	<script src="vendor/scrollMagic2.0.8/ScrollMagic.min.js"></script>
	<script src="js/intro_social/common.js"></script>
	<script src="js/intro_social/script.js"></script>

	<script src="vendor/swiper/swiper-bundle.min.js" ></script>
	<script>
		$(function(){
			/* swiper slider */


		
			/* swiper slider */
			var sliderOp = ( $('.skins-slider .swiper-slide').length > 1 )? true : false;
			var templateSl;

			if( sliderOp ){
				templateSl = new Swiper('.skins-slider', {
					autoplay: {
						delay: 1,
						disableOnInteraction: false
					},
					freemode: true, 
					width: 236,
					speed: 5000,
					loop: true,
					loopAdditionalSlides: 2,
					breakpoints: {
						320:{
							slidesPerView: 1.5,
							spaceBetween: 28,
						},
						768:{
							slidesPerView: 'auto',
							spaceBetween: 56,
						}
					},
				});
			}
		});
	</script>



</body>
</html>