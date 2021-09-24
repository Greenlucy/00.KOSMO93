package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.com.jso.mem.sql.MemberSqlMap;

public abstract class GetMemberMaxNum {

	// MaxNum 디비에서 가져오기
	public static String getMaxNum(){
		
		// 지역변수 선언하고 초기화하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum = "";
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(MemberSqlMap.getMemberChabunQuery());
			System.out.println("채번 쿼리 확인 >>> : " + MemberSqlMap.getMemberChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				while(rsRs.next()){
					// rsRs.getString(COLUMNINDEX);
					maxNum = rsRs.getString("MAXNUM");
				}
			}
			// 콘솔에 출력 + 확인
			System.out.println("maxNum >>> : " + maxNum);
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("채번 DB 에러 >>> : " + sq.getMessage());
			System.out.println("채번 에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return maxNum;
	}
	
	public static void main(String[] args){
		// 2. 채번로직 만들고 콘솔에 확인하기
		GetMemberMaxNum.getMaxNum();
	}
}
