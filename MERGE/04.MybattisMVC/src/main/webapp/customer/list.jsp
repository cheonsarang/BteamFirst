<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객정보보기</title>
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
	<%@ include file="/include/header.jsp"%>
		<h1>고객관리 모듈</h1>

<%-- 	<%=list.size() %>  list의 사이즈 1이상 들어왔는지 체크 --%>
	<h1 style="text-align: center;"> 고객 정보 조회</h1>

	<table class="styled-table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>이메일</th>
				<th>핸드폰</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<CustomerDTO> list =(List<CustomerDTO>) request.getAttribute("list");
		for(int i = 0 ;  i<list.size(); i ++){
	%>
			<tr>
				<td><a> <%=list.get(i).getId() %></a></td>
				<td><a> <%=list.get(i).getName()%></a></td>
				<td><a> <%=list.get(i).getGender()%></a></td>
				<td><a> <%=list.get(i).getEmail()%></a></td>
				<td><a> <%=list.get(i).getPhone()%></a></td>
			
			</tr>
			
			<%} %>
		</tbody>
	</table>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>