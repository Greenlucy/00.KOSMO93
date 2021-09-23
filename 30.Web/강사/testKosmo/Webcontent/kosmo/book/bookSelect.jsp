<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="a.b.c.com.kosmo.book.service.BookService"%>
<%@page import="a.b.c.com.kosmo.book.service.BookServiceImpl"%>    
<%@page import="a.b.c.com.kosmo.book.vo.BookVO"%>    
<%@page import="java.util.ArrayList"%>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>도서 정보 조회 화면</title>
<style type="text/css">
	* {
		margin: 0 auto;
		text-align: center;
	}
	
	fieldset {
		width: 400px;
	}

	legend {
		font-size: 1.2em;
		/*font-weight: bold;*/
	}

	td {
		padding: 5px;
	}
	
	.attr {
		font-weight: bold;
	}
	
	.align {
		text-align: left;
	}
</style>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	function bookUpdate(actionUpdate){
		console.log("bookUpdate 진입 >>> : " + actionUpdate);
				
		if ('U' == actionUpdate){
			document.bookUpdateForm.action="/testKosmo/book?isudtype=UOK";			
		}
		
		if ('D' == actionUpdate){
			document.bookUpdateForm.action="/testKosmo/book?isudtype=DOK";
		}
		
		document.bookUpdateForm.method="POST";
		document.bookUpdateForm.enctype="application/x-www-form-urlencoded";
		document.bookUpdateForm.submit();		
	}
	
	function checkAction(actionName){
		console.log("actionName 진입 >>> : " + actionName);
		
		if ('I' == actionName){	
			location.href="/testKosmo/kosmo/book/book.html";
		}
		if ('SALL' == actionName){			
			location.href="/testKosmo/book?isudtype=SALL";
		}
	}	
</script>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
SELECT 
<%
	Object obj = request.getAttribute("aList");
	if (obj == null) return;
	
	ArrayList<BookVO> aList = (ArrayList<BookVO>)obj;
	int nCnt = aList.size();	
	out.println(":::: 조회 건수  " + nCnt + " 건");
	
	String bnum = "";
	String btitle = "";
	String bauth = "";
	String isbn = "";	
	String bcomp = "";
	String bprice = "";
	String bqty = "";	
	String bcover = "";
	String deleteyn = "";
	String insertdate = "";
	String updatedate = "";
	
	if (nCnt == 1){
		BookVO bvo = aList.get(0);
		
		bnum = bvo.getBnum();
		btitle = bvo.getBtitle();
		bauth = bvo.getBauth();
		isbn = bvo.getIsbn();
		bcomp = bvo.getBcomp();
		bprice = bvo.getBprice();
		bqty = bvo.getBqty();
		bcover = bvo.getBcover();
		deleteyn = bvo.getDeleteyn();		
		insertdate = bvo.getInsertdate();
		updatedate = bvo.getUpdatedate();		
	}
%>
<table>
<tr>
<td calspan="2">
<font size="4" color="blue">
	<img src="/testKosmo/img/img_mando/ase.gif" width="25" height="25" alter="image">
	BOOK TEST
</font>
</td>
</tr>
</table>
<hr>
<hr>
<fieldset>
<legend>도서 정보 조회</legend>
<form name="bookUpdateForm" id="bookUpdateForm">
<table border=1>
<tr>
	<td class="attr">도서번호</td>
	<td><input type="text" id="bnum" name="bnum" class="align" value="<%= bnum %>" readonly /></td>
</tr>
<tr>
	<td class="attr">도서명</td>
	<td><input type="text" id="btitle" name="btitle" class="align" value="<%= btitle %>" readonly /></td>
</tr>
<tr>
	<td class="attr">저&nbsp;&nbsp;&nbsp;자</td>
	<td><input type="text" id="bauth" name="bauth"  class="align" value="<%= bauth %>" readonly /></td>
</tr>
<tr>
	<td style="letter-spacing: 3px" class="attr">ISBN</td>
	<td><input type="text" id="isbn" name="isbn"  class="align" value="<%= isbn %>" readonly /></td>
</tr>
<tr>
	<td class="attr">출판사</td>
	<td><input type="text" id="bcomp" name="bcomp"  class="align" value="<%= btitle %>" readonly /></td>
</tr>
<tr>
<td class="attr">단&nbsp;&nbsp;&nbsp;가</td>
<td><input type="number" id="bprice" name="bprice"  class="align" value="<%= bcomp %>" /></td>
</tr>
<tr>
<td class="attr">수&nbsp;&nbsp;&nbsp;량</td>
<td><input type="number" id="bqty" name="bqty"  class="align" value="<%= btitle %>" /></td>
</tr>
<tr>
<td class="attr">표&nbsp;&nbsp;&nbsp;지</td>
<td><input type="text" id="bcover" name="bcover" class="align" value="<%= bcover %>" /></td>
</tr>
<tr>
<td class="attr">삭제여부</td>
<td> 
<input type="text" name="mdeleteyn" id="mdeleteyn" class="align" value="<%= deleteyn %>" disabled  />		      
</td>
</tr>
<tr>
<td class="attr">등록일</td>
<td> 
<input type="text" name="minsertdate" id="minsertdate" class="align" value="<%= insertdate %>" disabled />		      
</td>
</tr>	
<tr> 
<td class="attr">수정일</td>
<td> 
<input type="text" name="mupdatedate" id="mupdatedate" class="align" value="<%= updatedate %>" disabled />		      
</td>
</tr>	 	 
<tr>
	<td colspan="2"> 
		<input type="hidden" name="isudtype" id="isudtype" />	
		<input type="button" value="수정" onclick="bookUpdate('U')"/>
		<input type="button" value="삭제" onclick="bookUpdate('D')"/>
	    <input type="reset" value="취소" />
	    &nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="button" value="입력" onclick="checkAction('I')"/>
		<input type="button" value="목록" onclick="checkAction('SALL');">
	</td>				
</tr>
</table>
</form>
</fieldset>
</html>