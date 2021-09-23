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
		out.println("<h3>LocationServlet :: ������ �̵� �׽�Ʈ</h3>");
		out.println("<hr>");
		
		/*
		out.println("<script>");
		out.println("location.href='http://www.naver.com'");
		out.println("</script>");
		*/

		// dispather.html ���±׿��� �Ѿ�� input �±��� hidden Ÿ�� ���� �޴´�.
		String isudtype = req.getParameter("isudtype");
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		
		if (isudtype !=null && isudtype.length() > 0){
			isudtype = isudtype.toUpperCase();
			
			if ("SALL".equals(isudtype)){
				System.out.println("��ü��ȸ isudtype >>> : " + isudtype);
				
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
					System.out.println("������ >>> : " + e.getMessage());
				}
				
				
				if (aList !=null && aList.size() > 0){
					
					// dispather.jsp �� ������ ArrayList ��ü ����
					req.setAttribute("aList", aList);
					
					// /testKosmo/WebContent/cgiTest/dispather.jsp 
					// /testKosmo/cgiTest/dispather.jsp 
					// :: WebContent ��θ� ��Ŭ���� ���̳��� �� ������Ʈ ���� �����ӿ�ũ���� ����ϴ� ���� ����̴�.
					// RequestDispatcher �������̽� ���� ����ϴ� getRequestDispatcher �Լ������� 
					// Context ��θ� �������  ����			
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispather.jsp");
					rd.forward(req, res);			
				}else{
					out.println("<script>");
					out.println("alert('������ ��ȸ ����')");
					out.println("location.href='/testKosmo/location'");
					out.println("</script>");
				}				
			}
			
			if ("S".equals(isudtype)){
				System.out.println("������ȸ isudtype >>> : " + isudtype);				
				out.println("<h3>������ȸ ���� ��</h3><br>");		

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
					System.out.println("������ >>> : " + e.getMessage());
				}
				
				if (1 == nCnt){					
					// dispatherSelect.jsp �� ������ ArrayList ��ü ����
					
					req.setAttribute("nCnt", new Integer(nCnt));
					
					// RequestDispatcher �������̽� ���� ����ϴ� getRequestDispatcher �Լ������� 
					// Context ��θ� �������  ����
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatherSelect.jsp");
					rd.forward(req, res);		
					
				}else{
					out.println("<script>");
					out.println("alert('������ ��ȸ ����')");
					out.println("location.href='/testKosmo/cgiTest/dispather.html'");
					out.println("</script>");
				}							
			}
			
		}else{
			System.out.println("isudtype�� �� �����ÿ� !!!! ");
		}
		
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
