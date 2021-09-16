package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a.b.c.com.jso.book.sql.BookSqlMap;

public abstract class GetBookMaxNum {

	public static String getMaxNum(){
		System.out.println("GetBookMaxNum getMaxNum() �Լ� ���� >>> : ");
		// ���� ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String maxNum = "";
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getChabunQuery());
			System.out.println("ä�� ���� Ȯ�� >>> : " + BookSqlMap.getChabunQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				while(rsRs.next()){
					maxNum = rsRs.getString("MAXNUM");
				}
			}else{
				System.out.println("ä�� ���� ���� >>> : ");
			}
			
			// ��񿡼� ������ �ƽ���
			System.out.println("maxNum >>> : " + maxNum);

		}catch(Exception sq){
			System.out.println("ä�� DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}
		// �̰� �� ã�Ƽ� ��û ���� ��... : return ""; �س��� ��� ä���� �� ���ư�
		return maxNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GetBookMaxNum.getMaxNum());
	}

}
