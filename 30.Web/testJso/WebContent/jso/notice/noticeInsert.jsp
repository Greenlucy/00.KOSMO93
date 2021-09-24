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
			System.out.println("nCntI >>> : " + nCntI + " 건 등록 완료");
	%>
		<script>
			location.href="/testJso/notice?ISUD_TYPE=SALL";
		</script>
	<%
		}else{
			System.out.println("controller로부터 noticeInsert.jsp로 데이터 안 넘어옴");
		}
	%>
</body>
</html>