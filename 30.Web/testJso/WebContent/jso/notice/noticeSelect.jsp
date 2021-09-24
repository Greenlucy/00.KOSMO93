<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="a.b.c.com.jso.notice.vo.NoticeVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>Select</title>
	<style type="text/css">
		* {
			margin: 0 auto;
		}
		.align {
			text-align: center;
		}
	</style>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	
		function noticeUpdate(isudType){
			// 수정
			alert("noticeUpdate() 함수 진입 >>> : ");
			
			$("#NoticeSelectForm")
			.attr({
				"action":"/testJso/notice?ISUD_TYPE="+isudType,
				"method":"POST",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		}
		
		function checkAction(actionType){
			// 입력, 전체목록 조회
			alert("checkAction() 함수 진입 >>> : " + actionType);
			if ("I" == actionType){
				location.href="/testJso/jso/notice/notice.html";
			}
			
			if ("SALL" == actionType){
				location.href="/testJso/notice?ISUD_TYPE=SALL";
			} 
			
		}
		
	</script>
</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	SELECT
	<%
		Object obj = request.getAttribute("aListS");
		ArrayList<NoticeVO> aListS = (ArrayList<NoticeVO>)obj;
		int nCnt = aListS.size();
		
		if (nCnt == 1){
			out.println(":::: 조건조회 >>> : " + nCnt + "<br>");
			NoticeVO nvo = aListS.get(0);
			
	%>
		<thead>
			<table>
				<tr>
					<td class="align">NOTICE TEST</td>
				</tr>
			</table>
		</thead>
		<hr><hr>
		<form name="NoticeSelectForm" id="NoticeSelectForm">
			<table border="1">
				<tr>
					<td colspan="20" class="align">
					 	<font size="4" style="Color: blue;">공지 사항</font>
					</td>
				</tr>
				<tr>
					<td>글번호</td>
					<td>
						<input type="text" id="nnum" name="nnum" value="<%= nvo.getNnum() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" id="nsubject" name="nsubject" value="<%= nvo.getNsubject() %>" >
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<input type="text"	id="nmemo" name="nmemo" value="<%= nvo.getNmemo() %>">
					</td>
				</tr>
				<tr>
					<td>사진</td>
					<td>
						<img src="/testJso/fileupload/notice/<%= nvo.getNphoto() %>">
						<input type="file" >
					</td>
				</tr>
				<tr>
					<td>삭제여부</td>
					<td>
						<input type="text" id="deleteyn" name="deleteyn" value="<%= nvo.getDeleteyn() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>등록일</td>
					<td>
						<input type="text" id="insertdate" name="insertdate" value="<%= nvo.getInsertdate() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>수정일</td>
					<td>
						<input type="text" id="updatedate" name="updatedate" value="<%= nvo.getUpdatedate() %>" readonly>
					</td>
				</tr>
	<%
		} // end of if
	%>
				<tr>
					<td colspan="2" align="right">
						<input type="hidden" id="ISUD_TYPE" name="ISUD_TYPE" value="">
						<input type="button" value="수정" onclick="noticeUpdate('UOK')">
						<input type="reset" value="취소">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="입력" onclick="checkAction('I')">
						<input type="button" value="목록" onclick="checkAction('SALL')">
					</td>
				</tr>
			</table>
		</form>
	
</body>
</html>