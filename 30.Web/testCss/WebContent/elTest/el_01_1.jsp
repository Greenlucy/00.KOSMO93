<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    	int sum = 0;
    	for(int i=1; i <= 100; i++){
    		sum += i;
    	}
    	
    	pageContext.setAttribute("sum", sum);
    %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>el_01_1</title>
</head>
<body>
	<h3>el_01_1</h3>
	<hr>
	JSP ��� : <%= sum %><br/>
	EL ��� : ${ sum }<br/>
	EL ��� : $ { sum }
</body>
</html>