<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>에러 페이지</h1>
	<%@page errorPage= "Ex02ErrorPage.jsp" %>
	<!-- 에러가 발생할 코드가 있다면 어떤 (다른) 페이지에서 처리할건지 가능 -->
	<!-- 에러만들기 -->
	<% int[] arr = {1, 2, 3, 4}; %>
	<%= arr[8] %>
	
	<% String str = null; int leng = str.length(); %>
</body>
</html>