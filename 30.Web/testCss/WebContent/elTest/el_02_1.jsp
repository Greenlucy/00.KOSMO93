<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    //	int sum = (int) request.getAttribute("sum");
    	Integer sum = (Integer) request.getAttribute("sum");
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>el_02_1</title>
</head>
<body>
	<h3>el_02_1</h3>
	<hr>
	1���� 100������ ������(JSP) : <%= sum %><br/>
	1���� 100������ ������(EL) : ${sum }	
</body>
</html>