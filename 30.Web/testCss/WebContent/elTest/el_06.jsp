<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="a.b.c.com.common.EL_MemberVO" %>
    <%
    	// 배열 : String[]
    	String[] study ={ "JAVA", "View", "SQL", "Servlet/JSP/SPRING", "Android", "IoT", "Project" };
    	request.setAttribute("sutdy", study);
    	
    	// ArrayList<String>
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("오렌지");
    	list.add("바나나");
    	list.add("사과");
    	list.add("멜론");
    	list.add("레몬");
    	request.setAttribute("list", list);
    	
    	// EL_MemberVO()
    	EL_MemberVO mvo = new EL_MemberVO();
    	mvo.setIrum("김자성");
    	mvo.setId("KJS");
    	mvo.setPw("1234");
    	mvo.setAge(24);
    	mvo.setAddr("경기도 호법");
    	mvo.setTel("032-111-2222");
    	request.setAttribute("mvo", mvo);
    	
    	// ArrayList<EL_MemberVO>
    	ArrayList<EL_MemberVO> mlist = new ArrayList<>();
    	mlist.add(new EL_MemberVO("홍길동", "hong", "1234", 11, "서울시", "010-1111-1111"));
    	mlist.add(new EL_MemberVO("홍길동", "hong", "1234", 22, "서울시", "010-2222-2222"));
    	mlist.add(new EL_MemberVO("홍길동", "hong", "1234", 33, "서울시", "010-3333-3333"));
    	mlist.add(new EL_MemberVO("홍길동", "hong", "1234", 44, "서울시", "010-4444-4444"));
    	mlist.add(new EL_MemberVO("홍길동", "hong", "1234", 55, "서울시", "010-5555-5555"));
    	request.setAttribute("mlist", mlist);
    %>
    <jsp:forward page="el_06_1.jsp" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>el_06</title>
</head>
<body>
	<h3>el_06</h3>
	<hr>
</body>
</html>