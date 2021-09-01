<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입 JSP</title>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR"); %>
	<h3>회원가입 jsp</h3>
	<hr>

	<%
		String mname = request.getParameter("mname");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mgender = request.getParameter("mgender");
		String mbirth = request.getParameter("mbirth");
		String mbirth1 = request.getParameter("mbirth1");
		String mbirth2 = request.getParameter("mbirth2");
		String mhp = request.getParameter("mhp");
		String mhp1 = request.getParameter("mhp1");
		String mhp2 = request.getParameter("mhp2");
		String mtel = request.getParameter("mtel");
		String mtel1 = request.getParameter("mtel1");
		String mtel2 = request.getParameter("mtel2");
		String meamil = request.getParameter("memail");
		String memail1 = request.getParameter("memail1");
		String memail2 = request.getParameter("memail2");
		String mzonecode = request.getParameter("mzonecode");
		String mroadaddress = request.getParameter("mroadaddress");
		String mroadaddressdetail = request.getParameter("mroadaddress");
		String mjibunaddress = request.getParameter("mgibunaddress");
		String mhobby = request.getParameter("mhobby");
		String minfo = request.getParameter("minfo");
		String mphoto = request.getParameter("mphoto");
		
		System.out.println("mname >>> : " + mname);
		System.out.println("mid >>> : " + mid);
		System.out.println("mpw >>> : " + mpw);
		System.out.println("mgender >>> : " + mgender);
		System.out.println("mbirth >>> : " + mbirth);
		System.out.println("mbirth1 >>> : " + mbirth1);
		System.out.println("mbirth2 >>> : " + mbirth2);
		System.out.println("mhp >>> : " + mhp );
		System.out.println("mhp1 >>> : " + mhp1);
		System.out.println("mhp2 >>> : " + mhp2);
		System.out.println("mtel >>> : " + mtel);
		System.out.println("mtel1 >>> : " + mtel1);
		System.out.println("mtel2 >>> : " + mtel2);
		System.out.println("memail >>> : " + meamil);
		System.out.println("meamil1 >>> : " + memail1);
		System.out.println("meamil2 >>> : " + memail2);
		System.out.println("mzonecode >>> : " + mzonecode);
		System.out.println("mroadaddress >>> : " + mroadaddress);
		System.out.println("mroadaddressdetail >>> : " + mroadaddressdetail);
		System.out.println("mjibunaddress >>> : " + mjibunaddress);
		System.out.println("mhobby >>> : " + mhobby);
		System.out.println("minfo >>> : " + minfo);
		System.out.println("mphoto >>> : " + mphoto);
		
		out.println("mname >>> : " + mname + "<br>");
		out.println("mid >>> : " + mid + "<br>");
		out.println("mpw >>> : " + mpw + "<br>");
		out.println("mgender >>> : " + mgender + "<br>");
		out.println("mbirth >>> : " + mbirth + "<br>");
		out.println("mbirth1 >>> : " + mbirth1 + "<br>");
		out.println("mbirth2 >>> : " + mbirth2 + "<br>");
		out.println("mhp >>> : " + mhp + "<br>" );
		out.println("mhp1 >>> : " + mhp1 + "<br>");
		out.println("mhp2 >>> : " + mhp2 + "<br>");
		out.println("mtel >>> : " + mtel + "<br>");
		out.println("mtel1 >>> : " + mtel1 + "<br>");
		out.println("mtel2 >>> : " + mtel2 + "<br>");
		out.println("memail >>> : " + meamil + "<br>");
		out.println("meamil1 >>> : " + memail1 + "<br>");
		out.println("meamil2 >>> : " + memail2 + "<br>");
		out.println("mzonecode >>> : " + mzonecode + "<br>");
		out.println("mroadaddress >>> : " + mroadaddress + "<br>");
		out.println("mroadaddressdetail >>> : " + mroadaddressdetail + "<br>");
		out.println("mjibunaddress >>> : " + mjibunaddress + "<br>");
		out.println("mhobby >>> : " + mhobby + "<br>");
		out.println("minfo >>> : " + minfo + "<br>");
		out.println("mphoto >>> : " + mphoto + "<br>");
		
	%>	

</body>
</html>