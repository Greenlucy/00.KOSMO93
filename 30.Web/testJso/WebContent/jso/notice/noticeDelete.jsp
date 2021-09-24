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
		Object obj = request.getAttribute("nCntD");
		int nCntD = ((Integer)obj).intValue();
		
		if (nCntD > 0){
			System.out.println("삭제 성공 !! nCntD >>> : " + nCntD);
	%>
		<script>
			location.href="/testJso/notice?ISUD_TYPE=SALL";
		</script>
	<%
		}else{
			System.out.println("삭제 실패 !!");
		}
	%>
</body>
</html>