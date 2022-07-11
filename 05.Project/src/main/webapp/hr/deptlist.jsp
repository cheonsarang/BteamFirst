<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
>>>>>>> d9f14bf55e061a43cdbfa2b9837d14f2f5b3fb2f
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<<<<<<< HEAD
	<%@ include file="/include/layout.jsp"%>
	<div class="container-fluid px-4">

		<h1 class="mt-4">부서 리스트</h1>
		<div class="card-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>부서번호</th>
						<th>부서명</th>
						<th>매니저번호</th>
						<th>지역번호</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${deptlist}" var="dto">
						<tr>
							<td>${dto.department_id}</td>
							<td>${dto.department_name}</td>
							<td>${dto.manager_id}</td>
							<td>${dto.location_id}</td>
						</tr>

					</c:forEach>


				</tbody>
			</table>
		</div>
	</div>

	<%@ include file="/include/footer.jsp"%>
=======
	<%@ include file="/include/layout.jsp" %>
		<div class="container-fluid px-4">
					<h1 class="mt-4";">부서정보 조회</h1>
				         	<div class="card-body">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>부서번호</th>
                                            <th>부서명</th>
                                            <th>관리자ID</th>
                                            <th>지역번호</th>

                                        </tr>
                                    </thead>
      
                                    <tbody>
										<c:forEach items="${list}" var="dto">
                                        <tr>
											<th>${dto.department_id}</th>
											<th>${dto.department_name}</th>
											<th>${dto.manager_id}</th>
											<th>${dto.location_id}</th>
											
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