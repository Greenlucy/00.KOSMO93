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
<h3>EL 표현식으로 데이터 추출하기</h3>
<hr>
$ {m_fvo } >>> : ${m_fvo }<br>
$ {m_fvo.datanum } >>> : ${m_fvo.datanum }<br>
$ {fvo.dataid } >>> : ${fvo.dataid }<br>
$ {formDataVO.datapw } >>> : ${formDataVO.datapw } : FormDataVO<br>
<!--  FormDataVO formDataVO = new FormDataVO(); -->
<p>
<h3>EL 표현식 및 객체 함수로 데이터 추출하기</h3>
<hr>
\${m_fvo } >>> : ${m_fvo }<br>
\${m_fvo.getDatanum() } >>> : ${m_fvo.getDatanum() }<br>
\${fvo.getDataid() } >>> : ${fvo.getDataid() }<br>
\${formDataVO.getDatapw() } >>> : ${formDataVO.getDatapw() } : FormDataVO<br>

<p>
<h3>request.getAttribute() 객체로 데이터 추출하기</h3>
<hr>
<%
	Object obj = request.getAttribute("m_fvo");
	FormDataVO fdvo = (FormDataVO)obj;
	
	System.out.println("formdata_get_spring_return.jsp >>> : fdvo >>> : " + fdvo);	
	System.out.println("formdata_get_spring_return.jsp >>> : fdvo.getDatanum() ::: " + fdvo.getDatanum());
	System.out.println("formdata_get_spring_return.jsp >>> : fdvo.getDataid() ::: " + fdvo.getDataid());
	System.out.println("formdata_get_spring_return.jsp >>> : fdvo.getDatapw() ::: " + fdvo.getDatapw());
	System.out.println("formdata_get_spring_return.jsp >>> : fdvo.getDataname() ::: " + fdvo.getDataname());
	
	out.println("formdata_get_spring_return.jsp >>> : fdvo >>> : " + fdvo + "<br>");	
	out.println("formdata_get_spring_return.jsp >>> : fdvo.getDatanum() ::: " + fdvo.getDatanum() + "<br>");
	out.println("formdata_get_spring_return.jsp >>> : fdvo.getDataid() ::: " + fdvo.getDataid() + "<br>");
	out.println("formdata_get_spring_return.jsp >>> : fdvo.getDatapw() ::: " + fdvo.getDatapw() + "<br>");
	out.println("formdata_get_spring_return.jsp >>> : fdvo.getDataname() ::: " + fdvo.getDataname() + "<br>");
%>
</body>
</html>