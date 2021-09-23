package a.b.c.cgitest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestJspServlet_5
 */
@WebServlet("/testjsp_5")
public class TestJspServlet_5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>Servlet ...</title></head><body>");
		
		// http://192.168.219.100:8088/testKosmo/testjsp_5
		String remoteAddr = req.getRemoteAddr();
		out.println("remoteAddr >>> : " + remoteAddr + "<br>");
		System.out.println("remoteAddr >>> : " + remoteAddr);
		
		String protocol = req.getProtocol();
		out.println("protocol >>> : " + protocol + "<br>");
		System.out.println("protocol >>> : " + protocol);
		
		String method = req.getMethod();
		out.println("method >>> : " + method + "<br>");
		System.out.println("method >>> : " + method);
		
		String uri = req.getRequestURI();
		out.println("uri >>> : " + uri + "<br>");
		System.out.println("uri >>> : " + uri);	
		
		String url = req.getRequestURL().toString();
		out.println("url >>> : " + url + "<br>");
		System.out.println("url >>> : " + url);	
		
		String context = req.getContextPath();
		out.println("context >>> : " + context + "<br>");
		System.out.println("context >>> : " + context);	
		
		String serverName = req.getServerName();
		out.println("serverName >>> : " + serverName + "<br>");
		System.out.println("serverName >>> : " + serverName);	
		
		String serverPort = String.valueOf(req.getServerPort());
		out.println("serverPort >>> : " + serverPort + "<br>");
		System.out.println("serverPort >>> : " + serverPort);	
		
		String remotePort = String.valueOf(req.getRemotePort());
		out.println("remotePort >>> : " + remotePort + "<br>");
		System.out.println("remotePort >>> : " + remotePort);
	
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
