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
	JSP ��� : <%= sum %><br/>
	<%-- sum �� �޾ƿͼ� EL�� ��� �ƹ��͵� �� �� --%>
	EL ��� : ${ sum }
</body>
</html>