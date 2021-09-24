package a.b.c.com.jso.login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a.b.c.com.jso.login.service.LoginService;
import a.b.c.com.jso.login.service.LoginServiceImpl;
import a.b.c.com.jso.mem.vo.MemberVO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoginController doGet() �Լ� ���� >>> : ");
		
		// html���� ���� �޾ƿ� �� �ְ� �����ϱ�
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html); charset=EUC-KR");		// ��� ������
		// �������� html �ڵ��� out�� ����� �� �ְ� �����ϱ�
		PrintWriter out = response.getWriter();
		
		String login_type = request.getParameter("login_type");
		
		if (login_type != null && login_type.length() > 0){
			login_type.toUpperCase();
			
			String remoteIP = request.getRemoteAddr();
			String method = request.getMethod();
			
			// �α���
			if ("LOGIN".equals(login_type)){
				out.println("�α��� üũ login_type >>> : " + login_type);
				System.out.println("�α��� üũ login_type >>> : " + login_type);
				System.out.println("method >>> : " + method);
				System.out.println("remoteIP >>> : " + remoteIP);
				
				// ���������κ��� �Է¹��� ������ ������ �����ϱ� 
				String mid = request.getParameter("mid");
				String mpw = request.getParameter("mpw");
				System.out.println("mid >>> : " + mid);
				System.out.println("mpw >>> : " + mpw);
				
				// ���� ȣ��
				LoginService ls = new LoginServiceImpl();
				
				MemberVO mvo = null;
				mvo = new MemberVO();
				// ���������κ��� �Է¹��� placeholder ������ mvo�� set�ϱ�
				mvo.setMid(mid);
				mvo.setMpw(mpw);
				System.out.println("���̵� mid >>> : " + mid);
				System.out.println("��й�ȣ mpw >>> : " + mpw);
				
				// set�� ������ ~~LoginDAOImpl loginCheckCnt()�Լ��� �ƱԸ�Ʈ�� �Է��Ͽ� 
				// int�� ���� nCnt�� �����ϰ� ����(�Ҵ�)�ϱ� 
				int nCntL = ls.loginCheckCnt(mvo);
				System.out.println("nCnt >>> : " + nCntL);
				
				// jsp�� ������ �����ϱ�
				if (nCntL > 0){
					System.out.println("�α��� ���� !!");
					request.setAttribute("nCntL", new Integer(nCntL));
					RequestDispatcher rd = request.getRequestDispatcher("/jso/login/login.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("�α��� ���� !!");
					out.println("<script>");
					out.println("alert('�α��� ���� !!')");
					out.println("location.href='/testJso/jso/login/login.html'");
					out.println("</script>");
				}
			}
			
			if ("LOGOUT".equals(login_type)){
				out.println("�α׾ƿ� login_type >>> : " + login_type);
				System.out.println("�α׾ƿ� login_type >>> : " + login_type);
				
				String mid = request.getParameter("mid");
				boolean bool = false;
				
				if (mid != null && mid.length() > 0){
					bool = true;
				}
				
				if (bool){
					RequestDispatcher rd = request.getRequestDispatcher("/jso/login/logout.jsp");
					rd.forward(request, response);
				}else{
					
				}
			}
		}else{
			System.out.println("login_type�� �� �ѱ⼼�� >>> : " + login_type);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoginController doPost() �Լ� ���� >>> : ");
		doGet(request, response);
	}

}
