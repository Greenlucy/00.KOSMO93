<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset=EUC-KR">
	<title>IDFIND</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("mconfirm").click(function(){
				console.log("mconfirm >>> : ");
				alert("mconfirm >>> : ");
			});
			
			$("#idbtn").click(function(){
				console.log("idbtn >>> : ");
				alert("idbtn >>> : ");
			
				$("#login_type").attr({
					'action':'/testWeb/html_1/formTest_2.html',
					'method':'GET',
					'enctype':'application/x-www-form-urlencoded'
				})
			})
		});
	</script>
</head>
<body>
	<h3 align="center">IDFIND</h3>
	<hr>
	<%
		String mname = "";
		String memail = "";
		String authnum = "";
	%>
	<h4 align="center">����Ȯ�� �̸��� �ּҿ� �Է��� �ּҰ� ���ƾ�, ������ȣ�� ���� �� �ֽ��ϴ�.</h4>
	<form name="idForm" id="idForm">
		<table border="1" align="center">
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="mname" id="mname" value='<%=mname %>' style="width:200px;"></td>
			</tr>
			<tr>
				<td>�̸��� �ּ�</td>
				<td>
					<input type="text" name="memail" id="memail" value='<%=memail %>' placeholder="" style="width:200px;">
					<button type="button" id="mconfirm">������ȣ�ޱ�</button>
				</td>
			</tr>
			<tr>
				<td>������ȣ</td>
				<td>
					<input type="text" name="authnum" id="authnum" value='<%=authnum %>' placeholder="������ȣ 6�ڸ� ���� �Է�" style="width:200px;">
				</td>
			</tr>
			<tr>
			<td></td>
			<td>
				������ȣ�� ���� �ʳ���<img src="/testWeb/img/ase.gif" width="20" height="20">
			</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="hidden" name="login_type" id="login_type">
				<button type="button" id="idbtn" a href="http://localhost:8088/testWeb/jsp/findPw.jsp">����</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>