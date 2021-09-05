<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>로그인 JSP</title>
</head>
<body>
	<h3>로그인 JSP</h3>
	<hr>
<% request.setCharacterEncoding("EUC-KR"); %>
<%
	String mid = request.getParameter("mid");
	String mpw = request.getParameter("mpw");
	
	System.out.println("mid >>> : " + mid);
	System.out.println("mpw >>> : " + mpw);
	
	if ("abc".equals(mid) && "abc1234".equals(mpw)){
%>
		<script>
			alert("로그인 성공");
			location.href="http://localhost:8088/testWeb/html_1/formTest_1.html";
		</script>
<%		
	}else{
%>
		<script>
			alert("로그인 실패");
			history.go(-1);
		</script>
<%
	}
%>
</body>
</html>