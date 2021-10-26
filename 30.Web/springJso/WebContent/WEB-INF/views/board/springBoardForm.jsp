<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BOARD : 게시판 : 글쓰기</title>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(document).on("click", "#sbbtn", function(){
				console.log("sbbtn >>> : ");
				$('#boardForm').attr({
					'action':'boardInsert.j',
					'method':'POST',
					'enctype':'multipart/form-data'
				}).submit();
			});
		});
	</script>
</head>
<body>
	<form name="boardForm" id="boardForm">
		<table border="1" align="center">
			<tr>
				<!-- colspan 잘못 써서 컬럼 한개만큼의 자리만 차지함 -->
				<td colspan="2" align="center">게시판 글쓰기</td>
			</tr>
			<tr>
				<td align="center">글번호</td>
				<!-- readonly을 사용해서 sbnum을 사용할 수 없게 만든다. -->
				<td><input type="text" name="sbnum" id="sbnum" size="20" readonly></td>
			</tr>
			<tr>
				<td align="center">제목</td>
				<td><input type="text" name="sbsubject" id="sbsubject" size="53"></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="sbname" id="sbname" size="53"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="sbpw" id="sbpw" size="20"></td>
			</tr>
			<tr>
				<td align="center">내용</td>
				<td>
					<textarea name="sbcontent" id="sbcontent" cols="50" rows="10"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center">사진</td>
				<td><input type="file" name="sbfile" id="sbfile"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
				<input type="button" value="글쓰기" id="sbbtn">
			</tr>
		</table>
	</form>
</body>
</html>