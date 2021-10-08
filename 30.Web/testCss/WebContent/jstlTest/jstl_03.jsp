<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>jstl_03</title>
</head>
<body>
	<h3>jstl_03</h3>
	<hr>
	<!-- 현재 받아오는 값이 없기 때문에, 아래와 같이 url 창에 입력해주면 값을 확인할 수 있다. -->
	<!-- jstl_03.jsp?num1=100&num2=50 -->
	첫 번째 수 : ${ param.num1 }<br>
	두 번째 수 : ${ param.num2 }<br>
	
	<%-- 
		<c:if test="조건식">
			실행문
		</c:if>
	 --%>
	 최댓값 : <c:if test="${ param.num1 - param.num2 > 0}" > ${ param.num1 } </c:if>
	 	   <c:if test="${ param.num1 - param.num2 < 0}" > ${ param.num2 } </c:if>
	 <br>
	 최솟값 : <c:if test="${ param.num1 - param.num2 > 0}" > ${ param.num2 } </c:if>
	 	   <c:if test="${ param.num1 - param.num2 < 0}" > ${ param.num1 } </c:if>
</body>
</html>