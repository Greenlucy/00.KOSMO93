<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="a.b.c.com.jso.board.vo.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>글 전체조회</title>
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
	
		// 체크박스 체크 확인하기
		// 버튼 클릭시 checkOnly함수를 호출
		function checkOnly(chk){
			// this를 웹 브라우저에 메시지로 출력하고
			// >>> : [object HTMLInputElement]
			alert(">>> : " + chk);		
			// 변수 선언, 초기화 name="bnumCheck" 의 요소 value=bvo.getBnum()를 가져와서 저장
			/* getElemntsByName : 문서객체 중 NAME 값을 가져오는데 사용되는 함수. 읽은 객체는 배열로 저장된다.
				변수 chkObj 는 문서 객체를 가지는 배열로 들어감.
				getElementById : 문서 객체 중 ID 값을 가져오기만 한다. 배열로 들어가지 않는다.(?) */
			var chkObj = document.getElementsByName("bnumCheck");
			// 콘솔에 배열 출력
			console.log("chkObj >>> : " + chkObj);
			// 배열의 길이 만큼 반복 for문
			for (var i=0; i < chkObj.length; i++){
				
				if (chkObj[i] == chk){
					alert("chkObj["+(i+1)+"].checked = true");
					alert((i+1) + " 번 게시글을 선택했습니다.");
					chkObj[i].checked = true;
				}else{
					chkObj[i].checked = false;
				}
				
			/*	// chkObj의 i번째 요소와 아규먼트 chk가 같지 않으면
				if (chkObj[i] != chk){
					alert("chkObj["+i+"].checked = false");
					// 체크를 해제한다.
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
					console.log("bnumCheck["+i+"] 번째");
					"#bnumCheck"[i] = true;
				}
			}else{
					console.log("체크박스 전체 선택 실패");
			}
		}
		
		$(document).ready(function(){
			// 등록하기
			$("#I").click(function(){
				location.href='/testJso/jso/board/board.html';	
			});
			
			// 조건조회
			$("#S").click(function(){
				// DOM 객체의 form 태그 name=boardSelectAllForm에서 
				// hidden name=ISUD_TYPE의 value가 S
				var isudType = document.boardSelectAllForm.ISUD_TYPE.value = "S";
				send(isudType);
			});
			
			// 수정하기
			$("#U").click(function(){
				var nCnt = chkInfo();
				if(nCnt == 0){
					console.log('체크박스를 체크하세요');
					alert('체크박스를 체크하세요');
				}else{
					/*자바스크립트 버전
						document.boardSelectAllForm.ISUD_TYPE.value = "U";
						alert("isudType U >>> : " +
								document.boardSelectAllForm.ISUD_TYPE.value);
						send(document.boardSelectAllForm.ISUD_TYPE.value);
					*/
					// jQuery 버전
					var v1 = $("#ISUD_TYPE").val('U');
					alert("v1 >>> : " + v1.val());
					send(v1);
				}
			});
			
			// 삭제하기
			$("#D").click(function(){
				var nCnt = chkInfo();
				if (nCnt == 0){
					console.log('체크박스를 체크하세요');
					alert('체크박스를 체크하세요');
				}else{
					
					// jQeury 버전
					var v2 = $("#ISUD_TYPE").val('D');
					alert("v2 >>> : " + v2.val());
					send(v2);
				}
			});
			
			// 체크박스 체크 카운트
			function chkInfo(){
				alert("chkInfo()함수 ");
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
		// key="aListAll"을 BoardController.java로부터 받아서 getAttribute으로 출력 준비 완료
		// >> Object 변수 obj에 저장
		Object obj = request.getAttribute("aListAll");
		if (obj == null){
			System.out.println("obj가 null입니다.");
			return;
		}
		
		// [78]
		// 형변환 : Object > ArrayList<BoardVO> 형태로.
		ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
		int nCnt = aList.size();
		out.println(":::: 전체 조회 건수 " + nCnt + " 건");
		// [79] html <table> 제목 생성	
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
	<!-- [80] 전체조회 form 생성 : <thead> 태그로 열 생성 -->
	<form name="boardSelectAllForm" id="boardSelectAllForm">
		<table border="1">
			<thead>
				<tr>
					<td class="tt"><input type="checkbox" name="chkAll" id="chkAll" onclick="checkAll(this)"></td>
					<td class="tt">순번</td>
					<td class="tt">글번호</td>
					<td class="tt">글제목</td>
					<td class="tt">저자</td>
					<td class="tt">패스워드</td>
					<td class="tt">내용</td>
					<td class="tt">이미지</td>
					<td class="tt">삭제여부</td>
					<td class="tt">등록일</td>
					<td class="tt">수정일</td>
				</tr>
			</thead>
			<%
				// [81] aList에 담은 정보들 순차 출력하기 위한 for 반복
				// 이걸 왜 여기에서 하지...? : <tbody> 안에 반복시키기 위해서?
				for(int i=0; i<nCnt; i++){
					BoardVO bvo = aList.get(i);				
				// [82] <tbody>에 행 생성
			%>
			<tbody>
				<tr>
					<td class="tt">
						<!-- checkbox를 넣는데, id와 name이 bnumCheck(key)이고, value는 BoardVO의 getBnum() 가져온 값이 된다.
											클릭을 하면, 이것만 check하는 checkonly()함수 실행 -->
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
				
				// [83] button 생성 id에 따라 함수 작동. 만약 "조회" 버튼을 눌렀다면, 
			%>
			<tr>
				<td colspan = "20" align="right">
					<input type="hidden" name="ISUD_TYPE" id="ISUD_TYPE" value="">
					<input type="button" value="등록" id="I">
					<input type="button" value="조회" id="S">
					<input type="button" value="수정" id="U">
					<input type="button" value="삭제" id="D">
				</td>
			</tr>
			</tbody>
		</table>
	</form>
</body>
</html>