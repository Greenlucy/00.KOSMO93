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
			// ����
			alert("noticeUpdate() �Լ� ���� >>> : ");
			
			$("#NoticeSelectForm")
			.attr({
				"action":"/testJso/notice?ISUD_TYPE="+isudType,
				"method":"POST",
				"enctype":"application/x-www-form-urlencoded"
			}).submit();
		}
		
		function checkAction(actionType){
			// �Է�, ��ü��� ��ȸ
			alert("checkAction() �Լ� ���� >>> : " + actionType);
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
			out.println(":::: ������ȸ >>> : " + nCnt + "<br>");
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
					 	<font size="4" style="Color: blue;">���� ����</font>
					</td>
				</tr>
				<tr>
					<td>�۹�ȣ</td>
					<td>
						<input type="text" id="nnum" name="nnum" value="<%= nvo.getNnum() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>����</td>
					<td>
						<input type="text" id="nsubject" name="nsubject" value="<%= nvo.getNsubject() %>" >
					</td>
				</tr>
				<tr>
					<td>����</td>
					<td>
						<input type="text"	id="nmemo" name="nmemo" value="<%= nvo.getNmemo() %>">
					</td>
				</tr>
				<tr>
					<td>����</td>
					<td>
						<img src="/testJso/fileupload/notice/<%= nvo.getNphoto() %>">
						<input type="file" >
					</td>
				</tr>
				<tr>
					<td>��������</td>
					<td>
						<input type="text" id="deleteyn" name="deleteyn" value="<%= nvo.getDeleteyn() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>�����</td>
					<td>
						<input type="text" id="insertdate" name="insertdate" value="<%= nvo.getInsertdate() %>" readonly>
					</td>
				</tr>
				<tr>
					<td>������</td>
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
						<input type="button" value="����" onclick="noticeUpdate('UOK')">
						<input type="reset" value="���">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="�Է�" onclick="checkAction('I')">
						<input type="button" value="���" onclick="checkAction('SALL')">
					</td>
				</tr>
			</table>
		</form>
	
</body>
</html>