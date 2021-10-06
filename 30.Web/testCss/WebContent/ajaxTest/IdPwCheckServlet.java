package a.b.c.com.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/idpwCheck")
public class IdPwCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("ISUD_TYPE");	
		if (isudType !=null && isudType.length() > 0){
			isudType = isudType.toUpperCase();
			
			// 아이디 중복 체크 
			if("IDCHECK".equals(isudType)){
				out.println("isudType >>> : " + isudType);
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rsRs = null;
				
				int nCnt = 0;	
				String idCheckVal = "";
				
				String idCheckQuery = "SELECT COUNT(A.ENAME) NCNT FROM EMP A WHERE A.ENAME = ?";				
				
				String mid = request.getParameter("mid");				
				
				try {			

					conn = CommonDBConn.getConnection();
					pstmt = conn.prepareStatement(idCheckQuery);
					System.out.println("아이디 중복 조회 >>> : \n"+ idCheckQuery);
		  
					pstmt.setString(1, mid);
					rsRs = pstmt.executeQuery();
					
					if (rsRs !=null) {
						while (rsRs.next()) {
							nCnt = rsRs.getInt(1);								
						}
					}						
				}catch(Exception e) {
					System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
				}
				
				if (nCnt == 1 ){
					idCheckVal = "IDGOOD";		
				}else{
					idCheckVal = "IDBAD";
				}
				
				if (idCheckVal.length() > 0){
					System.out.println("idCheckVal >>> : " + idCheckVal);				
					request.setAttribute("idCheckVal", idCheckVal);				
					RequestDispatcher rd= request.getRequestDispatcher("/ajaxTest/check/idCheck.jsp");
					rd.forward(request, response);
				}else{
					// Ajax 에서는 구현하지 않는다. 
				}
			}
			
			if("PWCHECK".equals(isudType)){
				out.println("isudType >>> : " + isudType);
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rsRs = null;
				int nCnt = 0;
				String pwCheckVal = "";
				
				String pwCheckQuery = "SELECT COUNT(A.EMPNO) NCNT FROM EMP A WHERE A.EMPNO = ?";				
				String mpw = request.getParameter("mpw");				
				
				try {			

					conn = CommonDBConn.getConnection();
					pstmt = conn.prepareStatement(pwCheckQuery);
					System.out.println("패스워드 체크 조회 >>> : \n"+ pwCheckQuery);
		  
					pstmt.setString(1, mpw);
					rsRs = pstmt.executeQuery();
					
					if (rsRs !=null) {
						while (rsRs.next()) {
							nCnt = rsRs.getInt(1);								
						}
					}						
				}catch(Exception e) {
					System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
				}
				
				if (nCnt == 1 ){
					pwCheckVal = "PW_GOOD";		
				}else{
					pwCheckVal = "PW_BAD";
				}
				
				if (pwCheckVal.length() > 0){
					System.out.println("pwCheckVal >>> : " + pwCheckVal);					
					request.setAttribute("pwCheckVal", pwCheckVal);				
					RequestDispatcher rd= request.getRequestDispatcher("/ajaxTest/check/pwCheck.jsp");
					rd.forward(request, response);					
				}else{
					// Ajax 에서는 구현하지 않는다. 
				}
			}
	
		}else{
			System.out.println("isudType 타입을 잘 넘기세요  >>> : " + isudType);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
