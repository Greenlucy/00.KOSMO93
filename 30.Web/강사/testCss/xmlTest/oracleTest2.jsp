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
 -->
<h3>
	JNDI InitalContext <br>
	JNDI : Java Naming and Directory Interface   
</h3>
<hr>
<%
	// 사용할 때는 하기 방법으로 사용할 것 
	// java:comp/env : JNDI 환경변수 이름 
	// jdbc/Oracle11g_orclHBE00 : context.xml 리소스 엘리먼트(Resource)에 선언한 
	// name 속성의 이름(name="jdbc/Oracle11g_orclKOSMO00")과 같아야 한다. 
	Context context = new InitialContext();
	DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g_orclHBE00");
	
	Connection conn = dataSource.getConnection(); 
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