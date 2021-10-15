<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>RETURN JSP</title>
</head>
<body>
<h3>RETURN JSP</h3>
<hr>
<h3>${msg} </h3>
<%
	String msg1 = String.valueOf(request.getAttribute("msg"));
	System.out.println("msg1 >>> : " + msg1);
	out.println("msg1 >>> : " + msg1);
%>
</body>
</html>