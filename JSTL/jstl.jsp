<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>    
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL 사용</h1>
	<p>JSP 개발을 좀 더 편하고 단순화하기 위한 태그 library(JSP Standard Tag Library)</p>
	<h3>CORE(jstl/core)</h3>
	<!-- 내가 사용할 기능이 들어있는 library를 taglib태그를 통해 추가 -->
	<!-- Spring Boot(HTML), Spring Legacy(JSP) JSTL-->
	<% int num = 100; %><!-- 자바코드 이용해서 변수 선언 : 가독성 떨어짐 -->
	<c:set var="num1" value="200" /> <!-- jstl을 이용한 변수 선언 -->
	<p>자바로 만든 변수 EL 문법으로 출력 : ${num} 안됨</p>
	<p>JSTL로 만든 변수 출력 : ${num1}</p>
	
	<c:set var="num2" value="300" /> <!-- jstl을 이용한 변수 선언 -->
	<c:set var="num3" value="8123354" /> <!-- jstl을 이용한 변수 선언 -->
	<p>num1과 num2의 합 : ${num1 + num2}</p>
	<p>num1과 num2의 합 : ${num2 + num3}</p>
	
	
	
</body>
</html>