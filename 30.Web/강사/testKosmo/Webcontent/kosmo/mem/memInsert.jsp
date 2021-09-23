<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 등록</title>
</head>
<body>
<h3>회원 등록</h3>
<hr>
<%
	Object obj = request.getAttribute("bInsert");
	if (obj == null) return;
		
	boolean bool = ((Boolean)obj).booleanValue();
	
	if (bool){
		System.out.println("입력 성공  bool >>> : " + bool);
%>
		<script>
			location.href="/testKosmo/mem?ISUD_TYPE=SALL";
		</script>
<%		
	}else{
		
	}
%>
</body>
</html>