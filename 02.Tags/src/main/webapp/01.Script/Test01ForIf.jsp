<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- for, if 문 중첩 / 1 ~ 100까지의 수 중 짝수의 합, 홀수의 합 출력
	짝수도 출력, 홀수도 출력 -->
	
	<% int i = 0; 
		int oddsum = 0; 
		int evensum = 0; %>
	
	<%for(i = 1; i <= 100; i++) {%>
		<%if(i % 2 == 0) {%>
			<p style = "color:red"; font-size = 3px;><%= i %></p>
			<%evensum  += i;%>
		<%}else{%>
			<p style = "color:blue"><%= i %></p>
			<%oddsum += i; %>
		<%}%>
	<%}%>
	짝수의 합 : <%= evensum %>
	홀수의 합 : <%= oddsum %>
</body>
</html>