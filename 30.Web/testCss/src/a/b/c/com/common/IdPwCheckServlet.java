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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet() 함수 진입 >>> : ");
		
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("ISUD_TYPE");
		if (isudType != null && isudType.length() > 0){
			isudType = isudType.toUpperCase();
			
			// 아이디 중복 체크
			if ("IDCHECK".equals(isudType)){
				out.println("isudType >>> : " + isudType);
				
				// dao, service, sql 생략 + 간략화
				// 사용할 객체 선언하고 초기화
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
					System.out.println("아이디 중복 조회 >>> : \n" + idCheckQuery);
					
					pstmt.clearParameters();
					pstmt.setString(1, mid);
					rsRs = pstmt.executeQuery();
					
					if (rsRs != null){
						while(rsRs.next()){
							nCnt = rsRs.getInt(1);			// 공부
						}
					}
				}catch(Exception e){
					System.out.println("디비연동에 문제가 생겼습니다. >>> : " + e);
				}
				
				if (nCnt == 1){
					idCheckVal = "IDGOOD";
				}else{
					idCheckVal = "IDBAD";
				}
				
				if (idCheckVal.length() > 0){
					System.out.println("idCheckVal >>> : " + idCheckVal);
					request.setAttribute("idCheckVal", idCheckVal);
					RequestDispatcher rd = request.getRequestDispatcher("/ajaxTest/check/idCheck.jsp");
					rd.forward(request, response);
				}else{
					// Ajax 에서는 구현하지 않는다. >> 다른 곳으로 보내야 하는게 아니라, Ajax로 보내야 함
				}
			} // end of if("IDCHECK")
			
			// 비밀번호 확인
			if ("PWCHECK".equals(isudType)){
				out.println("isudType >>> : " + isudType);
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rsRs = null;
				int nCnt = 0;
				String pwCheckVal = "";
				String pwCheckQuery = "SELECT COUNT(A.EMPNO) NCNT FROM EMP A WHERE A.EMPNO = ?";
				String mpw = request.getParameter("mpw");
				
				conn = CommonDBConn.getConnection();
				
			}
		}else{
			System.out.println("isudType 타입을 잘 넘기세요 >>> : " + isudType);
		} // end of if(isudType)
	} // end of doGet()

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() 함수 진입 >>> : ");
		doGet(request, response);
	} // end of doPost()

}
