<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>�� ����</title>
</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	<h3>�� ����</h3>
	<% 
	Object obj = request.getAttribute("boolD"); 
	
	boolean bool = ((Boolean)obj).booleanValue();
	
	if (obj == null){
		return;
	}
	
	if (bool){
		System.out.println("�� ���� ���� !!!");
	%>
		<script>
			location.href="/testJso/board?ISUD_TYPE=SALL";
		</script>
	<%
	}else{
		System.out.println("�� ���� ���� !!!");
	}
	%>
</body>
</html>