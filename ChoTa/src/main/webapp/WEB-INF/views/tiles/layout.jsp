<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix='tiles' %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix='c'%>


<c:choose>
	<c:when test="${category eq 'it'}"><c:set var='title' value='- 소개'/></c:when>
	<c:when test="${category eq 'sp'}"><c:set var='title' value='- 학교'/></c:when>
	<c:when test="${category eq 'sc'}"><c:set var='title' value='- 일정'/></c:when>
	<c:when test="${category eq 'yu'}"><c:set var='title' value='- 소셜스타'/></c:when>
	<c:when test="${category eq 'pl'}"><c:set var='title' value='- 체험활동'/></c:when>
	<c:when test="${category eq 'no'}"><c:set var='title' value='- 공지사항'/></c:when>
	<c:when test="${category eq 'login'}"><c:set var='title' value=''/></c:when>
	<c:when test="${category eq 'join'}"><c:set var='title' value='- 회원가입'/></c:when>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChoTa ${title}</title>
<link rel='stylesheet' type='text/css' 
	href='css/common.css?<%=new java.util.Date()%>'>
<link rel='stylesheet' type='text/css' href='css/member.css?<%=new java.util.Date()%>'>

<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"> 
<link rel='icon' type='image/x-icon' href='img/chota_logo100.png'>
	
<script src='https://code.jquery.com/jquery-3.6.0.min.js'></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/js/all.min.js"></script>
<script src='js/common.js?<%=new java.util.Date()%>'></script>
</head>
<body>
<tiles:insertAttribute name='header'/>
<div id='container'>
<tiles:insertAttribute name='container'/>
</div>
<tiles:insertAttribute name='footer'/>

</body>
</html>