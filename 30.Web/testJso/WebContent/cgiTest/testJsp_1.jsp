<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 
	없어도 되지만, 있으면 최상단에 있어야 함
	page : page 디렉티브
	language="java" : 이 페이지에서 사용하는 언어는 자바입니다.
	
	contentType : 현재 jsp 문서의 문서형태와 인코딩 설정
	text/html : MIME : 이 현재 페이지는 html 형식을 하고 있다.
	MIME : Multipurpose Internet Mail Extensions : 전자우편을 위한 인터넷 표준 포맷.
			파일의 포맷 및 인코딩 설정 표시
	charset="EUC-KR" : 현재 jsp 페이지의 인코딩이 EUC-KR이다.
	pageEncoding : 페이지 인코딩부터 해야 함
 -->
 
 <!-- jsp 파일에 객체를 불러오기 (import 하기) -->
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<!-- 
	이 페이지의 html의 인코딩이 EUC-KR이다.
 -->
	<meta charset="EUC-KR">
	<title>jsp 태그들</title>
</head>
<body>
	<h3>JSP 태그(요소, 엘리먼트) 사용법</h3>
	<hr>
	<%-- jsp 주석 : 웹브라우저(클라이언트 서버)로 넘어가지 않는다. f12 콘솔창에서도 보이지 않는다. --%>
	<!-- Scriptlet : 스크립틀릿 요소(태그, 엘리먼트) -->
	<%
		out.println("요기는 스크립틀릿 영역이다. <br>");
		out.println("자바 코드를 구현하면 된다. <br>");
		out.println("1. jsp 내장형 오브젝트 : request, response <br>");
		out.println("2. Servlet 코드 <br>");
		out.println("3. java 코드 <br>");
		out.println("4. 프로그램 실행 결과만 클라이언트로 응답한다. <br>");
				
		out.println("out.println(); 밖에 new Date() 출력 원하는 위치 <br>"); new Date();		// new Date() 하면 맨 마지막에 출력된다.		
		out.println("out.println(); 사용하여 new Date() 원하는 위치에 출력 >>> : " + new Date() + "<br>");
	%>
	
	<!-- 표현식 요소(태그, 엘리먼트) -->
	<hr>
	<%= "요기는 표현식 영역이다. " %><br>
	<%= "하는 역할은 브라우저에 출력을 담당한다." %><br>
	<%= "스크립틀릿 영역에서 사용하는 out.println() 과 같은 기능이다." %><br>
	<%= new Date() %><br>
	
	<!-- 인쿨르드 디렉티브 요소(태그, 엘리먼트), 파일을 불러오기 : 정적인 기능 -->
	<!-- 메인페이지 footer 용도로 사용한다. -->
	<hr>
	<%@ include file="testJsp.jsp" %>
</body>
</html>