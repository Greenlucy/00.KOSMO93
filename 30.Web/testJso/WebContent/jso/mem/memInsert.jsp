<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>ȸ������ ���</title>
	</head>
<body>
	<% request.setCharacterEncoding("EUC-KR"); %>
	INSERT
	<%
		Object obj = request.getAttribute("boolI");
		/* 
			Boolean : public final class Boolean
			The Boolean class wraps a value of the primitive type boolean in an object. 
		 	(Boolean Ŭ������ ��ü�� �⺻ ���� �� ���� �����մϴ�.)
		 	In addition, this class provides many methods for converting a boolean to a String and a String to a boolean, as well as other constants and methods useful when dealing with a boolean.
		 	(���� �� Ŭ������ ���� ���ڿ��� ��ȯ�ϰ� ���ڿ��� �ҷ� ��ȯ�ϱ� ���� ���� �޼��带 ������ �Ӹ� �ƴ϶� ���� ó���� �� ������ ��Ÿ ��� �� �޼��带 �����մϴ�.)
		
		 	boolean : primitive type (�⺻ �ڷ���)
		 	Boolean : reference type (���۷��� Ÿ�� : ���� �޼ҵ带 ����)
		 	boolean a = null;		// ���� �߻�	(boolean�� true �Ǵ� false���� ��ȯ ����)
		 	Boolean a = null;		// ���������� ������ ��
		*/
		// Boolean.booleanValue() : �� Boolean Object�� ���� boolean primitive(����, �⺻ ����)�� ��ȯ�մϴ�.
		boolean bool = ((Boolean)obj).booleanValue();
		
		if (bool){
			System.out.println("memInsert.jsp >>> : ȸ������ ��� ���� !!!");
	%>
	<script>
		// ��ü��ȸ�� �̵��ϰ� ��.(��ü��� ��ȸ ����)
		location.href="/testJso/member?ISUD_TYPE=SALL";
	</script>
	<%
		}else{
			System.out.println("memInsert.jsp >>> : ȸ������ ��� ���� !!!");
		}
	%>
</body>
</html>