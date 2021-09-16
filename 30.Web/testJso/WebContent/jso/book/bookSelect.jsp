<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="a.b.c.com.jso.book.vo.BookVO" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>���� ���� ��ȸ ȭ��</title>
	<style type="text/css">
		* {
			margin : 0 auto;
			text-align : center;
		}
		
		fieldset {
			width : 400px;
		}
		
		legend {
			font-size : 1.2em;
			/* font-weight : bold; */
		}
		
		td {
			padding : 5px;
		}
		
		.attr {
			font-weight : bold;
		}
		
		.align {
			text-align : left;
		}
	</style>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
			
		function bookUpdate(actionUpdate){
			console.log("bookUpdate ���� >>> : " + actionUpdate);
			
			if ("U" == actionUpdate){
				var uConfirm = confirm("���� ������ ���� �����Ͻðڽ��ϱ�?");
				if (uConfirm) {
					document.bookUpdateForm.action = "/testJso/book?isudtype=UOK";	
					document.bookUpdateForm.method = "POST";
					document.bookUpdateForm.enctype = "multipart/form-data";
					document.bookUpdateForm.submit();
					
					return true;
				}else{
					System.out.println("���� ���� ���� ���� !!!");	
					return false;
				}
			}
			
			if ("D" == actionUpdate){
				var dConfirm = confirm("���� ������ ���� �����Ͻðڽ��ϱ�?");
				if(dConfirm){
					document.bookUpdateForm.action = "/testJso/book?isudtype=DOK";
				}else{
					console.log("���� ���� ���� ���� !!!");
					return false;
				}
			}
			
			// �� �κ� ����Ƿ��� if(true){}�� return; ���� �帧�� ������ X 
			document.bookUpdateForm.method = "POST";
			document.bookUpdateForm.enctype = "application/x-www-urlencoded";
			document.bookUpdateForm.submit();
		}
		
		function checkAction(actionName){
			if ("I" == actionName) {
				location.href = "/testJso/jso/book/book.html";
			}
			
			if ("SALL" == actionName){
				location.href = "/testJso/book?isudtype=SALL";
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
		
		ArrayList<BookVO> aListS = (ArrayList<BookVO>)obj;
		int nCnt = aListS.size();
		out.println(":::: ��ȸ �Ǽ� " + nCnt + " �� ��ȸ �Ϸ�");
		
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
		
		// ������ȸ�ϱ� ������ 1�̸�
		if (nCnt == 1){
			// bvo�� aListS�� ù��° ��� ����
			BookVO bvo = aListS.get(0);
			
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
	
		// ��ȸ�Ǽ� 1���̹Ƿ� for�� �ʿ����� ����
//		for(int i=0; i < aListS.size(); i++){
			
//		}
	%>
	<table>
		<tr>
			<td colspan="2">
			<font size="4" color="blue">
				<img src="/testJso/img/img_mando/ase.gif" width="25" height="25" alter="image">
				BOOK TEST
			</font>
			</td>
		</tr>
	</table>
	<hr>
	<hr>
	<fieldset>
		<legend>���� ���� ��ȸ</legend>
		<form name="bookUpdateForm" id="bookUpdateForm">
			<table border="1">
				<tr>
					<td class="attr">������ȣ</td>
					<td><input type="text" id="bnum" name="bnum" class="align" value="<%= bnum %>" readonly /></td>
				</tr>
				<tr>
					<td class="attr">������</td>
					<td><input type="text" id="btitle" name="btitle" class="align" value="<%= btitle %>" readonly /></td>
				</tr>
				<tr>
					<td class="attr">��&nbsp;&nbsp;&nbsp;��</td>
					<td><input type="text" id="bauth" name="bauth" class="align" value="<%= bauth %>" readonly /></td>
				</tr>
				<tr>
					<td style="letter-spacing : 3px" class="attr">ISBN</td>
					<td><input type="text" id="isbn" name="isbn" class="align" value="<%= isbn %>" readonly /></td>
				</tr>
				<tr>
					<td class="attr">���ǻ�</td>
					<td><input type="text" id="bcomp" name="bcomp" class="align" value="<%= bcomp %>" readonly/></td>
				</tr>
				<tr>
					<td class="attr">��&nbsp;&nbsp;&nbsp;��</td>
					<td><input type="number" id="bprice" name="bprice" class="align" value="<%= bprice %>" /></td>
				</tr>
				<tr>
					<td class="attr">��&nbsp;&nbsp;&nbsp;��</td>
					<td><input type="number" id="bqty" name="bqty" class="align" value="<%= bqty %>" /></td>
				</tr>
				<tr>
					<td class="attr">ǥ&nbsp;&nbsp;&nbsp;��</td>
					<td>
					<input type="hidden" id="bcover" name="bcover" />
					<input type="text" id="bcover_old" name="bcover_old" class="align" value="<%= bcover %>" />
					<input type="file" id="bcover_new" name="bcover_new" class="align">					
					</td>
				</tr>
				<tr>
					<td class="attr">��������</td>
					<td><input type="text" id="deleteyn" name="deleteyn" class="align" value="<%= deleteyn %>" disabled /></td>
				</tr>
				<tr>
					<td class="attr">�����</td>
					<td><input type="text" id="insertdate" name="insertdate" class="align" value="<%= insertdate %>" disabled /></td>
				</tr>
				<tr>
					<td class="attr">������</td>
					<td><input type="text" id="updatedate" name="updatedate" class="align" value="<%= updatedate %>" disabled /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden" id="isudtype" name="isudtype" />
						<input type="button" value="����" onclick="bookUpdate('U')" />
						<input type="button" value="����" onclick="bookUpdate('D')" />
						<input type="reset" value="���" />
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="�Է�" onclick="checkAction('I')" />
						<input type="button" value="���" onclick="checkAction('SALL')" />
					</td>
				</tr>
			</table>
		</form>
	</fieldset>
	
</body>
</html>