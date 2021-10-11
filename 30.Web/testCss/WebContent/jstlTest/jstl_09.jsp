<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>jstl_09</title>
</head>
<body>
	<h3>jstl_09</h3>
	<hr>
	<c:set var="num" value="123456789" />
	<h3>숫자 포맷 : ${ num }</h3>
	형식1 : <fmt:formatNumber value="${ num }" groupingUsed="true"/><br/>
	형식2 : <fmt:formatNumber value="${ num }" groupingUsed="false" /><br/>
	형식3 : <fmt:formatNumber value="${ num }" pattern="#,##0" /><br/>
	형식4 : <fmt:formatNumber value="${ num }" pattern="#,##0개" /><br/>
	<%--
		(브라우저 웹에 출력된 결과)		
		숫자 포맷 : 123456789
		형식1 : 123,456,789		groupingUsed="true"
		형식2 : 123456789			gruopingUsed="false"
		형식3 : 123,456,789		pattern="#,##0"
		형식4 : 123,456,789개		pattern="#,##0개"
	 --%>
	
	
	<h3>기타 포맷 : 통화, 백분율</h3>
	<%-- 통화 기호를 입력할 경우 특수문자 : ㄹ > 한자 --%>
	금액1 : <fmt:formatNumber value="${ num }" type="currency" currencySymbol="￦"/><br/>
	금액2 : <fmt:formatNumber value="${ num }" type="currency" currencySymbol="＄"/><br/>
	금액3 : <fmt:formatNumber value="${ num }" pattern="￦#,##0원" /><br/>
	백분율1 : <fmt:formatNumber value="0.123" type="percent" /><br/>
	백분율2 : <fmt:formatNumber value="0.123" pattern="0.00%" /><br/>
	<%--
		(브라우저 웹에 출력된 결과)
		기타 포맷 : 통화, 백분율
		금액1 : ￦123,456,789		type="currency"
		금액2 : ＄123,456,789		type="currency"
		금액3 : ￦123,456,789원		pattern="￦#,##0원"
		백분율1 : 12%				type="percent"
		백분율2 : 12.30%			pattern="0.00%"
	 --%>
</body>
</html>