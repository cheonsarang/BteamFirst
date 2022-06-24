<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>if문 사용해보기</h1>
	<!-- 전역변수 선언(누적) -->
	<%! int iVar = 3; %>
	
	<!-- 자바로직을 넣을 수 있는 스크립틀릿태그를 이용해 제어문 사용 -->
	<!-- 스크립트 태그 열림, 닫힘 사이는 자바코드 영역, 그 외에는 HTML 영역 -->
	
	<% if(iVar % 2 == 0) {%>
		짝수
	<%}else {%>
		홀수
		<% System.out.print("<br>홀수"); %>
		
	<%}	%>
	
	<%iVar++; if(iVar % 2 == 0){%>
		<br>iVar 는 현재 <%=iVar%> 짝수 입니다.
	<%}else{%>
		<br>iVar 는 현재 <%=iVar%> 홀수 입니다.
	<%}%>
	
</body>
</html>