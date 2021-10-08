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
		이름 : <input type="text" name="irum" required="required" /><br />
		<br />
		다음 중 회원님께서 키우고 싶은 애완동물을 선택하세요. <br />
		<input type="checkbox" name="animal" value="강아지" />강아지<br />
		<input type="checkbox" name="animal" value="알파카" />알파카<br />
		<input type="checkbox" name="animal" value="토끼" />토끼<br />
		<input type="checkbox" name="animal" value="고슴도치 " />고슴도치<br />
		<input type="checkbox" name="animal" value="금붕어 " />금붕어<br />
		<input type="checkbox" name="animal" value="고양이" />고양이<br />
		<input type="submit" value="전송하기" />
	</form>
</body>
</html>