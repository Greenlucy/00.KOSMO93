package a.b.c.cgitest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocationServlet
 */
@WebServlet("/location")
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 서블릿이라면 꼭 쳐야 할 코드!
		// req(기본 request) : HttpServletRequest의 참조변수(매개변수. jsp의 내장된 오브젝트와 다름!)
		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html; charset=EUC-KR");		// MIME
		// 프린트하려면 PrintWriter 참조변수 out 사용해야 함
		PrintWriter out = res.getWriter();
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h3>LocationServlet :: 페이지 이동 테스트</h3>");
		out.println("<hr>");
		
		// html 안 쓰고
		/*
		out.println("<script>");
		out.println("location.href='/testJso/cgiTest/dispatcher.jsp'");
//		out.println("location.href='http://www.naver.com'");		>> 이동할 수 있음
		out.println("</script>");
		*/
		
		// dispatcher.html 폼태그에서 넘어온 input 태그의 hidden 타입 값을 받는다.
		String isudtype = req.getParameter("isudtype"); 
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		
		if (isudtype != null && isudtype.length() > 0){
			isudtype = isudtype.toUpperCase();
			
			if ("SALL".equals(isudtype)){
				System.out.println("전체조회 isudtype >>> : " + isudtype);
				
				ArrayList<EmpVO> aList = null;
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO", "scott", "tiger");
					Statement stmt = conn.createStatement();
					ResultSet rsRs = stmt.executeQuery("SELECT * FROM EMP");
					aList = new ArrayList<EmpVO>();
					while (rsRs.next()){
						EmpVO evo = new EmpVO();
						evo.setEmpno(rsRs.getString("EMPNO"));
						evo.setEname(rsRs.getString("ENAME"));
						evo.setJob(rsRs.getString("JOB"));
						evo.setMgr(rsRs.getString("MGR"));
						evo.setHiredate(rsRs.getString("HIREDATE"));
						evo.setSal(rsRs.getString("SAL"));
						evo.setComm(rsRs.getString("COMM"));
						evo.setDeptno(rsRs.getString("DEPTNO"));
						
						aList.add(evo);
					}
				}catch(Exception e){
					System.out.println("에러가 >>> : " + e);
				}
				
				if (aList != null && aList.size() > 0){
					
					// ##### 중요 포인트!! #####  
					// LocationServlet.java에서는 "set"Attribute()
					// dispatcher.jsp에서는  "get"Attribute()
					req.setAttribute("aList", aList);
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcher.jsp");
					rd.forward(req, res);
				}else{
					out.println("aList가 비었습니다. >>> : ");
					out.println("<script>");
					out.println("location.href='/testJso/location'");
					out.println("</script>");
				}
			} // end of if("SALL") 문
			
			if ("S".equals(isudtype)){
				System.out.println("조건조회 isudtype >>> : " + isudtype);
				out.println("<h3>조건조회 실행 블럭</h3><br>");
				
				int nCnt = 0; 
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO", "scott", "tiger");
					Statement stmt = conn.createStatement();
					ResultSet rsRs = stmt.executeQuery("SELECT COUNT(EMPNO) NCNT FROM EMP WHERE EMPNO = " + empno + " AND ENAME = " + "'" + ename + "'");
					
					while (rsRs.next()){
						nCnt = rsRs.getInt(1);
					}
					
				}catch(Exception e){
					System.out.println("에러가 >>> : " + e);
				}
				
				if (1 == nCnt){
					// dispatcherSelect.jsp로 보내는 ArrayList 객체 세팅
					req.setAttribute("nCnt", new Integer(nCnt));
					// RequestDipatcher 인터페이스에서 사용하는 getRequestDispatcher 함수에서는
					// Context 경로를 사용하지 않음
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcherSelect.jsp");
					rd.forward(req, res);
				}else{
					out.println("<script>");
					out.println("alert('데이터 조회 실패')");
					out.println("location.href='/testJso/cgiTest/dispatcher.html'");
					out.println("</script>");
				}
			} // end of if("S") 문
			
		}else{
			System.out.println("isudtype을 잘 보내시오 !!!!");
			out.println("isudtype을 잘 보내시오 !!!!");
		} // end of if(isudtype) 문
				
		out.println("</body></html>");
		
		// 서블릿에 있는 객체를 사용해서 보내는 것
		/*
		 /testJso/WebContent/cgiTest/dispatcher.jsp	 :: 상대경로
		 /testJso/cgiTest/dispatcher.jsp
		 :: WebContest 경로를 이클립스 다이나믹 웹 프로젝트 빌드 프레임워크에서 사용하는 가상 경로이다.
		 RequestDispatcher 인터페이스에서 사용하는 getReuqestDispatcher 함수에서는 Context 경로를 사용하지 않음
		 컨텍스트(도메인) 내부에서만 파일을 움직이라는 의미.
		  
		RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcher.jsp");
//		RequestDispatcher rd = req.getRequestDispatcher("http://www.naver.com");	>> 이동할 수 없음
		rd.forward(req, res);
		*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
