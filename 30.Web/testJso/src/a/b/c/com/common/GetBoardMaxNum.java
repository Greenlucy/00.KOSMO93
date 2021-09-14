package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.com.jso.sql.BoardSqlMap;

public abstract class GetBoardMaxNum {
	
	// MaxNum ��񿡼� ��������
	public static String getMaxNum(){
		System.out.println("GetBoardMaxNum getMaxNum() >>> : ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum = "";
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getChabunQuery());
			System.out.println("ä������ Ȯ�� >>> : " + BoardSqlMap.getChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				while(rsRs.next()){
					maxNum = rsRs.getString("MAXNUM");
				}
			}else{
				System.out.println("ä������ ���� >>> : ");
			}
			
			// ��񿡼� ������ �ƽ��� :: 1
			System.out.println("MAXNUM >>> : " + maxNum);
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("ä������ ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return maxNum;
	}
	
	public static void main(String[] args){
		System.out.println(GetBoardMaxNum.getMaxNum());
	}
}
