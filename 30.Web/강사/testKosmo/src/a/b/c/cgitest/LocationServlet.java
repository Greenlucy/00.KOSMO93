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

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html; charset=EUC-KR"); 
		PrintWriter out = res.getWriter();
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h3>LocationServlet :: 페이지 이동 테스트</h3>");
		out.println("<hr>");
		
		/*
		out.println("<script>");
		out.println("location.href='http://www.naver.com'");
		out.println("</script>");
		*/

		// dispather.html 폼태그에서 넘어온 input 태그의 hidden 타입 값을 받는다.
		String isudtype = req.getParameter("isudtype");
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		
		if (isudtype !=null && isudtype.length() > 0){
			isudtype = isudtype.toUpperCase();
			
			if ("SALL".equals(isudtype)){
				System.out.println("전체조회 isudtype >>> : " + isudtype);
				
				ArrayList<EmpVO> aList = null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO00", "scott","tiger");
					Statement stmt = conn.createStatement();
					ResultSet rsRs = stmt.executeQuery("SELECT * FROM EMP");
					aList = new ArrayList<EmpVO>();
					while (rsRs.next()){
						EmpVO evo = new EmpVO();
						evo.setEmpno(rsRs.getString(1));
						evo.setEname(rsRs.getString(2));
						evo.setJob(rsRs.getString(3));
						evo.setMgr(rsRs.getString(4));
						evo.setHiredate(rsRs.getString(5));
						evo.setSal(rsRs.getString(6));
						evo.setComm(rsRs.getString(7));
						evo.setDeptno(rsRs.getString(8));
						
						aList.add(evo);						
					}
					//aList = null;
				} catch (Exception e) {
					// TODO Auto-generated catch block 
					System.out.println("에러가 >>> : " + e.getMessage());
				}
				
				
				if (aList !=null && aList.size() > 0){
					
					// dispather.jsp 로 보내는 ArrayList 객체 세팅
					req.setAttribute("aList", aList);
					
					// /testKosmo/WebContent/cgiTest/dispather.jsp 
					// /testKosmo/cgiTest/dispather.jsp 
					// :: WebContent 경로를 이클립스 다이나믹 웹 프로젝트 빌드 프레임워크에서 사용하는 가상 경로이다.
					// RequestDispatcher 인터페이스 에서 사용하는 getRequestDispatcher 함수에서는 
					// Context 경로를 사용하지  않음			
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispather.jsp");
					rd.forward(req, res);			
				}else{
					out.println("<script>");
					out.println("alert('데이터 조회 실패')");
					out.println("location.href='/testKosmo/location'");
					out.println("</script>");
				}				
			}
			
			if ("S".equals(isudtype)){
				System.out.println("조건조회 isudtype >>> : " + isudtype);				
				out.println("<h3>조건조회 실행 블럭</h3><br>");		

				int nCnt = 0;
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO00", "scott","tiger");
					Statement stmt = conn.createStatement();
					ResultSet rsRs = stmt.executeQuery("SELECT COUNT(EMPNO) NCNT FROM EMP WHERE EMPNO = " + empno + " AND ENAME = " + "'" + ename + "'");
					while (rsRs.next()){
						nCnt = rsRs.getInt(1);					
					}
				} catch (Exception e) {
					System.out.println("에러가 >>> : " + e.getMessage());
				}
				
				if (1 == nCnt){					
					// dispatherSelect.jsp 로 보내는 ArrayList 객체 세팅
					
					req.setAttribute("nCnt", new Integer(nCnt));
					
					// RequestDispatcher 인터페이스 에서 사용하는 getRequestDispatcher 함수에서는 
					// Context 경로를 사용하지  않음
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatherSelect.jsp");
					rd.forward(req, res);		
					
				}else{
					out.println("<script>");
					out.println("alert('데이터 조회 실패')");
					out.println("location.href='/testKosmo/cgiTest/dispather.html'");
					out.println("</script>");
				}							
			}
			
		}else{
			System.out.println("isudtype을 잘 보내시오 !!!! ");
		}
		
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
