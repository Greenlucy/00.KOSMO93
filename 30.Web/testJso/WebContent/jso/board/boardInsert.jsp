<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="a.b.c.com.jso.board.vo.BoardVO" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset=EUC-KR">
	<title>�۵��</title>
</head>
<body>
	<!-- [47] --> 
	<h3>�۵��</h3>
	��û�� ����Ʈ Ÿ�� = <%= request.getContentType() %>	<!-- ��û�� ����Ʈ Ÿ�� = null -->
	<hr>
	<%	// [48] key�� ���� value obj�� ���� 	
		Object obj = request.getAttribute("bInsert");
		// getAttribute(""); null�̸� : org.apache.jasper.JasperException ���� ���.
		if(obj == null){
			out.println("obj�� null ���̴�.");
			return;
		}
		// [49] bool���·� ����ȯ
		boolean bool = ((Boolean)obj).booleanValue();
		
		// [50] bool = true���� Ȯ��
		if (bool){
			System.out.println("�Է� ���� bool >>> : " + bool);
	%>
		<script>
			// [50] bool = true���, ISUD_TYPE = SALL �Է��Ͽ� BoardController.java �� �̵�
			// location.href("/testJso/board?ISUD_TYPE=SALL"); �Ἥ �Լ��� �ƴ϶�� ������ ��� ����
			location.href="/testJso/board?ISUD_TYPE=SALL";
		</script>
	<% 
		}else{
			System.out.println("�Է� ���� bool >>> : " + bool); 
		}
		
		/*	
		try{
			ArrayList<BoardVO> aList = (ArrayList<BoardVO>)obj;
			
			if (aList != null && aList.size() > 0){
				out.println("aList >>> : " + aList.size() + "<br>");
				
				for(int i=0; i < aList.size(); i++){
				//	BoardVO bvo = new BoardVO();
					BoardVO bvo = aList.get(i);
					// bvo.setBnum(bnum); �̰� ����, �����ϴ� ��. ���� �������� �Ŵϱ� getter �Լ� ����ϱ�
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
				out.println("ArrayList�� �����Ͱ� �����ϴ�.");
			}	
		}catch(Exception e){
			System.out.println("boardInsert.jsp ������ >>> : " + e);
			// boardInsert.jsp ������ >>> : 
			//	java.lang.ClassCastException: java.lang.Boolean cannot be cast to java.util.ArrayList
		}
		*/
	%>
	
	
</body>
</html>