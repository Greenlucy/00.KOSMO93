package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.com.kosmo.book.sql.BookSqlMap;

public abstract class GetBookMaxNum {

	// MaxNum ��񿡼� �������� 
	public static String getMaxNum(){
		
		// �������� ���� �ϰ� �ʱ�ȭ �ϱ� 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum = "";
		
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getMaxChabunQuery());
			System.out.println("ä�� ���� >>> \n" + BookSqlMap.getMaxChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				while (rsRs.next()) {
					maxNum = rsRs.getString("MAXNUM");									
				}
			}else {
				System.out.println("ä������ ���� >>> : ");
			}
			
			// ��񿡼� ������  �ƽ��� :: 1
			System.out.println("maxNum >>> : " + maxNum);			
 			
			ConnProperty.conClose(conn, pstmt, rsRs);			
		}catch(Exception e) {
			System.out.println("GetBookMaxNum ymdNum ��� ���� >>> : " + e.getMessage());
		}finally {
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return maxNum;
	}

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(">>> : " + GetBookMaxNum.getMaxNum());
	}

}
