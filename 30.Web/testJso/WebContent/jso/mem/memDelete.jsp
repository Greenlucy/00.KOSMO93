<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>Delete</title>
</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	DELETE
	<%
		Object obj = request.getAttribute("boolD");
		boolean boolD = ((Boolean)obj).booleanValue();
		
		if (boolD){
	%>
		<script>
			location.href="/testJso/member?ISUD_TYPE=SALL";
		</script>
	<%
		}
	%>
</body>
</html>