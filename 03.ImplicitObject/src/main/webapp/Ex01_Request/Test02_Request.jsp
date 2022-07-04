<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../Test02_Request" method="get">
		<input type="text" name="id"  placeholder="아이디를 입력하세요.">
		<input type="text" name="pw" placeholder="비밀번호를 입력하세요.">
		<input type="submit" value="전송하기">
		<!-- form태그 안쪽에 있는 태그에 값을 전송(HTML) => 태그의 이름을 key값으로 사용
		
		  -->
	</form>
</body>
</html>