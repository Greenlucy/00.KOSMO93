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
		
		// �����̶�� �� �ľ� �� �ڵ�!
		// req(�⺻ request) : HttpServletRequest�� ��������(�Ű�����. jsp�� ����� ������Ʈ�� �ٸ�!)
		req.setCharacterEncoding("EUC-KR");
		res.setContentType("text/html; charset=EUC-KR");		// MIME
		// ����Ʈ�Ϸ��� PrintWriter �������� out ����ؾ� ��
		PrintWriter out = res.getWriter();
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<h3>LocationServlet :: ������ �̵� �׽�Ʈ</h3>");
		out.println("<hr>");
		
		// html �� ����
		/*
		out.println("<script>");
		out.println("location.href='/testJso/cgiTest/dispatcher.jsp'");
//		out.println("location.href='http://www.naver.com'");		>> �̵��� �� ����
		out.println("</script>");
		*/
		
		// dispatcher.html ���±׿��� �Ѿ�� input �±��� hidden Ÿ�� ���� �޴´�.
		String isudtype = req.getParameter("isudtype"); 
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		
		if (isudtype != null && isudtype.length() > 0){
			isudtype = isudtype.toUpperCase();
			
			if ("SALL".equals(isudtype)){
				System.out.println("��ü��ȸ isudtype >>> : " + isudtype);
				
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
					System.out.println("������ >>> : " + e);
				}
				
				if (aList != null && aList.size() > 0){
					
					// ##### �߿� ����Ʈ!! #####  
					// LocationServlet.java������ "set"Attribute()
					// dispatcher.jsp������  "get"Attribute()
					req.setAttribute("aList", aList);
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcher.jsp");
					rd.forward(req, res);
				}else{
					out.println("aList�� ������ϴ�. >>> : ");
					out.println("<script>");
					out.println("location.href='/testJso/location'");
					out.println("</script>");
				}
			} // end of if("SALL") ��
			
			if ("S".equals(isudtype)){
				System.out.println("������ȸ isudtype >>> : " + isudtype);
				out.println("<h3>������ȸ ���� ��</h3><br>");
				
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
					System.out.println("������ >>> : " + e);
				}
				
				if (1 == nCnt){
					// dispatcherSelect.jsp�� ������ ArrayList ��ü ����
					req.setAttribute("nCnt", new Integer(nCnt));
					// RequestDipatcher �������̽����� ����ϴ� getRequestDispatcher �Լ�������
					// Context ��θ� ������� ����
					RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcherSelect.jsp");
					rd.forward(req, res);
				}else{
					out.println("<script>");
					out.println("alert('������ ��ȸ ����')");
					out.println("location.href='/testJso/cgiTest/dispatcher.html'");
					out.println("</script>");
				}
			} // end of if("S") ��
			
		}else{
			System.out.println("isudtype�� �� �����ÿ� !!!!");
			out.println("isudtype�� �� �����ÿ� !!!!");
		} // end of if(isudtype) ��
				
		out.println("</body></html>");
		
		// ������ �ִ� ��ü�� ����ؼ� ������ ��
		/*
		 /testJso/WebContent/cgiTest/dispatcher.jsp	 :: �����
		 /testJso/cgiTest/dispatcher.jsp
		 :: WebContest ��θ� ��Ŭ���� ���̳��� �� ������Ʈ ���� �����ӿ�ũ���� ����ϴ� ���� ����̴�.
		 RequestDispatcher �������̽����� ����ϴ� getReuqestDispatcher �Լ������� Context ��θ� ������� ����
		 ���ؽ�Ʈ(������) ���ο����� ������ �����̶�� �ǹ�.
		  
		RequestDispatcher rd = req.getRequestDispatcher("/cgiTest/dispatcher.jsp");
//		RequestDispatcher rd = req.getRequestDispatcher("http://www.naver.com");	>> �̵��� �� ����
		rd.forward(req, res);
		*/
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
