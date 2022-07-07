<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포맷태그</title>
</head>
<body>
<<<<<<< HEAD
	<h1>포맷태그 사용 </h1>
	<c:set var="date" value="<%=new Date() %>"/>
	<p>현재 시간을 EL로 그냥 표현하기 : ${date }</p>
	<p>오늘의 날짜 FMT태그: <f:formatDate value="${date}" type="date"/> </p>
	<p>오늘의 날짜 FMT태그: <f:formatDate value="${date}" type="time"/> </p>
	<p>오늘의 날짜 FMT태그: <f:formatDate value="${date}" type="both"/> </p>
	<p>포맷을 이용한 패턴 : <f:formatDate value="${date}" type="date" pattern="yyyy년 MM월 dd일(E)"/> </p>
	
	<c:set var="num" value="123456789"/>
	<p>현재 숫자를 EL로 그냥 표현하기 : ${num}</p>
	<p>fmt이용 그루핑 사용 : <f:formatNumber value="${num}" groupingUsed="true" /></p>
	<p>fmt이용 그루핑 미사용 : <f:formatNumber value="${num}" groupingUsed="false" /></p>
	<p>fmt이용 패턴 : <f:formatNumber value="${num}" pattern="#,##0" /></p>
	<p>fmt이용 패턴 : <f:formatNumber value="${num}" pattern="#,##0원" /></p>
	
	<!-- 기타포맷 : 통화기호 , 백분율  -->
	<p>금액1 : <f:formatNumber value="${num}" type="currency" /></p>
	<p>금액2 : <f:formatNumber value="${num}" type="currency" currencySymbol="$" /></p>
	<p>퍼센트 : <f:formatNumber value="0.123" type="percent" /></p>
	<p>퍼센트 : <f:formatNumber value="0.123" pattern="0.00%"/></p>
	
	
	
	
=======
	<h1>포맷태그 사용</h1>
	<c:set var="date" value="<%=new Date() %>"/>
	<p>현재 시간을 EL로 표현하기 : ${date}</p>
	<p>오늘의 날짜 FTM태그 : <f:formatDate value="${date}" type="date" /></p>
	<p>오늘의 날짜 FTM태그 : <f:formatDate value="${date}" type="time" /></p>
	<p>오늘의 날짜 FTM태그 : <f:formatDate value="${date}" type="both" /></p>
	<p>포맷을 이용한 패턴 : <f:formatDate value="${date}" type="date" pattern="yyyy년 mm월 dd일(E)"/></p>
	
	<c:set var="num" value="123456789" />
	<p>현재 숫자를 EL로 그냥 표현하기 : ${num}</p>
	<p>FMT이용 그루핑 사용 : <f:formatNumber value="${num}" groupingUsed="true"/></p>
	<p>FMT이용 그루핑 미사용 : <f:formatNumber value="${num}" groupingUsed="false"/></p>
	<p>FMT이용 패턴 : <f:formatNumber value="${num}" pattern="#,##0" /></p>
	<p>FMT이용 패턴 : <f:formatNumber value="${num}" pattern="#,##0원" /></p>
	
	<!-- 기타포맷 : 통화기호, 백분율 -->
	<p>금액1 : <f:formatNumber value="${num}" type="currency" /></p>
	<p>금액2 : <f:formatNumber value="${num}" type="currency" currencySymbol="$" /></p>
	<p>백분율1 : <f:formatNumber value="0.123" type="percent" /></p>
	<p>백분율2 : <f:formatNumber value="0.123" type="percent" pattern="0.00%"/></p>

>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
</body>
</html>