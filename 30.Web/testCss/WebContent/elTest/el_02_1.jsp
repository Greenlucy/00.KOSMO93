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
	1부터 100까지의 누적합(JSP) : <%= sum %><br/>
	1부터 100까지의 누적합(EL) : ${sum }	
</body>
</html>