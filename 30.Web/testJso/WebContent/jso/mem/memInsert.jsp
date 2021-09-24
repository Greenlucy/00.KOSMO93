<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>회원정보 등록</title>
	</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	INSERT
	<%
		Object obj = request.getAttribute("boolI");
		/* 
			Boolean : public final class Boolean
			The Boolean class wraps a value of the primitive type boolean in an object. 
		 	(Boolean 클래스는 객체의 기본 유형 불 값을 래핑합니다.)
		 	In addition, this class provides many methods for converting a boolean to a String and a String to a boolean, as well as other constants and methods useful when dealing with a boolean.
		 	(또한 이 클래스는 불을 문자열로 변환하고 문자열을 불로 변환하기 위한 여러 메서드를 제공할 뿐만 아니라 불을 처리할 때 유용한 기타 상수 및 메서드를 제공합니다.)
		
		 	boolean : primitive type (기본 자료형)
		 	Boolean : reference type (레퍼런스 타입 : 여러 메소드를 제공)
		 	boolean a = null;		// 오류 발생	(boolean은 true 또는 false값만 반환 가능)
		 	Boolean a = null;		// 정상적으로 컴파일 됨
		*/
		// Boolean.booleanValue() : 이 Boolean Object의 값을 boolean primitive(원어, 기본 유형)로 반환합니다.
		boolean bool = ((Boolean)obj).booleanValue();
		
		if (bool){
			System.out.println("memInsert.jsp >>> : 회원정보 등록 성공 !!!");
	%>
	<script>
		// 전체조회로 이동하게 함.(전체목록 조회 위해)
		location.href="/testJso/member?ISUD_TYPE=SALL";
	</script>
	<%
		}else{
			System.out.println("memInsert.jsp >>> : 회원정보 등록 실패 !!!");
		}
	%>
</body>
</html>