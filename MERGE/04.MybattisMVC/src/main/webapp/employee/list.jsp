<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- JSTL 태그를 이용하기 위한 준비 ↑ -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록조회</title>
<style>
	body {
		display: table;
		margin: 0px auto;
	}
	
	h1 {
		text-align: center;
	}

	table {
		margin: 20px auto;
		border: 2px solid #000;
		border-collapse: collapse;
		text-align: center;
	}
	
	th, td{
		border: 2px solid #000;
		width : 60px;
	}
	
	th {
		background-color: #000;
		color: #fff;
	}
</style>
</head>
<body>
<!-- $← 동적으로 request에 있는 자원에 접근해서 사용
	bean활용해서 사용
 -->
	<%@ include file = "/include/header.jsp" %>
	<h1>사원목록조회</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>GENDER</th>
			<th>EMAIL</th>
			<th>PHONE</th>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.id}</td>
				<td>${dto.name}</td>	
				<td>${dto.gender}</td>	
				<td>${dto.email}</td>	
				<td>${dto.phone}</td>	
			</tr>
		</c:forEach>
	</table>
	<%@ include file = "/include/footer.jsp" %>
</body>
</html>