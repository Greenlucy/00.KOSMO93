<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>el_03</title>
</head>
<body>
	<h3>el_03</h3>
	<hr>
	<form action="el_03_1.jsp" method="GET">
		�̸� : <input type="text" name="irum" required="required" /><br />
		<br />
		���� �� ȸ���Բ��� Ű��� ���� �ֿϵ����� �����ϼ���. <br />
		<input type="checkbox" name="animal" value="������" />������<br />
		<input type="checkbox" name="animal" value="����ī" />����ī<br />
		<input type="checkbox" name="animal" value="�䳢" />�䳢<br />
		<input type="checkbox" name="animal" value="����ġ " />����ġ<br />
		<input type="checkbox" name="animal" value="�ݺؾ� " />�ݺؾ�<br />
		<input type="checkbox" name="animal" value="�����" />�����<br />
		<input type="submit" value="�����ϱ�" />
	</form>
</body>
</html>