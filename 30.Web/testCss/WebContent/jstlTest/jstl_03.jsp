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
	<!-- ���� �޾ƿ��� ���� ���� ������, �Ʒ��� ���� url â�� �Է����ָ� ���� Ȯ���� �� �ִ�. -->
	<!-- jstl_03.jsp?num1=100&num2=50 -->
	ù ��° �� : ${ param.num1 }<br>
	�� ��° �� : ${ param.num2 }<br>
	
	<%-- 
		<c:if test="���ǽ�">
			���๮
		</c:if>
	 --%>
	 �ִ� : <c:if test="${ param.num1 - param.num2 > 0}" > ${ param.num1 } </c:if>
	 	   <c:if test="${ param.num1 - param.num2 < 0}" > ${ param.num2 } </c:if>
	 <br>
	 �ּڰ� : <c:if test="${ param.num1 - param.num2 > 0}" > ${ param.num2 } </c:if>
	 	   <c:if test="${ param.num1 - param.num2 < 0}" > ${ param.num1 } </c:if>
</body>
</html>