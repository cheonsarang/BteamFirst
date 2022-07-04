<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		JSP에서 제공하는 내장 객체들을 사용해보기
		
		
	 -->
	 
	
	
	<%
		String pageCtx = (String)pageContext.getAttribute("pageCtx");	//param(String), attribute(Object)이기때문에 캐스팅 필요함
		String req = (String)request.getAttribute("req");
		String sSession = (String)session.getAttribute("session");
		String sApp = (String)application.getAttribute("app");
	%>
	
	<p><%= pageCtx %></p>
	<p><%= req %></p>
	<p><%= sSession %></p>
	<p><%= sApp %></p>
	
</body>
</html>