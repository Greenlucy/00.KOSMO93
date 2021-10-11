<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>jstl_02</title>
</head>
<body>
	<h3>jstl_02</h3>
	<hr>
	<%-- JSTL 변수 선언 : <c:set ~~> 
		코드 : abc001
		제품명 : 컴퓨터
		가격 :				scope="request" 를 안 하면, 브라우저에 value가 출력되지 않음
	--%>
	<c:set var="code" value="abc001" scope="request" />
	<c:set var="name" value="컴퓨터" scope="request" />
	<c:set var="price" value="5000000" />
	<jsp:forward page="jstl_02_1.jsp" />
</body>
</html>