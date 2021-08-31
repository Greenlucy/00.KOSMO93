<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>getData JSP</title>
</head>
<body>
<!-- 
	http://localhost:8088/testWeb/html_1/getData_1.html?mname=1111&maddr=2222
 -->
 <%
 	System.out.println(request.getRemoteAddr());
 	System.out.println(request.getRemoteAddr());
 	String mname = request.getParameter("mname");	// mname=1111 &
 	String maddr = request.getParameter("maddr");	// maddr=2222
 	out.println("mname >>> : " + mname);
 	out.println("maddr >>> : " + maddr);
 	System.out.println("mname >>> : " + mname);
 	System.out.println("maddr >>> : " + maddr);
 %>
</body>
</html>