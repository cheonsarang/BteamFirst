<<<<<<< HEAD
=======
<%@page import="Controller.StudentCotroller"%>
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
<%@page import="student.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<title>Insert title here</title>
<style type="text/css">
	td{
		background: #aaa;
		
	}
</style>

</head>
<body>

	<%@ include file="/include/header.jsp"%>
	
	<h1 style="text-align: center;"> 수정 하기 </h1>
	<% StudentDTO dto =(StudentDTO) request.getAttribute("dto"); //Object , %>
	<form action="modify.st" method="get">
	<input type="hidden" name="student_no" value="<%=dto.getStudent_no()%>">
	<input type="hidden" name="user_id" value="<%=dto.getUser_id()%>">
	<table class="styled-table" border="1">
=======
<title>업데이트</title>
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
		width: 500px;
	}
	
	th, td{
		border: 2px solid #000;
	}
	
	th {
		width: 100px;
		background-color: #999999;
		color: #fff;
	}
	td {
		width: 400px;
	}
	 {
		width: 250px;
	}
	
	a {
		color:black;
	}
	
</style>
</head>
<body>
	<%@include file = "/include/header.jsp" %>
	<!-- new 인스턴스화 하는 거 아님, 이미 있는 정보 빼오면 됨, 캐스팅 꼭 할 것 -->
	<h1 style="text-align: center;"> 수정하기 </h1>
	<% StudentDTO dto =(StudentDTO) request.getAttribute("dto"); //Object , %>
	<form action="modify.st" method="get">
	<input type="hidden" name="student_no" value="<%=dto.getStudent_no() %>"/>
		<input type="hidden" name="user_id" value="<%=dto.getUser_id() %>"/>
	<table>
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
		<thead>
			<tr>
				<th>학생번호</th>
				<td><p><%=dto.getStudent_no()%></p></td>
			</tr>
			<tr>
			<tr>
				<th>아이디</th>
				<td><p><%=dto.getUser_id()%></p></td>
				
			</tr>
			<tr>
			<th>학생이름</th>
				<td><input type="text" name="student_name" value="<%=dto.getStudent_name()%>"> </td>
			</tr>
			<tr>
				<th>성</th>
				<td><input type="text" name="first_name"  value="<%=dto.getFirst_name()%>"></td>
			
			</tr>
			<tr>
				<th>이름</th>
<<<<<<< HEAD
					<td><input type="text" name="last_name" value="<%=dto.getLast_name()%>"></td>
			</tr>
		
		
		</thead>
		<tbody>
				<tr>
					<td><input type="submit" value="수정완료"/>
					</td>
=======
				<td><input type="text" name="last_name" value="<%=dto.getLast_name()%>"></td>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><input type="submit" value="수정완료"></td>
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
					<td><a href="#">삭제하기</a>
					</td>
			
				</tr>
		</tbody>
	</table>
	
	</form>
<<<<<<< HEAD
	<%@ include file="/include/footer.jsp"%>
	
=======
	<%@include file = "/include/footer.jsp" %>
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
</body>
</html>