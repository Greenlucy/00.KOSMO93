package a.b.c.com.jso.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.jso.book.sql.BookSqlMap;
import a.b.c.com.jso.book.vo.BookVO;

public class BookDAOImpl implements BookDAO {

	@Override
	public ArrayList<BookVO> bookSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl bookSelectAll() �Լ� ���� >>> : ");
		
		// ����� ��ü �����ϰ� �ʱ�ȭ�ϱ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<BookVO> aList = null;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getSelectAllQuery());
			System.out.println("��������_��ü��ȸ ���� Ȯ�� >>> : " + BookSqlMap.getSelectAllQuery());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				// ArrayList<BookVO> �޸𸮿� �ν��Ͻ� >> ���� �� �ִ� ���� Ȯ��
				aList = new ArrayList<BookVO>();
				
				// db ���̺� ����� �����͵��� "���� ����ŭ" ��� ����ϱ� ���� while �ݺ��� ���
				// Ŀ���Լ� ResultSet.next() ����Ͽ� boolean ����
				while (rsRs.next()){
					// BookVO �ν��Ͻ�
					BookVO bvo = new BookVO();
					// ������ ������ ����� rsRs��ü�������� �÷� String��(key) setter()�Լ��� �ƱԸ�Ʈ�� �����Ͽ�
					// bvo ���������� �ʱ�ȭ�ϱ�
					bvo.setBnum(rsRs.getString("BNUM"));
					bvo.setBtitle(rsRs.getString("BTITLE"));
					bvo.setBauth(rsRs.getString("BAUTH"));
					bvo.setIsbn(rsRs.getString("ISBN"));
					bvo.setBcomp(rsRs.getString("BCOMP"));
					bvo.setBprice(rsRs.getString("BPRICE"));
					bvo.setBqty(rsRs.getString("BQTY"));
					bvo.setBcover(rsRs.getString("BCOVER"));
					bvo.setDeleteyn(rsRs.getString("DELETEYN"));
					bvo.setInsertdate(rsRs.getString("INSERTDATE"));
					bvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					
					// aList�� bvo�� ����� �����͵��� "�� ����" �����Ͽ� ��� 
					aList.add(bvo);
					System.out.println("BookVO.printBookVO(bvo) >>> : ");
					BookVO.printBookVO(bvo);
				}
			}
			
			if (aList != null && aList.size() > 0){
				System.out.println("��ü��ȸ >>> : " + aList.size() + " �� ����");
			}else{
				System.out.println("aList�� ������ϴ�.");
			}
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("��ü��ȸ DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		return aList;
	}

	@Override
	public ArrayList<BookVO> bookSelect(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl bookSelect() �Լ� ���� >>> : ");
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<BookVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getSelectQuery());
			System.out.println("������ȸ ���� Ȯ�� >>> : " + BookSqlMap.getSelectQuery());
			// placeholder ���ε� ���ֱ�
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				aList = new ArrayList<BookVO>();
				while(rsRs.next()){
					BookVO _bvo = new BookVO();
					_bvo.setBnum(rsRs.getString("BNUM"));
					_bvo.setBtitle(rsRs.getString(2));
					_bvo.setBauth(rsRs.getString(3));
					_bvo.setIsbn(rsRs.getString(4));
					_bvo.setBcomp(rsRs.getString(5));
					_bvo.setBprice(rsRs.getString(6));
					_bvo.setBqty(rsRs.getString(7));
					_bvo.setBcover(rsRs.getString(8));
					_bvo.setDeleteyn(rsRs.getString(9));
					_bvo.setInsertdate(rsRs.getString(10));
					_bvo.setUpdatedate(rsRs.getString(11));
					
					aList.add(_bvo);
				}
				System.out.println("aList.size() >>> : " + aList.size() + " �� ��ȸ �Ǿ���");
			}
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("������ȸ DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	}

	@Override
	public int bookInsert(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl bookInsert() �Լ� ���� >>> : ");
		
		// ����� ��ü �����ϰ� �ʱ�ȭ�ϱ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0; 
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getInsertQuery());
			System.out.println("å��� ���� Ȯ�� >>> : " + BookSqlMap.getInsertQuery());
			
			pstmt.clearParameters();
			// setString(int parameterIndex, String x)
			pstmt.setString(1, bvo.getBnum());
			pstmt.setString(2, bvo.getBtitle());
			pstmt.setString(3, bvo.getBauth());
			pstmt.setString(4, bvo.getIsbn());
			pstmt.setString(5, bvo.getBcomp());
			pstmt.setString(6, bvo.getBprice());
			pstmt.setString(7, bvo.getBqty());
			pstmt.setString(8, bvo.getBcover());
			
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " �� ��� �Ǿ���");
			}else{
				System.out.println("nCnt�� ������ϴ�.");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("å��� DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		
		return nCnt;
	}

	@Override
	public int bookUpdate(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl bookUpdate() �Լ� ���� >>> : ");
		
		// ����� ��ä �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getUpdateQuery());
			System.out.println("������������ ���� Ȯ�� >>> : " + BookSqlMap.getUpdateQuery());
			// placeholder ���ε��ϱ�
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBprice());
			pstmt.setString(2, bvo.getBqty());
			pstmt.setString(3, bvo.getBcover());
			pstmt.setString(4, bvo.getBnum());
			
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ���");
			}else{
				System.out.println("nCnt�� ������ϴ�.");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("������������ DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		
		return nCnt;
	}

	@Override
	public int bookDelete(BookVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BookDAOImpl bookDelete() �Լ� ���� >>> : ");
		
		// ����� ��ü �����ϰ� �ʱ�ȭ�ϱ�
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BookSqlMap.getDeleteQuery());
			// placeholder ���ε��ϱ�
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ���");
			}else{
				System.out.println("nCnt�� ������ϴ�.");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("�������� ���� DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		
		return nCnt;
	}

}
