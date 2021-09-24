<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   	<%@ page import="java.util.ArrayList" %>
   	<%@ page import="a.b.c.com.jso.mem.vo.MemberVO" %>
   	<%@ page import="a.b.c.com.common.CodeUtil" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>ȸ������ ��ü��ȸ</title>
	<style type="text/css">
		* {
			margin : 0 auto;
			/*text-align: center;*/
		}
		
		td, th {
			padding: 5px;
		}
		
		.tt {
			text-align: center;
		}
	</style>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		// üũ�ڽ� üũ Ȯ���ϱ�
		function checkOnly(chk){
			// alert(">>> : " + ch);
			var chkObj = document.getElementsByName("mnumCheck");
			console.log("chkObj >>> : " + chkObj);
			for (var i=0; i < chkObj.length; i++){
				if (chkObj[i] != chk){
					chkObj[i].checked = false;
				}
			}
		}
		
		$(document).ready(function(){
			// ����ϱ�
			$("#I").click(function(){
				location.href='/testJso/jso/mem/mem.html';
			});
			
			// ������ȸ
			$("#S").click(function(){
				var isudType = document.memSelectAllForm.ISUD_TYPE.value = "S";
				send(isudType);
			});
			
			// �����ϱ�
			$("#U").click(function(){
				var nCnt = chkInfo();
				if (nCnt == 0){
					console.log("üũ�ڽ��� üũ�ϼ���");
					alert("üũ�ڽ��� üũ�ϼ���");
				}else{
					// jQuery ����
					var v1 = $("#ISUD_TYPE").val('U');
					alert("v1 >>> : " + v1.val());
					send(v1);
				}
			});
			
			//�����ϱ�
			$("#D").click(function(){
				var nCnt = chkInfo();
				if (nCnt == 0){
					console.log("üũ�ڽ��� üũ�ϼ���");
					alert("üũ�ڽ��� üũ�ϼ���");
				}else{
					// jQuery ����
					var v2 = $("#ISUD_TyPE").val('D');
					alert("v2 >>> : " + v2.val());
					send(v2);
				}
			});
			
			// üũ�ڽ� üũ ī��Ʈ
			function chkInfo(){
				var obj = document.getElementsByName("mnumCheck");
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
				
				$("#memSelectAllForm").attr({
					"action":"/testJso/member?ISUD_TYPE="+isudType,
					"method":"GET",
					"enctype":"application/x-www-form-urlencoded"
				}).submit();
			}
		});
		
	</script>
	</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	SELECT ALL
	<%
		Object obj = request.getAttribute("aListSA");
		ArrayList<MemberVO> aListSA = (ArrayList<MemberVO>)obj;
		System.out.println("memSelectAll :: aListSA >>> : " + aListSA);
		int nCnt = aListSA.size();
		
		if (aListSA != null && nCnt > 0){
		out.println("��ü��ȸ >>> : " + nCnt + " �� ��ȸ");
	%>
	<fieldset>
		<legend>��ü��ȸ ���</legend>
		<table>
			<tr>
				<td colspan="2">
				<font size="4"	color="blue">
					<img src="/testJso/img/img_mando/ase.gif" width="25" height="25" alter="image">
					BOARD TEST
				</font>
				</td>
			</tr>
		</table>
		<hr>
		<hr>
		<form name="memSelectAllForm" id="memSelectAllForm">
			<table border="1">
				<thead>
					<tr>
						<td><input type="checkbox" id="checkAll" name="checkAll" /></td>
						<td>����</td>
						<td>ȸ����ȣ</td>
						<td>�̸�</td>
						<td>���̵�</td>
						<td>�н�����</td>
						<td>����</td>
						<td>�������</td>
						<td>�ڵ���</td>
						<td>��ȭ��ȣ</td>
						<td>�̸���</td>
						<td>�ּ�</td>
						<td>���</td>
						<td>�Ұ���</td>
						<td>����</td>
						<td>������</td>
					</tr>
				</thead>
				<%
					String gender = "";
					String birth = "";
					String hp = "";
					String tel = "";
					String addr = "";
					String hobby = "";
					
					for (int i=0; i < nCnt; i++){
//						MemberVO mvo = new MemberVO();		// �̷��� �ϸ�, MemberVO�� ���� �ν��Ͻ��Ǹ鼭 aListSA�� ��Ƶ� ������ �������� �� ��			
//						System.out.println("memSelectAll :: mvo >>> " + mvo);
						MemberVO mvo = aListSA.get(i);
						System.out.println("memSelectAll.jsp :: mvo >>> : " + mvo);
						/*
						MemberVO mvo = new MemberVO();
						System.out.println("memSelectAll :: mvo = new MemberVO() >>> " + mvo);
						mvo = aListSA.get(i);
						System.out.println("memSelectAll :: mvo = aListSA.get(i) >>> " + mvo);
						*/
						gender = CodeUtil.gender(mvo.getMgender());
						birth = CodeUtil.birth(mvo.getMbirth());
						hp = CodeUtil.hp(mvo.getMhp());
						tel = CodeUtil.tel(mvo.getMtel());
						addr = CodeUtil.addr(mvo.getMzonecode(), mvo.getMroadaddress().replace("@", " "), mvo.getMgibunaddress());
						hobby = CodeUtil.hobby(mvo.getMhobby());
				%>
					<tr>
						<td class="tt">
							<input type="checkbox" id="mnumCheck" name="mnumCheck" value="<%= mvo.getMnum() %>" onclick="checkOnly(this)">
						</td>
						<td class="tt"><%= i + 1 %></td>
						<td class="tt"><%= mvo.getMnum() %></td>
						<td class="tt"><%= mvo.getMname() %></td>
						<td class="tt"><%= mvo.getMid() %></td>
						<td class="tt"><%= mvo.getMpw() %></td>
						<td class="tt"><%= gender %></td>
						<td class="tt"><%= birth %></td>
						<td class="tt"><%= hp %></td>
						<td class="tt"><%= tel %></td>
						<td class="tt"><%= mvo.getMemail() %></td>
						<td class="tt"><%= addr %></td>
						<td class="tt"><%= hobby %></td>
						<td class="tt"><%= mvo.getMinfo() %></td>
						<td class="tt"><img src="/testJso/fileupload/member/<%= mvo.getMphoto() %>"></td>
						<td class="tt"><%= mvo.getUpdatedate() %></td>
					</tr>
				<%		
					}	// end of for��
				%>
					<tr>
						<td colspan="20" align="right">
							<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">
							<input type="button" value="���" id="I">
							<input type="button" value="��ȸ" id="S">
							<input type="button" value="����" id="U">
							<input type="button" value="����" id="D">							
						</td>
					</tr>
			</table>
		</form>
	</fieldset>
	<%
		}else{
			System.out.println("memSelectAll.jsp >>> : ��ü��ȸ ���� !!");
			out.println("memSelectAll.jsp >>> : ��ü��ȸ ���� !!");
		}
	%>
</body>
</html>