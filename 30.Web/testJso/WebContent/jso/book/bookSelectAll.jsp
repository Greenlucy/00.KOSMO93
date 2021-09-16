<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="a.b.c.com.jso.book.vo.BookVO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>도서 목록 조회</title>
	<style>
		* {
			margin : 0 atyo;
			/*text-align : center; */
		}
		
		fieldset {
			width : 100px;
		}
		
		legend {
			font-size : 1.5em;
			font-weight : bold;
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
	
		// 체크박스 체크 확인하기
		function checkOnly(chk) {
			var chkObj = document.getElementsByName("bnumCheck");
			console.log("chkObj >>> : " + chkObj);
			for (var i=0; i < chkObj.length; i++){
				if (chkObj[i] != chk){
					chkObj[i].checked = false;
				}
			}
		}
		
		$(document).ready(function(){
			
			// 등록하기
			$("#I").click(function(){
				location.href="/testJso/jso/book/book.html";
			});
			
			// 조건조회
			$("#S").click(function(){
				alert("S 함수 진입 >>> : ");	
				var isudtype = document.bookSelectAllForm.isudtype.value = "S";
				send(isudtype);
			});
			
			// 수정하기
			$("#U").click(function(){
				alert("U 함수 진입 >>> : ");
				var nCnt = chkInfo();
				if (nCnt == 0){
					alert("체크박스를 체크하세요");
					console.log("체크박스를 체크하세요");
				}else{
					document.bookSelectAllForm.isudtype.value = "U";
					alert("isdutype U >>> : " + document.bookSelectAllForm.isudtype.value);
					send(document.bookSelectAllForm.isudtype.value);
				}
			});
			
			// 삭제하기
			$("#D").click(function(){
				alert("D 함수 진입 >>> : ");
				var nCnt = chkInfo();
				if (nCnt == 0){
					alert("체크박스를 체크하세요");
					console.log("체크박스를 체크하세요");
				}else{
					document.bookSelectAllForm.isudtype.value = "D";
					alert("isudtype D >>> : " + document.bookSelectAllForm.isudtype.value);
					send(document.bookSelectAllForm.isudtype.value);
				}
			});
			
			// 체크박스 체크 카운트
			function chkInfo(){
				var obj = document.getElementsByName("bnumCheck");
				var nCnt = 0; 
				for(var i=0; i < obj.length; i++){
					if (obj[i].checked == true){
						nCnt++;
					}
				}
				console.log("nCnt >>> : " + nCnt);
				return nCnt;
			}
			
			// submit
			function send(isudtype){
				alert("isudtype >>> : " + isudtype);
				
				$("#bookSelectAllForm")
				.attr({
					"action":"/testJso/book?isudtype="+isudtype,
					"method":"POST",
					"enctype":"application/x-www-form-urlencoded"	// 왜 multipart/form-data 안 쓰지?
				}).submit();
			}
		});
		
	</script>
</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	SELECT ALL
	<%
		System.out.println("bookSelectAll.jsp 진입 >>> : ");
	
		Object obj = request.getAttribute("aListSA");
		ArrayList<BookVO> aList = (ArrayList<BookVO>)obj;
		int nCnt = aList.size();
		if (aList != null && nCnt > 0){
			System.out.println("aList가 null이 아닙니다.");
		}else{
			System.out.println("aList가 null입니다.!!");
		}
		
		out.println(":::: 전체 조회 건수 " + nCnt + " 건");
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
		<legend>도서 정보 조회</legend>
		<form name="bookSelectAllForm" id="bookSelectAllForm">
			<table border="1">
				<thead>
					<tr>
						<td class="tt"><input type="checkbox" name="chkAll" id="chkAll"></td>
						<td class="tt">순번</td>
						<td class="tt">도서번호</td>
						<td class="tt">도서명</td>
						<td class="tt">저자</td>
						<td class="tt">ISBN</td>
						<td class="tt">출판사</td>
						<td class="tt">단가</td>
						<td class="tt">수량</td>
						<td class="tt">표지</td>
						<td class="tt">삭제여부</td>
						<td class="tt">등록일</td>
						<td class="tt">수정일</td>
					</tr>
				</thead>
	<%
			for(int i=0; i < nCnt; i++){
				
				BookVO bvo = aList.get(i);
	%>
				<tbody>
					<tr>
						<td class="tt"><input type="checkbox" id="bnumCheck" name="bnumCheck" value=<%= bvo.getBnum() %> onclick="checkOnly(this)" /></td>
						<td class="tt"><% out.println(i + 1); %></td>
						<td class="tt"><%= bvo.getBnum() %></td>
						<td class="tt"><%= bvo.getBtitle() %></td>
						<td class="tt"><%= bvo.getBauth() %></td>
						<td class="tt"><%= bvo.getIsbn() %></td>
						<td class="tt"><%= bvo.getBcomp() %></td>
						<td class="tt"><%= bvo.getBprice() %></td>
						<td class="tt"><%= bvo.getBqty() %></td>
						<td class="tt"><img src="/testJso/fileupload/book/<%= bvo.getBcover() %>" border="1" width="25" height="25" alt="image" /></td>
						<td class="tt"><%= bvo.getDeleteyn() %></td>
						<td class="tt"><%= bvo.getInsertdate() %></td>
						<td class="tt"><%= bvo.getUpdatedate() %></td>
					</tr>
	<%
			} // end of for
	%>
					<tr>
						<td colspan="20" align="right">
							<input type="hidden" id="isudtype" name="isudtype" value="" >
							<input type="button" value="도서정보등록" id="I">
							<input type="button" value="도서정보조회" id="S">
							<input type="button" value="도서정보수정" id="U">
							<input type="button" value="도서정보삭제" id="D">							
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</fieldset>
	
</body>
</html>