package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.com.jso.mem.sql.MemberSqlMap;

public abstract class GetMemberMaxNum {

	// MaxNum ��񿡼� ��������
	public static String getMaxNum(){
		
		// �������� �����ϰ� �ʱ�ȭ�ϱ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum = "";
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberChabunQuery());
			System.out.println("ä�� ���� Ȯ�� >>> : " + MemberSqlMap.getMemberChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				while(rsRs.next()){
					// rsRs.getString(COLUMNINDEX);
					maxNum = rsRs.getString("MAXNUM");
				}
			}
			// �ֿܼ� ��� + Ȯ��
			System.out.println("maxNum >>> : " + maxNum);
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("ä�� DB ���� >>> : " + sq.getMessage());
			System.out.println("ä�� ���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return maxNum;
	}
	
	public static void main(String[] args){
		// 2. ä������ ����� �ֿܼ� Ȯ���ϱ�
		GetMemberMaxNum.getMaxNum();
	}
}
