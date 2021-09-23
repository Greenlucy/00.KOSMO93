package a.b.c.com.kosmo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import a.b.c.com.common.ConnProperty;
import a.b.c.com.kosmo.board.sql.BoardSqlMap;
import a.b.c.com.kosmo.board.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("BoardDAOImpl boardSelectAll() �Լ� ���� >>> : ");		
		
		// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rsRs = null;
		
		ArrayList<BoardVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardSelectAllQuery());
			System.out.println("��ü��ȸ :: \n" + BoardSqlMap.getBoardSelectAllQuery());
			
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null){	
				aList = new ArrayList<BoardVO>();
			
				while (rsRs.next()){					
					BoardVO _bvo = new BoardVO();
					_bvo.setBnum(rsRs.getString(1));
					_bvo.setBsubject(rsRs.getString(2));
					_bvo.setBwriter(rsRs.getString(3));
					_bvo.setBpw(rsRs.getString(4));		
					_bvo.setBmemo(rsRs.getString(5));
					_bvo.setBphoto(rsRs.getString(6));
					_bvo.setDeleteyn(rsRs.getString(7));
					_bvo.setInsertdate(rsRs.getString(8));
					_bvo.setUpdatedate(rsRs.getString(9));					
					aList.add(_bvo);
					
					BoardVO.printBoardVO(_bvo);
				}
			}
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		catch (Exception sq){
			System.out.println(" ��ü��ȸ DB ���� " + sq.getMessage());	
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);	
		}
		
		return aList;
	}

	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub		
		System.out.println("BoardDAOImpl boardSelect() �Լ� ���� >>> : ");		
		BoardVO.printlnHbeBoardVO(bvo);
		
		// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rsRs = null;
		
		ArrayList<BoardVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardSelectQuery());
			System.out.println("������ȸ :: \n" + BoardSqlMap.getBoardSelectQuery());
			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null){	
				aList = new ArrayList<BoardVO>();
			
				while (rsRs.next()){					
					BoardVO _bvo = new BoardVO();
					_bvo.setBnum(rsRs.getString(1));
					_bvo.setBsubject(rsRs.getString(2));
					_bvo.setBwriter(rsRs.getString(3));
					_bvo.setBpw(rsRs.getString(4));		
					_bvo.setBmemo(rsRs.getString(5));
					_bvo.setBphoto(rsRs.getString(6));
					_bvo.setDeleteyn(rsRs.getString(7));
					_bvo.setInsertdate(rsRs.getString(8));
					_bvo.setUpdatedate(rsRs.getString(9));					
					aList.add(_bvo);
					
					BoardVO.printBoardVO(_bvo);
				}
			}
			
			ConnProperty.conClose(conn, pstmt, rsRs);
		}
		catch (Exception sq){
			System.out.println(" ��ü��ȸ DB ���� " + sq.getMessage());	
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);	
		}
		
		return aList;
	}

	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardDAOImpl boardInsert() �Լ� ���� >>> : ");
		BoardVO.printlnHbeBoardVO(bvo);
		
		// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
		Connection        conn = null;
		PreparedStatement pstmt = null;		
		int nCnt = 0;
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardInsertQuery());
			System.out.println("�μ�Ʈ :: \n" + BoardSqlMap.getBoardInsertQuery());
			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			pstmt.setString(2, bvo.getBsubject());
			pstmt.setString(3, bvo.getBwriter());			
			pstmt.setString(4, bvo.getBpw());		
			pstmt.setString(5, bvo.getBmemo());	
			pstmt.setString(6, bvo.getBphoto());	
								
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();						
			System.out.println("nCnt >>> : " + nCnt + " �� ��� �Ǿ��� ");	
			
			if (nCnt > 0 ) bool = true;
			
			ConnProperty.conClose(conn, pstmt);
		}catch (Exception sq){
			System.out.println(" �μ�Ʈ DB ���� " + sq.getMessage());			
		}finally{
			ConnProperty.conClose(conn, pstmt);	
		}
		
		return bool;
	}

	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub		
		System.out.println("BoardDAOImpl boardUpdate() �Լ� ���� >>> : ");
		
		// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
		Connection        conn = null;
		PreparedStatement pstmt = null;		
		int nCnt = 0;
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardUpdateQuery());
			System.out.println("������Ʈ :: \n" + BoardSqlMap.getBoardUpdateQuery());
			
			pstmt.clearParameters();			
			pstmt.setString(1, bvo.getBsubject());
			pstmt.setString(2, bvo.getBmemo());	
			pstmt.setString(3, bvo.getBnum());
								
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();						
			System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");	
			
			if (nCnt > 0 ) bool = true;
			
			ConnProperty.conClose(conn, pstmt);
		}catch (Exception sq){
			System.out.println(" ������Ʈ DB ���� " + sq.getMessage());			
		}finally{
			ConnProperty.conClose(conn, pstmt);	
		}
		
		return bool;
	}

	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub		
		System.out.println("BoardDAOImpl boardDelete() �Լ� ���� >>> : ");
		
		// ����� ��ü�� ���������� �����ϰ� �ʱ�ȭ �ϱ� 
		Connection        conn = null;
		PreparedStatement pstmt = null;		
		int nCnt = 0;
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardDeleteQuery());
			System.out.println("����Ʈ :: \n" + BoardSqlMap.getBoardDeleteQuery());
			
			pstmt.clearParameters();			
			pstmt.setString(1, bvo.getBnum());
								
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();						
			System.out.println("nCnt >>> : " + nCnt + " �� ���� �Ǿ��� ");	
			
			if (nCnt > 0 ) bool = true;
			
			ConnProperty.conClose(conn, pstmt);
		}catch (Exception sq){
			System.out.println(" ������Ʈ DB ���� " + sq.getMessage());			
		}finally{
			ConnProperty.conClose(conn, pstmt);	
		}
		
		return bool;
	}
}
