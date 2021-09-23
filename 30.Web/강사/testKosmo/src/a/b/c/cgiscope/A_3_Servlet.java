package a.b.c.cgiscope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A_3_Servlet
 */
@WebServlet("/a_3")
public class A_3_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		out.println("a_3 A_3_Servlet ::: mid >>> : " + mid + "<br>");
		out.println("a_3 A_3_Servlet ::: mpw >>> : " + mpw + "<br>");
		System.out.println("a_3 A_3_Servlet ::: mid >>> : " + mid);
		System.out.println("a_3 A_3_Servlet ::: mpw >>> : " + mpw);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
