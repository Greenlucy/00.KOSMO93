<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset=EUC-KR">
	<title>PWFIND</title>
</head>
<body>
	<div align="center">PWFIND</div>
	<hr>
	<form name="pwForm" id="pwForm">
		<table border="1" align="center">
			<tr>
				<td>�ӽú�й�ȣ</td>
				<td>
					<input type="text" mane="mtempid" id="mtempid" style="width:200px;">
				</td>
			</tr>
			<tr>
				<td>����й�ȣ</td>
				<td>
					<input type="text" name="mpw" id="mpw" style="width:200px;">
				</td>
			</tr>
			<tr>
				<td>����й�ȣ Ȯ��</td>
				<td>
					<input type="text" name="mpw_r" id="mpw_r" style="width:200px;">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button type="button" id="btn" style="background-color : yellow;">
				����
				</button>
			</tr>
		</table>
	</form>
</body>
</html>