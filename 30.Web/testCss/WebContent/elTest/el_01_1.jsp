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
	JSP 출력 : <%= sum %><br/>
	EL 출력 : ${ sum }<br/>
	EL 출력 : $ { sum }
</body>
</html>