<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

=======
<%@	taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<title>Insert title here</title>
</head>
<body>
	<h1>펑션</h1>
	<c:set var="str" value="     Hello Jsp Servlet      "/>
	<p> 일반 EL 문자열 출력 : ${str}</p>
	<p> 대문자로 바꾸기 : ${fn:toUpperCase(str)} </p>  
	<p> 소문자로 바꾸기 : ${fn:toLowerCase(str)} </p>
	<p> 문자열의 길이 : ${fn:length(str) }</p>
=======
<title>펑션태그</title>
</head>
<body>
	<h1>펑션태그 사용</h1>
	<c:set var="str" value="  Hello Jsp Servlet  "/>
	<p>일반 EL 문자열 출력 : ${str}</p>
	<p>대문자로 바꾸기 : ${fn:toUpperCase(str)}</p>
	<p>소문자로 바꾸기 : ${fn:toLowerCase(str)}</p>
	<p>문자열의 길이 : ${fn:length(str)}</p>
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
	<p> 공백을 제거 : ${fn:trim(str) }</p>
	<p> 공백을 제거후 길이 : ${fn:length( fn:trim(str) )}</p>
	<p> Jsp문자를 JAVA로 바꿔보기 : ${fn:replace(str , "Jsp" , "JAVA") } </p>
</body>
</html>