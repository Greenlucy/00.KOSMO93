package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.com.jso.notice.sql.NoticeSqlMap;

public class GetNoticeMaxNum {

	public static String getMaxNum() {
		System.out.println("GetNoticeMaxNum : getMaxNum() 함수 진입  >>> : ");
		
		// 사용할 객체 선언, 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum = "";
		
		try {
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(NoticeSqlMap.getNoticeChabunQuery());
			System.out.println("채번 쿼리 확인 >>> : " + NoticeSqlMap.getNoticeChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null) {
				while (rsRs.next()){
					maxNum = rsRs.getString("MAXNUM");
				}
				
			}else{
				System.out.println("채번 실패 !!");
			}
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("채번 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return maxNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("maxNum >>> : " + GetNoticeMaxNum.getMaxNum());
	}

}
