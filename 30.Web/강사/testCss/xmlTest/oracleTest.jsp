<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>OracleTest</title>
</head>
<body>
<!-- 
	JNDI InitalContext
	JNDI : Java Naming and Directory Interface	
	JNDI �� �ڹٿ��� �ڱ� ��ǻ��(����) �Ǵ� �ٸ� ��ǻ��(�ٸ� ����)��
	���丮��(���丮���ִ� ������) �̸����� ã�ư��� �����̴�. 
 -->
<h3>
	JNDI InitalContext <br>
	JNDI : Java Naming and Directory Interface   
</h3>
<hr>
<%
	
	//Obtain our environment naming context
	Context initCtx = new InitialContext();
	out.println("initCtx >>> : " + initCtx + "<br>");
	
	//initCtx�� lookup�޼��带 �̿��ؼ� "java:comp/env" �� �ش��ϴ� ��ü�� ã�Ƽ� evnCtx�� ����
	Context envCtx = (Context) initCtx.lookup("java:comp/env");
	out.println("envCtx >>> : " + envCtx + "<br>");
	
	//Look up our data source
	//envCtx�� lookup�޼��带 �̿��ؼ� "jdbc/Oracle11g_orclHBE00"�� �ش��ϴ� ��ü�� ã�Ƽ� ds�� ����
	//name="jdbc/Oracle11g_orclKOSMO00"
	DataSource ds = (DataSource)envCtx.lookup("jdbc/Oracle11g_orclKOSMO00");
	out.println("ds >>> : " + ds + "<br><hr>");

	//getConnection�޼��带 �̿��ؼ� Ŀ�ؼ� Ǯ�� ���� Ŀ�ؼ� ��ü�� ���� conn������ ����
	Connection conn = ds.getConnection();
	PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMP");
	ResultSet rsRs = stmt.executeQuery();
	
	while (rsRs.next()){
		out.println(rsRs.getString(1) + " ");
		out.println(rsRs.getString(2) + " ");
		out.println(rsRs.getString(3) + " ");
		out.println(rsRs.getString(4) + " ");
		out.println(rsRs.getString(5) + " ");
		out.println(rsRs.getString(6) + " ");
		out.println(rsRs.getString(7) + " ");
		out.println(rsRs.getString(8) + " <br>");
	}

%>

</body>
</html>