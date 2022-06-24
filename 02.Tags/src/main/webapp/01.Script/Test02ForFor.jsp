<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		margin: 10px;
	}



</style>
</head>
<body>
	<!-- 구구단 출력 / table 이용 -->
	
	<table border="1">
<%		for(int i=2;i<10;i++)
		{
%>
		<%} %>
</tr>
<%		for(int i=0;i<9;i++)
		{
		%>
<tr>
	<%	for(int j=0;j<8;j++)
		{
		%>
		<td><%=j+2%> * <%=i+1 %> = <%=(j+2)*(i+1) %></td>
	<%}%>
	</tr>
	<%}%>
	
	
	
	
		<table border="1">

<%		for(int i=2;i<10;i++)
		{
		%>
<tr>
	<%	for(int j=1;j<10;j++)
		{
		%>
		<td><%=i%> * <%=j%> = <%=(i)*(j) %></td>
	<%}%>
	</tr>
	<%}%>
</table>

<table border="1" id = "table1">

<%		for(int i=2;i<10;i++)
		{
		%>
<tr>
	<%	for(int j=1;j<10;j++)
		{
		%>
		<td><%=i%> * <%=j%> = <%=(i)*(j) %></td>
	<%}%>
	</tr>
	<%}%>
</table>




<table border= "1px solid black";>
		<%for(int i = 2 ; i<10; i ++){ %>
			<tr>
				<%for(int j = 1 ; j<10; j ++){ %>
				<td> <%=i %> * <%=j %> = <%=i*j %></td>
				<%} %>
			</tr>
		<%} %>
	</table>
	
	
	<table border= "1px solid black";>
		<%for(int i = 1 ; i<10; i ++){ %>
			<tr>
				<%for(int j = 2 ; j<10; j ++){ %>
				<td> <%=j %> * <%=i %> = <%=i*j %></td>
				<%} %>
			</tr>
		<%} %>
	</table>
	
		<table border= "1px solid black";>
		<%for(int i = 1 ; i<10; i ++){ %>
			<tr>
				<%for(int j = 2 ; j<10; j ++){ %>
				<td style="background: #123456;"> <%=j %> * <%=i %> = <%=i*j %></td>
				<%} %>
			</tr>
		<%} %>
	</table>
</body>
</html>