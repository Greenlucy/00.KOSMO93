<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="a.b.c.com.jso.board.vo.BoardVO" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset=EUC-KR">
	<title>글등록</title>
</head>
<body>
	<!-- [47] --> 
	<h3>글등록</h3>
	요청한 컨텐트 타입 = <%= request.getContentType() %>	<!-- 요청한 컨텐트 타입 = null -->
	<hr>
	<%	// [48] key에 대한 value obj에 저장 	
		Object obj = request.getAttribute("bInsert");
		// getAttribute(""); null이면 : org.apache.jasper.JasperException 오류 뜬다.
		if(obj == null){
			out.println("obj가 null 값이다.");
			return;
		}
		// [49] bool형태로 형번환
		boolean bool = ((Boolean)obj).booleanValue();
		
		// [50] bool = true인지 확인
		if (bool){
			System.out.println("입력 성공 bool >>> : " + bool);
	%>
		<script>
			// [50] bool = true라면, ISUD_TYPE = SALL 입력하여 BoardController.java 로 이동
			// location.href("/testJso/board?ISUD_TYPE=SALL"); 써서 함수가 아니라는 오류가 계속 떴음
			location.href="/testJso/board?ISUD_TYPE=SALL";
		</script>
	<% 
		}else{
			System.out.println("입력 실패 bool >>> : " + bool); 
		}
		
		/*	
		try{
			ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
			
			if (aList != null && aList.size() > 0){
				out.println("aList >>> : " + aList.size() + "<br>");
				
				for(int i=0; i < aList.size(); i++){
				//	BoardVO bvo = new BoardVO();
					BoardVO bvo = aList.get(i);
					// bvo.setBnum(bnum); 이건 저장, 설정하는 것. 값을 가져오는 거니까 getter 함수 사용하기
					out.println(bvo.getBnum() + " : ");
					out.println(bvo.getBsubject() + " : ");
					out.println(bvo.getBwriter() + " : ");
					out.println(bvo.getBpw() + " : ");
					out.println(bvo.getBmemo() + " : ");
					out.println(bvo.getBphoto() + " : ");
					out.println(bvo.getDeleteyn() + " : ");
					out.println(bvo.getInsertdate() + " : ");
					out.println(bvo.getUpdatedate() + "<br>");	
				}	
			}else{
				out.println("ArrayList에 데이터가 없습니다.");
			}	
		}catch(Exception e){
			System.out.println("boardInsert.jsp 에러가 >>> : " + e);
			// boardInsert.jsp 에러가 >>> : 
			//	java.lang.ClassCastException: java.lang.Boolean cannot be cast to java.util.ArrayList
		}
		*/
	%>
	
	
</body>
</html>