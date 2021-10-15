<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Spring POST</title>
</head>
<body>
<h3>Spring POST</h3>
<hr>
<h3>${post_msg} </h3>
<%
	String post_msg1 = String.valueOf(request.getAttribute("post_msg"));
	System.out.println("post_msg1 >>> : " + post_msg1);
	out.println("post_msg1 >>> : " + post_msg1);
%>
</body>
</html>