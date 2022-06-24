<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>반복문을 써 봅시다</h1>
	<!-- for문으로 p태그 30개 -->
	
	<%! String a = "와우"; %>
	
	<% for(int i = 0; i < 30; i++) {%>
		<p>찍음 인덱스()</p>
		<%= a %>
	<%}%>
	
</body>
</html>