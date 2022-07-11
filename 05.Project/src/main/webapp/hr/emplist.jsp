<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%@ include file="/include/layout.jsp" %>
	<h1 style="text-align: center">사원 정보 조회</h1>
	<table id="datatablesSimple">
 		
           <thead>
               <tr>
                   <th>사원번호</th>
                   <th>이름</th>
                   <th>이메일</th>
                   <th>핸드폰</th>
                   <th>월급</th>
                   <th>매니저 아이디</th>
                   <th>입사날짜</th>
               </tr>
           </thead>
           <tfoot>
               <tr>
                   <th>사원번호</th>
                   <th>이름</th>
                   <th>이메일</th>
                   <th>핸드폰</th>
                   <th>월급</th>
                   <th>매니저 아이디</th>
                   <th>입사날짜</th>
               </tr>
           </tfoot>
           <tbody>
           <c:forEach items="${list}" var="dto">
               <tr>
                   <td>${dto.employee_id}</td>
                   <td>${dto.last_name}</td>
                   <td>${dto.email}</td>
                   <td>${dto.phone_number}</td>
                   <td>${dto.salary}</td>
                   <td>${dto.manager_id}</td>
                   <td>${dto.hire_date}</td>
               </tr>
            </c:forEach>
           </tbody>
       </table>
                  <%@ include file="/include/footer.jsp" %>
</body>
</html>