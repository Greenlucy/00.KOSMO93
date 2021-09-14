package a.b.c.com.jso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.jso.sql.BoardSqlMap;
import a.b.c.com.jso.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		// [58]
		System.out.println("BoardDAOImpl boardSelectAll() ���� >>> : ");
		
		// [59]
		// ����� ��ü ����, �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<BoardVO> aList = null;
		
		try{
			// [60]
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardSelectAllQuery());
			System.out.println("��ü��ȸ ������ Ȯ�� >>> : " + BoardSqlMap.getBoardSelectAllQuery());
			rsRs = pstmt.executeQuery();
			
			// [61]
			if (rsRs != null){
				// ArrayList new Ŭ���� �ν��Ͻ� �� ���༭ java.lang.NullPointerException ���� �߻�
				// while()�� �ȿ� ���� ù��° ���� ���..!
				aList = new ArrayList<BoardVO>();		
				while(rsRs.next()){
					// while()�� �ȿ� ���� ù��° ���� ���..! : �Ʒ�ó�� ���� Ŭ �� ����
//					aList = new ArrayList<BoardVO>();
					
					BoardVO bvo = new BoardVO();
					bvo.setBnum(rsRs.getString("BNUM"));
					bvo.setBsubject(rsRs.getString("BSUBJECT"));
					bvo.setBwriter(rsRs.getString("BWRITER"));
					bvo.setBpw(rsRs.getString("BPW"));
					bvo.setBmemo(rsRs.getString("BMEMO"));
					bvo.setBphoto(rsRs.getString("BPHOTO"));
					bvo.setDeleteyn(rsRs.getString("DELETEYN"));
					bvo.setInsertdate(rsRs.getString("INSERTDATE"));
					bvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					
					aList.add(bvo);
				}
			}
			// [67]
			if (aList != null && aList.size() > 0){
				System.out.println("��ü��ȸ aList�� ���� ��� �Ϸ�");
			}else{
				System.out.println("aList�� ������ϴ�.");
			}
			
			// [68]
			ConnProperty.conClose(conn, pstmt, rsRs);
		}catch(Exception sq){
			System.out.println("��ü��ȸ DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			// [69]
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		
		// [70]
		return aList;
	}

	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardDAOImpl boardSelect() �Լ� ���� >>> : ");
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<BoardVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardSelectQuery());
			System.out.println("������ȸ ������ Ȯ�� >>> : " + BoardSqlMap.getBoardSelectQuery());
			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null){
				aList = new ArrayList<BoardVO>();
				while(rsRs.next()){
					BoardVO _bvo = new BoardVO();
					_bvo.setBnum(rsRs.getString("BNUM"));
					_bvo.setBsubject(rsRs.getString("BSUBJECT"));
					_bvo.setBwriter(rsRs.getString("BWRITER"));
					_bvo.setBpw(rsRs.getString("BPW"));
					_bvo.setBmemo(rsRs.getString("BMEMO"));
					_bvo.setBphoto(rsRs.getString("BPHOTO"));
					_bvo.setDeleteyn(rsRs.getString("DELETEYN"));
					_bvo.setInsertdate(rsRs.getString("INSERTDATE"));
					_bvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					
					aList.add(_bvo);
				}
			}
		}catch(Exception e){
			System.out.println("������ȸ DB ���� >>> : " + e.getMessage());
			System.out.println("���� >>> : " + e);
		}
		
		return aList;
	}

	// [16]
	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		// [17]
		System.out.println("BoardDAOImpl boardInsert() ���� >>> : ");
		
		// [18]
		// ����� ��ü ���������� ����, �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean bool = false;
		int nCnt = 0;
		
		try{
			// [19] �����ͺ��̽��� ���� > ConnProperty Ŭ���� �ٳ��
			conn = ConnProperty.getConnection();
			// [27] �����ͺ��̽��� ���� �� SqlMap�� Insert������ ����
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardInsertQuery());
			// [32] �Ķ���� Ŭ����
			pstmt.clearParameters();
			// [33] 
			// void setString(int parameterIndex, String x) throws SQLException
			// �־��� �ڹ� ��Ʈ�� value�� �����ε� �Ķ���͸� �����Ѵ�. ����̹��� �����ͺ��̽��� �� ���� ���� �� ����̹��� �̰��� SQL VARCHAR �Ǵ� LONGVARCHAR value�� ��ȯ�Ѵ�.
			// (�ƱԸ�Ʈ�� ����� ����. ����̹��� VARCHAR values�� �Ѱ�� ���Ͽ�) 
			pstmt.setString(1, bvo.getBnum());
			pstmt.setString(2, bvo.getBsubject());
			pstmt.setString(3, bvo.getBwriter());
			pstmt.setString(4, bvo.getBpw());
			pstmt.setString(5, bvo.getBmemo());
			pstmt.setString(6, bvo.getBphoto());
			// [34] execute : ����[����]�ϴ� (������ �ǹ�)
			nCnt = pstmt.executeUpdate();
			
			// [35] Ŀ�� �� ���� ��� ���
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			
			// [36] ������ bool�� �°� �ڷᰡ ������ true�� �������ֱ�
			if (nCnt > 0) {
				System.out.println("BoardDAOImpl boardInsert() : nCnt >>> : " + nCnt + " �� ��� �Ǿ���");
				bool = true;
			}else{
				System.out.println("nCnt�� ������ϴ�.");
			}
			
			// [37] io �ݾ��ֱ� 
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("�μ�Ʈ ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			// [38-1] finally (�߰�)
			ConnProperty.conClose(conn, pstmt);
		}
		
		// [39] ���� bool 
		return bool;
	}

	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardDAOImpl boardDelete() �Լ� ���� >>> : ");
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0; 
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardDeleteQuery());
			System.out.println("�� ���� ���� Ȯ�� >>> : " + BoardSqlMap.getBoardDeleteQuery());
			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			if (nCnt > 0){
				System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ���");
				bool = true;
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("���� DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		return bool;
	}

	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardDAOImpl boardUpdate() �Լ� ���� >>> : ");
		
		// ����� ��ü �����ϰ� �ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardUpdateQuery());
			System.out.println("�ۼ��� ������ Ȯ�� >>> : " + BoardSqlMap.getBoardUpdateQuery());
			
			// placeholder ���ε��ϱ�
			// �������� key & value�� getString()�Լ����� 1,2,3 �Է��� �� �ִ°ű���..
			// setString(int, String) : key�� ������ int
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBsubject());
			pstmt.setString(2, bvo.getBmemo());
			pstmt.setString(3, bvo.getBnum());
			
			// executeUpdate() �Լ��� �������� int >> ���� �� �ִ� int���� �������� ��
			nCnt = pstmt.executeUpdate();
			
			if (!conn.getAutoCommit()){
				conn.commit();
			}
			if (nCnt > 0) {
				System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ���");
				bool = true;
			}else{
				System.out.println("���� ���� !!!");
				System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ���");
			}
			
			ConnProperty.conClose(conn, pstmt);
		}catch(Exception sq){
			System.out.println("�� ���� DB ���� >>> : " + sq.getMessage());
			System.out.println("���� >>> : " + sq);
		}finally{
			ConnProperty.conClose(conn, pstmt);
		}
		return bool;
	}
}
