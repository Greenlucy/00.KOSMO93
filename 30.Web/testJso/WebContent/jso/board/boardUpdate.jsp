<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="a.b.c.com.jso.board.vo.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>글 수정 </title>
</head>
<body>
	<% // request의 문자인코딩을 "EUC-KR"로  set 초기화한다.
	request.setCharacterEncoding("EUC-KR"); %>
	<h3>글 수정</h3>
	<%
		Object obj = request.getAttribute("bUpdate");
//		boolean bool = (boolean)obj; : 요거 내가 한건데 아니야!!
		boolean bool = ((Boolean)obj).booleanValue();
		
		if(obj == null){
			return;
		}
		
		if (bool){
			System.out.println("수정 성공 bool >>> : " + bool);		
	%>
		<script>
			location.href="/testJso/board?ISUD_TYPE=SALL";
		</script>
	<%
		}else{
			System.out.println("수정 실패 bool >>> : " + bool);
			// form 태그에서 hidden 타입의 ISUD_TYPE 잘 넘기세요 !!! 출력됌
			// 요게 아니던데.. 다시 방금 페이지로 돌아가게는 어떻게 하지..?
		//	for (int i=0; i < 1; i++){
		//		break;
		//	}
		}
	%>
</body>
</html>