package a.b.c.cgiform;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class CgiFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>CgiFormServlet</title></head><body>");
		out.println("<h3>CgiFormServlet</h3>header<hr>");
		
		String isudtype = request.getParameter("isudtype");
		if (isudtype !=null) isudtype.toUpperCase();
		
		if (isudtype !=null && isudtype.length() > 0){
			System.out.println("isudtype >>> : " + isudtype);
			System.out.println("remoteIP >>> : " + request.getRemoteAddr());
			System.out.println("method >>> : " + request.getMethod());	
			
			// 도서 정보 전체 조회
			if ("I".equals(isudtype)){
				
				Enumeration<String> em = request.getHeaderNames();
				while (em.hasMoreElements()){
					String name = em.nextElement();
					String value = request.getHeader(name);
					out.println(name + " : " + value + "<br>");
					System.out.println(name + " : " + value);		
				}
				
				out.println("<br>getParameter<hr>");	
				
				// input type="text"			
				String mname = request.getParameter("mname");
				out.println("mname >>> : " + mname + "<br>");
				System.out.println("mname >>> : " + mname);
				
				String mid = request.getParameter("mid");
				out.println("mid >>> : " + mid + "<br>");
				System.out.println(mid);
				System.out.println("mid >>> : " + mid);
				
				String mpw = request.getParameter("mpw");
				out.println("mpw >>> : " + mpw + "<br>");
				System.out.println(mpw);
				System.out.println("mpw >>> : " + mpw);
					
				// input type="radio"
				String mgender = request.getParameter("mgender");
				out.println("mgender >>> : " + mgender + "<br>");
				System.out.println("mgender >>> : " + mgender);
						
				// input type="checkbox"
				String mhobby = "";					
				String hobby[] = request.getParameterValues("mhobby");		
				if (hobby !=null){
					for(int i=0; i < hobby.length; i++){
						//out.println("hobby : " + hobby[i] + ", <br>");
						//System.out.println("hobby : " + hobby[i] + ",");
						mhobby += hobby[i] + ",";
					}		
				}
				out.println("mhobby >>> : " + mhobby + "<br>");	
				
				// input type="select"
				String mlocal = request.getParameter("mlocal");
				out.println("mlocal >>> : " + mlocal + "<br>");
				System.out.println("mlocal >>> : " + mlocal);
				
				// textarea
				String mmsg = request.getParameter("mmsg");
				out.println("mmsg >>> : " + mmsg + "<br>");
				System.out.println("mmsg >>> : " + mmsg);	
			}
		}else{			
			System.out.println("isudtype 을 잘 보내시오 !!!");
		}	
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
