package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.com.jso.book.sql.BookSqlMap;

public abstract class GetBookMaxNum {

	public static String getMaxNum(){
		System.out.println("GetBookMaxNum getMaxNum() 함수 진입 >>> : ");
		// 서비스 연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum = "";
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getChabunQuery());
			System.out.println("채번 쿼리 확인 >>> : " + BookSqlMap.getChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				while(rsRs.next()){
					maxNum = rsRs.getString("MAXNUM");
				}
			}else{
				System.out.println("채번 쿼리 실패 >>> : ");
			}
			
			// 디비에서 가져온 맥스값
			System.out.println("maxNum >>> : " + maxNum);

		}catch(Exception sq){
			System.out.println("채번 DB 에러 >>> : " + sq.getMessage());
			System.out.println("에러 >>> : " + sq);
		}
		// 이거 못 찾아서 엄청 뻘짓 함... : return ""; 해놔서 계속 채번이 안 돌아감
		return maxNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GetBookMaxNum.getMaxNum());
	}

}
