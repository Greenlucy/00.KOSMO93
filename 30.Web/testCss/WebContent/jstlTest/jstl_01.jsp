<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>jstl_01</title>
</head>
<body>
	<h3>jstl_01</h3>
	<hr>
	1. �⺻ ���α׷��� Tag(����, �迭, if, for, switch-case ��) > core<br/>
	<%
		int num = 100;
	%>
	JAVA num : <%= num %><br/>
	
	<%-- JSTL ���� ���� : <c:set ~~> --%>
	<c:set var="su1" value="200" />
	JSTL su1 : ${ su1 }<br/>
	
	<%-- JAVA num ���� JSTL su2�� �Ҵ� --%>
	<c:set var="su2" value="<%= num %>" />
	JSTL su2 : ${ su2 }<br/>
	
	<%-- JSTL su1 ���� su2 ���� ���� �� : result --%>
	<c:set var="result" value="${ su1 + su2 }" />
	JSTL result : ${ result }
</body>
</html>