<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import= "java.util.ArrayList" %>
    <%@ page import= "a.b.c.com.jso.board.vo.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>�� ������ȸ</title>
	<style type="text/css">
		* {
			margin : 0 auto;
			/*text-align : center; */
		}
		div {
			margin : 50px 0px 0px 100px;
		}
		
		td, th {
			padding : 5px;
		}
		
		.tt {
			text-align : center;
		}
	</style>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	
		function boardUpdate(actionUpdate){
			console.log("boardUpdate ���� >>> : " + actionUpdate);
			
			if ("U" == actionUpdate){
				console.log();
				var v1 = "UOK";
				// document.formObject.action �Ӽ� : form�� submit�� �� form data�� ���� ������ ��üȭ�Ѵ�.
				//				Sets or returns the value of the action attribute in a form
				//	 	/board �� ���� ������̼ǵǾ� �ִ� BoardController.java�� 
				//	 	key=?&value=? : ISUD_TYPE="UOK"�� ������.
				document.boardUpdateForm.action="/testJso/board?ISUD_TYPE="+v1;
			}
			
			if ("D" == actionUpdate){
				var v2 = "DOK";
				document.boardUpdateForm.action="/testJso/board?ISUD_TYPE="+v2;
			}
			
			// POST������� submit()
			document.boardUpdateForm.method="POST";
			document.boardUpdateForm.enctype="application/x-www-form-urlencoded";
			document.boardUpdateForm.submit();
		}
	
		function checkAction(actionName){
			console.log("checkAction ���� >>> : " + actionName);
			if ("I" == actionName){
				location.href="/testJso/jso/board/board.html";
			}
			if ("SALL" == actionName){
				// /board ������̼��� BoardController.java�� key&value�� ISUD_TYPE=SALL�� �̵��Ѵ�.
				location.href="/testJso/board?ISUD_TYPE=SALL";
			}
		}
	</script>
</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	SELECT
	<%
		Object obj = request.getAttribute("aListS");
		if (obj == null){
			return;
		}
		
		ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
		int nCnt = aList.size();
		out.println(":::: ���� ��ȸ >>> : " + nCnt + " ��");
		
		String bnum = "";
		String bsubject = "";
		String bwriter = "";
		String bpw = "";
		String bmemo = "";
		String bphoto = "";
		String deleteyn = "";
		String insertdate = "";
		String updatedate = "";
		
		if (nCnt == 1){
			BoardVO bvo = aList.get(0);
			
			bnum = bvo.getBnum();
			bsubject = bvo.getBsubject();
			bwriter = bvo.getBwriter();
			bpw = bvo.getBpw();
			bmemo = bvo.getBmemo();
			bphoto = bvo.getBphoto();
			deleteyn = bvo.getDeleteyn();
			insertdate = bvo.getInsertdate();
			updatedate = bvo.getUpdatedate();
		}	
	%>
	<hr>
	<!-- div �±� �ȿ�  -->
	<div>
		<!-- form �±� �ȿ�  -->
		<form name="boardUpdateForm" id="boardUpdateForm">
			<!-- table 1�� -->
			<table border="1">
				<tr>
					<td colspan="2" align="center">
						<font size="4"	style="color:blue;">�Խ��� �� ���� && ����</font>
						<img src="testJso/img/img_mando/ase.gif" width="25" height="25" alt="image">
					</td>
				</tr>
				<tr>
					<td class="tt">�۹�ȣ</td>
					<td><input type="text" name="bnum" id="bnum" size="20" value="<%= bnum %>" readonly></td>
				</tr>
				<tr>
					<td class="tt">����</td>
					<td><input type="text" name="bsubject" id="bsubject" size="20" value="<%= bsubject %>" size="55"></td>
				</tr>
				<tr>
					<td class="tt">�̸�</td>
					<td><input type="text" name="bwriter" id="bwriter" size="20" value="<%= bwriter %>" size="20" readonly></td>
				</tr>
				<tr>
					<td class="tt">��й�ȣ</td>
					<td><input type="text" name="bpw" id="bpw" size="20" value="<%= bpw %>" size="20" readonly></td>
				</tr>
				<tr>
					<td class="tt">��������</td>
					<td><input type="text" name="deleteyn" id="deleteyn" size="20" value="<%= deleteyn %>" disabled ></td>
				</tr>
				<tr>
					<td class="tt">�Է���</td>
					<td><input type="text" name="insertdate" id="insertdate" size="20" value="<%= insertdate %>" disabled ></td>
				</tr>
				<tr>
					<td class="tt">������</td>
					<td><input type="text" name="updatedate" id="updatedate" size="20" value="<%= updatedate %>" disabled ></td>
				</tr>
				<tr>
					<td class="tt">����</td>
					<td><textarea name="bmemo" id="bmemo" cols="50" rows="10"><%= bmemo %></textarea></td>
				</tr>
				<tr>
					<td class="tt">����</td>
					<td><img src="/testJso/fileupload/board/<%= bphoto %>" border="1" width="40" height="50" alt="image"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE">
						<input type="button" value="����" onclick="boardUpdate('U')"/>
						<input type="button" value="����" onclick="boardUpdate('D')"/>
						<input type="reset" value="���" />
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="�Է�" onclick="checkAction('I')"/>
						<input type="button" value="���" onclick="checkAction('SALL')"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>