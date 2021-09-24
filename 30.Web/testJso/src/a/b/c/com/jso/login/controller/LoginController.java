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
		System.out.println("LoginController doGet() 함수 진입 >>> : ");
		
		// html에서 정보 받아올 수 있게 세팅하기
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html); charset=EUC-KR");		// 요거 빼먹음
		// 서블릿에서 html 코드인 out을 사용할 수 있게 세팅하기
		PrintWriter out = response.getWriter();
		
		String login_type = request.getParameter("login_type");
		
		if (login_type != null && login_type.length() > 0){
			login_type.toUpperCase();
			
			String remoteIP = request.getRemoteAddr();
			String method = request.getMethod();
			
			// 로그인
			if ("LOGIN".equals(login_type)){
				out.println("로그인 체크 login_type >>> : " + login_type);
				System.out.println("로그인 체크 login_type >>> : " + login_type);
				System.out.println("method >>> : " + method);
				System.out.println("remoteIP >>> : " + remoteIP);
				
				// 웹브라우저로부터 입력받은 데이터 변수에 저장하기 
				String mid = request.getParameter("mid");
				String mpw = request.getParameter("mpw");
				System.out.println("mid >>> : " + mid);
				System.out.println("mpw >>> : " + mpw);
				
				// 서비스 호출
				LoginService ls = new LoginServiceImpl();
				
				MemberVO mvo = null;
				mvo = new MemberVO();
				// 웹브라우저로부터 입력받은 placeholder 데이터 mvo에 set하기
				mvo.setMid(mid);
				mvo.setMpw(mpw);
				System.out.println("아이디 mid >>> : " + mid);
				System.out.println("비밀번호 mpw >>> : " + mpw);
				
				// set한 데이터 ~~LoginDAOImpl loginCheckCnt()함수에 아규먼트로 입력하여 
				// int형 변수 nCnt를 선언하고 저장(할당)하기 
				int nCntL = ls.loginCheckCnt(mvo);
				System.out.println("nCnt >>> : " + nCntL);
				
				// jsp와 데이터 연결하기
				if (nCntL > 0){
					System.out.println("로그인 성공 !!");
					request.setAttribute("nCntL", new Integer(nCntL));
					RequestDispatcher rd = request.getRequestDispatcher("/jso/login/login.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("로그인 실패 !!");
					out.println("<script>");
					out.println("alert('로그인 실패 !!')");
					out.println("location.href='/testJso/jso/login/login.html'");
					out.println("</script>");
				}
			}
			
			if ("LOGOUT".equals(login_type)){
				out.println("로그아웃 login_type >>> : " + login_type);
				System.out.println("로그아웃 login_type >>> : " + login_type);
				
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
			System.out.println("login_type을 잘 넘기세요 >>> : " + login_type);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("LoginController doPost() 함수 진입 >>> : ");
		doGet(request, response);
	}

}
