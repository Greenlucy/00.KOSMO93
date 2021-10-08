<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    	int sum = 0;
    	for (int i=1; i <= 100; i++){
    		sum += i;
    	}
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>el_01</title>
</head>
<body>
	<h3>el_01</h3>
	<hr>
	JSP 출력 : <%= sum %><br/>
	<%-- sum 못 받아와서 EL은 출력 아무것도 안 됨 --%>
	EL 출력 : ${ sum }
</body>
</html>