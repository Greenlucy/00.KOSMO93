<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>jstl_10</title>
</head>
<body>
	<h3>jstl_10</h3>
	<hr>
	<c:set var="date" value="<%= new Date() %>" />
	<h3>날짜와 시간의 기본적인 표시 : ${ date }</h3>
	오늘의 날짜 : <fmt:formatDate value="${ date }" type="date" /><br/>
	현재의 시각 : <fmt:formatDate value="${ date }" type="time" /><br/>
	날짜와 시각 : <fmt:formatDate value="${ date }" type="both" /><br/>
	Short : <fmt:formatDate value="${ date }" type="both" dateStyle="short" timeStyle="short" /><br/>
	Medium : <fmt:formatDate value="${ date }" type="both" dateStyle="medium" timeStyle="medium" /><br/>
	Long : <fmt:formatDate value="${ date }" type="both" dateStyle="long" timeStyle="long" /><br/>
	Full : <fmt:formatDate value="${ date }" type="both" dateStyle="full" timeStyle="full" /><br/>
	Pattern1 : <fmt:formatDate value="${ date }" type="date" pattern="yyyy년 MM월 dd일(E)" /><br/>
	Pattern2 : <fmt:formatDate value="${ date }" type="time" pattern="(a) hh시 mm분" /><br/>
	<%--
		(브라우저에 출력된 정보)
		날짜와 시간의 기본적인 표시 : Mon Oct 11 15:40:17 KST 2021
		오늘의 날짜 : 2021. 10. 11							type="date"
		현재의 시각 : 오후 3:40:17							type="time"
		날짜와 시각 : 2021. 10. 11 오후 3:40:17				type="both"
		Short : 21. 10. 11 오후 3:40						(date, timeStyle="short" 분까지만)
		Medium : 2021. 10. 11 오후 3:40:17					(date, timeStyle="medium" 2021표시 / 초까지만)
		Long : 2021년 10월 11일 (월) 오후 3시 40분 17초			(date, timeStyle="long" 년,월,일(요일) 표시 / 시,분,초 단위까지)
		Full : 2021년 10월 11일 월요일 오후 3시 40분 17초 KST		(date, timeStyle="full" 년,월,일,요일 표시 / KST까지)
		Pattern1 : 2021년 10월 11일(월)						패턴 설정에 따라 : yyyy년 MM월 dd일(E)
		Pattern2 : (오후) 03시 40분						패턴 설정에 따라 : (a) hh시 mm분
	 --%>
	
	<br/><hr/><br/>
	<%
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
	%>
	JAVA : <%= now %><br/>
	JAVA Format : <%= sdf.format(now) %>
	<%--
		(브라우저에 출력된 정보)
		JAVA : Mon Oct 11 15:40:17 KST 2021
		JAVA Format : 2021년 10월 11일 15시 40분 17초
	 --%>
</body>
</html>