package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.com.jso.sql.BoardSqlMap;

public abstract class GetBoardMaxNum {
	
	// MaxNum 디비에서 가져오기
	public static String getMaxNum(){
		System.out.println("GetBoardMaxNum getMaxNum() >>> : ");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum = "";
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getChabunQuery());
			System.out.println("채번쿼리 확인 >>> : " + BoardSqlMap.getChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				while(rsRs.next()){
					maxNum = rsRs.getString("MAXNUM");
				}
			}else{
				System.out.println("채번쿼리 실패 >>> : ");
			}
			
			// 디비에서 가져온 맥스값 :: 1
			System.out.println("MAXNUM >>> : " + maxNum);
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("채번쿼리 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return maxNum;
	}
	
	public static void main(String[] args){
		System.out.println(GetBoardMaxNum.getMaxNum());
	}
}
