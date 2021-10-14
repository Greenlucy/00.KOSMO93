<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>helloWorld_post</title>
</head>
<body>
	<h3>${ post_msg }</h3>
	<hr>
	<%
		String post_msg = String.valueOf(request.getAttribute("post_msg"));
		System.out.println("post_msg >>> : " + post_msg);
		out.println("post_msg >>> : " + post_msg);
	%>
</body>
</html>