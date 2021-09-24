<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="a.b.c.com.jso.notice.vo.NoticeVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>공지사항 전체 조회</title>
	<style type="text/css">
	
		* {
			margin : 0 auto;
		}
		.align {
			text-align: center;
		}
		
	</style>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var isudType = document.NoticeSelectAllForm.ISUD_TYPE.value;
			// 등록하기
			$("#I").click(function(){
				location.href="/testJso/jso/notice/notice.html";
			});
			
			// 조건조회
			$("#S").click(function(){
				isudType = "S";
				$("#NoticeSelectAllForm")
				.attr({
					"action":"/testJso/notice?ISUD_TYPE="+isudType,
					"method":"POST",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
			});
			
			
			// 수정하기
			$("#U").click(function(){
				isudType = "U";
				$("#NoticeSelectAllForm")
				.attr({
					"action":"/testJso/notice?ISUD_TYPE="+isudType,
					"method":"POST",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
			});
			
			// 삭제하기
			$("#DOK").click(function(){
				isudType = "DOK";
				$("#NoticeSelectAllForm")
				.attr({
					"action":"/testJso/notice?ISUD_TYPE="+isudType,
					"method":"POST",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
			});
		});
		
	</script>
</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	SELELCT ALL
	<%
		Object obj = request.getAttribute("aListSA");
		if (obj == null){
			return;
		}
		
		ArrayList<NoticeVO> aListSA = (ArrayList<NoticeVO>)obj;
		int nCnt = aListSA.size();
		
		if (aListSA != null && nCnt > 0){
			out.println(":::: 전체 조회 >>> : " + nCnt + " 건");
		} // end of if
			
	%>
		<table>
			<tr>
				<td colspan="2" class="align">
					<font size="4" color="blue">
						<img src="/testJso/img/img_mando/ase.gif" width="25" height="25" alter="image">
						NOTICE TEST
					</font>
				</td>
			</tr>
		</table>
		<hr>
		<hr>
		<form name="NoticeSelectAllForm" id="NoticeSelectAllForm" class="align">
			<table border="1">
				<thead>
					<tr>
						<td class="align"><input type="checkbox" name="chkAll" id="chkAll"></td>
						<td class="align">순번</td>
						<td class="align">글번호</td>
						<td class="align">제목</td>
						<td class="align">내용</td>
						<td class="align">사진</td>
						<td class="align">삭제여부</td>
						<td class="align">등록일</td>
						<td class="align">수정일</td>
					</tr>
				</thead>
				<tbody>
					
		<%
					
			if (aListSA != null && nCnt > 0){
				for (int i=0; i < nCnt; i++){
					NoticeVO nvo = aListSA.get(i);		// 이거 arrayList에 넣는것 놓침
					System.out.println("noticeSelectAll.jsp : nvo >>> : " + nvo);
		%>
					<tr>
						<td><input type="checkbox" id="chknum" name="chknum" value="<%= nvo.getNnum() %>"></td>
						<td><%= i + 1 %></td>
						<td><%= nvo.getNnum() %></td>
						<td><%= nvo.getNsubject() %></td>
						<td><%= nvo.getNmemo() %></td>
						<td><img src="/testJso/fileupload/notice/<%= nvo.getNphoto() %>"></td>
						<td><%= nvo.getDeleteyn() %></td>
						<td><%= nvo.getInsertdate() %></td>
						<td><%= nvo.getUpdatedate() %></td>
					</tr>
		<%
				} // end of for
			}
		%>
					<tr>
						<td colspan="9" align="right">
							<input type="hidden" id="ISUD_TYPE" name="ISUD_TYPE" value="">
							<input type="button" value="등록" id="I">
							<input type="button" value="조회" id="S">
							<input type="button" value="수정" id="U">
							<input type="button" value="삭제" id="DOK">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	
</body>
</html>