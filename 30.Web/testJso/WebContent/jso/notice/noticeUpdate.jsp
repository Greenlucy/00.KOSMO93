<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>Update</title>
</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	UPDATE
	<%
		Object obj = request.getAttribute("nCntU");
		if (obj == null){
			return;
		}
		
		int nCntU = ((Integer)obj).intValue();
		if (nCntU > 0){
			System.out.println("���� ���� !! >>> : " + nCntU + " ��");
	%>
		<script>
			location.href="/testJso/notice?ISUD_TYPE=SALL";
		</script>
	<%
		}else{
			System.out.println("���� ���� !! >>> : " + nCntU + " ��");
		}
	%>
</body>
</html>