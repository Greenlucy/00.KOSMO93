<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp</title>
</head>
<body>
Hello Jsp ~~~
<%
	String mid = request.getParameter("mid");
	out.println(mid);
	System.out.println("mid >>> : " + mid);
	String mpw = request.getParameter("mpw");
	out.println(mpw);
	System.out.println("mpw >>> : " + mpw);
%>

</body>
</html>