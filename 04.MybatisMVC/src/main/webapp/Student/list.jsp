<%@page import="student.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 보기</title>
</head>
<body>
<%@ include file = "/include/header.jsp"  %>
	<!-- 학생의 이름 student_no student_name,  user_id, user_pw, first_name, last_name -->
	<h1>학생정보를 보여줍니다</h1>
	<table class="stu">
	<tr>
		<th>번호</th>
		<th>학생이름</th>
		<th>아이디</th>
		<th>성</th>
		<th>이름</th>
	</tr>
	
	
	
	<% 
	ArrayList<StudentDTO> list = (ArrayList<StudentDTO>)request.getAttribute("list");
	for(int i = 0; i < list.size(); i++) {%>
		<tr>
			<td><a href="detail.st?student_no=<%=list.get(i).getStudent_no() %>&user_id=<%=list.get(i).getUser_id()%>"><%=list.get(i).getStudent_no() %></a></td>
			<td><a href="detail.st"><%= list.get(i).getStudent_name()%></a></td>
			<td><a><%= list.get(i).getUser_id()%></a></td>
			<td><a><%= list.get(i).getFirst_name()%></a></td>
			<td><a><%= list.get(i).getLast_name()%></a></td>
			<td>
			<form action="detail.st" method="get">
				<input type="hidden" name = "student_no()" value="<%= list.get(i).getStudent_no() %>"/>
				<input type="hidden" name= "user_id" value="<%= list.get(i).getUser_id() %>"/>
				<input type="submit" value="<%= "detail.st로 요청" %>"/>
			
			</form>
			</td>
		</tr>
	<%}%>
	</table>
	<%@ include file = "/include/footer.jsp"  %>
</body>
</html>