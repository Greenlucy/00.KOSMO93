<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ۼ���</title>
</head>
<body>
<h3>�ۼ���</h3>
<hr>
<%
	Object obj = request.getAttribute("bUpdate");
	if (obj == null) return;
		
	boolean bool = ((Boolean)obj).booleanValue();
	
	if (bool){
		System.out.println("���� ����  bool >>> : " + bool);
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