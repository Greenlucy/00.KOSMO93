<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>Insert</title>
</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	INSERT
	<%
		Object obj = request.getAttribute("nCntI");
		int nCntI = ((Integer)obj).intValue();
		
		if (nCntI > 0){
			System.out.println("nCntI >>> : " + nCntI + " �� ��� �Ϸ�");
	%>
		<script>
			location.href="/testJso/notice?ISUD_TYPE=SALL";
		</script>
	<%
		}else{
			System.out.println("controller�κ��� noticeInsert.jsp�� ������ �� �Ѿ��");
		}
	%>
</body>
</html>