<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.vo.FormDataVO" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>formdata_get_spring_return</title>
</head>
<body>
	<h3>formdata_get_spring_return</h3>
	<hr>
	
	<p>
	<h3>EL ǥ�������� ������ �����ϱ�</h3>
	<hr>
	$ { m_fvo } >>> : ${ m_fvo }<br>
	$ { m_fvo.datanum } >>> : ${ m_fvo.datanum }<br>
	$ { fvo.dataid } >>> : ${ fvo.dataid }<br>
	$ { formDataVO.datapw } >>> : ${ formDataVO.datapw }<br>
	<!-- FormDataVO formDataVO = new FormDataVO();
		��ü������ �������� VOŬ���� �ν��Ͻ����� �� �������� �ձ��ڰ� Ŭ�������� �ҹ��ڷ� ���� 
		F > f
	 -->
	 
	<h3>EL ǥ���� �� ��ü �Լ��� ������ �����ϱ�</h3>
	<hr>
	$ { m_fvo } >>> : ${ m_fvo }<br>
	$ { m_fvo.getDatanum() } >>> : ${ m_fvo.getDatanum() }<br>
	$ { fvo.getDataid() } >>> : ${ fvo.getDataid() }<br>
	$ { formDataVO.getDatpw() } >>> : ${ formDataVO.getDatpw() } : FormDataVO<br>
	
	<h3>request.getAttribute() ��ü�� ������ �����ϱ�</h3>
	<%
		Object obj = request.getAttribute("m_fvo");
		FormDataVO fvo = (FormDataVO)obj;
		
		String request_datanum = String.valueOf(request.getAttribute("request_datanum"));
		String request_dataid = String.valueOf(request.getAttribute("request_dataid"));
		
		System.out.println("formdata_get_spring.jsp : datanum >>> : " + fvo.getDatanum());
		System.out.println("formdata_get_spring.jsp : dataid >>> : " + fvo.getDataid());
		System.out.println("formdata_get_spring.jsp : datapw >>> : " + fvo.getDatapw());
		System.out.println("formdata_get_spring.jsp : dataname >>> : " + fvo.getDataname());
				
		out.println("datanum >>> : " + fvo.getDatanum());
		out.println("dataid >>> : " + fvo.getDataid());
		out.println("datapw >>> : " + fvo.getDatapw());
		out.println("dataname >>> : " + fvo.getDataname());
		
		
	%>
</body>
</html>