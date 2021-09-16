<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>글 삭제</title>
</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	<h3>글 삭제</h3>
	<% 
	Object obj = request.getAttribute("boolD"); 
	
	boolean bool = ((Boolean)obj).booleanValue();
	
	if (obj == null){
		return;
	}
	
	if (bool){
		System.out.println("글 삭제 성공 !!!");
	%>
		<script>
			location.href="/testJso/board?ISUD_TYPE=SALL";
		</script>
	<%
	}else{
		System.out.println("글 삭제 실패 !!!");
	}
	%>
</body>
</html>