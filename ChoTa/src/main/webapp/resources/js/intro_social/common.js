$(function(){
	/* 모바일 브라우저 "홈화면에 추가"*/
	var userAgent = navigator.userAgent.toLowerCase(); // 접속 핸드폰 정보

	// 모바일 홈페이지 바로가기 링크 생성
	switch(userAgent){
		case 'iphone' :
			$('head').append('<link rel="apple-touch-icon" href="https://www.clickn.co.kr/favicon.png" />');
			break;
		case 'ipad':
			$('head').append('<link rel="apple-touch-icon" sizes="72*72" href="https://www.clickn.co.kr/favicon.png" />');
			break;
		case 'ipod':
			$('head').append('<link rel="apple-touch-icon" href="https://www.clickn.co.kr/favicon.png" />');
			break;
		case 'android':
			$('head').append('<link rel="shortcut icon" href="https://www.clickn.co.kr/favicon.png" />');
			break;
		default:
			break;
	}

	/* touch device check */
	if( $('#wrap').length ){
		var state = isTouchDevice();
		$('#wrap').attr('data-touch',state);
	}

	/* gnb show/hide */
	var didScroll;
	var lastScrollTop = 0;
	var delta = 5;
	var $header = $('#layout_header');
	var headerH = $header.outerHeight();
	$(window).scroll(function(event){
		didScroll = true;
	});
	setInterval(function() {
		if (didScroll) {
			hasScrolled();
			didScroll = false;
		}
	}, 250);
	function hasScrolled() {
		var scrollTop = $(this).scrollTop();

		// Make sure they scroll more than delta
		if(Math.abs(lastScrollTop - scrollTop) <= delta) return;
		if( $('aside').hasClass('on') ) return;

		// If they scrolled down and are past the navbar, add class .nav-up.
		// This is necessary so you never see what is "behind" the navbar.
		if (scrollTop > lastScrollTop && scrollTop > headerH){
			// Scroll Down
			if( $(window).scrollTop() > headerH ) {
				if( !$header.hasClass('slideup') ) $header.addClass('slideup');
			}
		}
		else {
			// Scroll Up
			if( $header.hasClass('slideup') ) $header.removeClass('slideup');
		}
		lastScrollTop = scrollTop;

	}

	/*gnb 색상 변경*/
	var winPos = 0,
		gnbPos = 0;

	/* aside */
	$('.btn_aside').on('click',function(){
		if( $(this).hasClass('opened') )
			asideClose();
		else
			asideOpen();
	});
	function asideOpen(){
		$('aside').fadeIn(200).addClass('on');
		$('.btn_aside').addClass('opened');
		if( $('#layout_header').hasClass('changed') )
			$('#layout_header').removeClass('changed');
	}
	function asideClose(){
		$('aside').fadeOut(200).removeClass('on');
		if( $('.gnb .on').length )
			$('.gnb .on').removeClass('on').next('.lnb').slideUp();

		$('.btn_aside').removeClass('opened');
	}
	//PC로 전환 시 aside 표시
	$(window).resize(function(){
		if( screenCheck() == "pc" ){
			if( $('aside').is(':hidden') )
				$('aside').removeAttr('style');
		}
	});
	//태블릿 이하 gnb
	$(document).on('click','.gnb .has > a',function(e){

		if( screenCheck() != "pc" ){
			e.preventDefault();

			if( $(this).hasClass('on') ){
				$(this).removeClass('on').next('.lnb').slideUp();
			}
			else{
				if( $('.gnb .on').length ){
					$('.gnb .on').removeClass('on').next('.lnb').slideUp();
				}
				$(this).addClass('on').next('.lnb').slideDown();
			}
			return false;

		}
	});

	// touch device unable gnb 1depth
	if( isTouchDevice() ){
		$('.gnb li.has > a').attr('href','javascript:;');
	}

	/* footer family */
	$('.btn_family').on('click',function(){
		$(this).toggleClass('on');
	});
	$(document).on('click',function(e){
		if( !$(e.target).hasClass('btn_family') & $('.btn_family').hasClass('on') )
			$('.btn_family').removeClass('on');
	});

	/* top btn */
	$(window).scroll(function(){
		if( $(window).scrollTop() > 200 )
			$('#js_top').addClass('show');
		else
			$('#js_top').removeClass('show');
	});
	//상단 이동
	$('#js_top').on('click',function(){
		scrollTo(0);
	});


	// run sroll effect
	if( $('[data-scroll]').length)
		scrollEffect();

	// close layer popup
	$('.layerpop_comm .btn_close').on('click',function(){
		layerpopClose();
	});
	$('.layerpop_comm').after().on('click',function(e){
		var $popInner = $(".pop_inner");
		if($popInner.has(e.target).length === 0){
			layerpopClose();
		}
	});

	/* comma */
	if( $('[data-comma]').length ) {
		$('[data-comma]').number( true );
	}

	$.datepicker.setDefaults({
		dateFormat: 'yy-mm-dd',
		prevText: '이전 달',
		nextText: '다음 달',
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		dayNames: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
		dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
		showMonthAfterYear: true,
		yearSuffix: '년'
	});
	$( ".datepicker" ).datepicker();

	/* 탑배너 슬라이더 */
	if( $('.topbnr_sl').length ){
		var topbnrSlId = '.topbnr_sl';
		var topbnrSlOp = ( $(topbnrSlId).find('li').length > 1 )? true : false;
		var topbnrSl;

		if( topbnrSlOp ){
			topbnrSl = new Swiper(topbnrSlId + (' .swiper-container'), {
				direction: 'vertical',
				loop: topbnrSlOp,
				autoplay: {
					delay: 4000,
				},
				navigation: {
					nextEl: topbnrSlId + ' .btn_next',
					prevEl: topbnrSlId + ' .btn_prev',
					disabledClass: 'disable'
				},
			});
		}
		else{
			$(topbnrSlId).find('.swiper-nav').addClass('hide');
		}
	}
}); // jquery

/* 터치 체크 */
function isTouchDevice(){
    return (('ontouchstart' in window) ||
        (navigator.maxTouchPoints > 0) ||
        (navigator.msMaxTouchPoints > 0));
}
/* 모바일 체크 */
function mobileCheck(){
	return ($(window).width() < 768)? true : false;
}
/* 태블릿 체크 */
function tabletCheck(){
	return ($(window).width() < 1024)? true : false;
}
/* 스크린 체크 */
function screenCheck(){
	var width = $(window).width(),
		type = '';

	if( width >= 1024 )
		type = "pc";
	else if( width < 1024 && width >= 768)
		type = "tablet";
	else
		type = "mobile";

	return type;
}

/* scroll effect */
function scrollEffect(){
	var controller = new ScrollMagic.Controller();

	var revealElements = document.querySelectorAll('[data-scroll]');
	for (var i=0; i<revealElements.length; i++) {

		var scene = new ScrollMagic.Scene({
			triggerElement: revealElements[i],
			triggerHook: 0.9
		})
		.setClassToggle(revealElements[i], "on") // add class toggle
		.addTo(controller);
	};

	if( $('[data-scroll="steps"]').length ){
		$('[data-scroll="steps"] [data-scroll]').each(function(i){
			$(this).css('transition-delay',(i*.1)+'s');
		});
	}
}

/* layer popup */
function layerpopOpen(id){
	$('.layerpop_comm[data-layer-id="'+id+'"]').fadeIn();
}
function layerpopClose(){
	$('.layerpop_comm').fadeOut();
}

/**
 * Background disable 처리
 */
function showProgress (mode) {
	if (mode) {
		$('#show_progress').show();
		$('#submitRegister').prop('disabled', true);
		$.ajaxSetup({async:false});
	} else {
		$('#submitRegister').prop('disabled', false);
		$('#show_progress').hide();
		$.ajaxSetup({async:true});
	}
}

/*** page scroll
 * : 변수를 number 또는 id로 받음
 */
function scrollTo(tar){
	var offset = 0;
	if( typeof(tar) != 'number')
		offset = $("#" + tar).offset().top;
	else
		offset
	$('html, body').animate({scrollTop : offset}, 400);
}


/**
 * 날자 범위 지정
 */
function setDateRange ($s_date, $e_date, label)
{
	var ranges = {
		'Today': [ moment(), moment() ],
		'Last 3 Days': [ moment().subtract(2, 'days'), moment() ],
		'Last 7 Days': [ moment().subtract(6, 'days'), moment() ],
		'This Month':  [moment().startOf('month'), moment() ],
		'Last Month': [ moment().subtract(1, 'month').add(1, 'days'), moment() ],
		'Last 3 Month': [ moment().subtract(3, 'month').add(1, 'days'), moment() ]
	}

	var dates = ranges[label];

	$s_date.val(dates[0].format('YYYY-MM-DD'));
	$e_date.val(dates[1].format('YYYY-MM-DD'));

	return false;
}

/**
 * 오픈다이얼로그
 */
function openDialog(title, layerId, customOptions, callback){
	if((typeof layerId) != 'string') var layerSelector = layerId;
	else if(layerId.substring(0,1)=='#' || layerId.substring(0,1)=='.' || (typeof layerId) != 'string') var layerSelector = layerId;
	else var layerSelector = "#"+layerId;

	var options = {
		"zIndex" : 10000,
		"show" : "fade",
		"hide" : "blind",
		"modal" : true,
		"resizable" : false,
		"draggable" : true,
		"noClose" : false,
	};
	if(customOptions != undefined){
		for(var i in customOptions){
			options[i] = customOptions[i];
		}
	}
	options['title'] = title;

	if(callback){
		$(layerSelector).dialog({
			"modal" : options['modal'],
			"close" : function(){
				callback();
			}
		});
	}

	if(options['autoOpen']==false){
		$(layerSelector)
		.dialog({"autoOpen" : false})
		.dialog("option", options);
	}else{
		$(layerSelector)
		.dialog({"autoOpen" : false})
		.dialog("option", options)
		.dialog("open")
		.focus();
	}

	if (options['noClose']){
		$(".ui-dialog-titlebar-close", $(layerSelector).closest(".ui-dialog")).hide();
		$(layerSelector).dialog("option","close",function(){
			if(options['noClose']) $(layerSelector).dialog("open").focus();
		});
	}

	if(parseInt($(layerSelector).closest('.ui-dialog').css('top'))<$(document).scrollTop()){
		$(layerSelector).closest('.ui-dialog').css('top',$(document).scrollTop()+'px');
	}

	var height = parseInt($(layerSelector).css('height')) + 25;
	$(layerSelector).css('height', height + 'px');

	var dlgWin = $(".ui-dialog", window.parent.document);
}


/**
 * openDialog를 이용한 alert창
 * @param data
 * @param callback
 * @param customOptions
 * @returns
 */
function openDialogAlert(data, callback, customOptions){
	var options = {
		'z-index' : 999999,
		'hideButton' : false,
		'modal' : true
	};

	if (customOptions != undefined){
		for (var i in customOptions){
			options[i] = customOptions[i];
		}
	}

	if (data.width){
		options['width'] = data.width;
	}

	// dialog 기본지원 버튼이 아닌 확인버튼 추가
	data.msg += '<div class="ui-button-wrap">';
	data.msg += '<button type="button" class="ui-button" onclick="closeDialog(\'#openDialogLayerMsg\');">확인</button>';
	data.msg += '</div>';
	$('#openDialogLayerMsg').html(data.msg);

	var title = '알림';
	if (data.title){
		title = data.title;
	}
	openDialog(title, "openDialogLayer", options, callback);
}

/**
 * openDialog를 이용한 confirm창
 * @param data
 * @param callback
 * @param customOptions
 * @returns
 */
function openDialogConfirm(data, yesCallback, customOptions,noCallback){
	var options = {
		'z-index' : 999999,
		'hideButton' : false,
		'modal' : true
	};
	var btn1 = '확인';
	var btn2 = '취소';
	if (customOptions != undefined){
		for (var i in customOptions){
			options[i] = customOptions[i];
		}
	}

	if (data.width){
		options['width'] = data.width;
	}
	if (data.btn1) {
		btn1 = data.btn1;
	}
	if (data.btn2) {
		btn2 = data.btn2;
	}
	// dialog 기본지원 버튼이 아닌 확인버튼 추가
	var randVal = getRand(10000, 99999);
	data.msg += '<div class="ui-button-wrap">';
	data.msg += '<button type="button" class="ui-button" id="btnDialogConfirmYes_' + randVal + '" style="width:40%;">' + btn1 + '</button>';
	data.msg += '<button type="button" class="ui-button" id="btnDialogConfirmNo" style="width:40%;">' + btn2 + '</button>';
	data.msg += '</div>';
	$('#openDialogLayerMsg').html(data.msg);

	$('#openDialogLayerMsg').find('button#btnDialogConfirmYes_' + randVal).off('click');
	$('#openDialogLayerMsg').find('button#btnDialogConfirmYes_' + randVal).on('click', function(){
		closeDialog('#openDialogLayer');
		if(yesCallback) yesCallback();
	});
	$('#openDialogLayerMsg').find('button#btnDialogConfirmNo').off('click');
	$('#openDialogLayerMsg').find('button#btnDialogConfirmNo').on('click', function(){
		closeDialog('#openDialogLayer');
		if(noCallback) noCallback();
	});

	var title = '확인';
	if (data.title){
		title = data.title;
	}
	openDialog(title, "openDialogLayer", options, function(){});
}

/**
 * Dialog 수동 close
 * @param selector
 * @returns
 */
function closeDialog(selector){
	$(selector).closest('.ui-dialog-content').dialog('close');
}

/**
 * 임의의 수 생성
 * @param min
 * @param max
 * @returns
 */
function getRand(min, max){
	min = Math.ceil(min);
	max = Math.floor(max);
	return Math.floor(Math.random() * (max - min + 1)) + min;
}

//ajax
$.ajaxSetup({
	headers: {
		'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
	},
	error: function (xhr, status, error) {
		var json = $.parseJSON(xhr.responseText);

		if (typeof json == 'object') {
			if (typeof json.error != 'undefined') {
				alert (json.error);
			}
		} else {
			if (xhr.responseText) {
				alert(xhr.responseText)
			} else {
				alert(error);
			}
		}
	}
});

$.extend(jQuery.expr[':'], {
	invalid : function(elem, index, match){
		return elem.validity !== undefined && elem.validity.valid === false;
	},

	valid : function(elem, index, match){
		return elem.validity !== undefined && elem.validity.valid === true;
	}
});

/* 서비스 로딩 화면 */
function loadingProgress(state){
	if(state == "show"){
		$('#pannelSpinner').fadeIn(300);
	}
	else if(state == "hide"){
		$('#pannelSpinner').hide();
	}
}


/**
 * ajax 전송함수
 * @param url
 * @param type
 * @param params
 * @param userFunc
 * @returns
 */
function commonAjax(url, type, params, userFunc){
    $.ajax({
        'url' : url,
        'type' : type,
        'data' : params,
        'dataType' : 'json',
        'headers': {'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')},
        'success' : function(res) {
            if (res.error) {
                openDialogAlert({'msg':res.error});
                return false;
            }

            if (typeof(userFunc) == 'function'){
                userFunc(res.data);
            }else{
                var Func = window[userFunc];
                Func(res.data);
            }
        },
        'beforeSend' : function() {
            $('#ajax_loading').show();
        },
        'complete' : function(){
            $('#ajax_loading').hide();
        },
        'fail' : function(request, status, error) {
            if (request.status == 422 && request.responseJSON) {
                $('#form_errors > ul').empty();
                $.each(request.responseJSON, function(k, v) {
                    $('#form_errors > ul').append('<li>' + v[0] + '</li>');
                });
                $('#form_errors').show();
            } else {
                openDialogAlert({'msg':error + ' (' + request.status + ')'});
            }
        }
    });
}
