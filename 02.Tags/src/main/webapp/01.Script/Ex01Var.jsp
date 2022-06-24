<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 전역변수 만들어보기 / String, double, String[] 배열 4개 이상의 크기(배열내용 : T, E, S, T)-->
	<%! int vInt = 145; 
		double num = 1.4;
		String str = "롸";
		String[] list = {"T", "E", "S", "T"};%>
	
	<!-- 지역 변수 -->
	<% int lvInt = 10; 
		vInt ++;
		lvInt ++;
	%>

	<!-- 전역변수 표현해보기 -->
	<p>vInt 값 <%=vInt %> lvInt 값 <%=lvInt %></p>
	<p>num 값 <%=num %></p>
	<p>str 값 <%=str %></p>
	<p>list 값 <%=list[0]%><%=list[1]%><%=list[2]%><%=list[3]%></p>
</body>
</html>