package a.b.c.com.kosmo.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.kosmo.login.sql.LoginSqlMap;
import a.b.c.com.kosmo.mem.vo.MemberVO;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public int loginCheckCnt(MemberVO mvo) {
		// TODO Auto-generated method stub
		System.out.println("LoginDAOImpl loginCheckCnt() �Լ� ���� >>> : ");
		MemberVO.printlnMemberVO(mvo);
		
		// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		int nCnt = 0;
		
		try {			

			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(LoginSqlMap.getLoginCheckCntQuery());
			System.out.println("�α� üũ >>> : \n"+ LoginSqlMap.getLoginCheckCntQuery());
			
			pstmt.clearParameters();
			pstmt.setString(1, mvo.getMid());
			pstmt.setString(2, mvo.getMpw());
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				while (rsRs.next()) {
					nCnt = rsRs.getInt(1);								
				}
			}	
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception e) {
			System.out.println("��񿬵��� ������ ������ϴ�. >>> : " + e);
		}finally {
			try {
				ConnProperty.conClose(conn, pstmt, rsRs);				
			}catch(Exception e2) {}
		}
				
		return nCnt;
	}
}
