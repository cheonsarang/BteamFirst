<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- prefix 는 변수에 명칭 주는 느낌, c라고 쓰는게 관례 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/include/header.jsp" %>
	<h1>하이</h1>
	<p>JSP 개발을 좀 더 편하고 단순화하기 위한 태그  library(JSP Standard Tag Library)</p>
	<!-- 따로 공부하지 않아도 됨, 검색해가면서 사용하기 -->
	<!-- Spring Boot(HTML) 타임리프, Spring Legacy(JSP) JSTL -->
	<h3>CORE(jstl/core)</h3>
	<!-- 내가 사용할 기능이 들어있는 library를 taglib태그를 통해서 추가 -->
	<!-- 변수선언 -->
	<% int num = 100; %><!-- 자바코드 이용해서 변수선언 -->
	<c:set var="num1" value="200" /><!-- JSTL을 이용한 변수 선언 -->
	<!-- 안쪽에 아무것도 안써줄거면 간단하게 줄여 써줄 수 있음-->
	<p>자바로 만든 변수 EL문법으로 출력 : ${num} </p><!-- 아무것도 안나옴 -->
	<p>JSTL로 만든 변수 출력 : ${num1} </p>
	<c:set var="num2" value="300" />
	<c:set var="num5" value="600" />
	
	<p>num1과 num2의 합 : ${num1+num2} </p>
	<p>num2과 num5의 합 : ${num1+num5} </p>
	<%@ include file = "/include/footer.jsp" %>
</body>
</html>