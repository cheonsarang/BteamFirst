<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		Ex02_ResLogin 이라는 맵핑을 입력받으면 Ex02_ResLogin.jsp까지 이동하는 서블릿을 만들기
		http://localhost/imo/Ex02_ResLogin 이라는 맵핑을 입력받으면  
		Ex02_ResLogin.jsp까지 이동하는 서블릿을 만든다.
		
		URL을 통해서 파라메터 id와 pw를 입력받는다. id가 admini이고 pw admin1234이면
		a태그를 이용해서 성공 이라고 출력(HTML)
		그외에는 실패라고 출력 
	 -->
	 
	 <!-- ※※Forward(파라메타나 어떤 넘겨줄 값을 보내줄 수가 있음 다음페이지로)
	 	  	Response(어떠한 파라메터도 못보내고 강제로 페이지를 전환) -->
	 
	 <!-- Attribute -->
<%-- 	 <%
	 	if(request.getAttribute("id").equals("admin")&&request.getAttribute("pw").equals("admin1234")) {%>
	 		<a>성공</a>
	 	<%} else {%>
	 		<a>실패</a>
	 		
	 	<% }%>
	  --%>
	 
	 <!-- Cookie (Response를 통해 페이지 전환 일어났을 때 또는 일정시간 후 어떤 데이터를 삭제해야하는 상황 등등에서 사용할 수 있는 데이터 공간 -->
	 
	 <!-- param 
	 	  url = http://localhost/imo/Ex02_ResLogin?id=admin&&pw=admin1234 -->
	 <%
	 	if(request.getParameter("id") != null &&
				request.getParameter("pw") != null &&
				request.getParameter("id").equals("admin") &&
				request.getParameter("pw").equals("admin1234")) {%>
	 		<!-- <a>성공</a> -->
	 		<% response.sendRedirect("Ex02_Response/Ex02_Success.jsp"); 
	 		 Cookie cookie = new Cookie("id","admin");
	 		response.addCookie(cookie);//응답객체에 쿠키(임시데이터저장)을 추가함
	 		
	 		%>
	 		
	 	<%} else {%>
	 		<!-- <a>실패</a> -->
	 		<% response.sendRedirect("Ex02_Response/Ex02_Failed.jsp"); %>
	 		
	 	<% }%>
	 
</body>
</html>