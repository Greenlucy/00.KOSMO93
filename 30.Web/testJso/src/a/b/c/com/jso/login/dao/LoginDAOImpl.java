package a.b.c.com.jso.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.jso.login.sql.LoginSqlMap;
import a.b.c.com.jso.mem.vo.MemberVO;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public int loginCheckCnt(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("LoginDAOImpl loginCheckCnt() 함수 진입 >>> : ");
		MemberVO.printlnMemberVO(mvo);
		
		// 사용할 객체 선언하고 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(LoginSqlMap.getloginCheckQuery());
			System.out.println("로그인 쿼리 확인 >>> : " + LoginSqlMap.getloginCheckQuery());
			pstmt.clearParameters();
			// 웹브라우저에 입력되어 컨트롤러를 통해 전달되어 mvo에 저장된 데이터들..
			// placeholder에 set하기 (바인딩)
			pstmt.setString(1, mvo.getMid());
			pstmt.setString(2, mvo.getMpw());
			
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				// 커서함수 next() 반복문 돌림
				while (rsRs.next()){		// nCnt 를 어떻게 사용할지 감을 못 잡음...
					// int java.sql.ResultSet.getInt(int columnIndex) throws SQLException
					nCnt = rsRs.getInt(1);
					System.out.println("로그인 >>> : " + nCnt + " 건 로그인 성공 !");
				}
			}else{
				System.out.println("로그인 >>> : 로그인 실패");
			}
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("로그인 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return nCnt;
	}

}
