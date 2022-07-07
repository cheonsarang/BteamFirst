<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
=======
<%@page import="customer.CustomerDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL 태그를 이용하기 위한 준비 ↑  -->
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#new_btn{
		position: fixed;
		right: 20%;
		top: 20%;
		z-index: 999;
	}

</style>
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<<<<<<< HEAD
	<h1>JSTL 사용</h1>
	<p>JSP 개발을 좀 더 편하고 단순화하기 위한 태그 library(JSP Standard Tag Library)</p>
	<a href="listfmt.js"> 포맷태그 </a> <!--  listfmt.jsp 파일을 만들고 해당하는 파일로 연결되게 (Controller)처리 -->
	<a href="listfn.js"> 펑션태그 </a> <!--  listfmt.jsp 파일을 만들고 해당하는 파일로 연결되게 (Controller)처리 -->
	
	<h3>CORE(jstl/core)</h3>
	<!-- 내가 사용할 기능이 들어있는 library를 taglib태그를 통해서 추가한다.  -->
	<!-- Spring Boot(HTML) 타임리프 , Spring Legacy(JSP) JSTL  -->
	<% int num= 100; %><!-- 자바코드 이용해서 변수선언  -->
	<c:set var="num1" value="200" /> <!-- JSTL을 이용한 변수 선언  -->
	<p>자바로 만든 변수 EL문법으로 출력 : ${num}</p>
	<p>JSTL로 만든 변수 출력 : ${num1}</p>
	<c:set var="num2" value="300" /> <!-- JSTL을 이용한 변수 선언  -->
	
	<p>num1과num2의 합 : ${num1 + num2 }</p>
	
	<!-- attribute(req)에 들어있는 값을 판단해서 사용을 해야 금방 익숙해짐  -->
	<h1> 코어 choose</h1>
	<c:choose>
		<c:when test="${num1 == 200 }">
			<a>200이맞습니다 </a>
		</c:when>
		<c:when test="${num1 != 200 }">
			<a>200이 아닙니다 </a>
		</c:when>
		<c:otherwise>
			<a>test</a>
		</c:otherwise>
	</c:choose>
	<h1> 코어 if</h1>
	<c:if test="${num1 == 200 }">
		<p>200이랑 같습니다 if</p>
	</c:if>
	<h1> 코어 foreach</h1>
	<!--  ↑ 데이터가 한건 이상일때는 collection 자료구조를 사용하기때문에 안쪽에 있는 Object를 빼내올때 유용하다. -->
	<% for(int i = 0 ; i <= 10 ; i ++){ %>
		<p><%=i%> 자바 FOR문을 이용한 반복문</p>
		
	<% } %>
	<c:forEach var="i" begin="0" end="10">
		<p>${i} 자바 FOR문을 이용한 반복문</p>		
	</c:forEach>
	
	<!-- 1. 구구단 출력해보기 (2단) ↑Core 처음 c:forEach가 어렵다면 자바 문법으로 완성 후 변경 -->
	<!-- 2. 구구단 출력해보기 (2단~9단) -->
	<c:forEach var="i" begin="1" end="9">
		<p> 2 * ${i} = ${2*i}</p>
	</c:forEach>
	<c:forEach var="i" begin="1" end="9"> <!-- 2 * 1 , 2 * 2   -->
		<c:forEach var="j" begin="2" end="9">
			<p> ${j} * ${i} = ${i*j}
		</c:forEach>
	</c:forEach>
	
	
	<%-- <c:if test="${num1 == 200 }">
		<a>200</a>
	</c:if>
	
	<c:if test="${num1 != 200 }">
		<a>200</a>
	</c:if> --%>
	
	
=======
<!-- $<-동적으로 request에 있는 자원에 접근해서 사용
  -->
	<%@ include file="/include/header.jsp"%>
	<h1>고객관리 모듈(JSTL)</h1>
	<button type="button"  id="new_btn" class="btn btn-primary" onclick="showModal();" >신규 고객 추가</button>
	
	<table class="styled-table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>이메일</th>
				<th>핸드폰</th>
				<th>수정</th>
			</tr>
		</thead>
		<tbody>
	
	<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.id}</td>
			<td>${dto.name}</td>
			<td>${dto.gender}</td>
			<td>${dto.email}</td>
			<td>${dto.phone}</td>
			<td>
			<!-- EL문법으로 showModal에 파라메터를 하나 전송 전송 된 파라메터를 alert 으로 출력 -->
			<button type="button"  class="btn btn-secondary" onclick="showModal('${dto.id}','${dto.name}','${dto.email }','${dto.phone }','${dto.gender }');" >정보 수정</button>
			</td>

		</tr>
	</c:forEach>
	
			</tbody>
	</table>
	
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">고객 추가</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">이름</label>
            <input type="text" name="name" class="form-control" id="recipient-name">
          </div>
           <div class="mb-3">
            <label for="recipient-name" class="col-form-label">성별</label>
            <input type="radio" checked="checked" name="gender" value="남" />남
            <input type="radio" name="gender" value="여" />여
          </div>
           <div class="mb-3">
            <label for="recipient-name" class="col-form-label">이메일</label>
            <input type="text" name="email" class="form-control" id="recipient-name">
          </div>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">핸드폰</label>
            <input type="text" name="phone" class="form-control" id="recipient-name">
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary" name="submit" onclick="addCustomer();">추가</button>
      </div>
    </div>
  </div>
</div>
	
	
	<%@ include file="/include/footer.jsp"%>
	
	<script type="text/javascript">
		function showModal() {
			$('#exampleModal').modal('show');//hide 숨김
			$('[name=submit]').attr('onclick' ,'addCustomer()');
		}
		function showModal(id , name , email , phone , gender) {
			$('[name=submit]').attr('onclick' ,'modifyCustomer()');
			 $('[name=name]').val(name);
			/* 보류 => jquery로 나중에 처리  
			if(gender == '남'){
				 $('[name=gender]')[0].attr('checked' , false);
				 $('[name=gender]')[1].attr('checked' , false);
			 }else{
				 
			 } */
			//  $('[name=gender]').val('');
			  $('[name=email]').val(email);
			  $('[name=phone]').val(phone);
			  
			  $('#exampleModal').modal('show');
		}
		function addCustomer() {
			/* alert( $('[name=name]').val() );  jquery를 이용해서 name속성이 name의 값을 가져옴*/
			/* ajax<-통신 이용해서 insert.cu를 만들고 해당하는 Servlet까지 값을 전송해보기  */
			var gender = $('[name=gender]:checked').val();
			$.ajax({
				url: 'insert.cu',
				data: {/*request.getParameter로 받아줄것(name) : <- 넣어줄 실제값   */
					  name:$('[name=name]').val(),
					  gender:gender,
					  email:$('[name=email]').val(),
					  phone:$('[name=phone]').val()
					  },
				success: function ( response) {
					  $('[name=name]').val('');
					  $('[name=gender]').val('');
					  $('[name=email]').val('');
					  $('[name=phone]').val('');
				},error: function (req,msg) {
					alert(msg + " : ");
				}	  
			});
			
			location.reload();
			$('#exampleModal').modal('hide');
			
		}
		/*  addCustomer 평션을 만들고 input type에 들어있는 값들을 콘솔 또는 alert이용해서 띄워보기*/
	</script>
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
	
	
</body>
</html>