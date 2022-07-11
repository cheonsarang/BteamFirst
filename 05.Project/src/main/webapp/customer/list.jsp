<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
=======
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
>>>>>>> d9f14bf55e061a43cdbfa2b9837d14f2f5b3fb2f
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<<<<<<< HEAD
<body>
	<%@ include file="/include/layout.jsp"%>
	<div class="container-fluid px-4">

		<h1 class="mt-4">고객 관리</h1>
		<div class="card-body">
			<table id="datatablesSimple">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>성별</th>
						<th>이메일</th>
						<th>핸드폰</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>성별</th>
						<th>이메일</th>
						<th>핸드폰</th>
						<th>삭제</th>
					</tr>
				</tfoot>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.id}</td>
							<td>${dto.name}</td>
							<td>${dto.gender}</td>
							<td>${dto.email}</td>
							<td>${dto.phone}</td>
							<td><a href="delete.cu?id=${dto.id}">삭제</a>
							</td>
						</tr>

					</c:forEach>


				</tbody>
			</table>
		</div>
	</div>

	<%@ include file="/include/footer.jsp"%>
=======

<body>
	<%@ include file="/include/layout.jsp" %>
		<div class="container-fluid px-4">
					<h1 class="mt-4";">고객정보 조회</h1>
				         	<div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>번호</th>
                                            <th>이름</th>
                                            <th>성별</th>
                                            <th>이메일</th>
                                            <th>핸드폰</th>
                                 			<th>삭제</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                        	<th>번호</th>
                                            <th>이름</th>
                                            <th>성별</th>
                                            <th>이메일</th>
                                            <th>핸드폰</th>
                                            <th>삭제</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
										<c:forEach items="${list}" var="dto">
                                        <tr>
											<th>${dto.id}</th>
											<th>${dto.name}</th>
											<th>${dto.gender}</th>
											<th>${dto.email}</th>
											<th>${dto.phone}</th>
											<th><a href="delete.cu?id=${dto.id}">삭제</a></th>
											
										
										</tr>
								
										</c:forEach>
									
                              
                                    </tbody>
                                </table>
                     		</div>
                       </div>
	<%@ include file="/include/footer.jsp" %>

>>>>>>> d9f14bf55e061a43cdbfa2b9837d14f2f5b3fb2f
</body>
</html>