<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>Insert title here</title>
	</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	UPDATE
	<%
		Object obj = request.getAttribute("boolU");
		boolean boolU = ((Boolean)obj).booleanValue();
		
		if (boolU) {
	%>
	<script type="text/javascript">
		location.href='/testJso/member?ISUD_TYPE=SALL';
	</script>
	<%
		}else{
			System.out.println("수정 실패 !!");
		}
	%>
</body>
</html>