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
		System.out.println("LoginDAOImpl loginCheckCnt() �Լ� ���� >>> : ");
		MemberVO.printlnMemberVO(mvo);
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(LoginSqlMap.getloginCheckQuery());
			System.out.println("�α��� ���� Ȯ�� >>> : " + LoginSqlMap.getloginCheckQuery());
			pstmt.clearParameters();
			// ���������� �ԷµǾ� ��Ʈ�ѷ��� ���� ���޵Ǿ� mvo�� ����� �����͵�..
			// placeholder�� set�ϱ� (���ε�)
			pstmt.setString(1, mvo.getMid());
			pstmt.setString(2, mvo.getMpw());
			
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				// Ŀ���Լ� next() �ݺ��� ����
				while (rsRs.next()){		// nCnt �� ��� ������� ���� �� ����...
					// int java.sql.ResultSet.getInt(int columnIndex) throws SQLException
					nCnt = rsRs.getInt(1);
					System.out.println("�α��� >>> : " + nCnt + " �� �α��� ���� !");
				}
			}else{
				System.out.println("�α��� >>> : �α��� ����");
			}
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("�α��� DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return nCnt;
	}

}
