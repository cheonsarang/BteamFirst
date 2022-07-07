<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/include/header.jsp" %>
	<%
			
	%>
<!--<form  method="get">-->
	 	<form action="/mvc/result.st" method="get"> 
		<label for="id">아이디   : </label>
		<input type="text" name="id" id="id" placeholder="아이디를 입력해주세요"/>
		<label for="pw">비밀번호 : </label>
		<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력해주세요"/>
		<input type="submit" value="제출" />
	</form>
	<%@ include file = "/include/footer.jsp" %>
</body>
</html>