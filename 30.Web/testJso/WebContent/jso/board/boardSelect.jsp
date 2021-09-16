<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import= "java.util.ArrayList" %>
    <%@ page import= "a.b.c.com.jso.board.vo.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>글 조건조회</title>
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
			console.log("boardUpdate 진입 >>> : " + actionUpdate);
			
			if ("U" == actionUpdate){
				console.log();
				var v1 = "UOK";
				// document.formObject.action 속성 : form이 submit될 때 form data를 어디로 보낼지 구체화한다.
				//				Sets or returns the value of the action attribute in a form
				//	 	/board 웹 서블릿 어노테이션되어 있는 BoardController.java로 
				//	 	key=?&value=? : ISUD_TYPE="UOK"를 보낸다.
				document.boardUpdateForm.action="/testJso/board?ISUD_TYPE="+v1;
			}
			
			if ("D" == actionUpdate){
				var v2 = "DOK";
				document.boardUpdateForm.action="/testJso/board?ISUD_TYPE="+v2;
			}
			
			// POST방식으로 submit()
			document.boardUpdateForm.method="POST";
			document.boardUpdateForm.enctype="application/x-www-form-urlencoded";
			document.boardUpdateForm.submit();
		}
	
		function checkAction(actionName){
			console.log("checkAction 진입 >>> : " + actionName);
			if ("I" == actionName){
				location.href="/testJso/jso/board/board.html";
			}
			if ("SALL" == actionName){
				// /board 어노테이션인 BoardController.java의 key&value가 ISUD_TYPE=SALL로 이동한다.
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
		out.println(":::: 조건 조회 >>> : " + nCnt + " 건");
		
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
	<!-- div 태그 안에  -->
	<div>
		<!-- form 태그 안에  -->
		<form name="boardUpdateForm" id="boardUpdateForm">
			<!-- table 1개 -->
			<table border="1">
				<tr>
					<td colspan="2" align="center">
						<font size="4"	style="color:blue;">게시판 글 수정 && 삭제</font>
						<img src="testJso/img/img_mando/ase.gif" width="25" height="25" alt="image">
					</td>
				</tr>
				<tr>
					<td class="tt">글번호</td>
					<td><input type="text" name="bnum" id="bnum" size="20" value="<%= bnum %>" readonly></td>
				</tr>
				<tr>
					<td class="tt">제목</td>
					<td><input type="text" name="bsubject" id="bsubject" size="20" value="<%= bsubject %>" size="55"></td>
				</tr>
				<tr>
					<td class="tt">이름</td>
					<td><input type="text" name="bwriter" id="bwriter" size="20" value="<%= bwriter %>" size="20" readonly></td>
				</tr>
				<tr>
					<td class="tt">비밀번호</td>
					<td><input type="text" name="bpw" id="bpw" size="20" value="<%= bpw %>" size="20" readonly></td>
				</tr>
				<tr>
					<td class="tt">삭제여부</td>
					<td><input type="text" name="deleteyn" id="deleteyn" size="20" value="<%= deleteyn %>" disabled ></td>
				</tr>
				<tr>
					<td class="tt">입력일</td>
					<td><input type="text" name="insertdate" id="insertdate" size="20" value="<%= insertdate %>" disabled ></td>
				</tr>
				<tr>
					<td class="tt">수정일</td>
					<td><input type="text" name="updatedate" id="updatedate" size="20" value="<%= updatedate %>" disabled ></td>
				</tr>
				<tr>
					<td class="tt">내용</td>
					<td><textarea name="bmemo" id="bmemo" cols="50" rows="10"><%= bmemo %></textarea></td>
				</tr>
				<tr>
					<td class="tt">사진</td>
					<td><img src="/testJso/fileupload/board/<%= bphoto %>" border="1" width="40" height="50" alt="image"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE">
						<input type="button" value="수정" onclick="boardUpdate('U')"/>
						<input type="button" value="삭제" onclick="boardUpdate('D')"/>
						<input type="reset" value="취소" />
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="입력" onclick="checkAction('I')"/>
						<input type="button" value="목록" onclick="checkAction('SALL')"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>