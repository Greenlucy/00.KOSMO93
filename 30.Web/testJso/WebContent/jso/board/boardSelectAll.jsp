<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="a.b.c.com.jso.board.vo.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>�� ��ü��ȸ</title>
	<style type="text/css">
		* {
			margin: 0 auto;
			/*text-align:center; */
		}
		
		td, th{
			padding: 5px;
		}
		
		.tt{
			text-align: center;
		}
	</style>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
	
		// üũ�ڽ� üũ Ȯ���ϱ�
		// ��ư Ŭ���� checkOnly�Լ��� ȣ��
		function checkOnly(chk){
			// this�� �� �������� �޽����� ����ϰ�
			// >>> : [object HTMLInputElement]
			alert(">>> : " + chk);		
			// ���� ����, �ʱ�ȭ name="bnumCheck" �� ��� value=bvo.getBnum()�� �����ͼ� ����
			/* getElemntsByName : ������ü �� NAME ���� �������µ� ���Ǵ� �Լ�. ���� ��ü�� �迭�� ����ȴ�.
				���� chkObj �� ���� ��ü�� ������ �迭�� ��.
				getElementById : ���� ��ü �� ID ���� �������⸸ �Ѵ�. �迭�� ���� �ʴ´�.(?) */
			var chkObj = document.getElementsByName("bnumCheck");
			// �ֿܼ� �迭 ���
			console.log("chkObj >>> : " + chkObj);
			// �迭�� ���� ��ŭ �ݺ� for��
			for (var i=0; i < chkObj.length; i++){
				
				if (chkObj[i] == chk){
					alert("chkObj["+(i+1)+"].checked = true");
					alert((i+1) + " �� �Խñ��� �����߽��ϴ�.");
					chkObj[i].checked = true;
				}else{
					chkObj[i].checked = false;
				}
				
			/*	// chkObj�� i��° ��ҿ� �ƱԸ�Ʈ chk�� ���� ������
				if (chkObj[i] != chk){
					alert("chkObj["+i+"].checked = false");
					// üũ�� �����Ѵ�.
					chkObj[i].checked = false;
				}else{
					alert("chkObj["+i+"].checked = true");
				} 											*/		
			
			}
		}
		
		function checkAll(chk){
			
			var chkAll = document.getElementsBy("chkAll");
			var chkObj = document.getElementsBy("bnumCheck");
			
			if (chkAll == true){
				for (var i=0; i < "#bnumCheck".size; i++){
					console.log("bnumCheck["+i+"] ��°");
					"#bnumCheck"[i] = true;
				}
			}else{
					console.log("üũ�ڽ� ��ü ���� ����");
			}
		}
		
		$(document).ready(function(){
			// ����ϱ�
			$("#I").click(function(){
				location.href='/testJso/jso/board/board.html';	
			});
			
			// ������ȸ
			$("#S").click(function(){
				// DOM ��ü�� form �±� name=boardSelectAllForm���� 
				// hidden name=ISUD_TYPE�� value�� S
				var isudType = document.boardSelectAllForm.ISUD_TYPE.value = "S";
				send(isudType);
			});
			
			// �����ϱ�
			$("#U").click(function(){
				var nCnt = chkInfo();
				if(nCnt == 0){
					console.log('üũ�ڽ��� üũ�ϼ���');
					alert('üũ�ڽ��� üũ�ϼ���');
				}else{
					/*�ڹٽ�ũ��Ʈ ����
						document.boardSelectAllForm.ISUD_TYPE.value = "U";
						alert("isudType U >>> : " +
								document.boardSelectAllForm.ISUD_TYPE.value);
						send(document.boardSelectAllForm.ISUD_TYPE.value);
					*/
					// jQuery ����
					var v1 = $("#ISUD_TYPE").val('U');
					alert("v1 >>> : " + v1.val());
					send(v1);
				}
			});
			
			// �����ϱ�
			$("#D").click(function(){
				var nCnt = chkInfo();
				if (nCnt == 0){
					console.log('üũ�ڽ��� üũ�ϼ���');
					alert('üũ�ڽ��� üũ�ϼ���');
				}else{
					
					// jQeury ����
					var v2 = $("#ISUD_TYPE").val('D');
					alert("v2 >>> : " + v2.val());
					send(v2);
				}
			});
			
			// üũ�ڽ� üũ ī��Ʈ
			function chkInfo(){
				alert("chkInfo()�Լ� ");
				var obj = document.getElementsByName("bnumCheck");
				var nCnt = 0; 
				for(var i=0; i < obj.length; i++){
					if (obj[i].checked == true){
						nCnt++;
					}
				}
				console.log('nCnt >>> : ' + nCnt);
				return nCnt;
			}
			
			// submit
			function send(isudType){
				alert("isudType send >>> : " + isudType);
				$("#boardSelectAllForm").attr({
					"action":"/testJso/board?ISUD_TYPE="+isudType,
					"method":"GET",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
			}
		});
		
	</script>
</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); 
	// [76] 									%>
	SELECT ALL
	<%
		// [77]
		// key="aListAll"�� BoardController.java�κ��� �޾Ƽ� getAttribute���� ��� �غ� �Ϸ�
		// >> Object ���� obj�� ����
		Object obj = request.getAttribute("aListAll");
		if (obj == null){
			System.out.println("obj�� null�Դϴ�.");
			return;
		}
		
		// [78]
		// ����ȯ : Object > ArrayList<BoardVO> ���·�.
		ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
		int nCnt = aList.size();
		out.println(":::: ��ü ��ȸ �Ǽ� " + nCnt + " ��");
		// [79] html <table> ���� ����	
	%>
	<table>
		<tr>
			<td colspan="2">
			<font size="4" color="blue">
				<img src="/testJso/img/img_mando/ase.gif" width="25" height="25" alter="image">
				BOARD TEST
			</font>
			</td>
		</tr>
	</table>
	<hr>
	<hr>
	<!-- [80] ��ü��ȸ form ���� : <thead> �±׷� �� ���� -->
	<form name="boardSelectAllForm" id="boardSelectAllForm">
		<table border="1">
			<thead>
				<tr>
					<td class="tt"><input type="checkbox" name="chkAll" id="chkAll" onclick="checkAll(this)"></td>
					<td class="tt">����</td>
					<td class="tt">�۹�ȣ</td>
					<td class="tt">������</td>
					<td class="tt">����</td>
					<td class="tt">�н�����</td>
					<td class="tt">����</td>
					<td class="tt">�̹���</td>
					<td class="tt">��������</td>
					<td class="tt">�����</td>
					<td class="tt">������</td>
				</tr>
			</thead>
			<%
				// [81] aList�� ���� ������ ���� ����ϱ� ���� for �ݺ�
				// �̰� �� ���⿡�� ����...? : <tbody> �ȿ� �ݺ���Ű�� ���ؼ�?
				for(int i=0; i<nCnt; i++){
					BoardVO bvo = aList.get(i);				
				// [82] <tbody>�� �� ����
			%>
			<tbody>
				<tr>
					<td class="tt">
						<!-- checkbox�� �ִµ�, id�� name�� bnumCheck(key)�̰�, value�� BoardVO�� getBnum() ������ ���� �ȴ�.
											Ŭ���� �ϸ�, �̰͸� check�ϴ� checkonly()�Լ� ���� -->
						<input type="checkbox" id="bnumCheck" name="bnumCheck" value=<%= bvo.getBnum() %> onclick="checkOnly(this)">
					</td>
					<td class="tt"><%= i + 1 %></td>
					<td class="tt"><%= bvo.getBnum() %> </td>
					<td class="tt"><%= bvo.getBsubject() %> </td>
					<td class="tt"><%= bvo.getBwriter() %></td>
					<td class="tt"><%= bvo.getBpw() %></td>
					<td class="tt"><%= bvo.getBmemo() %></td>
				<!-- <td class="tt"><%= bvo.getBphoto() %></td> -->	
					<td class="tt"><img src="/testJso/fileupload/board/<%= bvo.getBphoto() %>"></td>
					<td class="tt"><%= bvo.getDeleteyn() %></td>
					<td class="tt"><%= bvo.getInsertdate() %></td>
					<td class="tt"><%= bvo.getUpdatedate() %></td>
				</tr>
			<% 
				} // end of for
				
				// [83] button ���� id�� ���� �Լ� �۵�. ���� "��ȸ" ��ư�� �����ٸ�, 
			%>
			<tr>
				<td colspan = "20" align="right">
					<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">
					<input type="button" value="���" id="I">
					<input type="button" value="��ȸ" id="S">
					<input type="button" value="����" id="U">
					<input type="button" value="����" id="D">
				</td>
			</tr>
			</tbody>
		</table>
	</form>
</body>
</html>