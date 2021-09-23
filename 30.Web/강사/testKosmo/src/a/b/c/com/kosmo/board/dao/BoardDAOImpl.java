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
		System.out.println("BoardDAOImpl boardSelectAll() 함수 진입 >>> : ");		
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rsRs = null;
		
		ArrayList<BoardVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardSelectAllQuery());
			System.out.println("전체조회 :: \n" + BoardSqlMap.getBoardSelectAllQuery());
			
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
			System.out.println(" 전체조회 DB 에러 " + sq.getMessage());	
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);	
		}
		
		return aList;
	}

	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub		
		System.out.println("BoardDAOImpl boardSelect() 함수 진입 >>> : ");		
		BoardVO.printlnHbeBoardVO(bvo);
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rsRs = null;
		
		ArrayList<BoardVO> aList = null;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardSelectQuery());
			System.out.println("조건조회 :: \n" + BoardSqlMap.getBoardSelectQuery());
			
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
			System.out.println(" 전체조회 DB 에러 " + sq.getMessage());	
		}finally{
			ConnProperty.conClose(conn, pstmt, rsRs);	
		}
		
		return aList;
	}

	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		System.out.println("BoardDAOImpl boardInsert() 함수 진입 >>> : ");
		BoardVO.printlnHbeBoardVO(bvo);
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection        conn = null;
		PreparedStatement pstmt = null;		
		int nCnt = 0;
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardInsertQuery());
			System.out.println("인서트 :: \n" + BoardSqlMap.getBoardInsertQuery());
			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			pstmt.setString(2, bvo.getBsubject());
			pstmt.setString(3, bvo.getBwriter());			
			pstmt.setString(4, bvo.getBpw());		
			pstmt.setString(5, bvo.getBmemo());	
			pstmt.setString(6, bvo.getBphoto());	
								
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();						
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음 ");	
			
			if (nCnt > 0 ) bool = true;
			
			ConnProperty.conClose(conn, pstmt);
		}catch (Exception sq){
			System.out.println(" 인서트 DB 에러 " + sq.getMessage());			
		}finally{
			ConnProperty.conClose(conn, pstmt);	
		}
		
		return bool;
	}

	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub		
		System.out.println("BoardDAOImpl boardUpdate() 함수 진입 >>> : ");
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection        conn = null;
		PreparedStatement pstmt = null;		
		int nCnt = 0;
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardUpdateQuery());
			System.out.println("업데이트 :: \n" + BoardSqlMap.getBoardUpdateQuery());
			
			pstmt.clearParameters();			
			pstmt.setString(1, bvo.getBsubject());
			pstmt.setString(2, bvo.getBmemo());	
			pstmt.setString(3, bvo.getBnum());
								
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();						
			System.out.println("nCnt >>> : " + nCnt + " 건 수정 되었음 ");	
			
			if (nCnt > 0 ) bool = true;
			
			ConnProperty.conClose(conn, pstmt);
		}catch (Exception sq){
			System.out.println(" 업데이트 DB 에러 " + sq.getMessage());			
		}finally{
			ConnProperty.conClose(conn, pstmt);	
		}
		
		return bool;
	}

	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub		
		System.out.println("BoardDAOImpl boardDelete() 함수 진입 >>> : ");
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection        conn = null;
		PreparedStatement pstmt = null;		
		int nCnt = 0;
		boolean bool = false;
		
		try{
			conn = ConnProperty.getConnection();
			pstmt = conn.prepareStatement(BoardSqlMap.getBoardDeleteQuery());
			System.out.println("딜리트 :: \n" + BoardSqlMap.getBoardDeleteQuery());
			
			pstmt.clearParameters();			
			pstmt.setString(1, bvo.getBnum());
								
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();						
			System.out.println("nCnt >>> : " + nCnt + " 건 삭제 되었음 ");	
			
			if (nCnt > 0 ) bool = true;
			
			ConnProperty.conClose(conn, pstmt);
		}catch (Exception sq){
			System.out.println(" 업데이트 DB 에러 " + sq.getMessage());			
		}finally{
			ConnProperty.conClose(conn, pstmt);	
		}
		
		return bool;
	}
}
