<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�۵��</title>
</head>
<body>
<h3>�۵��</h3>
<hr>
<%
	Object obj = request.getAttribute("bInsert");
	if (obj == null) return;
		
	boolean bool = ((Boolean)obj).booleanValue();
	
	if (bool){
		System.out.println("�Է� ����  bool >>> : " + bool);
%>
		<script>
			location.href="/testKosmo/board?ISUD_TYPE=SALL";
		</script>
<%		
	}else{
		
	}
%>
</body>
</html>