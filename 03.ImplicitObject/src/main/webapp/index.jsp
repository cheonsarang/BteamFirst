<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>태그</title>
</head>
<body>
	<h1> Request 요청 </h1>
	<ul>
		<li><a href="Ex01_Request/Ex00_infoRequest.jsp"> ( 관련 된 정보들을 살펴보기 )  </a> </li>
		<li><a href="Ex01_Request/Ex01_Request.jsp"> 요청해보기 </a> </li>
		<li><a href="Ex01_Request/Test01_Request.jsp"> 요청해보기 테스트1</a> </li>
		<li><a href="Ex01_Request/Test02_Request.jsp"> 요청해보기 테스트2</a> </li>
		
		<!-- Request(요청) 가 받을수있는 파라메터 form  (get, post), url?key=value   -->
		
		<li><a href="Ex01_Request/Scope.jsp"> Scope(데이터의 전달 범위)</a> </li>
		<li><a href="Ex01_Request/ScopeServlet.jsp"> Scope(서블릿에서 받아서 쓰기)</a> </li>
		<li><a href="Ex02_Response/Ex01_Redirect.jsp"> Redirect </a> </li>
		<li><a href="Ex02_Response/Ex02_ResLogin.jsp"> 다시 연습 </a> </li>
		
		<!-- 
		Scope : Zoom 망원경
		데이터의 전달범위는 각각의 스코프마다 차이가 있음
		많은 데이터를 사용하지 않는데 계속 전달을 하려면 유지를 해야함(Memory)
		많은 데이터를 사용하지 않는데 어떠한 key값으로 저장을 해두면 나중에 혼동이 생김
		
		PageContext( jsp 페이지 내에서만 데이터 전달 ( java변수, js 변수 ) 사용빈도 낮음
		
		Request ( 요청이나 Forward(페이지 전환)시에 한번만 데이터를 전송함) 사용빈도 높음 ※※
				  ex)login.jsp 에서 로그인할 때 요청 => Servlet에서 받음 => 페이지 전환(Request x) 메모리 효율적으로 관리됨
				( 모든 데이터의 페이지 이동시 사용 )
				  
		Session ( 같은 브라우저 내에 요청되는 모든 데이터를 저장 / 브라우저 내에서는 계속 유지되는 정보 ) 사용빈도 높음 ※
				( 크롬을 실행시킴 < 둘은 세션이 다름 > 크롬창을 시크릿으로 킴)
				( 크롬을 실행시킴 < 세션이 같음 > 크롬탭을 추가)
				
		ApplicationContext ( 어플리케이션이 완전히 종료되지 않는한 유지됨 => 주로 버전등으로만 사용 ) 사용빈도 낮음
		 -->
		
	</ul>
	
	
	
</body>
</html>









